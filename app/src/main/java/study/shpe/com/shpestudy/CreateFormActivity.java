package study.shpe.com.shpestudy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.firebase.client.Firebase;

import study.shpe.com.shpestudy.ui.ListActivity;

public class CreateFormActivity extends AppCompatActivity {
    EditText name;
    EditText place;
    EditText capacity;
    DatePicker date;
    Button submit;
    TimePicker time;
    String nameText;
    String placeText;
    int capacityText;
    int day, month;
    int hour, minute;
    EditText description;
    String descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        setContentView(R.layout.createform);

        name = (EditText) findViewById(R.id.Name);
        date = (DatePicker) findViewById(R.id.DateTime);
        place = (EditText) findViewById(R.id.Place);
        capacity = (EditText) findViewById(R.id.Capacity);
        submit = (Button) findViewById(R.id.Submit);
        time = (TimePicker) findViewById(R.id.timePicker);
        description =(EditText) findViewById(R.id.description);


    }
    public void showTimePickerDialog(View v) {

        TimeSettings.mainActivity = this;

        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        DateSettings.mainActivity = this;
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");

    }
    public void clicked(View v) {
        nameText = name.getText().toString();

        placeText = place.getText().toString();

        capacityText = Integer.parseInt(capacity.getText().toString());
        day = date.getDayOfMonth();
        month = date.getMonth();


        hour = time.getCurrentHour();
        minute = time.getCurrentMinute();
        //// TODO: 5/21/16
        descriptionText = description.getText().toString();

        Firebase ref = new Firebase("https://shpestudy.firebaseio.com/");
        Firebase eventRef = ref.child("shpestudy").child(nameText);
        DerpEvent event = new DerpEvent(nameText, placeText, capacityText, day, month, hour, minute, descriptionText);
        eventRef.setValue(event);

        Toast.makeText(this,"Event created!", Toast.LENGTH_SHORT).show();
        Intent home = new Intent(this, ListActivity.class);
        startActivity(home);
        finish();
    }

    void resetTime(int hours, int minutes) {
        time.setCurrentHour(hours);
        time.setCurrentMinute(minutes);
    }
    void resetDate(int year, int monthOfYear, int dayOfMonth){
        date.updateDate(year, monthOfYear, dayOfMonth);
    }
}
