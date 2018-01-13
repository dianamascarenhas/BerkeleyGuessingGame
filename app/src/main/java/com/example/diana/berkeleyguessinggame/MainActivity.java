package com.example.diana.berkeleyguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1, num2;
    private int points =0;

    @Override
    protected void onCreate(Bundle savedInstanceState)      // Any code we want to run on startup, we put it here
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
    }

    public void pickNumbers()
    {
        Button lbutton =(Button) findViewById(R.id.leftButton); // Returns object representing that button //
        Button rbutton =(Button) findViewById(R.id.rightButton); // Returns object representing that button //
        Random randy= new Random();
        num1= 0;
        num2 = 0;

         while(num1==num2)
        {
        num1 = randy.nextInt(10);
        num2 = randy.nextInt(10);
        }

        lbutton.setText(String.valueOf(num1));
        rbutton.setText(String.valueOf(num2));

    }

    public void leftClickButton(View view) {
        /* This code runs when left button is clicked */
        if(num1>num2)
        {
            Toast.makeText(this, "You are CORRECT", Toast.LENGTH_SHORT).show();
            points++;
        }
        else
        {
            Toast.makeText(this, "You are WRONG", Toast.LENGTH_SHORT).show();
            points--;
        }
        pickNumbers();
        TextView pointsView= (TextView)findViewById(R.id.PointsView);
        pointsView.setText("Points : " +points);
    }

    public void RightClickButton(View view) {
        /* This code runs when right button is clicked */
        if(num1<num2)
        {
            Toast.makeText(this, "You are CORRECT", Toast.LENGTH_SHORT).show();
            points++;
        }
        else
        {
            Toast.makeText(this, "You are WRONG", Toast.LENGTH_SHORT).show();
            points--;
        }
        pickNumbers();
        TextView pointsView= (TextView)findViewById(R.id.PointsView);
        pointsView.setText("Points : " +points);



    }
}
