package com.example.mareklaskowski.myapplication;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_FILE_NAME = "mySPfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate was called");

        //load shared preferences from the SharedPreferences file (if it exists)
        loadSharedPreferences();
    }

    @Override
    protected void onStop() {
        super.onStop();

        //by the way we can use system.out.println, cool!!
        System.out.println("onStop was called!");

        saveSharedPreferences();//we're going to write this
    }

    /*
    save data to the Shared Preferences file...
    specifically we're goint o save the data entered into the EditText boxes
    that have not yet been saved to the database.
     */
    protected void saveSharedPreferences(){
        System.out.println("saveSharedPreferences() was called!");
        /*
        recall the key classes that we need ot work with for Shared Preferences
        step 0 will be to get a SharedPreferences instance from the framework
        (specify filename and mode arguments)
         */
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME, 0);//0 means private
        /*
        step 1: in order to write to SharedPreferences we need to use the SharedPreferences.Editor object
        calling .edit() on our SharedPreferences instance will get us an Editor object
         */
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //next get the value we want to store in the sharedPreferences file (get from EditText(s))
        EditText editTextStudentId = (EditText) findViewById(R.id.editTextStudentId);
        long studentId = Long.parseLong(editTextStudentId.getText().toString());
        //step3: use the editor to write our data into SharedPreferences
        editor.putLong("studentID", studentId); //TODO: use a static final String for the key
        //TODO: you will also need to store the grade as well (I'm not going to do this for you!)
        //step 4: call commit to save the changes~!
        editor.commit();//alternatively you may use the "apply" method
    }

    protected void loadSharedPreferences(){
        System.out.println("loadSharedPreferences() was called!@");
        //step 0: open the shared preferences file if it exists (otherwise it will be created here!)
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME,0);
        //step 1: simply read data out of the file...
        long studentId = sharedPreferences.getLong("studentID", -1); //invalid student ID by default
        //typically the pattern is to use a reasonable default, or an invalid one that you check
        //using logic below.
        if(studentId == -1){
            System.out.println("there was no student ID saved.. ");
        }else{
            //a valid studentID was saved.. insert it into the appropriate EditText box
            EditText editTextStudentId = (EditText) findViewById(R.id.editTextStudentId);
            editTextStudentId.setText(""+studentId);
        }
        //TODO: you do the grade as well (as a String)!
    }
}




