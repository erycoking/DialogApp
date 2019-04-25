package com.erycoking.dialogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnInputListener {

    private static final String TAG = "MainActivity";

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
