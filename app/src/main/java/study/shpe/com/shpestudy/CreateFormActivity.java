package study.shpe.com.shpestudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.firebase.client.Firebase;

/**
 * Created by nguyen on 5/7/2016.
 */
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


    }
    public void showTimePickerDialog(View v) {

        TimeSettings.mainActivity = this;

        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void clicked(View v) {
        nameText = name.getText().toString();

        placeText = place.getText().toString();

        capacityText = Integer.parseInt(capacity.getText().toString());
        day = date.getDayOfMonth();
        month = date.getMonth();

        hour = time.getHour();
        minute = time.getMinute();

        Firebase ref = new Firebase("https://shpestudy.firebaseio.com/");
        Firebase eventRef = ref.child("shpestudy").child(nameText);
        Event event = new Event(nameText, placeText, capacityText, day, month, hour, minute);
        eventRef.setValue(event);
    }

    void resetTime(int hours, int minutes) {
        time.setHour(hours);
        time.setMinute(minutes);
    }
    void resetDate(int year, int monthOfYear, int dayOfMonth){
        date.updateDate(year, monthOfYear, dayOfMonth);
    }
}
