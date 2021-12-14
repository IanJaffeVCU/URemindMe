package com.example.version3_355app.ui.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.version3_355app.R;

public class NoteActivity extends AppCompatActivity {
    // These are the global variables
    EditText editSubject, editNotes;
    TextView result;
    Button SaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Using the id of views specified in layout XML
        we can initialize the view using findViewById
        */
        editSubject  = (EditText) findViewById(R.id.editSubject);
        editNotes = (EditText) findViewById(R.id.editNotes);
        SaveButton = (Button) findViewById(R.id.SaveButton);

        // Attaching OnClick listener to the submit button
        SaveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // get text from EditText Subject view
                String Subject = editSubject.getText().toString();
                // get text from EditText Notes view
                String Notes = editNotes.getText().toString();
                // Get the Data and Use it

            }
        });
    }


}
