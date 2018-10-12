package bistu_yyx.calculator;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class JinzhiZhuanhuan extends AppCompatActivity {
    public String start1 = "";
    public String ten1 = "";
    public int ten = 0;
    public int flag1 = 0;
    public int flag2 = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi_zhuanhuan);
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
                flag1 = 2;
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 8;
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 =10;
            }
        });
        Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1=16;
            }
        });
        Button2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2=2;
            }
        });
        Button8a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 8;
            }
        });
        Button10a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 10;
            }
        });
        Button16a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = 16;
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start1 = shuru.getText().toString();
                if (flag1 == 2) {
                    ten1 = Integer.valueOf(start1, 2).toString();
                    ten = Integer.parseInt(ten1);
                    if (flag2 == 2) {
                        shuchu.setText(start1);
                    } else if (flag2 == 8) {
                        shuchu.setText(Integer.toOctalString(ten));
                    } else if (flag2 == 10) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 16) {
                        shuchu.setText(Integer.toHexString(ten));
                    } else
                        Toast.makeText(JinzhiZhuanhuan.this, "请选择要转化的数", Toast.LENGTH_SHORT);
                }
                if (flag1 == 8) {
                    ten1 = Integer.valueOf(start1, 8).toString();
                    ten = Integer.parseInt(ten1);
                    if (flag2 == 2) {
                        shuchu.setText(Integer.toBinaryString(ten));
                    } else if (flag2 == 8) {
                        shuchu.setText(start1);
                    } else if (flag2 == 10) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 16) {
                        shuchu.setText(Integer.toHexString(ten));
                    } else
                        Toast.makeText(JinzhiZhuanhuan.this, "请选择要转化的数", Toast.LENGTH_SHORT);
                }
                if (flag1 == 10) {
                    ten1 = Integer.valueOf(start1, 10).toString();
                    ten = Integer.parseInt(ten1);

                    if (flag2 == 2) {
                        shuchu.setText(Integer.toBinaryString(ten));
                    } else if (flag2 == 8) {
                        shuchu.setText(Integer.toOctalString(ten));
                    } else if (flag2 == 10) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 16) {
                        shuchu.setText(Integer.toHexString(ten));
                    } else
                        Toast.makeText(JinzhiZhuanhuan.this, "请选择要转化的数", Toast.LENGTH_SHORT);
                }
                if (flag1 == 16) {
                    ten1 = Integer.valueOf(start1, 16).toString();
                    ten = Integer.parseInt(ten1);
                    if (flag2 == 2) {
                        shuchu.setText(Integer.toBinaryString(ten));
                    } else if (flag2 == 8) {
                        shuchu.setText(Integer.toOctalString(ten));
                    } else if (flag2 == 10) {
                        shuchu.setText(ten1);
                    } else if (flag2 == 16) {
                        shuchu.setText(Integer.toHexString(ten));
                    } else
                        Toast.makeText(JinzhiZhuanhuan.this, "请选择要转化的数", Toast.LENGTH_SHORT);
                }
                else  Toast.makeText(JinzhiZhuanhuan.this, "请选择转化的数", Toast.LENGTH_SHORT);
            }


        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JinzhiZhuanhuan.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}