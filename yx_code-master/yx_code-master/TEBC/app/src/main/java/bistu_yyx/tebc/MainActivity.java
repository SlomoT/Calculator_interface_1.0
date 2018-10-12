package bistu_yyx.tebc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.support.annotation.IdRes;


public class MainActivity extends AppCompatActivity {
    public EditText edit;
    public CheckBox checkbox1;
    public CheckBox checkbox2;
    public CheckBox checkbox3;
    public RadioButton radio1;
    public RadioButton radio2;
    public RadioButton radio3;
    public TextView text;

    private boolean checkFoUser = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_1);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox_2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox_3);
        radio1 = (RadioButton) findViewById(R.id.radio_1);
        radio2 = (RadioButton) findViewById(R.id.radio_2);
        radio3 = (RadioButton) findViewById(R.id.radio_3);
        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
            }
        });


        checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == checkFoUser) {
                    text.setText(text.getText().toString()+ checkbox1.getText().toString());
                }
                else
                    text.setText("");

            }
        });
        checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == checkFoUser) {
                    text.setText(text.getText().toString()+ checkbox2.getText().toString());
                }
                else
                    text.setText("");
            }
        });
        checkbox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == checkFoUser) {
                    text.setText(text.getText().toString()+ checkbox3.getText().toString());
                }
                else
                    text.setText("");
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radio_1) {
                    text.setText(""+ radio1.getText().toString());
                }
                if (checkedId == R.id.radio_2) {
                    text.setText(""+ radio2.getText().toString());
                }
                if (checkedId == R.id.radio_3) {
                    text.setText(""+ radio3.getText().toString());
                }
            }
        });


    }
}
