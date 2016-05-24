package study.shpe.com.shpestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.lang.reflect.Array;
import study.shpe.com.shpestudy.ui.ListActivity;

public class SignupActivity extends AppCompatActivity  {

    EditText userEmail, userName;
    Button userLogin;
    Intent j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("SIGN UP");
        Firebase myFirebaseRef = new Firebase("https://shpestudy.firebaseio.com/");
        final Firebase userFirebase = myFirebaseRef.child("users");

        setContentView(R.layout.signup);
        userEmail= (EditText) findViewById(R.id.myEmail);
        userName= (EditText) findViewById(R.id.myName);
        userLogin= (Button) findViewById(R.id.submit);
        j = new Intent(SignupActivity.this,ListActivity.class);
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmail.getText().toString();
                boolean valid = email.contains("@")&& email.contains(".");
                if(valid) {
                    Firebase firebaseObj = userFirebase.push();
                        firebaseObj.child("name").setValue(userName.getText().toString());
                    firebaseObj.child("email").setValue(userEmail.getText().toString());
                    Toast.makeText(getApplicationContext(),"You have signed up!",Toast.LENGTH_SHORT).show();
                    userEmail.setText("");
                    userName.setText("");
                    startActivity(j);
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Email is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
