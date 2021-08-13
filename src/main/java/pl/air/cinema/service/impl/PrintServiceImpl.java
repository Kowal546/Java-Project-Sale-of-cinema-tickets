package pl.air.cinema.service.impl;

import org.springframework.stereotype.Service;
import pl.air.cinema.model.*;
import pl.air.cinema.service.PrintService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {

	/* Movie */
	@Override
	public void printMovie(Movie one) {
		printMovie(one, true);
	}

	public void printMovie(Movie one, boolean header) {
		Long id = one.getId();
		String title = one.getTitle();
		String director = one.getDirector().getLastName();
		String productionCompany = one.getProductionCompany().getName();
		//List<Star> stars = one.getStars();

		if (header) {
			printMovieHeader();
		}
		System.out.format(
				"%-3d | %-20s | %-20s | %-20s \n", id, title, director, productionCompany//, stars
		);
	}


	@Override
	public void printMovies(List<Movie> many) {
		printMovieHeader();
		for (Movie one : many) {
			printMovie(one, false);
		}
	}

	private void printMovieHeader() {
		System.out.println(
				"id  | nazwa                | reżyser              | wytwórnia          \n" +
				"----+----------------------+----------------------+----------------------"
		);
	}


	/* Customer */
	@Override
	public void printCustomer(Customer one) {
		printCustomer(one, true);
	}

	public void printCustomer(Customer one, boolean header) {
		Long id = one.getId();
		String fullName = one.getFirstName() + " " + one.getLastName();
		//List<Ticket> tickets = one.getTickets();

		if (header) {
			printCustomerHeader();
		}
		System.out.format(
				"%-3d | %-30s \n", id, fullName//, tickets
		);
	}
	
	@Override
	public void printCustomers(List<Customer> many) {
		printCustomerHeader();
		for (Customer one : many) {
			printCustomer(one, false);
		}
	}

	private void printCustomerHeader() {
		System.out.println(
				"id  | imię i nazwisko                \n" +
				"----+--------------------------------"
		);
	}

	/* Director */
	@Override
	public void printDirector(Director one) {
		printDirector(one, true);
	}

	public void printDirector(Director one, boolean header) {
		Long id = one.getId();
		String fullName = one.getFirstName() + " " + one.getLastName();
		LocalDate birthDate = one.getBirthDate();

		if (header) {
			printCustomerHeader();
		}
		System.out.format(
				"%-3d | %-30s | %-10s\n", id, fullName, birthDate
		);
	}

	@Override
	public void printDirectors(List<Director> many) {
		printDirectorHeader();
		for (Director one : many) {
			printDirector(one, false);
		}
	}

	private void printDirectorHeader() {
		System.out.println(
				"id  | imię i nazwisko                | data urodzenia        \n" +
						"----+--------------------------------+------------"
		);
	}

	/* Star */
	@Override
	public void printStar(Star one) {
		printStar(one, true);
	}

	public void printStar(Star one, boolean header) {
		Long id = one.getId();
		String fullName = one.getFirstName() + " " + one.getLastName();
		LocalDate birthDate = one.getBirthDate();
		if (header) {
			printStarHeader();
		}
		System.out.format(
				"%-3d | %-30s | %-10s \n", id, fullName, birthDate
		);
	}

	@Override
	public void printStars(List<Star> many) {
		printStarHeader();
		for (Star one : many) {
			printStar(one, false);
		}
	}

	private void printStarHeader() {
		System.out.println(
				"id  | imię i nazwisko                | data urodzenia        \n" +
						"----+--------------------------------+------------"
		);
	}

	/* FilmShow */
	@Override
	public void printFilmShow(FilmShow one) {
		printFilmShow(one, true);
	}

	private void printFilmShow(FilmShow one, boolean header) {
		Long id = one.getId();
		LocalDate date = one.getDate();
		String movName = one.getMovie().getTitle();

		if (header) {
			printFilmShowHeader();
		}
		System.out.format(
				"%-3d | %-20s | %-10s \n", id, movName, date
		);
	}

	@Override
	public void printFilmShows(List<FilmShow> many) {
		printFilmShowHeader();
		for (FilmShow one : many) {
			printFilmShow(one, false);
		}
	}

	private void printFilmShowHeader() {
		System.out.println(
				"id  | tutuł filmu          | data seansu \n" +
						"----+----------------------+-------------"
		);
	}
	/* ProductionCompany */

	@Override
	public void printProductionCompany(ProductionCompany one) {
		printProductionCompany(one, true);
	}

	private void printProductionCompany(ProductionCompany one, boolean header) {
		Long id = one.getId();
		String name = one.getName();
		LocalDate founded = one.getFounded();

		if (header) {
			printProductionCompanyHeader();
		}
		System.out.format(
				"%-3d | %-20s | %-10s \n", id, name, founded
		);
	}

	@Override
	public void printProductionCompanies(List<ProductionCompany> many) {
		printProductionCompanyHeader();
		for (ProductionCompany one : many) {
			printProductionCompany(one, false);
		}
	}

	private void printProductionCompanyHeader() {
		System.out.println(
				"id  | nazwa                | założony \n" +
						"----+----------------------+--------------"
		);
	}

	/* Ticket */
	@Override
	public void printTicket(Ticket one) {
		printTicket(one, true);
	}

	private void printTicket(Ticket one, boolean header) {
		Long id = one.getId();
		double price = one.getPrice();
		int seat = one.getSeat();
		String movie = one.getFilmShow().getMovie().getTitle();

		if (header) {
			printTicketHeader();
		}
		System.out.format(
				"%-3d | %-10s | %-8d | %-20s \n", id, price, seat, movie
		);
	}

	@Override
	public void printTickets(List<Ticket> many) {
		printTicketHeader();
		for (Ticket one : many) {
			printTicket(one, false);
		}
	}

	private void printTicketHeader() {
		System.out.println(
				"id  | cena       | miejsce  | film                  \n" +
						"----+------------+----------+----------------------"
		);
	}


}
