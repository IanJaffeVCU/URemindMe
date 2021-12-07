package com.example.version3_355app.ui.classSchedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassScheduleViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ClassScheduleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ClassSchedule fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}