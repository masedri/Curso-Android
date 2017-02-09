package com.example.masedri.dialogprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.masedri.dialogprueba.dialogs.CustomLayoutDialog;
import com.example.masedri.dialogprueba.dialogs.MyPositeveNgiteDialog;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements CustomLayoutDialog.CustomDialogInterface {

    private TextView monitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monitor = (TextView) findViewById(R.id.monitor);
    }

    public void showDialog1(View v){

        MyPositeveNgiteDialog myDialog = new MyPositeveNgiteDialog();
        myDialog.show(getFragmentManager(), "MyDIalog");

    }

    public void showCustomLayoutDialog(View v){
        CustomLayoutDialog myDialog = new CustomLayoutDialog();
        myDialog.show(getFragmentManager(), "MycustomLayouDialog");

    }

    @Override
    public void setData(Map<String, String> data) {
        String email = data.get(CustomLayoutDialog.EMAIL_KEY);
        String name = data.get(CustomLayoutDialog.NAME_KEY);
        monitor.setText("Email:" + email + "Name: " + name);

    }
}
