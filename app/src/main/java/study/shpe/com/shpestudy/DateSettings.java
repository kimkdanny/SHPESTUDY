package study.shpe.com.shpestudy;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;


public class DateSettings implements DatePickerDialog.OnDateSetListener {
    Context context;
    static CreateFormActivity mainActivity;

    public DateSettings(Context context){
        this.context = context;

    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mainActivity.resetDate(year, monthOfYear, dayOfMonth);
    }
}
