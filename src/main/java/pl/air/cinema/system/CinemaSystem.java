package pl.air.cinema.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.air.cinema.model.*;

import pl.air.cinema.repo.*;
import pl.air.cinema.service.PrintService;
import pl.air.cinema.service.ReadService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class CinemaSystem {

    @Autowired
    private ReadService readService;
    @Autowired
    private CustomerRepository cusRepo;
    @Autowired
    private MovieRepository movRepo;
    @Autowired
    private DirectorRepository dirRepo;
    @Autowired
    private StarRepository staRepo;
    @Autowired
    private FilmShowRepository filRepo;
    @Autowired
    private ProductionCompanyRepository proRepo;
    @Autowired
    private TicketRepository ticRepo;
    @Autowired
    private PrintService printService;
//    @Autowired private CustomerRepository ticRepo;

    public void run() {
        while (true) {
            printMenu();
            int option = readService.readInt("Wybierz opcje z menu");
            switch (option) {
                case 1:
                    cusAll();
                    break;
                case 2:
                    cusById();
                    break;
                case 3:
                    dirAll();
                    break;
                case 4:
                    dirById();
                    break;
                case 5:
                    filAll();
                    break;
                case 6:
                    filById();
                    break;
                case 7:
                    movAll();
                    break;
                case 8:
                    movById();
                    break;
                case 9:
                    proAll();
                    break;
                case 10:
                    proById();
                    break;
                case 11:
                    staAll();
                    break;
                case 12:
                    staById();
                    break;
                case 13:
                    ticAll();
                    break;
                case 14:
                    ticById();
                    break;
                case 15:
                    movByTitle();
                    break;
                case 16:
                    staByMov();
                    break;
                case 17:
                    ticByCus();
                    break;
                case 18:
                    movByDir();
                    break;
                case 19:
                    movBySta();
                    break;
                case 20:
                    cusNew();
                    break;
                case 21:
                    filNew();
                    break;
                case 22:
                    ticNew();
                    break;
                case 23:
                    cusDel();
                    break;
                case 24:
                    filDel();
                    break;
                case 25:
                    ticDel();
                    break;
                case 26:
                    cusUpd();
                    break;
//                case 27:
//                    addTicToCus();
//                    break;
                case 28:
                    System.out.println("Koniec pracy");
                    return;

            }
        }
    }

    @Transactional(readOnly = true)
    void cusAll() {
        List<Customer> all = cusRepo.findAll();
        printService.printCustomers(all);
    }

    @Transactional(readOnly = true)
    void cusById() {
        Long id = readService.readLong("Podaj id klienta");
        Optional<Customer> opt = cusRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono klienta");
            return;
        }
        Customer one = opt.get();
        printService.printCustomer(one);
    }


    @Transactional(readOnly = true)
    void dirAll() {
        List<Director> all = dirRepo.findAll();
        printService.printDirectors(all);
    }

    @Transactional(readOnly = true)
    void dirById() {
        Long id = readService.readLong("Podaj id reżysera");
        Optional<Director> opt = dirRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono reżysera");
            return;
        }
        Director one = opt.get();
        printService.printDirector(one);
    }

    @Transactional(readOnly = true)
    void movAll() {
        List<Movie> all = movRepo.findAll();
        printService.printMovies(all);
    }

    @Transactional(readOnly = true)
    void movById() {
        Long id = readService.readLong("Podaj id filmu");
        Optional<Movie> opt = movRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono filmu");
            return;
        }
        Movie one = opt.get();
        printService.printMovie(one);
    }


    @Transactional(readOnly = true)
    void staAll() {
        List<Star> all = staRepo.findAll();
        printService.printStars(all);
    }

    @Transactional(readOnly = true)
    void staById() {
        Long id = readService.readLong("Podaj id gwiazdy");
        Optional<Star> opt = staRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono gwiazdy");
            return;
        }
        Star one = opt.get();
        printService.printStar(one);
    }

    @Transactional(readOnly = true)
    void filAll() {
        List<FilmShow> all = filRepo.findAll();
        printService.printFilmShows(all);
    }

    @Transactional(readOnly = true)
    void filById() {
        Long id = readService.readLong("Podaj id seansu");
        Optional<FilmShow> opt = filRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono seansu");
            return;
        }
        FilmShow one = opt.get();
        printService.printFilmShow(one);
    }

    @Transactional(readOnly = true)
    void proAll() {
        List<ProductionCompany> all = proRepo.findAll();
        printService.printProductionCompanies(all);
    }

    @Transactional(readOnly = true)
    void proById() {
        Long id = readService.readLong("Podaj id wytwórni");
        Optional<ProductionCompany> opt = proRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono wytwórni");
            return;
        }
        ProductionCompany one = opt.get();
        printService.printProductionCompany(one);
    }

    @Transactional(readOnly = true)
    void ticAll() {
        List<Ticket> all = ticRepo.findAll();
        printService.printTickets(all);
    }

    @Transactional(readOnly = true)
    void ticById() {
        Long id = readService.readLong("Podaj id biletu");
        Optional<Ticket> opt = ticRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono biletu");
            return;
        }
        Ticket one = opt.get();
        printService.printTicket(one);
    }

    @Transactional(readOnly = true)
    void staByMov() {
        String name = readService.readText("Podaj nazwę filmu");

        Optional<Movie> opt = movRepo.findByTitle(name);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono filmu");
            return;
        }
        Movie mov = opt.get();
        List<Star> all = staRepo.findAllByMovies(mov);
        printService.printStars(all);
    }

    @Transactional(readOnly = true)
    void ticByCus() {

        String firstName = readService.readText("Podaj imię");
        String lastName = readService.readText("Podaj nazwisko");
        Optional<Customer> opt = cusRepo.findAllByFirstNameAndLastName(firstName, lastName);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono klienta");
            return;
        }
        Customer cus = opt.get();
        List<Ticket> all = ticRepo.findAllByCustomers(cus);
        printService.printTickets(all);
    }

    @Transactional(readOnly = true)
    void movByDir() {
        String firstName = readService.readText("Podaj imię reżysera");
        String lastName = readService.readText("Podaj nazwisko reżysera");

        Optional<Director> opt = dirRepo.findAllByFirstNameAndLastName(firstName, lastName);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono reżysera");
            return;
        }
        Director dir = opt.get();
        List<Movie> all = movRepo.findAllByDirector(dir);
        printService.printMovies(all);
    }

    @Transactional(readOnly = true)
    void movByTitle() {
        String title = readService.readText("Podaj tytuł filmu");
        Optional<Movie> opt = movRepo.findByTitle(title);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono filmu");
            return;
        }
        Movie one = opt.get();
        printService.printMovie(one);
    }

    @Transactional(readOnly = true)
    void movBySta() {
        String firstName = readService.readText("Podaj imię aktora");
        String lastName = readService.readText("Podaj nazwisko aktora");

        Optional<Star> opt = staRepo.findAllByFirstNameAndLastName(firstName, lastName);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono filmu");
            return;
        }
        Star sta = opt.get();
        List<Movie> all = movRepo.findAllByStars(sta);
        printService.printMovies(all);
    }

    @Transactional
    void filNew() {
        LocalDate date = readService.readDate("Data");
        String title = readService.readText("Podaj tytuł filmu");
        Optional<Movie> opt = movRepo.findByTitle(title);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono filmu");
            return;
        }
        Movie mov = opt.get();

        FilmShow one = new FilmShow();
        one.setDate(date);
        one.setMovie(mov);

        FilmShow oneSaved = filRepo.save(one);
        printService.printFilmShow(oneSaved);
    }

    @Transactional
    void ticNew() {
        boolean reduction = false;
        int red = readService.readInt("Czy naliczyć zniżkę? \n 1. Tak\n 2. Nie");
        if (red == 1) {
            reduction = true;
        }
        if (red == 2) {
            reduction = false;
        }
        int seat = readService.readInt("Podaj miejsce");
        double price = readService.readDouble("Podaj cenę");
        Long id = readService.readLong("Podaj id seansu");
        Optional<FilmShow> opt = filRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono seansu");
            return;
        }
        FilmShow fil = opt.get();
        Ticket one = new Ticket();
        one.setReduction(reduction);
        one.setPrice(price);
        one.setSeat(seat);
        one.setFilmShow(fil);


        Ticket oneSaved = ticRepo.save(one);
        printService.printTicket(oneSaved);
    }


    @Transactional
    void cusNew() {
        String firstName = readService.readText("Imię klienta");
        String lastName = readService.readText("Nazwisko klienta");
        Long id = readService.readLong("Podaj id biletu");
        Optional<Ticket> opt = ticRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono biletu");
            return;
        }
        Ticket tic = opt.get();

        Customer one = new Customer();
        one.setFirstName(firstName);
        one.setLastName(lastName);
        one.setTickets(List.of(tic));

        Customer oneSaved = cusRepo.save(one);
        printService.printCustomer(oneSaved);
    }

    @Transactional
    void cusDel() {
        Long id = readService.readLong("Podaj id klienta");
        Optional<Customer> opt = cusRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono klienta");
            return;
        } else {
            cusRepo.deleteCustomerById(id);
        }
    }

    @Transactional
    void filDel() {
        Long id = readService.readLong("Podaj id seansu");
        Optional<FilmShow> opt = filRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono seansu");
            return;
        } else {
            filRepo.deleteFilmShowById(id);
        }
    }

    @Transactional
    void ticDel() {
        Long id = readService.readLong("Podaj id biletu");
        Optional<Ticket> opt = ticRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono biletu");
            return;
        } else {
            ticRepo.deleteTicketById(id);
        }
    }

    @Transactional
    void cusUpd() {
        Long id = readService.readLong("Podaj id klienta");
        Optional<Customer> opt = cusRepo.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Nie znaleziono klienta");
            return;
        }
        Customer one = opt.get();
        String firstName = readService.readText("Podaj nowe imię klienta");
        String lastName = readService.readText("Podaj nowe nazwisko klienta");
        one.setFirstName(firstName);
        one.setLastName(lastName);
        cusRepo.save(one);
    }

