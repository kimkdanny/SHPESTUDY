package study.shpe.com.shpestudy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import study.shpe.com.shpestudy.R;

public class DetailActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        ((TextView)findViewById(R.id.eventName)).setText(extras.getString("NAME"));
        ((TextView)findViewById(R.id.eventDate)).setText(extras.getString("DATE"));
        ((TextView)findViewById(R.id.eventLocation)).setText(extras.getString("PLACE"));
        ((TextView)findViewById(R.id.eventTime)).setText(extras.getString("TIME"));
        ((TextView)findViewById(R.id.description)).setText(extras.getString("DESCRIPTION"));

    }
}