package com.example.lanspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner lanSpinner;
    Button lanBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        lanSpinner=findViewById(R.id.lanSpinner);
        lanBut=findViewById(R.id.lanBut);
        lanBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale=null;
                Toast.makeText(MainActivity.this,lanSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                switch (lanSpinner.getSelectedItem().toString()){
                    case "ru":{
                        locale=new Locale("ru");
                        break;
                    }
                    case "en":{
                        locale=new Locale("en");
                        break;
                    }
                }
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }


}
