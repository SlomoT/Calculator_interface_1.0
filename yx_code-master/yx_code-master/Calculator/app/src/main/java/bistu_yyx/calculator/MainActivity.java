package bistu_yyx.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.jinzhi:
                Intent intent = new Intent (MainActivity.this,JinzhiZhuanhuan.class);
                startActivity(intent);
                break;
            case R.id.help:
                Toast.makeText(MainActivity.this,"This is a hlep",Toast.LENGTH_SHORT).show();
                break;
            case R.id.danwei:
                Intent intent1 = new Intent(MainActivity.this,Danwei.class);
                startActivity(intent1);
                break;
            case R.id.exit:
                finish();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    Button btn0=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btnAdd=null;
    Button btnSub=null;
    Button btnMul=null;
    Button btnDiv=null;
    Button btnEqu=null;//
    Button btnSqrt=null;
    Button btnSin = null;
    Button btnCos = null;
    Button btnx2 = null;//
    Button btnC = null;//
    Button btnLeft = null;
    Button btnRight = null;
    Button btnPlu = null;//
    Button btnDot = null;
    Button btnBack = null;
    Button btnx3 =null;


    public String input="";
    public EditText editText;

    public void install(){
        btn0 = (Button)findViewById(R.id.zero);
        btn1 = (Button)findViewById(R.id.one);
        btn2 = (Button)findViewById(R.id.two);
        btn3 = (Button)findViewById(R.id.three);
        btn4 = (Button)findViewById(R.id.four);
        btn5 = (Button)findViewById(R.id.five);
        btn6 = (Button)findViewById(R.id.six);
        btn7 = (Button)findViewById(R.id.seven);
        btn8 = (Button)findViewById(R.id.eight);
        btn9 = (Button)findViewById(R.id.nine);
        btnC = (Button)findViewById(R.id.clear);
        btnBack = (Button)findViewById(R.id.btnBackspace);
        btnSin = (Button)findViewById(R.id.sin);
        btnCos = (Button)findViewById(R.id.cos);
        btnx2 = (Button)findViewById(R.id.x2);
        btnx3 = (Button)findViewById(R.id.x3);
        btnSqrt = (Button)findViewById(R.id.sqrt);
        btnLeft = (Button)findViewById(R.id.left);
        btnRight = (Button)findViewById(R.id.right);
        btnAdd = (Button)findViewById(R.id.plus) ;
        btnSub = (Button)findViewById(R.id.minus);
        btnMul = (Button)findViewById(R.id.multi) ;
        btnDiv = (Button)findViewById(R.id.div);
        btnDot = (Button)findViewById(R.id.dot);
        btnEqu = (Button)findViewById(R.id.equals);
        btnPlu = (Button)findViewById(R.id.plusorminus);
        editText = (EditText)findViewById(R.id.result_main) ;


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input = input.substring(0, input.length() -1);
                editText.setText(input);
            }
        });
        this.btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "s";
                editText.setText(input);
            }
        });
        this.btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "c";
                editText.setText(input);
            }
        });
        this.btnx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "²";
                editText.setText(input);
            }
        });
        this.btnx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input +="³";
                editText.setText(input);
            }
        });
        this.btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "√";
                editText.setText(input);
            }
        });
        this.btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "(";
                editText.setText(input);
            }
        });
        this.btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input +=")";
                editText.setText(input);
            }
        });
        this.btnAdd.setOnClickListener(this);

        this.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input +="-";
                editText.setText(input);
            }
        });
        this.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input +="*";
                editText.setText(input);
            }
        });
        this.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += "/";
                editText.setText(input);
            }
        });
        this.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                input += ".";
                editText.setText(input);
            }
        });
        this.btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(input, "onClick: ");
                input= String.valueOf(Calculators.evaluateExpression(input));
                Log.d(input, "onClick: ");
                editText.setText(input);
            }
        });
        this.btnPlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                double d =  Double.parseDouble(input);
                d=d*(-1);
                input = String.valueOf(d);
                editText.setText(input);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        install();
    }

    @Override
    public void onClick(View v) {
        String string = ((Button) v).getText().toString();
        input = editText.getText().toString();
        input = input + string;
        editText.setText(input);
    }
}