package com.example.freon.b601219interf;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LittleDialog extends AppCompatDialogFragment {
    public OnClickListener onClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onClickListener.onOkClick();
                    }
                });
        return builder.create();
    }

    public interface OnClickListener{
        void onOkClick();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onClickListener = (OnClickListener)context;
        } catch (ClassCastException e) {
            new ClassCastException(context.toString() +
                   "must be OnClickListener " );
        }
    }
}
