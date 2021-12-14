package com.example.version3_355app.ui.note;

public class NoteModel {
    private int id;
    private String Subject;
    private String Note;

    @Override
    public String toString() {
        return Subject;
    }

    public NoteModel(int id, String Subject, String Note){
        this.Subject = Subject;
        this.Note = Note;
    }

    public String getSubject() {
        return Subject;
    }

    public String getNote() {
        return Note;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
