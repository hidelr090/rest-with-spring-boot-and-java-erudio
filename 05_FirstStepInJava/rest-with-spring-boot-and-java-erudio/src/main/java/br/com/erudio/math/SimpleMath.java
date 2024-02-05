package br.com.erudio.math;

public class SimpleMath {
	public Double sum(Double numberOne, Double numberTwo){
		return numberOne + numberTwo;
	}
	
	public Double minus(Double numberOne, Double numberTwo){
		return numberOne - numberTwo;
	}
	
	public Double multiply(Double numberOne, Double numberTwo){
		return numberOne * numberTwo;
	}

	public Double divide(Double numberOne, Double numberTwo)throws Exception {
		return numberOne / numberTwo;
	}
	
	public Double mean(Double numberOne, Double numberTwo)throws Exception {
		return sum(numberOne, numberTwo) / 2;
	}
	
	public Double sqrt(Double numberOne)throws Exception {
		return Math.sqrt(numberOne);
	}

}
