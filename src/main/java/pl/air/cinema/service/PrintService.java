package pl.air.cinema.service;

import pl.air.cinema.model.*;

import java.util.List;

public interface PrintService {

	/* Customer */
	void printCustomer(Customer one);
	void printCustomers(List<Customer> many);

	/* Director */
	void printDirector(Director one);
	void printDirectors(List<Director> many);

	/* FilmShow */
	void printFilmShow(FilmShow one);
	void printFilmShows(List<FilmShow> many);

	/* Movie */
	void printMovie(Movie one);
	void printMovies(List<Movie> many);

	/* ProductionCompany */
	void printProductionCompany(ProductionCompany one);
	void printProductionCompanies(List<ProductionCompany> many);

	/* Star */
	void printStar(Star one);
	void printStars(List<Star> many);

	/* Ticket */
	void printTicket(Ticket one);
	void printTickets(List<Ticket> many);

}
