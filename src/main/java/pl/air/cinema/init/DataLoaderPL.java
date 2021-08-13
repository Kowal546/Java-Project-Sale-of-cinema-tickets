package pl.air.cinema.init;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import pl.air.cinema.model.*;
import pl.air.cinema.repo.*;

@Repository
public class DataLoaderPL implements DataLoader {

    @Autowired private CustomerRepository cusRepo;
    @Autowired private DirectorRepository humRepo;
    @Autowired private MovieRepository movRepo;
    @Autowired private ProductionCompanyRepository proRepo;
    @Autowired private StarRepository staRepo;
    @Autowired private FilmShowRepository filRepo;
    @Autowired private TicketRepository ticRepo;


    @Override
    @Transactional
    public void insertData() {



        // Reżyser

        Director pm = createDirector("Pierre", "Morel", "1964-05-12");
        Director fc = createDirector("Francis", "Ford Coppola", "1939-04-07");
        Director rp = createDirector("Roman", "Polański", "1933-08-18");
        Director re = createDirector("Roland", "Emmerich", "1955-11-10");
        Director gm = createDirector("George", "Miller", "1945-03-03");

        // Wytwórnia

        ProductionCompany cf = createProductionCompany("20th Century Fox", "1935-05-31");
        ProductionCompany pp = createProductionCompany("Paramount Pictures", "1912-05-08");
        ProductionCompany az = createProductionCompany("American Zoetrope", "1969-12-12");
        ProductionCompany bs = createProductionCompany("Babelsberg Studio", "1911-01-01");
        ProductionCompany cp = createProductionCompany("Columbia Pictures", "1918-01-01");
        ProductionCompany km = createProductionCompany("Kennedy Miller Mitchell", "1978-01-01");

        // Gwiazda

        Star ln = createStar("Liam", "Neeson", "1952-06-07");
        Star ap = createStar("Al", "Pacino", "1940-04-25");
        Star mb = createStar("Marlon", "Brando", "1924-04-03");
        Star ab = createStar("Adrien", "Brody", "1973-04-14");
        Star mg = createStar("Mel", "Gibson", "1956-01-03");


        // Film

        Movie uprowadzona = createMovie("Uprowadzona", pm, cf, ln);
        Movie ojciecChrzestny = createMovie("Ojciec Chrzestny", fc, pp, ap, mb);
        Movie czasApokalipsy = createMovie("Czas apokalipsy", fc, az, mb);
        Movie pianista = createMovie("Pianista", rp, bs, ab);
        Movie patriota = createMovie("Patriota", re, cp, mg);
        Movie madMax = createMovie("Mad Max", gm, km, mg);


        // Seans

        FilmShow dl = createFilmShow("2021-07-04", uprowadzona);
        FilmShow dl2 = createFilmShow("2021-07-19", ojciecChrzestny);
        FilmShow dl3 = createFilmShow("2021-09-30", czasApokalipsy);
        FilmShow pd = createFilmShow("2021-07-15", pianista);
        FilmShow ur = createFilmShow("2021-07-24", patriota);

        // Bilet

        Ticket jkt = createTicket(true, 20.00, 1, dl);
        Ticket jkt2 = createTicket(true, 20.00, 1, dl2);
        Ticket mnt = createTicket(false, 20.00, 1, dl3);
        Ticket rmt = createTicket(false, 20.00, 1, ur);
        Ticket jpt = createTicket(false, 20.00, 1, pd);

        // Klient

        Customer jk = createCustomer("Jan", "Kowalski", jkt , jkt2);
        Customer rg = createCustomer("Rafał", "Godfrydziak", jkt);
        Customer mn = createCustomer("Michał", "Nowak", mnt);
        Customer rm = createCustomer("Robert", "Malinowski", rmt);
        Customer jp = createCustomer("Janusz", "Polak", rmt, jpt);


        humRepo.saveAll(List.of(pm, fc, rp, re,gm));
        proRepo.saveAll(List.of(cf, pp, az, bs, cp, km));;
        staRepo.saveAll(List.of(ln, ap, mb, ab, mg));
        movRepo.saveAll(List.of(uprowadzona, ojciecChrzestny, czasApokalipsy, pianista, patriota, madMax));
        filRepo.saveAll(List.of(dl, dl2, dl3, pd, ur));
        ticRepo.saveAll(List.of(jkt, jkt2, mnt, rmt, jpt));
        cusRepo.saveAll(List.of(jk, rg, mn, rm, jp));



    }

    private Customer createCustomer(String firstName, String lastName, Ticket... tickets) {
        Customer one = new Customer();
        one.setFirstName(firstName);
        one.setLastName(lastName);
        one.setTickets(List.of(tickets));
        return one;
    }

    private FilmShow createFilmShow(String date, Movie movie) {
        FilmShow one = new FilmShow();
        one.setDate(LocalDate.parse(date));
        one.setMovie(movie);
        return one;
    }

    private Director createDirector(String firstName, String lastName, String birthDate) {
        Director one = new Director();
        one.setFirstName(firstName);
        one.setLastName(lastName);
        one.setBirthDate(LocalDate.parse(birthDate));
        return one;

    }

    private Movie createMovie(String title, Director director, ProductionCompany productionCompany, Star... stars) {
        Movie one = new Movie();
        one.setTitle(title);
        one.setDirector(director);
        one.setStars(List.of(stars));
        one.setProductionCompany(productionCompany);
        return one;
    }

    private ProductionCompany createProductionCompany(String name, String founded) {
        ProductionCompany one = new ProductionCompany();
        one.setName(name);
        one.setFounded(LocalDate.parse(founded));
        return one;
    }

    private Star createStar(String firstName, String lastName, String birthDate) {
        Star one = new Star();
        one.setFirstName(firstName);
        one.setLastName(lastName);
        one.setBirthDate(LocalDate.parse(birthDate));
        return one;
    }

    private Ticket createTicket(boolean reduction, double price, int seat, FilmShow filmShow) {
        Ticket one = new Ticket();
        one.setReduction(reduction);
        one.setPrice(price);
        one.setSeat(seat);
        one.setFilmShow(filmShow);
        return one;
    }
}
