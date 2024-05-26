package com.example.mynotes20;

import androidx.cardview.widget.CardView;

import com.example.mynotes20.Models.Notes;

public interface NotesCL { // клик лисенер интерфейс

    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
