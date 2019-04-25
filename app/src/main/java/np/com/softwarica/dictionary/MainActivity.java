package np.com.softwarica.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String countires[] = {
            " Nepal", "Kathamandu",
            "India", "Delhi",
            "China", "Beijing",
            "UK", "London",
            "US", "Washington DC",
            "Canada", "Ottawa"

    };
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listcountries = findViewById(R.id.countryarray);
        dictionary = new HashMap<>();
        for (int i = 0;
        i<countires.length;i+=2){
            dictionary.put(countires[i],countires[i+1]);
        }
            ArrayAdapter countryAdapter =new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1,
                    new ArrayList(dictionary.keySet())
        );
        listcountries.setAdapter(countryAdapter);
        listcountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country=parent.getItemAtPosition(position).toString();
                String capital=dictionary.get(country);
                Intent intent= new Intent(MainActivity.this, CapitalActivity.class);
                intent.putExtra("capital",capital );
                startActivity(intent);
            }
        });

    }
}
