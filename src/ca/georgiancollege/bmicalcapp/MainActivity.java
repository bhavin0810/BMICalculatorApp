/*
//Application Name: BMI Calculator Application
//Programmer: Bhavin Patel
//Description: Calculate the BMI using Height and Weight
//Date: April 3 2015
*/

package ca.georgiancollege.bmicalcapp;

//import libraries +++++++++++++++++++++++++++++++++++++++++++++++++++++++

import android.R.color;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Get Android Layout Objects +++++++++++++++++++++++++++++++++++++++++++++++++
		
		//Get the Button Objects
		final Button bmiButon = (Button) findViewById(R.id.bmiButton);
		final Button resetButton = (Button) findViewById(R.id.resetButton);
		
		//Get the EditText Objects
		final EditText heightText = (EditText)findViewById(R.id.heightEditText);
		final EditText weightText = (EditText)findViewById(R.id.weightEditText);
		final EditText bmiText = (EditText) findViewById(R.id.bmiEditText);
		final EditText bmiResultText = (EditText) findViewById(R.id.bmiResultEditText);
		
		//Get the RadioButton Group Objects
		final RadioGroup grpRadioButton = (RadioGroup) findViewById(R.id.grpRadioButton);
		
		//Get the TextView Objects
		final TextView underWeightText = (TextView) findViewById(R.id.underWeightTextView);
		final TextView underWeightResultText = (TextView) findViewById(R.id.underWeightResultTextView);
		final TextView normalText = (TextView) findViewById(R.id.normalTextView);
		final TextView noramlResultText = (TextView) findViewById(R.id.normalResultTextView);
		final TextView overweightText = (TextView) findViewById(R.id.overWeightTextView);
		final TextView overweightResultText = (TextView) findViewById(R.id.overWeightResultTextView);
		final TextView obeseText = (TextView) findViewById(R.id.obeseTextView);
		final TextView obeseResultText = (TextView) findViewById(R.id.obeseResultTextView);
		
		
		//Click Event of the Reset Button ++++++++++++++++++++++++++++++++++++++++
		resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	//Set the Height, weight and BMI Value to initial state
            	heightText.setText("0.00");
            	weightText.setText("0.00");
            	bmiText.setText("0.00");
            	bmiResultText.setText("");
            	
            	//Set the Text Color to Black
            	underWeightText.setTextColor(Color.parseColor("#000000"));
            	underWeightResultText.setTextColor(Color.parseColor("#000000"));
            	normalText.setTextColor(Color.parseColor("#000000"));
            	noramlResultText.setTextColor(Color.parseColor("#000000"));
            	overweightText.setTextColor(Color.parseColor("#000000"));
            	overweightResultText.setTextColor(Color.parseColor("#000000"));
            	obeseText.setTextColor(Color.parseColor("#000000"));
            	obeseResultText.setTextColor(Color.parseColor("#000000"));
            }
        }); //end of Reset Button click Event
		
		
		//Click Event of Calculate the BMI++++++++++++++++++++++++++++++++++++++++++++++
		bmiButon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            		
            	//Set the Text Color to Black
            	underWeightText.setTextColor(Color.parseColor("#000000"));
            	underWeightResultText.setTextColor(Color.parseColor("#000000"));
            	normalText.setTextColor(Color.parseColor("#000000"));
            	noramlResultText.setTextColor(Color.parseColor("#000000"));
            	overweightText.setTextColor(Color.parseColor("#000000"));
            	overweightResultText.setTextColor(Color.parseColor("#000000"));
            	obeseText.setTextColor(Color.parseColor("#000000"));
            	obeseResultText.setTextColor(Color.parseColor("#000000"));
            	
            	//Get the Height and Weight Value
            	final String heightValue = heightText.getText().toString();
            	final String weightValue = weightText.getText().toString();
            	float bmiValue;
            	
            	//Get id of the Radio Button that has selected
            	int checkedId = grpRadioButton.getCheckedRadioButtonId();
            	
            	
            	//check for the Radio Button
            	if (checkedId == R.id.kgsmtsRadioButton)
            	{              	
            		//Calculate the BMI and Set the value
                	bmiValue = Float.parseFloat(weightValue) / (Float.parseFloat(heightValue) * Float.parseFloat(heightValue));   	                    
                	bmiText.setText(String.format("%.2f", bmiValue));
            	}
            	else
            	{
            		//Calculate the BMI and set the value
                	bmiValue = (Float.parseFloat(weightValue) * 703 )/ (Float.parseFloat(heightValue) * Float.parseFloat(heightValue));         	                
                	bmiText.setText(String.format("%.2f", bmiValue));	
            	}     
        
            	
            	//Check for the BMI Value and Set the Color for the BMI Scale
				if (bmiValue < 18.5)
				{
					underWeightText.setTextColor(getResources().getColor(R.color.blue_bmi));
					underWeightResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
					
					bmiResultText.setText(underWeightText.getText().toString() + " - " + underWeightResultText.getText().toString());
				} 
				else if(bmiValue >= 18.5 && bmiValue <=24.99)
				{
					normalText.setTextColor(getResources().getColor(R.color.blue_bmi));
					noramlResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
					
					bmiResultText.setText(normalText.getText().toString() + " - " + noramlResultText.getText().toString());
				}
				else if(bmiValue >= 25 && bmiValue <= 29.99)
				{
					overweightText.setTextColor(getResources().getColor(R.color.blue_bmi));
					overweightResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
					
					bmiResultText.setText(overweightText.getText().toString() + " - " + overweightResultText.getText().toString());
				}
				else if(bmiValue >= 30)
				{
					obeseText.setTextColor(getResources().getColor(R.color.blue_bmi));
					obeseResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
					
					bmiResultText.setText(obeseText.getText().toString() + " - " + obeseResultText.getText().toString());
				}
            }
        }); //End of the Click Event of the BMI Calculate Button
		
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
