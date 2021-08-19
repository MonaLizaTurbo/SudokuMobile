package MLT.sudoku;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    ArrayList<Button> btnBoardList = new ArrayList<>();

    //ArrayList<>;

    int choosenButton = new Integer(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);

        btnBoardList.add(findViewById(R.id.button_board_0));
        btnBoardList.add(findViewById(R.id.button_board_1));
        btnBoardList.add(findViewById(R.id.button_board_2));
        btnBoardList.add(findViewById(R.id.button_board_3));
        btnBoardList.add(findViewById(R.id.button_board_4));
        btnBoardList.add(findViewById(R.id.button_board_5));
        btnBoardList.add(findViewById(R.id.button_board_6));
        btnBoardList.add(findViewById(R.id.button_board_7));
        btnBoardList.add(findViewById(R.id.button_board_8));
        btnBoardList.add(findViewById(R.id.button_board_9));
        btnBoardList.add(findViewById(R.id.button_board_10));
        btnBoardList.add(findViewById(R.id.button_board_11));
        btnBoardList.add(findViewById(R.id.button_board_12));
        btnBoardList.add(findViewById(R.id.button_board_13));
        btnBoardList.add(findViewById(R.id.button_board_14));
        btnBoardList.add(findViewById(R.id.button_board_15));
        btnBoardList.add(findViewById(R.id.button_board_16));
        btnBoardList.add(findViewById(R.id.button_board_17));
        btnBoardList.add(findViewById(R.id.button_board_18));
        btnBoardList.add(findViewById(R.id.button_board_19));
        btnBoardList.add(findViewById(R.id.button_board_20));
        btnBoardList.add(findViewById(R.id.button_board_21));
        btnBoardList.add(findViewById(R.id.button_board_22));
        btnBoardList.add(findViewById(R.id.button_board_23));
        btnBoardList.add(findViewById(R.id.button_board_24));
        btnBoardList.add(findViewById(R.id.button_board_25));
        btnBoardList.add(findViewById(R.id.button_board_26));
        btnBoardList.add(findViewById(R.id.button_board_27));
        btnBoardList.add(findViewById(R.id.button_board_28));
        btnBoardList.add(findViewById(R.id.button_board_29));
        btnBoardList.add(findViewById(R.id.button_board_30));
        btnBoardList.add(findViewById(R.id.button_board_31));
        btnBoardList.add(findViewById(R.id.button_board_32));
        btnBoardList.add(findViewById(R.id.button_board_33));
        btnBoardList.add(findViewById(R.id.button_board_34));
        btnBoardList.add(findViewById(R.id.button_board_35));
        btnBoardList.add(findViewById(R.id.button_board_36));
        btnBoardList.add(findViewById(R.id.button_board_37));
        btnBoardList.add(findViewById(R.id.button_board_38));
        btnBoardList.add(findViewById(R.id.button_board_39));
        btnBoardList.add(findViewById(R.id.button_board_40));
        btnBoardList.add(findViewById(R.id.button_board_41));
        btnBoardList.add(findViewById(R.id.button_board_42));
        btnBoardList.add(findViewById(R.id.button_board_43));
        btnBoardList.add(findViewById(R.id.button_board_44));
        btnBoardList.add(findViewById(R.id.button_board_45));
        btnBoardList.add(findViewById(R.id.button_board_46));
        btnBoardList.add(findViewById(R.id.button_board_47));
        btnBoardList.add(findViewById(R.id.button_board_48));
        btnBoardList.add(findViewById(R.id.button_board_49));
        btnBoardList.add(findViewById(R.id.button_board_50));
        btnBoardList.add(findViewById(R.id.button_board_51));
        btnBoardList.add(findViewById(R.id.button_board_52));
        btnBoardList.add(findViewById(R.id.button_board_53));
        btnBoardList.add(findViewById(R.id.button_board_54));
        btnBoardList.add(findViewById(R.id.button_board_55));
        btnBoardList.add(findViewById(R.id.button_board_56));
        btnBoardList.add(findViewById(R.id.button_board_57));
        btnBoardList.add(findViewById(R.id.button_board_58));
        btnBoardList.add(findViewById(R.id.button_board_59));
        btnBoardList.add(findViewById(R.id.button_board_60));
        btnBoardList.add(findViewById(R.id.button_board_61));
        btnBoardList.add(findViewById(R.id.button_board_62));
        btnBoardList.add(findViewById(R.id.button_board_63));
        btnBoardList.add(findViewById(R.id.button_board_64));
        btnBoardList.add(findViewById(R.id.button_board_65));
        btnBoardList.add(findViewById(R.id.button_board_66));
        btnBoardList.add(findViewById(R.id.button_board_67));
        btnBoardList.add(findViewById(R.id.button_board_68));
        btnBoardList.add(findViewById(R.id.button_board_69));
        btnBoardList.add(findViewById(R.id.button_board_70));
        btnBoardList.add(findViewById(R.id.button_board_71));
        btnBoardList.add(findViewById(R.id.button_board_72));
        btnBoardList.add(findViewById(R.id.button_board_73));
        btnBoardList.add(findViewById(R.id.button_board_74));
        btnBoardList.add(findViewById(R.id.button_board_75));
        btnBoardList.add(findViewById(R.id.button_board_76));
        btnBoardList.add(findViewById(R.id.button_board_77));
        btnBoardList.add(findViewById(R.id.button_board_78));
        btnBoardList.add(findViewById(R.id.button_board_79));
        btnBoardList.add(findViewById(R.id.button_board_80));


        btnBoardList.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(0).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(1).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(2).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(3).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(4).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(5).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(6).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(7).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(8).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(9).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(10).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(11).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(12).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(13).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(14).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(15).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(16).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(17).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(18).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(19).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(20).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(21).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(22).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(23).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(24).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(24).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(25).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(26).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(26).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(27).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(27).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(28).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(28).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(29).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(29).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(30).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(31).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(32).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(32).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(33).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(33).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(34).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(34).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(35).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(35).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(36).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(36).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(37).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(37).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(38).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(38).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(39).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(39).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(40).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(40).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(41).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(41).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(42).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(42).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(43).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(43).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(44).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(44).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(45).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(45).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(46).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(46).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(47).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(47).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(48).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(48).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(49).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(49).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(50).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(51).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(51).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(52).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(52).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(53).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(53).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(54).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(54).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(55).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(55).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(56).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(56).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(57).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(57).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(58).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(58).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(59).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(59).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(60).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(60).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(61).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(61).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(62).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(62).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(63).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(63).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(64).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(64).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(65).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(65).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(66).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(66).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(67).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(67).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(68).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(68).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(69).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(69).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(70).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(70).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(71).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(71).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(72).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(72).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(73).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(73).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(74).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(74).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(75).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(75).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(76).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(76).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(77).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(77).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(78).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(78).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(79).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(79).setText(String.valueOf(choosenButton));
            }
        });

        btnBoardList.get(80).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBoardList.get(80).setText(String.valueOf(choosenButton));
            }
        });


        //SELECT THE NUMBER TO SET==================================================================
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsColor(9);
            }
        });
    }

    void changeButtonsColor(int btnNumber){
        switch (btnNumber){
            case 0:
//                btn0.setBackgroundColor(getResources().getColor(R.color.purple_200));
                btn0.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 1:
                btn1.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 2:
                btn2.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 3:
                btn3.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 4:
                btn4.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 5:
                btn5.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 6:
                btn6.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 7:
                btn7.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 8:
                btn8.setBackgroundColor(getColor(R.color.purple_200));
                break;
            case 9:
                btn9.setBackgroundColor(getColor(R.color.purple_200));
                break;
        }

        switch (choosenButton){
            case 0:
                btn0.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 1:
                btn1.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 2:
                btn2.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 3:
                btn3.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 4:
                btn4.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 5:
                btn5.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 6:
                btn6.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 7:
                btn7.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 8:
                btn8.setBackgroundColor(getColor(R.color.purple_500));
                break;
            case 9:
                btn9.setBackgroundColor(getColor(R.color.purple_500));
                break;
        }

        choosenButton = btnNumber;
    }
}