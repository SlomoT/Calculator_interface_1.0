package bistu_yyx.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Danwei extends AppCompatActivity {
    public String start1 = "";
    public String ten1 = "";
    public int ten = 0;
    public int flag1 = 0;
    public int flag2 = 0 ;
    double m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danwei);
        final EditText shuru = (EditText)findViewById(R.id.shuru);
        final EditText shuchu = (EditText) findViewById(R.id.shuchu);
        final Button start = (Button)findViewById(R.id.start);
        final Button exit = (Button)findViewById(R.id.exit);
        RadioButton Button2  = (RadioButton)findViewById(R.id.button2);
        RadioButton Button8  = (RadioButton)findViewById(R.id.button8);
        RadioButton Button10 = (RadioButton)findViewById(R.id.button10);
        RadioButton Button16  = (RadioButton)findViewById(R.id.button16);
        RadioButton Button2a  = (RadioButton)findViewById(R.id.button2a);
        RadioButton Button8a  = (RadioButton)findViewById(R.id.button8a);
        RadioButton Button10a  = (RadioButton)findViewById(R.id.button10a);
        RadioButton Button16a  = (RadioButton)findViewById(R.id.button16a);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 0;
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 1;
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 =2;
            }
        });
        Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 3;
            }
        });
        Button2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2= 00;
            }
        });
        Button8a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 11;
            }
        });
        Button10a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 22;
            }
        });
        Button16a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 33;
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag1 == 0) {
                    m = Double.parseDouble(shuru.getText().toString());
                    ten1 = String.valueOf(m/10);
                    if (flag2 == 00) {
                        shuchu.setText(shuru.getText().toString());
                    } else if (flag2 == 11) {
                        ten1 = String.valueOf(m/10);
                        shuchu.setText(ten1);
                    } else if (flag2 == 22) {
                        ten1 = String.valueOf(m/100);
                        shuchu.setText(ten1);
                    } else if (flag2 == 33) {
                        ten1 = String.valueOf(m/1000);
                        shuchu.setText(ten1);
                    } else
                        Toast.makeText(Danwei.this, "请选择要转化的单位", Toast.LENGTH_SHORT);
                }
                if (flag1 == 1) {
                    m = Double.parseDouble(shuru.getText().toString());
                    ten1 = String.valueOf(m*10);
                    if (flag2 == 00) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 11) {
                        shuchu.setText(start1);
                    } else if (flag2 == 22) {
                        ten1 = String.valueOf(m/10);
                        shuchu.setText(ten1);
                    } else if (flag2 == 33) {
                        ten1 = String.valueOf(m/100);
                        shuchu.setText(ten1);
                    } else
                        Toast.makeText(Danwei.this, "请选择要转化的单位", Toast.LENGTH_SHORT);
                }
                if (flag1 == 2) {
                    m = Double.parseDouble(shuru.getText().toString());
                    ten1 = String.valueOf(m*100);
                    if (flag2 == 00) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 11) {
                        ten1 = String.valueOf(m*10);
                        shuchu.setText(ten1);
                    } else if (flag2 == 22) {
                        shuchu.setText(start1);
                    } else if (flag2 == 33){
                        ten1 = String.valueOf(m/10);
                        shuchu.setText(ten1);
                    } else
                        Toast.makeText(Danwei.this, "请选择要转化的单位", Toast.LENGTH_SHORT);
                }
                if (flag1 == 3) {
                    m = Double.parseDouble(shuru.getText().toString());
                    ten1 = String.valueOf(m*1000);
                    if (flag2 == 00) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 11) {
                        ten1 = String.valueOf(m*100);
                        shuchu.setText(ten1);
                    } else if (flag2 == 22) {
                        ten1 = String.valueOf(m*10);
                        shuchu.setText(ten1);
                    } else if (flag2 == 33) {
                        shuchu.setText(start1);
                    } else
                        Toast.makeText(Danwei.this, "请选择要转化的单位", Toast.LENGTH_SHORT);
                }
                else  Toast.makeText(Danwei.this, "请选择要转化的单位", Toast.LENGTH_SHORT);
            }


        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Danwei.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}