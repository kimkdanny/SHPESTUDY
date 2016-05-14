package study.shpe.com.shpestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class WriteOnScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_on_screen);
        LinearLayout myLInearLayout = (LinearLayout) findViewById(R.id.canvas);
        myLInearLayout.addView(new TouchEventView(this, null));
    }


}
