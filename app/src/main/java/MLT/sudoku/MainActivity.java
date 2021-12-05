package MLT.sudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import MLT.sudoku.dataBase.DatabaseHelper;
import MLT.sudoku.dataBase.GameLevel;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;

    int defaultValue = 0;
    int databaseVer = 0;
    int localDatabaseVer = 0;

    private List<GameLevel> gameLevels = new ArrayList<>();
    private List<GameLevel> serverGameLevels = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnPlay = findViewById(R.id.button_play);

        //get local database version
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        localDatabaseVer = sharedPref.getInt(getString(R.string.preferences_db_ver), defaultValue);

        //get server database version
        getDatabaseVersion();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LevelSelectionActivity.class);
                startActivity(intent);
            }
        });

    }

    void getDatabaseVersion() {
        DatabaseReference reference =
                FirebaseDatabase
                        .getInstance("https://mobile5ud0ku-default-rtdb.europe-west1.firebasedatabase.app")
                        .getReference("database_version").child("version");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                databaseVer = Integer.valueOf((String) dataSnapshot.getValue());
                //check if local database version is the same as server one
                if (localDatabaseVer != databaseVer) {
                    //if not, update database
                    downloadGameLevelsFromServer();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    void updateLocalDatabase(){
        DatabaseHelper db = new DatabaseHelper(this);
        gameLevels.clear();
        gameLevels.addAll(db.getAllGameLevels());

        //check if downloaded level already exist in database, if not insert it to database
        for(int i = 0 ; i < serverGameLevels.size() ; i++){
            boolean flagUnique = true;
            for(int j = 0 ; j < gameLevels.size() ; j++){
                if(serverGameLevels.get(i).getGame_level().matches(gameLevels.get(j).getGame_level())){
                    flagUnique = false;
                }
            }
            if(flagUnique){
                db.insertGameLevel(serverGameLevels.get(i));
            }
        }

        db.close();

        //update local database version
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.preferences_db_ver), databaseVer);
        editor.apply();

    }

    void insertAllIntoLocalDatabase(){

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        //insert to database all levels downloaded from server
        for(int i = 0 ; i < serverGameLevels.size() ; i++){
            db.insertGameLevel(serverGameLevels.get(i));
        }

        db.close();
        if(serverGameLevels.size() != 0) {
            //enable button which allows to go to levels list
            btnPlay.setEnabled(true);

            //update local database version
            SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(getString(R.string.preferences_db_ver), databaseVer);
            editor.apply();
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Unable to connect to database",
                    Toast.LENGTH_SHORT).show();
        }
    }

    List<GameLevel> downloadGameLevelsFromServer(){
        List<GameLevel> gameList = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance("https://mobile5ud0ku-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        Query query = reference.child("levels");

        //download levels from database
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<GameLevel> levelsList = new ArrayList<>();
                    for (DataSnapshot level : dataSnapshot.getChildren()) {
                        GameLevel gameLevel = new GameLevel();
                        gameLevel.setGame_solution(String.valueOf(level.child("solved").getValue()));
                        gameLevel.setPlayer_level(String.valueOf(level.child("level").getValue()));
                        gameLevel.setGame_level(String.valueOf(level.child("level").getValue()));
                        gameLevel.setDifficulty(Integer.valueOf(String.valueOf(level.child("difficulty").getValue())));
                        gameLevel.setLevel_state(0);
                        gameLevel.setPlaying_time(0);
                        serverGameLevels.add(gameLevel);
                    }
                    DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                    //if local database is empty
                    if(localDatabaseVer == 0){
                        //insert to database all downloaded levels
                        insertAllIntoLocalDatabase();

                    }
                    //if not
                    else {
                        //insert only new one
                        updateLocalDatabase();
                    }
                    localDatabaseVer = databaseVer;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return gameList;
    }

}