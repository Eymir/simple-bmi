package com.just.bmi;

public class calculateBMI {

	
	private double Cweight ;
	private double Cheight;
	public double result = 0;
	public calculateBMI(double weight , double height) {
		// TODO Auto-generated constructor stub
	Cweight=weight;
	Cheight=height;
		
	}
	
	
	public double calulateBmi()
	{
		Cheight=Cheight/100;
		result= Cweight/(Cheight*Cheight);
		return result;
	}
	
	
}
