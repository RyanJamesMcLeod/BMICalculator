package com.example.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	//This is used with the Height and Weight in Meters and Kilograms, respectively
	public void calculateClickHandler(View view) {
	     if (view.getId() == R.id.calculateButton) {

	      EditText weightText = (EditText)findViewById(R.id.weightText);
	      EditText heightText = (EditText)findViewById(R.id.heightText);
	      TextView resultText = (TextView)findViewById(R.id.resultLabel);
	 
	      float weight = Float.parseFloat(weightText.getText().toString());
	      float height = Float.parseFloat(heightText.getText().toString());
	 
	      float bmiValue = calculateBMI(weight, height);
	 
	      String bmiInterpretation = interpretBMI(bmiValue);

	      resultText.setText(bmiValue + "-" + bmiInterpretation);
	     }
	    }
	//This is used with the Height and Weight in Pounds and Inches, respectively
	public void calculateClickHandlerE(View view) {
	     if (view.getId() == R.id.calculateButtonE) {

	      EditText weightText = (EditText)findViewById(R.id.weightText2);
	      EditText heightText = (EditText)findViewById(R.id.heightText2);
	      TextView resultText = (TextView)findViewById(R.id.resultLabelE);
	 
	      float weight = Float.parseFloat(weightText.getText().toString());
	      float height = Float.parseFloat(heightText.getText().toString());
	 
	      float bmiValue = calculateBMI2(weight, height);
	 
	      String bmiInterpretation = interpretBMI(bmiValue);
	 
	      resultText.setText(bmiValue + "-" + bmiInterpretation);
	     }
	    }
	    //This is the metric calculation
	    private float calculateBMI (float weight, float height) {
	    	return (float) (weight / (height * height));
	    }
	    //This is the English calculation
	    private float calculateBMI2 (float weight, float height) {
	    	return (float) (weight * 703 / (height * height));
	    }
        //This sets the result string to the appropriate value based on the BMI
	    private String interpretBMI(float bmiValue) {

	      if (bmiValue < 18.5) {

	      return "Underweight";
	     } else if (bmiValue < 24.9) {

	      return "Normal";
	     } else if (bmiValue < 29.9) {

	      return "Overweight";
	     } else {
	      return "Obese";
	     }

	    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