//    @Transactional
//    void addTicToCus(){
//        Long id = readService.readLong("Podaj id klienta");
//        Optional<Customer> opt = cusRepo.findById(id);
//        if (opt.isEmpty()) {
//            System.out.println("Nie znaleziono klienta");
//            return;
//        }
//        Customer one = opt.get();
//
//
//        Long ticId = readService.readLong("Podaj id biletu który chcesz dodać");
//        Optional<Ticket> opti = ticRepo.findById(ticId);
//        if (opti.isEmpty()) {
//            System.out.println("Nie znaleziono biletu");
//            return;
//        }
//        Ticket tic = opti.get();
//
//        List<Ticket> tickets = one.getTickets();
//        tickets.add(0,tic);
//        one.addTicket(tic);
//
//        cusRepo.save(one);
//
//    }

    private void printMenu() {
        String menu = "\n" +
                "1. Wszyscy klienci \n" +
                "2. Klient o podanym id \n" +
                "3. Wszyscy reżyserzy \n" +
                "4. Reżyser o podanym id \n" +
                "5. Wszystkie seanse \n" +
                "6. Seans o podanym id \n" +
                "7. Wszystkie filmy \n" +
                "8. Film o podanym id \n" +
                "9. Wszystkie wytwórnie \n" +
                "10. Wytwórnia o podanym id \n" +
                "11. Wszystkie gwiazy \n" +
                "12. Gwiazda o podanym id \n" +
                "13. Wszystkie bilety \n" +
                "14. Bilet o podanym id \n" +
                "15. Znajdź film po nazwie \n" +
                "16. Gwiazdy w filmie \n" +
                "17. Bilety klienta \n" +
                "18. Filmy wybranego reżysera\n" +
                "19. Filmy w których grał wybrany aktor\n" +
                "20. Nowy klient \n" +
                "21. Nowy seans \n" +
                "22. Nowy bilet \n" +
                "23. Usuń klienta \n" +
                "24. Usuń seans \n" +
                "25. Usuń bilet \n" +
                "26. Zaktualizuj dane klienta \n" +
                "27. Koniec \n";
        System.out.println(menu);
    }
}
