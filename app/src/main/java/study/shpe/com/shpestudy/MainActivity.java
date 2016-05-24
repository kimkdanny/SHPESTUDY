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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.lang.reflect.Array;
import java.util.List;
import study.shpe.com.shpestudy.ui.ListActivity;

public class MainActivity extends AppCompatActivity  {
    String email;
    EditText userEmail;
    Button userLogin, userSignUp;
    Intent i, j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.login);
        userEmail= (EditText) findViewById(R.id.myEmail);
        userLogin= (Button) findViewById(R.id.submit);
        userSignUp= (Button) findViewById(R.id.signUp);
        i = new Intent(MainActivity.this,SignupActivity.class);
        j = new Intent(MainActivity.this,ListActivity.class);


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = userEmail.getText().toString();
                boolean valid = email.contains("@")& email.contains(".");
                if(valid) {
                    Firebase ref = new Firebase("https://shpestudy.firebaseio.com/").child("users");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            boolean found = false;
                            for(DataSnapshot child: dataSnapshot.getChildren()){
                                User user = child.getValue(User.class);
                                if (user.getEmail().equals(email)) {
                                    found = true;
                                    startActivity(j);
                                    finish();
                                }

                            }
                            if(found == false){
                                Toast.makeText(getApplicationContext(),"Email not registered",Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    //check if in database
                    //next acitivty if it's in database
                }
                else {
                    Toast.makeText(getApplicationContext(), "Email is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        userSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

    }

}
