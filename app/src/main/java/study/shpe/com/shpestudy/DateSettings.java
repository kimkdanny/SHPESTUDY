package study.shpe.com.shpestudy;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

/**
 * Created by nguyen on 5/7/2016.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener {
    Context context;
    static MainActivity mainActivity;

    public DateSettings(Context context){
        this.context = context;

    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mainActivity.resetDate(year, monthOfYear, dayOfMonth);
    }
}
