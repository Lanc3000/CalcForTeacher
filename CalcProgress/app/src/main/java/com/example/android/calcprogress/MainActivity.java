package com.example.android.calcprogress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textTwo;
    EditText textThree;
    EditText textFour;
    EditText textFive;
    EditText absentEdit;
     int numOfTwo,numOfThree, numOfFour, numOfFive;
    int sum;
    int absent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTwo = (EditText) findViewById(R.id.numOfTwo);
    }



    public void calculateAll(View view){
        textFive = (EditText) findViewById(R.id.numOfFive_edit_text);
        if (textFive.getText().toString().trim().equals(""))
        {
            numOfFive = 0;}
        else
        { numOfFive = Integer.parseInt(textFive.getText().toString());}
        textFour = (EditText) findViewById(R.id.numOfFour);
        if (textFour.getText().toString().trim().equals("")){
            numOfFour = 0;
        }
        else{
            numOfFour = Integer.parseInt(textFour.getText().toString());}

        textThree = (EditText) findViewById(R.id.numOfThree);
        if (textThree.getText().toString().trim().equals("")){
            numOfThree = 0;
        }
        else{
            numOfThree = Integer.parseInt(textThree.getText().toString());}
        textTwo = (EditText) findViewById(R.id.numOfTwo);
        if (textTwo.getText().toString().trim().equals("")){
            numOfTwo = 0;
        }
        else{
            numOfTwo = Integer.parseInt(textTwo.getText().toString());}
        absentEdit = (EditText) findViewById(R.id.numOfNA);
        if (absentEdit.getText().toString().trim().equals("")){
            absent = 0;
        }
        else{
            absent = Integer.parseInt(absentEdit.getText().toString());}

        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("numOfTwo", numOfTwo);
        intent.putExtra("numOfThree", numOfThree);
        intent.putExtra("numOfFour", numOfFour);
        intent.putExtra("numOfFive", numOfFive);
        intent.putExtra("absent", absent);

        startActivity(intent);


    }


}
