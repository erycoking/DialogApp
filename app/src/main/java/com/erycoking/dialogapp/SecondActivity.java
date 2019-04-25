package com.erycoking.dialogapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements MyCustomDialog2.OnInputListener {
    private static final String TAG = "SecondActivity";

    //    widgets
    private Button mButton;
    public TextView mInputDisplay;

    //    vars
    private String mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mButton = findViewById(R.id.open_dialog);
        mInputDisplay = findViewById(R.id.input_display);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog");
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.show(getSupportFragmentManager(), "MyCustomDialog");
            }
        });
    }

    @Override
    public void sendText(String input) {
        mInputDisplay.setText(input);
    }
}
