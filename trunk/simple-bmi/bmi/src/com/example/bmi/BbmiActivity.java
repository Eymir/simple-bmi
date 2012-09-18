package com.example.bmi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BbmiActivity extends Activity {

	TextView bmiMessage ;
	TextView bmiNumber;
	EditText weight;
	RadioGroup gpRadio;
	RadioButton kgRadio;
	RadioButton poundRadio;
	EditText heightCM;
	EditText heightFt;
	EditText heightInches;
	
	String weightchk="";
	String heightchkCM="";
	String heightchkFt="";
	String heightchkIn="";
	
	double weightToPass=0;
	double heightTopass=0;
	double resultBMI;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbmi);
        
        bmiMessage = (TextView)findViewById(R.id.statement);
        bmiNumber =(TextView)findViewById(R.id.numberBMI);
        weight=(EditText)findViewById(R.id.weightEdit);
        heightCM = (EditText)findViewById(R.id.cmEditText);
        heightFt=(EditText)findViewById(R.id.ftEditText);
        heightInches=(EditText)findViewById(R.id.inchesEditText);
        kgRadio =(RadioButton)findViewById(R.id.kgRadioButton);
       
        
    }

   
public void startBMI (View view)
  {

	
	
	weightchk=weight.getText().toString();
	heightchkCM=heightCM.getText().toString();
	heightchkFt=heightFt.getText().toString();
	heightchkIn=heightInches.getText().toString();	
	
	if(check())
	{
		Toast.makeText(this, "Please Fill in Empty Fields", Toast.LENGTH_LONG).show();
	}
	else
	{
		if(kgRadio.isChecked())
		{
			weightToPass=Integer.parseInt(weightchk);
		}
		else
		{
			int poundToKg = Integer.parseInt( weightchk);
			weightToPass = Math.round(poundToKg*0.45);
		}
		
		if(heightchkCM.length()!=0)
		{
		
			heightTopass=Integer.parseInt(heightchkCM);
		}
		else if(heightchkIn.length()!=0)
		{					int ft=Integer.parseInt(heightchkFt);
					int in=Integer.parseInt(heightchkIn) + ft*12;
					heightTopass=in*2.54;
					
		}
		else 
		{
			int ft=Integer.parseInt(heightchkFt);
			heightTopass=ft*30.48;
		}
		calcBMI();
	}
	

}
    
    public boolean check()
    {
    	
    	if(weightchk.length()==0||(heightchkCM.length()==0&&heightchkFt.length()==0))
    	{return true;}
    	
    	return false;
    }

    public void calcBMI()
    {
    	calculateBMI calcThat = new calculateBMI(weightToPass, heightTopass);
    	resultBMI = calcThat.calulateBmi();
    	setMessages(resultBMI);    	
    }
    
    public void setMessages(double value)
    {
    	String val = roundToOneDigit((float)value);
    	 	bmiNumber.setText(val);
    	if(value < 15)
    	{
    		bmiMessage.setText(R.string.lessthan15);
    	}
    	else if(value > 15 && value <16)
    	{
    		bmiMessage.setText(R.string.from15to16);
    	}
    	else if(value>16 && value<18.5)
    	{
    		bmiMessage.setText(R.string.from16to18_5);
    	}
    	else if(value>18.5&&value<25)
    	{
    		bmiMessage.setText(R.string.from18_5to25);
    	}
    	else if(value>25 && value < 30)
    	{
           bmiMessage.setText(R.string.from25to30);    		
    	}
    	else if(value>30 && value <35)
    	{
    		bmiMessage.setText(R.string.from30t035);
    	}
    	else if(value>35 && value<40)
    	{
    		bmiMessage.setText(R.string.from35to40);
    	}
    	else if(value>40)
    	{bmiMessage.setText(R.string.over40);}
    }
    
    public static String roundToOneDigit(float paramFloat) {
        return String.format("%.1f%n", paramFloat);
    }

}
