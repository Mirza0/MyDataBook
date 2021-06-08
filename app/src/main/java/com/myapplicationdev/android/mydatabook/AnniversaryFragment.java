package com.myapplicationdev.android.mydatabook;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AnniversaryFragment extends Fragment {
    Button btnEditAnn;
    TextView tvAnn;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    FloatingActionButton btnAnnSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_anniversary, container, false);
        btnEditAnn = v.findViewById(R.id.btnAnn);
        tvAnn = v.findViewById(R.id.tvAnn);
        btnAnnSearch = v.findViewById(R.id.fab);

        btnEditAnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio");
                builder.setView(inflater.inflate(R.layout.custom_dialog, null)).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog d = (Dialog) dialog;
                        EditText etDialog = d.findViewById(R.id.etDialog);
                        Log.d("dialog", etDialog.getText().toString());
                        tvAnn.setText(etDialog.getText().toString());
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

         btnAnnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View main_view = inflater.inflate(R.layout.activity_main, null);
                drawerLayout = main_view.findViewById(R.id.drawer_layout);
                toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.drawer_open, R.string.drawer_close);
                drawerLayout.addDrawerListener(toggle);
            }
        });

        return v;
    }
}