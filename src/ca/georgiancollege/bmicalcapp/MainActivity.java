package ca.georgiancollege.bmicalcapp;

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
		
		final Button bmiButon = (Button) findViewById(R.id.bmiButton);
		final Button resetButton = (Button) findViewById(R.id.resetButton);
		final EditText heightText = (EditText)findViewById(R.id.heightEditText);
		final EditText weightText = (EditText)findViewById(R.id.weightEditText);
		final RadioGroup grpRadioButton = (RadioGroup) findViewById(R.id.grpRadioButton);
		final EditText bmiText = (EditText) findViewById(R.id.bmiEditText);
		
		final TextView underWeightText = (TextView) findViewById(R.id.underWeightTextView);
		final TextView underWeightResultText = (TextView) findViewById(R.id.underWeightResultTextView);
		final TextView normalText = (TextView) findViewById(R.id.normalTextView);
		final TextView noramlResultText = (TextView) findViewById(R.id.normalResultTextView);
		final TextView overweightText = (TextView) findViewById(R.id.overWeightTextView);
		final TextView overweightResultText = (TextView) findViewById(R.id.overWeightResultTextView);
		final TextView obeseText = (TextView) findViewById(R.id.obeseTextView);
		final TextView obeseResultText = (TextView) findViewById(R.id.obeseResultTextView);
		
		resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	heightText.setText("0.00");
            	weightText.setText("0.00");
            	bmiText.setText("0.00");
            	underWeightText.setTextColor(Color.parseColor("#000000"));
            	underWeightResultText.setTextColor(Color.parseColor("#000000"));
            	normalText.setTextColor(Color.parseColor("#000000"));
            	noramlResultText.setTextColor(Color.parseColor("#000000"));
            	overweightText.setTextColor(Color.parseColor("#000000"));
            	overweightResultText.setTextColor(Color.parseColor("#000000"));
            	obeseText.setTextColor(Color.parseColor("#000000"));
            	obeseResultText.setTextColor(Color.parseColor("#000000"));
            }
        });
		
		bmiButon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                          	
            	underWeightText.setTextColor(Color.parseColor("#000000"));
            	underWeightResultText.setTextColor(Color.parseColor("#000000"));
            	normalText.setTextColor(Color.parseColor("#000000"));
            	noramlResultText.setTextColor(Color.parseColor("#000000"));
            	overweightText.setTextColor(Color.parseColor("#000000"));
            	overweightResultText.setTextColor(Color.parseColor("#000000"));
            	obeseText.setTextColor(Color.parseColor("#000000"));
            	obeseResultText.setTextColor(Color.parseColor("#000000"));
            	
            	final String heightValue = heightText.getText().toString();
            	final String weightValue = weightText.getText().toString();
            	float bmiValue;
            	int checkedId = grpRadioButton.getCheckedRadioButtonId();
            	
            	if (checkedId == R.id.kgsmtsRadioButton)
            	{              	
                	bmiValue = Float.parseFloat(weightValue) / (Float.parseFloat(heightValue) * Float.parseFloat(heightValue));   	                    
                	bmiText.setText(String.format("%.2f", bmiValue));
            	}
            	else
            	{
                	bmiValue = (Float.parseFloat(weightValue) * 703 )/ (Float.parseFloat(heightValue) * Float.parseFloat(heightValue));         	                
                	bmiText.setText(String.format("%.2f", bmiValue));	
            	}     
            	
				if (bmiValue < 18.5)
				{
					underWeightText.setTextColor(getResources().getColor(R.color.blue_bmi));
					underWeightResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
				} 
				else if(bmiValue >= 18.5 && bmiValue <=24.99)
				{
					normalText.setTextColor(getResources().getColor(R.color.blue_bmi));
					noramlResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
				}
				else if(bmiValue >= 25 && bmiValue <= 29.99)
				{
					overweightText.setTextColor(getResources().getColor(R.color.blue_bmi));
					overweightResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
				}
				else if(bmiValue >= 30)
				{
					obeseText.setTextColor(getResources().getColor(R.color.blue_bmi));
					obeseResultText.setTextColor(getResources().getColor(R.color.blue_bmi));
				}
            }
        });
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
