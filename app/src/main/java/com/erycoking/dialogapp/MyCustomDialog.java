package com.erycoking.dialogapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyCustomDialog extends DialogFragment implements MyCustomDialog2.OnInputListener {
    private static final String TAG = "MyCustomDialog";

    @Override
    public void sendText(String input) {
        dialog_2_input.setText(input);
    }

    public interface OnInputListener{
        void sendText(String input);
    }

//    widgets
    private EditText mInput;
    private TextView mActionOk;
    private TextView mActionCancel;
    private TextView dialog_2_input;
    private Button open_dialog2;

    OnInputListener inputListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout, container, false);

        mInput  = view.findViewById(R.id.input);
        mActionOk  = view.findViewById(R.id.action_ok);
        mActionCancel  = view.findViewById(R.id.action_cancel);
        open_dialog2  = view.findViewById(R.id.open_dialog2);
        dialog_2_input  = view.findViewById(R.id.dialog_2_input);

        open_dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomDialog2 dialog2 = new MyCustomDialog2();
                dialog2.setTargetFragment(MyCustomDialog.this, 1);
                dialog2.show(getFragmentManager(), "MyCustomDialog2");
            }
        });

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
        inputListener = (OnInputListener) context;
    }
}
