// класс для заметок
package com.example.mynotes20.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity (tableName = "notes") //создаем таблицу с именем notes
public class Notes implements Serializable {
    @PrimaryKey(autoGenerate = true) //идентификатор в таблице
    int ID = 0;
    @ColumnInfo(name = "title") //инфо в колонках
    String title = "";
    @ColumnInfo(name = "notes")
    String notes = "";
    @ColumnInfo(name = "date")
    String date = "";
    @ColumnInfo(name = "pinned")
    Boolean pinned = false;

    public int getID() {  //делаем геттеры и сеттеры
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean isPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }
}
