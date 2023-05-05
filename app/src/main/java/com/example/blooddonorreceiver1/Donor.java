
package com.example.blooddonorreceiver1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;
import java.util.HashMap;

public class
Donor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, email, dob, address, city, mobileno ;
    Spinner bloodg, gender, state;
    Button submit;
    int year,month,day;
    AwesomeValidation awesomeValidation;
    private FirebaseDatabase db = FirebaseDatabase.getInstance ();
    private DatabaseReference root = db.getReference ().child ("Donor Information");
    Calendar calender = Calendar.getInstance();
    String[] Blood = {"A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
    String[] Gender = {"Male", "Female"};
    String[] states = {"Andhar Pradesh", "Gujrat", "Maharashtra", "Tamilnadu", "Madhya Pradesh", "Panjab", "Bihar", "Rajastan", "Chatisgasd", "Goa", "Karnatak", "Keral"};
    public static int getText() {
        return 0;
    }
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate (saveInstanceState);
        setContentView (R.layout.activity_donor);
        name = findViewById (R.id.t1);
        email = findViewById (R.id.t2);
        dob = findViewById (R.id.t3);
        address = findViewById (R.id.t4);
        city = findViewById (R.id.t5);
        mobileno = findViewById (R.id.t6);
        bloodg = findViewById (R.id.s1);
        gender = findViewById (R.id.s2);
        state = findViewById (R.id.s3);
        submit = findViewById (R.id.btn1);
        bloodg.setOnItemSelectedListener (this);
        ArrayAdapter aa = new ArrayAdapter (this, android.R.layout.simple_spinner_item, Blood);
        aa.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        bloodg.setAdapter (aa);
        gender.setOnItemSelectedListener (this);
        ArrayAdapter aa2 = new ArrayAdapter (this, android.R.layout.simple_spinner_item, Gender);
        aa2.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter (aa2);
        state.setOnItemSelectedListener (this);
        ArrayAdapter aa3 = new ArrayAdapter (this, android.R.layout.simple_spinner_item, states);
        aa3.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter (aa3);






          awesomeValidation = new AwesomeValidation (ValidationStyle.BASIC);

          awesomeValidation.addValidation (this, R.id.t1, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

          awesomeValidation.addValidation (this, R.id.t5, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

          awesomeValidation.addValidation (this, R.id.t2, Patterns.EMAIL_ADDRESS, R.string.invalid_email);

          awesomeValidation.addValidation (this, R.id.t6, "[5-9]{1}[0-9]{9}$", R.string.invalid_mobile);

        submit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate ()) {
                    HashMap<String, Object> map = new HashMap<> ();
                    map.put ("Name", name.getText ().toString ());
                    map.put ("Email", email.getText ().toString ());
                    map.put ("Dob", dob.getText ().toString ());
                    map.put ("Address", address.getText ().toString ());
                    map.put ("City", city.getText ().toString ());
                    map.put ("Blood", bloodg.getSelectedItem ().toString ());
                    map.put ("Gender", gender.getSelectedItem ().toString ());
                    map.put ("State", state.getSelectedItem ().toString ());
                    map.put ("Mobileno", mobileno.getText ().toString ());

                    root.push ().setValue (map).addOnCompleteListener (new OnCompleteListener<Void> () {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                        }

                    });


                    Toast.makeText (getApplicationContext (), "Submited", Toast.LENGTH_SHORT).show ();
                    name.getText ().clear ();
                    email.getText ().clear ();
                    dob.getText ().clear ();
                    city.getText ().clear ();
                    address.getText ().clear ();
                    mobileno.getText ().clear ();
                } else {
                    Toast.makeText (getApplicationContext (), "Faild", Toast.LENGTH_SHORT).show ();
                }

            }
        });
    }

        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){

        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }
    }










