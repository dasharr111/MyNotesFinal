package com.example.mynotes20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.mynotes20.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText et_title, et_note;
    ImageView save_btn, exit_note_btn;
    Notes notes;

    Boolean isOldNote = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        save_btn = findViewById(R.id.save_btn); //обьявляем перменные
        save_btn = findViewById(R.id.save_btn);
        exit_note_btn = findViewById(R.id.exit_note_btn);
        et_note = findViewById(R.id.et_note);
        et_title = findViewById(R.id.et_title);

        notes = new Notes();
        try{
            notes = (Notes) getIntent().getSerializableExtra("prev_note");
            et_title.setText(notes.getTitle());
            et_note.setText(notes.getNotes());
            isOldNote = true;
        }catch(Exception e){
            e.printStackTrace();
        }

        exit_note_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( NotesTakerActivity.this, MainActivity.class);

            }
        });


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = et_title.getText().toString(); //получаем информацию из заметки
                String description = et_note.getText().toString();
                if(description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "please, write something", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                Date date = new Date(); //создаем дату в определенном формате

                if(!isOldNote){
                    notes = new Notes(); // новая заметка, добавляем название и инфо о ней
                }

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }



        });


    }
}