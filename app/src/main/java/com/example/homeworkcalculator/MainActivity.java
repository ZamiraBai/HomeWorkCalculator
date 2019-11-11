package com.example.homeworkcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bmin, bmul, bdiv, bdot, bequal, bclear;
    TextView answer;
    double var1, var2;
    boolean add, min, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b0 = (Button) findViewById(R.id.btn0);
        badd = (Button) findViewById(R.id.btn_add);
        bmin = (Button) findViewById(R.id.btn_minus);
        bmul = (Button) findViewById(R.id.btn_multiply);
        bdiv = (Button) findViewById(R.id.btn_divide);
        bdot = (Button) findViewById(R.id.btn_dot);
        bequal = (Button) findViewById(R.id.btn_equal);
        bclear = (Button) findViewById(R.id.btn_clear);

        answer = (TextView) findViewById(R.id.answer);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "1");
                Toast.makeText(MainActivity.this, answer.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + "9");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText() + ".");
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(answer.getText() + "");
                add = true;
                answer.setText(null);
            }
        });
        bmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(answer.getText() + "");
                min = true;
                answer.setText(null);
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(answer.getText() + "");
                mul = true;
                answer.setText(null);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(answer.getText() + "");
                div = true;
                answer.setText(null);
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var2 = Double.parseDouble(answer.getText() + "");
                if (add == true) {
                    answer.setText(var1 + var2 + "");
                    add = false;
                }
                if (min == true) {
                    answer.setText(var1 - var2 + "");
                    min = false;
                }
                if (mul == true) {
                    answer.setText(var1 * var2 + "");
                    mul = false;
                }
                if (div == true) {
                    answer.setText(var1 / var2 + "");
                    div = false;
                }
                if (answer!=null) {
                    Intent intent = new Intent();
                    intent.putExtra("result", answer.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = answer.getText().toString();
                answer.setText("");
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        if (answer != null) {
            outState.putString("key", answer.getText().toString());
            outState.putString("key1", answer.getText().toString());
            Log.e("TAG", "onSaveInstanceState: " + answer.getText().toString());
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (answer!=null){
        String key=savedInstanceState.getString("key");
        String key1=savedInstanceState.getString("key1");
        answer.setText(key);
        answer.setText(key1);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}