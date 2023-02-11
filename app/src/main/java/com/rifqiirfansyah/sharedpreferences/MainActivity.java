package com.rifqiirfansyah.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget. TextView;
public class MainActivity extends AppCompatActivity {

    private static final String FILE_SHARED_PREFERENCES = "com.rifqiirfansyah.sharedpreferences.example_file_prefs";
    SharedPreferences sharedPreferences;
    EditText editName, editAge;
    Button buttonSave, buttonRead;
    TextView showName, showAge;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        buttonSave = findViewById(R.id.buttonSave);
        buttonRead = findViewById(R.id.buttonRead);
        showName = findViewById(R.id.showName);
        showAge = findViewById(R.id.showAge);
        sharedPreferences = getSharedPreferences(FILE_SHARED_PREFERENCES, MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                savePrefs();
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readPrefs();
            }
            });
        }


    private void savePrefs () {
        String getName = editName.getText().toString();
        int getAge = Integer.parseInt(editAge.getText().toString());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", getName);
        editor.putInt("age", getAge);
        editor.clear();
        editor.apply();
    }

    private void readPrefs () {
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 0);
        showName.setText("Name \t: " + name);
        showAge.setText("Age \t\t\t: " + String.valueOf(age));
    }
}
