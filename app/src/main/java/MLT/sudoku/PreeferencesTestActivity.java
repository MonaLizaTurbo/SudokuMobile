package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class PreeferencesTestActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preeferences_test);
        editText = findViewById(R.id.editTextPreferences);


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getSharedPreferences("PREF_TEST", MODE_PRIVATE).edit();
        editor.putString("editTest", editText.getText().toString());
        editor.apply();


//        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("editTest", editText.getText().toString());
//        editor.apply();
//
    }

    @Override
    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        SharedPreferences sharedPref = getSharedPreferences("PREF_TEST",MODE_PRIVATE);
        editText.setText(sharedPref.getString("editTest","No name defined"));
    }
}