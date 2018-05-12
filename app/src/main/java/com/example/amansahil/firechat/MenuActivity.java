package com.example.amansahil.firechat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class MenuActivity extends Activity{
    TextView t1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        translatedText();
    }

    public void translatedText(){
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String userLang = bundle.getString("userLang");
        t1 = findViewById(R.id.hello);
        t1.setText("Hello" + username);

    }
}
