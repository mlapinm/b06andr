package com.example.b601203frag;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<CharSequence> text = new MutableLiveData<>();

    public void setText(CharSequence input){
        text.setValue(input);
    }

    public MutableLiveData<CharSequence> getText() {
        return text;
    }
}
