package com.example.freon.b611202edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        buttonConfirm = findViewById(R.id.button);

        buttonConfirm.setEnabled(false);

        username.addTextChangedListener(loginTextWatcher);
        password.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = username.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();
            boolean enabled =
                    !usernameInput.isEmpty() && !passwordInput.isEmpty();
            buttonConfirm.setEnabled(enabled);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void onClickConfirm(View view) {
    }
}