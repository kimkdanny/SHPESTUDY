package study.shpe.com.shpestudy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.firebase.client.Firebase;
import study.shpe.com.shpestudy.ui.ListActivity;

public class WriteOnScreenActivity extends AppCompatActivity {
    EditText email;
    TouchEventView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.shpepoints);
        LinearLayout myLInearLayout = (LinearLayout) findViewById(R.id.canvas);
        t = new TouchEventView(this, null);
        myLInearLayout.addView(t);
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
    public void onPointsSubmit(View v) {
        /* DONT FORGET TO PUT CODE CHECKING IF ALL INPUTS NEEDED ARE THERE */

        Button button = (Button) v;

        Canvas c = t.getCanvas();
        String encodedCanvas = c.toString();
        email = (EditText) findViewById(R.id.myEmail);
        EditText dateET = (EditText) findViewById(R.id.myDate);
        EditText activity = (EditText) findViewById(R.id.myAct);
        String emailText = email.getText().toString();
        String date = dateET.getText().toString();
        String act = activity.getText().toString();
        Firebase ref = new Firebase("https://shpestudy.firebaseio.com/");
        final Firebase userFirebase = ref.child("events");
        Firebase firebaseObj = userFirebase.push();
        firebaseObj.child("email").setValue(emailText);
        firebaseObj.child("event").setValue(act);
        firebaseObj.child("date").setValue(date);
        firebaseObj.child("signature").setValue(encodedCanvas);

        Toast.makeText(WriteOnScreenActivity.this, "Event Recorded", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,ListActivity.class);
        startActivity(i);
        finish();
    }
}
