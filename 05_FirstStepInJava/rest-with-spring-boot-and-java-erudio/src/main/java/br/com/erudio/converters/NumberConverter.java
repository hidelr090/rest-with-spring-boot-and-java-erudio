package br.com.erudio.converters;

public class NumberConverter {
	
	public static Double convertToDouble(String strNumber) throws Exception {
		if(strNumber == null) throw new Exception();
		
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}
	
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
