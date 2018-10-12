package bistu_yyx.login_yyx;

/*
注册页面
*/

import android.os.Bundle;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.app.Activity;

public class Register extends Activity {
    private Database dbHelper;
    private EditText username_r;
    private EditText password_r;
    private EditText password2_r;

    public void reg(){
        //建表
        dbHelper.getWritableDatabase();

        //插入数据
        String u_r = username_r.getText().toString();
        username_r.setText(u_r);
        String p_r = password_r.getText().toString();
        password_r.setText(p_r);
        String p2_r = password2_r.getText().toString();
        password2_r.setText(p2_r);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(u_r.length() >= 6 && u_r.length() <= 12) {
            if (p_r.length() >= 6 && p_r.length() <= 16){
                if (p2_r.equals(p_r)) {
                    values.put("account", u_r);
                    values.put("password", p_r);
                    db.insert("xj", null, values);
                    values.clear();
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, Login.class);
                    startActivity(intent);
                } else
                    Toast.makeText(this, "两次密码不同", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "密码不正确", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "用户名不正确", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new Database(this,"B.db",null,2);
        username_r = findViewById(R.id.username_r);
        password_r = findViewById(R.id.password_r);
        password2_r = findViewById(R.id.password2_r);

        Button cancel = findViewById(R.id.NoButton);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        Button register = findViewById(R.id.OkButton);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                reg();
            }
        });
    }
}
