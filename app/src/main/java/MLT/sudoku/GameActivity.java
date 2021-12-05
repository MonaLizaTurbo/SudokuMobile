package MLT.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;

import MLT.sudoku.dataBase.DatabaseHelper;
import MLT.sudoku.dataBase.GameLevel;

public class GameActivity extends AppCompatActivity {

    Button btn0;
    String gameLevelLevel;
    GameLevel gameLevel = new GameLevel();
    Long timeStamp;
    TextView levelName;

    //list of buttons which insert values into the grid
    public static final int[] INSERT_BUTTONS_IDS = {
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9
    };

    //list of grid buttons
    public static final int[] BUTTON_IDS = {
            R.id.button_board_0,
            R.id.button_board_1,
            R.id.button_board_2,
            R.id.button_board_9,
            R.id.button_board_10,
            R.id.button_board_11,
            R.id.button_board_18,
            R.id.button_board_19,
            R.id.button_board_20,

            R.id.button_board_3,
            R.id.button_board_4,
            R.id.button_board_5,
            R.id.button_board_12,
            R.id.button_board_13,
            R.id.button_board_14,
            R.id.button_board_21,
            R.id.button_board_22,
            R.id.button_board_23,

            R.id.button_board_6,
            R.id.button_board_7,
            R.id.button_board_8,
            R.id.button_board_15,
            R.id.button_board_16,
            R.id.button_board_17,
            R.id.button_board_24,
            R.id.button_board_25,
            R.id.button_board_26,

            R.id.button_board_27,
            R.id.button_board_28,
            R.id.button_board_29,
            R.id.button_board_36,
            R.id.button_board_37,
            R.id.button_board_38,
            R.id.button_board_45,
            R.id.button_board_46,
            R.id.button_board_47,

            R.id.button_board_30,
            R.id.button_board_31,
            R.id.button_board_32,
            R.id.button_board_39,
            R.id.button_board_40,
            R.id.button_board_41,
            R.id.button_board_48,
            R.id.button_board_49,
            R.id.button_board_50,

            R.id.button_board_33,
            R.id.button_board_34,
            R.id.button_board_35,
            R.id.button_board_42,
            R.id.button_board_43,
            R.id.button_board_44,
            R.id.button_board_51,
            R.id.button_board_52,
            R.id.button_board_53,

            R.id.button_board_54,
            R.id.button_board_55,
            R.id.button_board_56,
            R.id.button_board_63,
            R.id.button_board_64,
            R.id.button_board_65,
            R.id.button_board_72,
            R.id.button_board_73,
            R.id.button_board_74,

            R.id.button_board_57,
            R.id.button_board_58,
            R.id.button_board_59,
            R.id.button_board_66,
            R.id.button_board_67,
            R.id.button_board_68,
            R.id.button_board_75,
            R.id.button_board_76,
            R.id.button_board_77,

            R.id.button_board_60,
            R.id.button_board_61,
            R.id.button_board_62,
            R.id.button_board_69,
            R.id.button_board_70,
            R.id.button_board_71,
            R.id.button_board_78,
            R.id.button_board_79,
            R.id.button_board_80,
    };

    ArrayList<ArrayList<Button>> btnBoardList = new ArrayList<>();
    ArrayList<Button> btnInsertList = new ArrayList<>();

    //array which stores level
    private String[][] gameboard = new String[9][9];

    //array which stores solved level
    private String[][] solvedLevel = new String[9][9];

    //array which stores level modified by player
    private String[][] playerBoard = new String[9][9];


