package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import MLT.sudoku.dataBase.DatabaseHelper;
import MLT.sudoku.dataBase.GameLevel;
import MLT.sudoku.utils.RecyclerTouchListener;
import MLT.sudoku.utils.RecyclerViewAdapter;

public class LevelSelectionActivity extends AppCompatActivity {

    private RecyclerViewAdapter recyclerViewAdapter;
    private List<GameLevel> gameList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button btnEasy;
    private Button btnMedium;
    private Button btnHard;

    private int btnState = 2;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recycler_view);
        btnEasy = findViewById(R.id.level_selection_button_easy);
        btnMedium = findViewById(R.id.level_selection_button_medium);
        btnHard = findViewById(R.id.level_selection_button_hard);

        db = new DatabaseHelper(this);


        changeButtonColors(2);
        changeDisplayedLevels(2);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(1);
                changeDisplayedLevels(1);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(2);
                changeDisplayedLevels(2);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(3);
                changeDisplayedLevels(3);
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {


                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("levelId", gameList.get(position).getGame_level());
                intent.putExtra("levelName", getString(R.string.item_level_selection_text_level) + " " + (position+1));
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(LevelSelectionActivity.this, (View) recyclerView, "levelName");
                startActivity(intent, optionsCompat.toBundle());
            }

            @Override
            public void onLongClick(View view, int position) {
                clearLevelProgress(position);
            }
        }));

    }

    @Override
    protected void onResume() {
        super.onResume();
        changeDisplayedLevels(btnState);
    }

    //clear user progress in selected level
    private void clearLevelProgress(int position) {
        db.getWritableDatabase();
        GameLevel gameLevel = db.getGameLevelByLevel(gameList.get(position).getGame_level());
        gameLevel.setPlayer_level(gameLevel.getGame_level());
        gameLevel.setLevel_state(0);
        gameLevel.setPlaying_time(0);
        db.updateGameLevel(gameLevel);

        Toast.makeText(getApplicationContext(),
                "Level cleared",
                Toast.LENGTH_SHORT).show();
    }

    //changes button colors when button is pressed
    void changeButtonColors(int btnNumber){
        switch(btnState){
            case 1:
                btnEasy.setBackground(getDrawable(R.drawable.button_level_selection_left_form));
                break;
            case 2:
                btnMedium.setBackground(getDrawable(R.drawable.button_level_selection_middle_form));
                break;
            case 3:
                btnHard.setBackground(getDrawable(R.drawable.button_level_selection_right_form));
                break;
        }

        btnState = btnNumber;

        switch(btnState){
            case 1:
                btnEasy.setBackground(getDrawable(R.drawable.button_level_selection_left_selected_form));
                break;
            case 2:
                btnMedium.setBackground(getDrawable(R.drawable.button_level_selection_middle_selected_form));
                break;
            case 3:
                btnHard.setBackground(getDrawable(R.drawable.button_level_selection_right_selected_form));
                break;
        }
    }

    //loads level of chosen difficulty
    void changeDisplayedLevels(int btnNumber){

        gameList.clear();
        gameList.addAll(db.getGameLevelsWithChosenDifficulty(btnNumber));
        recyclerViewAdapter = new RecyclerViewAdapter(this, gameList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        db.close();
    }

}