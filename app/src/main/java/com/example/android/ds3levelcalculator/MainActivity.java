package com.example.android.ds3levelcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //creates action listener for TextView basically turning it into a button
        TextView calculate = (TextView) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });

    }

    void Calculate() {

        //array for required souls per level 0 is for level 1 since no souls are required and it avoids an off by 1 error
        int[] requiredSoulsPerLevel = {0, 673, 689, 706, 723, 740, 757, 793, 811, 829, 847, 1038, 1238,
                1445, 1659, 1882, 2113, 2353, 2601, 2857, 3122, 3395, 3678, 3969, 4270, 4580, 4899, 5228,
                5566, 5915, 6272, 6640, 7018, 7407, 7805, 8214, 8633, 9064, 9505, 9956, 10419, 10893, 11379,
                11876, 12384, 12904, 13435, 13979, 14535, 15102, 15682, 16274, 16879, 17497, 18127, 18770,
                19425, 20094, 20776, 21472, 22181, 22903, 23640, 24390, 25153, 25931, 26723, 27530, 28351,
                29186, 30036, 30900, 31780, 32675, 33584, 34509, 35449, 36405, 37377, 38364, 39367, 40385,
                41420, 42472, 43539, 44623, 45723, 46841, 47975, 49125, 50293, 51478, 52681, 53901, 55138,
                56393, 57665, 58956, 60265, 61591, 62936, 64299, 65681, 67082, 68501, 69939, 71395, 72871,
                74367, 75881, 77415, 78968, 80542, 82134, 83747, 85380, 87033, 88707, 90400, 92115, 93850,
                95605, 97382, 99179, 100998, 102838, 104699, 106582, 108486, 110413, 112360, 114330, 116322,
                118337, 120373, 122432, 124513, 126618, 128744, 130894, 133067, 135263, 137483, 139725,
                141992, 144282, 146595, 148933, 151295, 153680, 156090, 158524, 160983, 163466, 165975,
                168507, 171065, 173648, 176257, 178890, 181549, 184234, 186944, 189680, 192442, 195230,
                198044, 200884, 203751, 206644, 209564, 212511, 215484, 218485, 221513, 224568, 227650,
                230760, 233897, 237062, 240255, 243476, 246725, 250002};


        //imports XML elements so that there values can be extacted
        EditText currentLevel = (EditText) findViewById(R.id.currentLevel);
        EditText targetLevel = (EditText) findViewById(R.id.targetLevel);
        TextView display = (TextView) findViewById(R.id.display);

        //casts values entered into the EditTexts into Integer
        int CurrentLevel = 0;
        int TargetLevel = 0;

        //catch exception is user enters a non Int into
        try {
            //exact values from GUI elements
            CurrentLevel = Integer.parseInt(currentLevel.getText().toString());
            TargetLevel = Integer.parseInt(targetLevel.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "enter in a logical value for the current and target levels", Toast.LENGTH_LONG).show();
        }


        if (TargetLevel <= 183) {

            Integer requiredSouls = 0;


            for (int i = CurrentLevel + 1; i <= TargetLevel; i++)
                requiredSouls = requiredSouls + requiredSoulsPerLevel[i];


            //sets value of display TextView to the requiredSouls object
            display.setText(requiredSouls.toString());

        } else {
            //if user tries to set a target Level above the current array Size, the below toast message will display

            int supportedLevelCap = requiredSoulsPerLevel.length - 1;
            Toast.makeText(this, "Unfortunately we only support up to level " + supportedLevelCap, Toast.LENGTH_LONG).show();
        }
    }

}
