package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
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

public class LevelSelectionActivity extends AppCompatActivity {

    private RecyclerViewAdapter recyclerViewAdapter;
    private List<GameLevel> gameList = new ArrayList<>();
//    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private Button btnEasy;
    private Button btnMedium;
    private Button btnHard;

    private int btnState = 1;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        getSupportActionBar().hide();
//        coordinatorLayout = findViewById(R.id.coo)
        recyclerView = findViewById(R.id.recycler_view);
        btnEasy = findViewById(R.id.level_selection_button_easy);
        btnMedium = findViewById(R.id.level_selection_button_medium);
        btnHard = findViewById(R.id.level_selection_button_hard);

        db = new DatabaseHelper(this);


        changeButtonColors(1);
        changeDisplayedLevels(1);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(0);
                changeDisplayedLevels(0);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(1);
                changeDisplayedLevels(1);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColors(2);
                changeDisplayedLevels(2);
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
                //startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                startActivity(intent, optionsCompat.toBundle());

                Log.d("TEST", "short");
            }

            @Override
            public void onLongClick(View view, int position) {
                clearLevelProgress(position);
            }
        }));

    }

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
        Log.d("TEST", "long");
    }


    void changeButtonColors(int btnNumber){
        switch(btnState){
            case 0:
                btnEasy.setBackground(getDrawable(R.drawable.button_level_selection_left_form));
                break;
            case 1:
                btnMedium.setBackground(getDrawable(R.drawable.button_level_selection_middle_form));
                break;
            case 2:
                btnHard.setBackground(getDrawable(R.drawable.button_level_selection_right_form));
                break;
        }

        btnState = btnNumber;

        switch(btnState){
            case 0:
                btnEasy.setBackground(getDrawable(R.drawable.button_level_selection_left_selected_form));
                break;
            case 1:
                btnMedium.setBackground(getDrawable(R.drawable.button_level_selection_middle_selected_form));
                break;
            case 2:
                btnHard.setBackground(getDrawable(R.drawable.button_level_selection_right_selected_form));
                break;
        }
    }

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