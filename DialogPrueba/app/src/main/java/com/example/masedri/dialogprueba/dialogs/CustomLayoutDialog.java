package com.example.masedri.dialogprueba.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.masedri.dialogprueba.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by masedri on 25/1/17.
 */

public class CustomLayoutDialog extends DialogFragment {

    private  CustomDialogInterface mDialogInterface;
    public static final String EMAIL_KEY =  "email";
    public static final String NAME_KEY =  "name";
    private  EditText nameET, emailET;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mDialogInterface = (CustomDialogInterface) context;

        }catch (ClassCastException e){
            throw  new ClassCastException( "debes implementar la interface en el main");
        }
    }

    public interface CustomDialogInterface{ //

        public void setData(Map<String, String> data);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View layout = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);

        nameET = (EditText) layout.findViewById(R.id.nombreEditText);
        emailET = (EditText) layout.findViewById(R.id.emailEditTex);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        //Una vez que nemos el builder creado con los metodos set lo configuramos
        AlertDialog.Builder builder1 = builder.setMessage("My positive negative Builde")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // con getView obtener la referencia del layout que queremoas
                        EditText nombreEditText = (EditText) getView().findViewById(R.id.nombreEditText);
                        EditText emailEditText = (EditText) getView().findViewById(R.id.emailEditTex);

                        //Toast.makeText(getActivity(), "ok", Toast.LENGTH_LONG).show();

                        Map<String, String> data = new HashMap<>();
                        data.put(NAME_KEY, nameET.getText().toString());
                        data.put(EMAIL_KEY, emailET.getText().toString());

                        // Tenemos que pasarle los datos a la interface ya que es quien establece las reglas de la comunicacion.

                        mDialogInterface.setData(data);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getActivity(), "cancel", Toast.LENGTH_LONG).show();


                    }
                })

                .setView(layout);
        return builder.create();
    }
}
