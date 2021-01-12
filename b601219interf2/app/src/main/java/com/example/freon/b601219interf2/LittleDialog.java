package com.example.freon.b601219interf2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LittleDialog extends AppCompatDialogFragment {

    public OnClickListener onClickListener;

    public interface OnClickListener {
        void onOkClick();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onClickButton();

                    }
                });
        return builder.create();
    }

    private void onClickButton() {
        onClickListener.onOkClick();
        Toast.makeText(getActivity(), "press Ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            onClickListener = (OnClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must be OnClickListener");
        }
    }
}
