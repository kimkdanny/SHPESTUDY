package study.shpe.com.shpestudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import study.shpe.com.shpestudy.ui.ListActivity;

/**
 * Created by Eduardo on 5/14/2016.
 */
public class SampleActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customActionBar();
    }
    public void shpepoint(View v){
        Intent i = new Intent(this,WriteOnScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void newevent(View v){
        Intent i = new Intent(this,CreateFormActivity.class);
        startActivity(i);
        finish();
    }

    public void feed(View v){
        Intent i = new Intent(this,ListActivity.class);
        startActivity(i);
        finish();
    }



    public void customActionBar(){
        final LayoutInflater inflater = (LayoutInflater) this
                .getSupportActionBar().getThemedContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(
                R.layout.navigation, null);
        customActionBarView.findViewById(R.id.title);



        final android.support.v7.app.ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_SHOW_TITLE);

        actionBar.setCustomView(customActionBarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );
    }
}
