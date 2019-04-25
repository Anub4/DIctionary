package np.com.softwarica.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CapitalActivity extends AppCompatActivity {
    TextView tvNextACtivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);
        tvNextACtivity=findViewById(R.id.tvNextActivity);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String capital= bundle.getString("capital");
            tvNextACtivity.setText(capital);
        }
    }
}
