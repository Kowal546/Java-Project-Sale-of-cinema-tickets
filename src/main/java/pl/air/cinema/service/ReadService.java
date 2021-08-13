package pl.air.cinema.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ReadService {
	
	Integer readInt(String prompt);
	Long readLong(String prompt);
	Double readDouble(String prompt);
	BigDecimal readDecimal(String prompt);
	LocalDate readDate(String prompt);
	String readText(String prompt);
	
}
