package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EndGameActivity extends AppCompatActivity {

    private TextView textLevel;
    private TextView textTime;
    private TextView textInfo;
    private TextView textCongrats;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        getSupportActionBar().hide();

        textCongrats = findViewById(R.id.endGame_textView_congrats);
        textInfo = findViewById(R.id.endGame_textView_info);
        textTime = findViewById(R.id.endGame_textView_time);
        textLevel = findViewById(R.id.endGame_textView_level);
        btnBack = findViewById(R.id.endGame_button_back);

        btnBack.setText("Back bo level selection");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LevelSelectionActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        textLevel.setText(intent.getStringExtra("levelName"));
        textTime.setText(intent.getStringExtra("playTime"));
        textInfo.setText(getString(R.string.menu_end_game_text_in));
        textCongrats.setText(R.string.menu_end_game_text_info);


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}