package com.myapplicationdev.android.mydatabook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class BioFragment extends Fragment {
    Button btnEditBio;
    TextView tvBio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bio, container, false);
        SharedPreferences sharedPreferences = getActivity().getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        btnEditBio = v.findViewById(R.id.btnBio);
        tvBio = v.findViewById(R.id.tvBio);
        tvBio.setText(sharedPreferences.getString("bio", "Hello Bio"));

        btnEditBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio");
                builder.setView(inflater.inflate(R.layout.custom_dialog, null)).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog d = (Dialog) dialog;
                        EditText etDialog = d.findViewById(R.id.etDialog);
                        tvBio.setText(etDialog.getText().toString());
                        editor.putString("bio", etDialog.getText().toString());
                        editor.apply();
                        dialog.dismiss();
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialog", "onClick: cancel");
                        dialog.cancel();
                    }
                });
                builder.create().show();

            }
        });
        return v;
    }
}