package MLT.sudoku.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import MLT.sudoku.GameActivity;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "sudoku_db";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(GameLevel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GameLevel.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public void insertGameLevel(GameLevel gameLevel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(GameLevel.COLUMN_LEVEL_OF_DIFFICULTY, gameLevel.getDifficulty());
        values.put(GameLevel.COLUMN_LEVEL_STATE, gameLevel.getLevel_state());
        values.put(GameLevel.COLUMN_GAME_LEVEL, gameLevel.getGame_level());
        values.put(GameLevel.COLUMN_GAME_SOLUTION, gameLevel.getGame_solution());
        values.put(GameLevel.COLUMN_PLAYER_LEVEL, gameLevel.getPlayer_level());
        values.put(GameLevel.COLUMN_PLAYING_TIME, gameLevel.getPlaying_time());

        db.insert(GameLevel.TABLE_NAME, null, values);

        db.close();
    }


    public List<GameLevel> getGameLevelsWithChosenDifficulty(int difficultyLevel){
        List<GameLevel> gameLevelList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(GameLevel.TABLE_NAME,
                new String[]{GameLevel.COLUMN_ID, GameLevel.COLUMN_LEVEL_OF_DIFFICULTY,
                        GameLevel.COLUMN_LEVEL_STATE, GameLevel.COLUMN_GAME_LEVEL,
                        GameLevel.COLUMN_GAME_SOLUTION,
                        GameLevel.COLUMN_PLAYER_LEVEL, GameLevel.COLUMN_PLAYING_TIME},
                GameLevel.COLUMN_LEVEL_OF_DIFFICULTY + " = ? ",
                new String[]{String.valueOf(difficultyLevel)}, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                GameLevel gameLevel = new GameLevel();
                gameLevel.setId(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_ID)));
                gameLevel.setDifficulty(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_OF_DIFFICULTY)));
                gameLevel.setLevel_state(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_STATE)));
                gameLevel.setGame_level(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_LEVEL)));
                gameLevel.setGame_solution(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_SOLUTION)));
                gameLevel.setPlayer_level(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_PLAYER_LEVEL)));
                gameLevel.setPlaying_time(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_PLAYING_TIME)));

                gameLevelList.add(gameLevel);
            }while (cursor.moveToNext());
        }
        db.close();

        return gameLevelList;
    }

    public GameLevel getGameLevelByLevel(String level) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(GameLevel.TABLE_NAME,
                new String[]{GameLevel.COLUMN_ID, GameLevel.COLUMN_LEVEL_OF_DIFFICULTY,
                GameLevel.COLUMN_LEVEL_STATE, GameLevel.COLUMN_GAME_LEVEL,
                        GameLevel.COLUMN_GAME_SOLUTION,
                GameLevel.COLUMN_PLAYER_LEVEL, GameLevel.COLUMN_PLAYING_TIME},
                GameLevel.COLUMN_GAME_LEVEL + " = ? ",
                new String[]{level}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        GameLevel gameLevel = new GameLevel(
                cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_ID)),
                cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_OF_DIFFICULTY)),
                cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_STATE)),
                cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_LEVEL)),
                cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_SOLUTION)),
                cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_PLAYER_LEVEL)),
                cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_PLAYING_TIME))
        );

        cursor.close();
        db.close();
        return gameLevel;
    }

    public List<GameLevel> getAllGameLevels(){
        List<GameLevel> gameLevelList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + GameLevel.TABLE_NAME +
                " ORDER BY " + GameLevel.COLUMN_LEVEL_OF_DIFFICULTY + " DESC ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GameLevel gameLevel = new GameLevel();
                gameLevel.setId(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_ID)));
                gameLevel.setDifficulty(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_OF_DIFFICULTY)));
                gameLevel.setLevel_state(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_LEVEL_STATE)));
                gameLevel.setGame_level(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_LEVEL)));
                gameLevel.setGame_solution(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_GAME_SOLUTION)));
                gameLevel.setPlayer_level(cursor.getString(cursor.getColumnIndex(GameLevel.COLUMN_PLAYER_LEVEL)));
                gameLevel.setPlaying_time(cursor.getInt(cursor.getColumnIndex(GameLevel.COLUMN_PLAYING_TIME)));

                gameLevelList.add(gameLevel);
            }while (cursor.moveToNext());
        }
        db.close();

        return gameLevelList;
    }


    public int getGameLevelsCount(){
        String countQuery = "SELECT * FROM " + GameLevel.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count;
    }

    public int updateGameLevel(GameLevel gameLevel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(GameLevel.COLUMN_LEVEL_OF_DIFFICULTY, gameLevel.getDifficulty());
        values.put(GameLevel.COLUMN_LEVEL_STATE, gameLevel.getLevel_state());
        values.put(GameLevel.COLUMN_GAME_LEVEL, gameLevel.getGame_level());
        values.put(GameLevel.COLUMN_GAME_SOLUTION, gameLevel.getGame_solution());
        values.put(GameLevel.COLUMN_PLAYER_LEVEL, gameLevel.getPlayer_level());
        values.put(GameLevel.COLUMN_PLAYING_TIME, gameLevel.getPlaying_time());

        return  db.update(GameLevel.TABLE_NAME, values, GameLevel.COLUMN_GAME_LEVEL + " = ? ",
                new String[]{String.valueOf(gameLevel.getGame_level())});
    }
}
