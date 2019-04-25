package com.erycoking.dialogapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyCustomDialog2 extends DialogFragment {
    private static final String TAG = "MyCustomDialog";

    public interface OnInputListener{
        void sendText(String input);
    }

//    widgets
    private EditText mInput;
    private TextView mActionOk;
    private TextView mActionCancel;

    OnInputListener inputListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout2, container, false);

        mInput  = view.findViewById(R.id.input);
        mActionOk  = view.findViewById(R.id.action_ok);
        mActionCancel  = view.findViewById(R.id.action_cancel);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = mInput.getText().toString();
                if (!inputText.equals("")){
                    inputListener.sendText(inputText);
                }

                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        inputListener = (OnInputListener) getTargetFragment();
    }
}
