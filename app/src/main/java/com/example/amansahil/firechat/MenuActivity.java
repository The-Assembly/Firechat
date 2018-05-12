package com.example.amansahil.firechat;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MenuActivity extends Activity{
    TextView t1;
    Button science;

    private static final String API_KEY = "AIzaSyByUsjfI4DX5fQbltvCLZWtdq-vzqZBt5I";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        translatedText();
        redirect();
    }

    public void translatedText(){
        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");
        final String userLang = bundle.getString("userLang");
        t1 = findViewById(R.id.hello);
        t1.setText("Hello " + username);
        final Handler textViewHandler = new Handler();
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                TranslateOptions options = TranslateOptions.newBuilder().setApiKey(API_KEY).build();
                final Translate translate = options.getService();
                final Translation translation = translate.translate("Hello " + username, Translate.TranslateOption.targetLanguage(userLang));
                textViewHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        t1.setText(translation.getTranslatedText());
                    }
                });
                return null;
            }
        }.execute();
    }
    public void redirect() {
        science = findViewById(R.id.science);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                final String username = bundle.getString("username");
                final String userLang = bundle.getString("userLang");
                String cat ="science";
                Intent i = new Intent(MenuActivity.this, ChatActivity.class);
                i.putExtra("username", username);
                i.putExtra("userLang", userLang);
                i.putExtra("cat", cat);
                startActivity(i);
            }
        });
    }
}