    //variable which stores number of selected grid square
    int choosenSquare = new Integer(0);
    int choosenButton = new Integer(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        levelName = findViewById(R.id.game_textView_level_name);

        timeStamp = Instant.now().getEpochSecond();

        Intent intent = getIntent();

        levelName.setText(getIntent().getStringExtra("levelName"));
        gameLevelLevel = intent.getStringExtra("levelId");

        DatabaseHelper db = new DatabaseHelper(this);

        gameLevel = db.getGameLevelByLevel(gameLevelLevel);

        db.close();

        gameboard = writeFromStringToArray(gameLevel.getGame_level());
        solvedLevel = writeFromStringToArray(gameLevel.getGame_solution());
        playerBoard = writeFromStringToArray(gameLevel.getPlayer_level());

        btn0 = findViewById(R.id.button_0);

        // initialize of buttons
        int buttonIterator = 1;
        for (int id : INSERT_BUTTONS_IDS) {

            Button button = findViewById(id);
            int finalButtonIterator1 = buttonIterator;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertValue(finalButtonIterator1);
                    if(checkIfSolvedCorrectly(playerBoard, solvedLevel))
                        endGame();
                }
            });
            buttonIterator++;
            btnInsertList.add(button);
        }

        // initialize of buttons
        buttonIterator = 0;
        int row = 0;
        int column = 0;
        ArrayList<Button> helpButtonArrayList = new ArrayList<>();
        for (int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setTextSize(1,25);
            button.setText(playerBoard[row][column]);
            if (gameboard[row][column].matches("")) {
                button.setBackground(getResources().getDrawable(R.drawable.button_board_form));
            } else {

                button.setBackground(getResources().getDrawable(R.drawable.button_board_permanent_form));
            }
            int finalButtonIterator = buttonIterator;
            if(gameboard[row][column].matches("")) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eraseColor(choosenSquare);
                        choosenSquare = finalButtonIterator;
                        colorBoard(finalButtonIterator);
                    }
                });
            }
            helpButtonArrayList.add(button);
            buttonIterator++;
            if (buttonIterator % 9 == 0) {
                btnBoardList.add((ArrayList<Button>) helpButtonArrayList.clone());
                helpButtonArrayList.clear();

            }
            column++;
            if (column == 9) {
                row++;
                column = 0;
            }
            if (row == 9) {
                row = 0;
            }
        }


        //SELECT THE NUMBER TO SET==================================================================
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int placeIterator = 0;
                for (int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        if (choosenSquare == placeIterator && gameboard[row][column].matches("")) {
                            btnBoardList.get(row).get(column).setText("");
                            row = 9;
                            column = 9;
                        }
                        placeIterator++;
                    }
                }
            }
        });

    }


    //function that inserts value in to the grid
    private void insertValue(int value){
        String test = "";
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(gameboard[row][column].matches("")){
                    test+=" ";
                }
                else
                    test+=gameboard[row][column];
             }
            test+="\n";
            }

        int placeIterator = 0;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (choosenSquare == placeIterator && gameboard[row][column].matches("")) {
                        btnBoardList.get(row).get(column).setText(String.valueOf(value));
                        playerBoard[row][column] = String.valueOf(value);
                        row = 9;
                        column = 9;
                    }

                placeIterator++;
            }
        }
    }

    //change color of previously selected buttons to normal colour
    private void eraseColor(int chosenSquare) {
        int tableIterator = 0;
        int row = 0;
        int column = 0;
        for(int rowIt = 0 ; rowIt < 9 ; rowIt++){
            for(int columnIt = 0 ; columnIt < 9 ; columnIt++){
                if(tableIterator == chosenSquare){
                    row = rowIt;
                    column = columnIt;
                    columnIt = 9;
                    rowIt = 9;
                }
                tableIterator++;
            }
        }

        int rowStart = 0;
        int rowEnd;
        int columnStart = 0;
        int columnEnd;

        switch (row) {
            case 0:
            case 1:
            case 2:
                rowStart = 0;
                break;
            case 3:
            case 4:
            case 5:
                rowStart = 3;
                break;
            case 6:
            case 7:
            case 8:
                rowStart = 6;
                break;
        }

        rowEnd = rowStart + 2;

        switch (column) {
            case 0:
            case 1:
            case 2:
                columnStart = 0;
                break;
            case 3:
            case 4:
            case 5:
                columnStart = 3;
                break;
            case 6:
            case 7:
            case 8:
                columnStart = 6;
                break;
        }

        columnEnd = columnStart + 2;

        for(int iterator = 0 ;  iterator < 9 ; iterator++){
            if(!gameboard[row][iterator].matches("")){
                btnBoardList.get(row).get(iterator).setBackground(getResources().getDrawable(R.drawable.button_board_permanent_form));
            }
            else {
                btnBoardList.get(row).get(iterator).setBackground(getResources().getDrawable(R.drawable.button_board_form));
            }
            if(!gameboard[iterator][column].matches("")){
                btnBoardList.get(iterator).get(column).setBackground(getResources().getDrawable(R.drawable.button_board_permanent_form));
            }
            else {
                btnBoardList.get(iterator).get(column).setBackground(getResources().getDrawable(R.drawable.button_board_form));
            }
        }

        while(rowStart <= rowEnd){
            for(int columnIterator = columnStart ; columnIterator <= columnEnd ; columnIterator++){
                if(!gameboard[rowStart][columnIterator].matches("")){
                    btnBoardList.get(rowStart).get(columnIterator).setBackground(getResources().getDrawable(R.drawable.button_board_permanent_form));
                }
                else {
                    btnBoardList.get(rowStart).get(columnIterator).setBackground(getResources().getDrawable(R.drawable.button_board_form));
                }
            }
            rowStart++;
        }

    }

    //change colour of selected button
    private void colorBoard(int finalButtonIterator) {
        int tableIterator = 0;
        int row = 0;
        int column = 0;
        for(int rowIt = 0 ; rowIt < 9 ; rowIt++){
            for(int columnIt = 0 ; columnIt < 9 ; columnIt++){
                if(tableIterator == finalButtonIterator){
                    row = rowIt;
                    column = columnIt;
                    columnIt = 9;
                    rowIt = 9;
                }
                tableIterator++;
            }
        }

        int rowStart = 0;
        int rowEnd;
        int columnStart = 0;
        int columnEnd;

        switch (row) {
            case 0:
            case 1:
            case 2:
                rowStart = 0;
                break;
            case 3:
            case 4:
            case 5:
                rowStart = 3;
                break;
            case 6:
            case 7:
            case 8:
                rowStart = 6;
                break;
        }

        rowEnd = rowStart + 2;

        switch (column) {
            case 0:
            case 1:
            case 2:
                columnStart = 0;
                break;
            case 3:
            case 4:
            case 5:
                columnStart = 3;
                break;
            case 6:
            case 7:
            case 8:
                columnStart = 6;
                break;
        }

        columnEnd = columnStart + 2;

        for(int iterator = 0 ;  iterator < 9 ; iterator++){
            if(!gameboard[row][iterator].matches("")){
                btnBoardList.get(row).get(iterator).setBackground(getResources().getDrawable(R.drawable.button_board_selected_row_permanent_form));
            }
            else {
                btnBoardList.get(row).get(iterator).setBackground(getResources().getDrawable(R.drawable.button_board_selected_row_form));
            }
            if(!gameboard[iterator][column].matches("")){
                btnBoardList.get(iterator).get(column).setBackground(getResources().getDrawable(R.drawable.button_board_selected_row_permanent_form));
            }
            else {
                btnBoardList.get(iterator).get(column).setBackground(getResources().getDrawable(R.drawable.button_board_selected_row_form));
            }
        }


        while(rowStart <= rowEnd){
            for(int columnIterator = columnStart ; columnIterator <= columnEnd ; columnIterator++){
                if(!gameboard[rowStart][columnIterator].matches("")){
                    btnBoardList.get(rowStart).get(columnIterator).setBackground(getResources().getDrawable(R.drawable.button_board_selected_square_permanent_form));
                }
                else {
                    btnBoardList.get(rowStart).get(columnIterator).setBackground(getResources().getDrawable(R.drawable.button_board_selected_square_form));
                }
            }
            rowStart++;
        }
        btnBoardList.get(row).get(column).setBackground(getResources().getDrawable(R.drawable.button_board_selected_form));


    }

    //function that translate level from array to string
    private String writeFromArrayToString(String[][] gameLevel){
        String level = new String();
        for(int row = 0 ; row < 9 ; row++){
            for(int column = 0 ; column < 9 ; column++){
                if(gameLevel[row][column].matches("")){
                    level += " ";
                }
                else {
                    level += gameLevel[row][column];
                }
            }
        }
        return level;
    }

    //function that translate level from string to array
    private String[][] writeFromStringToArray(String level){
        String[][] levelArray = new String[9][9];
        int levelIterator = 0;

        for(int row = 0 ; row < 9 ; row++){
            for(int column = 0 ; column < 9 ; column++){
                switch (level.charAt(levelIterator)) {
                    case ' ':
                        levelArray[row][column] = "";
                        break;
                    default :
                        levelArray[row][column] = String.valueOf(level.charAt(levelIterator));
                }
                levelIterator++;
            }
        }

        return levelArray;
    }

    //function that checks if user solved level correctly
    boolean checkIfSolvedCorrectly (String[][] playerSolution, String[][] solution){
        Boolean correctFlag = true;
        for(int row = 0 ; row < 9 && correctFlag ; row++){
            for(int column = 0 ; column < 9 && correctFlag ; column++){
                if(!playerSolution[row][column].matches(solution[row][column])){
                    correctFlag = false;
                }
            }
        }
        return correctFlag;
    }

    //function which ends game after user solved level
    void endGame(){
        DecimalFormat df = new DecimalFormat("###");
        String playTimeMin = df.format((gameLevel.getPlaying_time() + (Instant.now().getEpochSecond() - timeStamp))/60);
        String playTimeSec = String.valueOf((gameLevel.getPlaying_time() + (Instant.now().getEpochSecond() - timeStamp)) % 60);
        gameLevel.setLevel_state(2);
        gameLevel.setPlaying_time(0);
        gameLevel.setPlayer_level(gameLevel.getGame_level());
        DatabaseHelper db = new DatabaseHelper(this);
        db.updateGameLevel(gameLevel);
        db.close();
        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("levelName", levelName.getText());
        intent.putExtra("playTime", playTimeMin + "m " + playTimeSec + "s ");
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(GameActivity.this, (View) levelName, "levelName");
        startActivity(intent, optionsCompat.toBundle());
    }

    //function which saves player progress if activity is stopped
    void savePlayerLevel(){
        Integer timeDifference = Integer.valueOf(String.valueOf(Instant.now().getEpochSecond() - timeStamp));
        DatabaseHelper db = new DatabaseHelper(this);
        gameLevel.setPlayer_level(writeFromArrayToString(playerBoard));
        gameLevel.setPlaying_time(Integer.valueOf(gameLevel.getPlaying_time() + timeDifference));
        gameLevel.setLevel_state(1);
        db.updateGameLevel(gameLevel);
        db.close();
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePlayerLevel();
        supportFinishAfterTransition();
    }
}