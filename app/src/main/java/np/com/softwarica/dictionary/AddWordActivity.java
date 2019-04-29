package np.com.softwarica.dictionary;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {

    private EditText etWord,etMeaning;
    private Button btnWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord= findViewById(R.id.etWord);
        etMeaning= findViewById(R.id.etMeaning);
        btnWord= findViewById(R.id.btnWord);

        btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save() {
//        try {
//            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
//            printStream.println(etWord.getText().toString() + "->" + etMeaning.getText().toString());
//            printStream.close();
//            Toast.makeText(this,"Saved to" + getFilesDir(), Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            Log.d("Dictionary app", "Message error" + e.toString());
//            e.printStackTrace();
//        }

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        if(myHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase)){
            Toast.makeText(this, "1 Row Inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Failed to insert data.", Toast.LENGTH_SHORT).show();
        }
    }

}
