package com.fish.fishcenter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Register extends AppCompatActivity {
    String TAG="Register";
    DatePickerDialog picker;
    EditText edit_company,edt_vehicle,edt_date,edt_tray;
    RelativeLayout rl_next;
    String party_name,date,vehicle,tray;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edit_company = findViewById(R.id.edt_user_id);
        edt_date = findViewById(R.id.edt_date);
        edt_vehicle = findViewById(R.id.edt_vehicle);
        edt_tray = findViewById(R.id.edt_tray);
        vehicle=edt_vehicle.getText().toString();
        date=edt_date.getText().toString();
        tray=edt_tray.getText().toString();
        rl_next = findViewById(R.id.rl_next);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            edit_company.setShowSoftInputOnFocus(false);
            edt_date.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            edit_company.setTextIsSelectable(false);
            edt_date.setTextIsSelectable(false);
        }
        Date d = new Date();
        CharSequence s  = DateFormat.format("dd/MM/yyyy", d.getTime());
        edt_date.setText(s);

        edit_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                searchCitiesList();
            }
        });
        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date=dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                edt_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        rl_next.setOnClickListener(new View.OnClickListener() {
            String company = edit_company.getText().toString();



            @Override
            public void onClick(View view) {


                    //do login
                    Intent intent = new Intent(Register.this, Product.class);
                    // intent.putExtra("username", username);
                    startActivity(intent);

            }

        });


    }

    public void searchCitiesList() {
        final Dialog dialog = new Dialog(Register.this);
        dialog.setContentView(R.layout.list);
        dialog.setTitle("Select City");
        final ListView listView;
        listView = dialog.findViewById(R.id.list);
        String[] values = new String[]{"Delhi",
                "Banglore", "Chennai",
                "Luckhow", "Goa",
                "Pune", "Agra",
                "Dehradun"};
        dialog.show();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView
                        .getItemAtPosition(position);
                party_name=itemValue;
                edit_company.setText(itemValue);
                // Show Alert
                Toast.makeText(
                        getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : "
                                + itemValue, Toast.LENGTH_LONG).show();
                dialog.cancel();

            }

        });
    }
    private boolean validateLogin(String party_name, String vehicle,String date,String tray){
        if(party_name == null || party_name.trim().length() == 0){
            Toast.makeText(this, "party name is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(vehicle == null || vehicle.trim().length() == 0){
            Toast.makeText(this, "vehicle is required", Toast.LENGTH_SHORT).show();
            return false;
        } if(date == null || date.trim().length() == 0){
            Toast.makeText(this, "Date is required", Toast.LENGTH_SHORT).show();
            return false;
        }if(tray == null || tray.trim().length() == 0){
            Toast.makeText(this, "tray is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
