package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	private SimpleMath math = new SimpleMath();
	
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/minus/{numberOne}/{numberTwo}")
	public Double minus(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return math.minus(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/divide/{numberOne}/{numberTwo}")
	public Double divide(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return math.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping(value = "/sqrt/{numberOne}")
	public Double sqrt(
			@PathVariable(value = "numberOne") String numberOne
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please, set a numeric value");
		
		return math.sqrt(NumberConverter.convertToDouble(numberOne));
	}

}
