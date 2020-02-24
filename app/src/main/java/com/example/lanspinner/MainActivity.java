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
    Spinner styleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        lanSpinner=findViewById(R.id.lanSpinner);
        lanBut=findViewById(R.id.lanBut);
        styleSpinner=findViewById(R.id.styleSpinner);
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
                switch (styleSpinner.getSelectedItem().toString()){
                    case "black":
                        Utils.changeToTheme(MainActivity.this,1);
                        break;
                    case "green":
                        Utils.changeToTheme(MainActivity.this,2);
                        break;
                    case "blue":
                        Utils.changeToTheme(MainActivity.this,3);
                        break;
                    case "Чёрный":
                        Utils.changeToTheme(MainActivity.this,1);
                        break;
                    case "Зелёный":
                        Utils.changeToTheme(MainActivity.this,2);
                        break;
                    case "Синий":
                        Utils.changeToTheme(MainActivity.this,3);
                        break;
                }
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }


}
