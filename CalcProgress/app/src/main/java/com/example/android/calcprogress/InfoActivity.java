package com.example.android.calcprogress;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Администратор on 22.03.2018.
 */

public class InfoActivity extends Activity {
    EditText textTwo;
    EditText textThree;
    EditText textFour;
    EditText textFive;
    EditText absentEdit;
    int numOfTwo, numOfThree, numOfFour, numOfFive;
    int sum;
    int absent;
    double average, acPerfom, perfom, degreeOfLearn;
    String academicPerfomance = "((кол-во '5' + кол-во '4' + кол-во '3')/общее количество учащихся)*100%";
    String qualityOfAcademicPerfomance = "((кол-во '5' + кол-во '4')/общее количество учащихся)*100%";
    String dgOfLearn = "((кол-во '5' + кол-во '4' * 0.64 + кол-во '3' * 0.36 + кол-во '2' * 0.16 + кол-во 'н/а' * 0.08)/общее количество учащихся)*100%";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        numOfTwo = (int) getIntent().getSerializableExtra("numOfTwo");
        numOfThree = (int) getIntent().getSerializableExtra("numOfThree");
        numOfFour = (int) getIntent().getSerializableExtra("numOfFour");
        numOfFive = (int) getIntent().getSerializableExtra("numOfFive");
        absent = (int) getIntent().getSerializableExtra("absent");

        sum = numOfFive + numOfFour + numOfThree + numOfTwo + absent;
        average(numOfTwo, numOfThree, numOfFour, numOfFive, sum);
        academicPerfomance(numOfFive, numOfFour ,numOfThree, sum);
        perfomance(numOfFive, numOfFour, sum);
        sumOfMarks(sum);
    }


    public void hintAcademicPerfomance(View view){
        Toast toast = Toast.makeText(getApplicationContext(), academicPerfomance, Toast.LENGTH_LONG);
        toast.show();
    }
    public void hintQualityOfAcademicPerfomance(View view){
        Toast toast = Toast.makeText(getApplicationContext(), qualityOfAcademicPerfomance, Toast.LENGTH_LONG);
        toast.show();
    }
    public void hintSou(View view){
        Toast toast = Toast.makeText(getApplicationContext(), dgOfLearn, Toast.LENGTH_LONG);
        toast.show();
    }

 

    //метод для расчета среднего балла
    private void average (int numberTwo, int numberThree, int numberFour, int numberFive, int Sum){
        TextView averageTextView = (TextView) findViewById(R.id.average_text_view);
        average = (double) ((numberFive * 5) + (numberFour * 4) + (numberThree * 3) + (numberTwo) * 2) / Sum;
        double result;
        result = Math.rint (100.0 * average) / 100.0;
        averageTextView.setText("" + result );
    }
    //метод для расчета успеваемости
    private void academicPerfomance(int numberFive, int numberFour, int numberThree, int Sum){
        TextView academicPerf = (TextView) findViewById(R.id.academicPerfomance);
        acPerfom = (double) ( numberFive + numberFour + numberThree ) / Sum;
        double result;
        result = Math.rint(acPerfom * 100.0);
        academicPerf.setText("" + result);
    }
    //метод для расчета качества знаний
    private void perfomance (int numsFive, int numsFour, int Sum){
        TextView perfomance = (TextView) findViewById(R.id.qualityOfAcademicPerfomance);
        perfom = (double) (numsFive + numsFour) / Sum;
        perfomance.setText("" + Math.rint(perfom * 100.0));

    }
    //метод для расчета СОУ
    private void SOU(int Five, int Four, int Three, int Two, int Sum, int
            absent){
        TextView sou = (TextView) findViewById(R.id.sou);
        degreeOfLearn = (Five  + Four * 0.64 + Three * 0.36 + Two * 0.16 + (absent * 0.08)) / Sum;
        sou.setText("" + Math.rint(degreeOfLearn * 100));
    }
    //вывод суммы всех оценок
    private void sumOfMarks(int sum){
        TextView sums = (TextView) findViewById(R.id.sum_of_number);
        sums.setText("" + sum);
    }
 }