package com.example.version3_355app.ui.note;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.version3_355app.ui.note.NoteModel;

public class NoteViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public NoteViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue();
    }

    public LiveData<String> getText() {
        return mText;
    }
}