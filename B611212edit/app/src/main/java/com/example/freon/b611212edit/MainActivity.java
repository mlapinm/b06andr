package com.example.freon.b611212edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLanguage;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputLogin = findViewById(R.id.text_input_login);
        textInputPassword = findViewById(R.id.text_input_password);


    }

    private boolean validEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if(emailInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        }else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validLogin(){
        String loginInput = textInputLogin.getEditText().getText().toString().trim();
        if(loginInput.isEmpty()){
            textInputLogin.setError("Field can't be empty");
            return false;
        }else {
            textInputLogin.setError(null);
            return true;
        }
    }

    private boolean validPassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if(passwordInput.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        }else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void onClickConfirm(View view) {
        if(!validEmail() | !validLogin() | !validPassword()){
            return;
        }
        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputLogin.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}