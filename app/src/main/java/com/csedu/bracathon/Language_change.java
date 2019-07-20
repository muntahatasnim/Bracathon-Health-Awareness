package com.csedu.bracathon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import java.util.*;


public class Language_change extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_change);
        loadLocate();// call LoadLocate
        setContentView(R.layout.activity_language_change);
        Button mBtn = (Button) findViewById(R.id.mChangeLang);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLang();
            }
        });


    }



    private final void showChangeLang() {
        String[] listItmes = new String[]{"English","Bangla"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder((Context) this);
        mBuilder.setTitle((CharSequence) "Choose Language");
        mBuilder.setSingleChoiceItems((CharSequence[]) listItmes, -1, (android.content.DialogInterface.OnClickListener) (new android.content.DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Language_change.this.setLocate("en");
                    Language_change.this.recreate();
                } else if (which == 1) {
                    Language_change.this.setLocate("bn-rBD");
                    Language_change.this.recreate();
                }

                dialog.dismiss();
            }
        }));
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private final void setLocate(String Lang) {
        Locale locale = new Locale(Lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Context var10000 = this.getBaseContext();
       // Intrinsics.checkExpressionValueIsNotNull(var10000, "baseContext");
        Resources var5 = var10000.getResources();
        Context var10002 = this.getBaseContext();
        //Intrinsics.checkExpressionValueIsNotNull(var10002, "baseContext");
        Resources var6 = var10002.getResources();
        //Intrinsics.checkExpressionValueIsNotNull(var6, "baseContext.resources");
        var5.updateConfiguration(config, var6.getDisplayMetrics());
        SharedPreferences.Editor editor = this.getSharedPreferences("Settings", 0).edit();
        editor.putString("My_Lang", Lang);
        editor.apply();
    }

    private final void loadLocate() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("Settings", 0);
        String language = sharedPreferences.getString("My_Lang", "");
        //Intrinsics.checkExpressionValueIsNotNull(language, "language");
        this.setLocate(language);
    }
}

