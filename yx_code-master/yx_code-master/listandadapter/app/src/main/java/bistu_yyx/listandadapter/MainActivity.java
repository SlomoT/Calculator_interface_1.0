package bistu_yyx.listandadapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private static final String NAME = "name";
    private static final String NUMBER = "number";
    private static final String DETAIL = "detail";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.list_test);
        String[] array = new String[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + "";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_list, array);

        int size = 10;
        String[] names = new String[size];
        String[] numbers = new String[size];
        String[] details = new String[size];
        List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            names[i] = NAME + i;
            numbers[i] = NUMBER + i;
            details[i] = DETAIL + i + " " + DETAIL + i + " " + DETAIL + i + " " + DETAIL + i;

            HashMap<String, String> map = new HashMap<>();
            map.put(NAME, names[i]);
            map.put(NUMBER, numbers[i]);
            map.put(DETAIL, details[i]);

            items.add(map);
        }

        SimpleAdapter adapter1 = new SimpleAdapter(this,
                items,
                R.layout.item_detail,
                new String[]{NAME, NUMBER, DETAIL},
                new int[]{R.id.name, R.id.number, R.id.detail}
        );
        list.setAdapter(adapter1);
    }
}
