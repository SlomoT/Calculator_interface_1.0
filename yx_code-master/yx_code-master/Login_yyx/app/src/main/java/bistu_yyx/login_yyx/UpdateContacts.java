package bistu_yyx.login_yyx;

/*
修改联系人
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContacts extends AppCompatActivity {
    private EditText name;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contacts);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);

        Button Q_B = (Button) findViewById(R.id.QButton);
        Q_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        Button C_B = (Button) findViewById(R.id.CButton);
        C_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateContacts.this,Contacts.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void update() {
        String n = name.getText().toString();
        String p = phone.getText().toString();

        Intent it = new Intent(Intent.ACTION_INSERT_OR_EDIT);
        it.setType("vnd.android.cursor.item/person");
        //联系人姓名
        it.putExtra(android.provider.ContactsContract.Intents.Insert.NAME, n);
        //联系人电话
        it.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, p);
        startActivity(it);
        Toast.makeText(this, "联系人数据编辑成功", Toast.LENGTH_SHORT).show();

    }
}