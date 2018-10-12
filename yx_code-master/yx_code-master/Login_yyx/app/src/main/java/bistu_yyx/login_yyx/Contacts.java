package bistu_yyx.login_yyx;

/*
查看联系人页面
*/

import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.database.CursorWrapper;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.widget.AdapterView;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import android.Manifest;

public class Contacts extends BaseActivity {
    ListAdapter adapter;
    List<String> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ListView contactsView = (ListView) findViewById(R.id.contact_view);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList);
        contactsView.setAdapter(adapter);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_CONTACTS
            }, 1);
        } else {
            readContacts();

            contactsView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                ListView contactsView = (ListView) findViewById(R.id.contact_view);
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    //从指针的封装类中获得选中项的电话号码并拨号
                    CursorWrapper wrapper=(CursorWrapper)contactsView.getItemAtPosition(position);
                    int columnIndex = wrapper.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    if(!wrapper.isNull(columnIndex)){
                        String number=wrapper.getString(columnIndex);
                        Log.d(" ","number = " + number);
                        //判断电话号码的有效性
                        if(PhoneNumberUtils.isGlobalPhoneNumber(number)){
                            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+ number));
                            startActivity(intent);
                        }
                    }
                }
            });
        }

        //登出按钮
        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("bistu_yyx.login_yyx.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

        //修改联系人按钮
        Button Update = (Button) findViewById(R.id.Update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contacts.this, UpdateContacts.class);
                startActivity(intent);
                finish();
            }
        });

        //新增联系人按钮
        Button Add = (Button) findViewById(R.id.Add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contacts.this, AddContacts.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void readContacts() {
        ListView contactsView = (ListView) findViewById(R.id.contact_view);
        Cursor cur = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null,null,null);
        adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cur,new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},new int[]{android.R.id.text1,android.R.id.text2});
        this.startManagingCursor(cur);
        contactsView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    readContacts();
                }else{
                    Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
