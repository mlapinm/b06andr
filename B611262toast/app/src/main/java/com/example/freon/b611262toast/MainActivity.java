package com.example.freon.b611262toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        switch(view.getId()){
            case R.id.button_error:
                Toasty.error(this, "This is an error Toas",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_success:
                Toasty.success(this, "This is an error Toas",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_info:
                Toasty.info(this, "This is an error Toas",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_warning:
                Toasty.warning(this, "This is an error Toas",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_normal1:
                Toasty.normal(this, "This is an error Toas",
                        Toast.LENGTH_SHORT,
                        ContextCompat.getDrawable(this,
                                R.drawable.ic_launcher_foreground)).show();
                break;
        }
    }
}