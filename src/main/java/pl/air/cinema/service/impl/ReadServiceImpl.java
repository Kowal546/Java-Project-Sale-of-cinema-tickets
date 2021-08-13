package pl.air.cinema.service.impl;

import org.springframework.stereotype.Service;
import pl.air.cinema.service.ReadService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class ReadServiceImpl implements ReadService {
	
	private Scanner sc = new Scanner(System.in);

	
	@Override
	public Integer readInt(String prompt) {
		while (true) {
			String input = readLine(prompt);
			try {
				Integer value = Integer.parseInt(input);
				return value;
			}
			catch (Exception ex) {
				System.out.println("Wprowadzona wartość nie jest liczbą całkowitą!");
			}
		}
	}

	@Override
	public Long readLong(String prompt) {
		while (true) {
			String input = readLine(prompt);
			try {
				Long value = Long.parseLong(input);
				return value;
			}
			catch (Exception ex) {
				System.out.println("Wprowadzona wartość nie jest liczbą całkowitą!");
			}
		}
	}

	@Override
	public Double readDouble(String prompt) {
		while (true) {
			String input = readLine(prompt);
			try {
				Double value = Double.parseDouble(input);
				return value;
			}
			catch (Exception ex) {
				System.out.println("Wprowadzona wartość nie jest liczbą!");
			}
		}
	}

	@Override
	public BigDecimal readDecimal(String prompt) {
		while (true) {
			String input = readLine(prompt);
			try {
				BigDecimal value = new BigDecimal(input);
				return value;
			}
			catch (Exception ex) {
				System.out.println("Wprowadzona wartość nie jest dziesiętną!");
			}
		}
	}

	@Override
	public LocalDate readDate(String prompt) {
		while (true) {
			String input = readLine(prompt + " (rrrr-mm-dd)");
			try {
				LocalDate value = LocalDate.parse(input);
				return value;
			}
			catch (Exception ex) {
				System.out.println("Wprowadzona wartość nie jest datą!");
			}
		}
	}

	@Override
	public String readText(String prompt) {
		String input = readLine(prompt);
		return input;		
	}
	
	
	private String readLine(String prompt) {
		System.out.print(prompt + ": ");
		String line = sc.nextLine();
		line = line.trim();
		return line;
	}

}
