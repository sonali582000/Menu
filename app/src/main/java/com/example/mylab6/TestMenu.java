package com.example.mylab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class TestMenu extends AppCompatActivity {
    TextView tv1;
    EditText edate1,edate2;
    String dob1;
    DatePickerDialog datePicker;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.option1:
                Toast.makeText(this,"Searching...",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option2:
                Toast.makeText(this,"Coping...",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //menu.setHeaderTitle("Choose your option ");
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationContentDescription("Navigation Icon");

        tv1=findViewById(R.id.textview1);
        registerForContextMenu(tv1);

        edate1 = (EditText) findViewById(R.id.date1);
        edate2 = (EditText) findViewById(R.id.date2);
        Calendar calendar=Calendar.getInstance();
        final int years=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        edate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog
                        (TestMenu.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {

                                month=month+1;
                                String date=day+"/"+month+"/"+year;
                                edate1.setText(date);
                                dob1=date;
                            }
                        },years,month,day);
                datePickerDialog.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.fav:
                Toast.makeText(this,"Add to your favourite..!!",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.location:
                Intent a=new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("geo:12.3656489.88.4569415"));
                Intent chooser= Intent.createChooser(a, "America");
                startActivity(chooser);
                return  true;
            case R.id.contact:
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+919974339652"));
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loc1(View view) {
        Intent a=new Intent(Intent.ACTION_VIEW);
        a.setData(Uri.parse("geo:12.3656489.88.4569875"));
        Intent chooser= Intent.createChooser(a, "Turkey");
        startActivity(chooser);
    }

    public void loc2(View view) {
        Intent a=new Intent(Intent.ACTION_VIEW);
        a.setData(Uri.parse("geo:12.3656489.88.4569415"));
        Intent chooser= Intent.createChooser(a, "America");
        startActivity(chooser);
    }


    public void book1(View view) {
        View v = findViewById(R.id.button2);
        String message = "Book now..!!!";
        int duration = Snackbar.LENGTH_SHORT;

        showSnackbar(view, message, duration);
    }
    public void showSnackbar(View view, String message, int duration)
    {
        Snackbar.make(view, message, duration).show();
    }

    public void show1(View view) {
        Toast toast = Toast.makeText(this,"America", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
    }

    public void show2(View view) {
        Toast toast = Toast.makeText(this,"Turkey", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 0);
        toast.show();
    }
}