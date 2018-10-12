package bistu_yyx.login_yyx;

/*
登录页面
*/

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Database dbHelper;
    private EditText username_l;
    private EditText password_l;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button LButton;
    private Button RButton;
    private Button ChangePass;
    private CheckBox remember_pass;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new Database(this, "B.db",null,2);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username_l = (EditText)findViewById(R.id.username_l);
        password_l = (EditText)findViewById(R.id.password_l) ;
        remember_pass = (CheckBox)findViewById(R.id.remember_pass);
        LButton = (Button) findViewById(R.id.LButton);
        boolean isRemember = pref.getBoolean("remember password", false);
        if(isRemember) {
            String username = pref.getString("username", "");
            String password = pref.getString("password", "");
            username_l.setText(username);
            password_l.setText(password);
            remember_pass.setChecked(true);
        }

        Button L_B = (Button) findViewById(R.id.LButton);
        L_B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = username_l.getText().toString();
                String password = password_l.getText().toString();
                boolean flag = login();
                if(flag){
                    editor = pref.edit();
                    if (remember_pass.isChecked()) {
                        editor.putBoolean("remember password", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(Login.this, Contacts.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button R_B = (Button) findViewById(R.id.RButton);
        R_B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public boolean login() {
        String username = username_l.getText().toString();
        String password = password_l.getText().toString();

        db = dbHelper.getWritableDatabase();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("xj", null, null, null, null, null, null);
        if (cursor.moveToFirst())
            do {
                String a = cursor.getString(cursor.getColumnIndex("account"));
                String b = cursor.getString(cursor.getColumnIndex("password"));

                if(username.equals(a)) {
                    if (password.equals(b)) {
                        Toast.makeText(Login.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        Toast.makeText(Login.this, "密码错误！", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else{
                    Toast.makeText(Login.this, "用户名错误！", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }while (cursor.moveToNext());
        cursor.close();
        return false;
    }

}
