package MLT.sudoku.dataBase;

public class GameLevel {

    public static final String TABLE_NAME = "game_levels";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LEVEL_OF_DIFFICULTY = "difficulty";
    public static final String COLUMN_GAME_LEVEL = "game_level";
    public static final String COLUMN_GAME_SOLUTION = "game_solution";
    public static final String COLUMN_PLAYER_LEVEL = "player_level";
    public static final String COLUMN_LEVEL_STATE = "level_state";
    public static final String COLUMN_PLAYING_TIME = "playing_time";

    private int id;
    private int difficulty;
    private String game_level;
    private String game_solution;
    private String player_level;
    private int level_state;
    private int playing_time;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_LEVEL_OF_DIFFICULTY + " INTEGER, "
            + COLUMN_LEVEL_STATE + " INTEGER, "
            + COLUMN_GAME_LEVEL + " TEXT, "
                    + COLUMN_GAME_SOLUTION + " TEXT, "
            + COLUMN_PLAYER_LEVEL + " TEXT, "
            + COLUMN_PLAYING_TIME + " INTEGER "
            + ")";


    public GameLevel(){}

    public GameLevel(int id, int difficulty, int level_state, String game_level, String game_solution, String player_level, int playing_time) {
        this.id = id;
        this.difficulty = difficulty;
        this.game_level = game_level;
        this.game_solution = game_solution;
        this.player_level = player_level;
        this.level_state = level_state;
        this.playing_time = playing_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getGame_level() {
        return game_level;
    }

    public void setGame_level(String game_level) {
        this.game_level = game_level;
    }

    public String getPlayer_level() {
        return player_level;
    }

    public void setPlayer_level(String player_level) {
        this.player_level = player_level;
    }

    public String getGame_solution() {
        return game_solution;
    }

    public void setGame_solution(String game_solution) {
        this.game_solution = game_solution;
    }

    public int getLevel_state() {
        return level_state;
    }

    public void setLevel_state(int level_state) {
        this.level_state = level_state;
    }

    public int getPlaying_time() {
        return playing_time;
    }

    public void setPlaying_time(int playing_time) {
        this.playing_time = playing_time;
    }
}
