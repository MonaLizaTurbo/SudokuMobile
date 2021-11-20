package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import MLT.sudoku.dataBase.DatabaseHelper;
import MLT.sudoku.dataBase.GameLevel;

public class SettingsActivity extends AppCompatActivity {

    Button btnLoad;

    String[] levelsList = {"89125674356274319873418926561847253927539841634961587215392468792786135448653792 "};

    String[] levelsSolvedList = {"891256743562743198734189265618472539275398416349615872153924687927861354486537921"};

//    String[] levelsList = {"8   5     62  31   3 1 9       7253 2 5 984 6 4961       9 4 8   78  35     3   1",
//            " 2   8  47 9  6    6    3   5 8 4 1    152     2 6    5      8       142 8  1 6 3",
//            "8    59 27    3   63  4 8   2 3  5      8      8  7 6   7 3  29   9    51 92    3"};
//
//    String[] levelsSolvedList = {"891256743562743198734189265618472539275398416349615872153924687927861354486537921",
//            "125378964739546821864291375956834217378152496412967538541623789693785142287419653",
//            "841765932795823416632149857924316578576482391318597264457638129283971645169254783"};

//    String[] levelsList = {"    94   4 5  7  28  3  6 97   3  9    9  2   49  57 3 7  6 9      49    5  814 7",
//            "3 4 7189 8  23  5  1  48   7     6    57   38   9 4 17     27 4  28   6     1    ",
//    "  7  5    2 93   713   65    3    68   71   9 8  9   45     4      8   3 7   9   "};
//
//    String[] levelsSolvedList = {"36289417549561783281735264972143859653897621464912578317456392886749351953281467",
//    "324571896876239451519648273798153642145726938263984517951362784432897165687415329",
//    "847125396625934817139876542913452768456718239782693154598367421264581973371249685"};

    int[] levelsDifficultyList = {0, 1, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

        btnLoad = findViewById(R.id.button_load);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                for(int i = 0 ; i < levelsList.length ; i++){
                    GameLevel gameLevel = new GameLevel();
                    gameLevel.setDifficulty(levelsDifficultyList[i]);
                    gameLevel.setGame_level(levelsList[i]);
                    gameLevel.setGame_solution(levelsSolvedList[i]);
                    gameLevel.setLevel_state(0);
                    gameLevel.setPlayer_level(levelsList[i]);
                    gameLevel.setPlaying_time(0);
                    dbHelper.insertGameLevel(gameLevel);
                }

                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.menu_settings_toast_successfully),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}