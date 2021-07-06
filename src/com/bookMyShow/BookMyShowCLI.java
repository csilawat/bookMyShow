package com.bookMyShow;

import com.bookMyShow.models.AddMovies;
import com.bookMyShow.models.Users;

import java.util.*;

public class BookMyShowCLI {

    static boolean condition = true;
    static String adminPassword = "admin";

    public static void main(String[] args) {

        BookMyShowCLI bookMyShowCLI = new BookMyShowCLI();
        Scanner scanner = new Scanner(System.in);
        List<Object> objectList = null;
        AddMovies bookedMovies = null;
        HashMap<String, Users> usersHashMap = new HashMap<String, Users>();
        HashMap<String, AddMovies> movieHashMap = new HashMap<String, AddMovies>();
        String operation;
        String menu = "Welcome To BookMyShow Login Screen:\n1 Admin Login:- \n2 users Login:-\n3 Register New User:- \n4 Exit";

        while (condition == true) {
            bookMyShowCLI.menu(menu);
            operation = scanner.next();
            List<AddMovies> movieList = bookMyShowCLI.addDefaultMovie();
            movieHashMap.put(movieList.get(0).getTitle(), movieList.get(0));
            movieHashMap.put(movieList.get(1).getTitle(), movieList.get(1));

            switch (operation) {

                case "1":
                    System.out.println("Admin Please Enter your Password = 'admin' ");
                    adminPassword = String.valueOf(scanner.next());
                    if (adminPassword.equals("admin")) {
                        System.out.println("your are lodged in as ADMIN");
                        bookMyShowCLI.adminLogin(scanner, movieHashMap);
                    } else {
                        System.out.println("You have exited wrong password");
                        System.exit(0);
                        condition = false;
                    }
                    break;

                case "2":
                    if (!(usersHashMap.isEmpty())) {
                        System.out.println("Enter your user name other than ADMIN : ");
                        String userName = bookMyShowCLI.showAllUsers(usersHashMap);
                        System.out.println(userName + " Please Enter your Password = user1 ");
                        String password = String.valueOf(scanner.next());
                        if (password.equals("user1")) {
                            System.out.println("your are lodged in as User1");
                            objectList = bookMyShowCLI.userMenu(movieHashMap);
                            if (!(objectList.get(1).equals(null))) {
                                bookedMovies = (AddMovies) objectList.get(1);
                                movieHashMap.remove(bookedMovies.getTitle());
                                movieHashMap.put(bookedMovies.getTitle(), bookedMovies);
                            }

                        } else {
                            System.out.println("You have exited wrong password for User1");
                        }
                    } else {
                        System.out.println("Create User before login");
                        Users users = bookMyShowCLI.createNewUsers();
                        usersHashMap.put(users.getName(), users);
                        break;
                    }
                    break;

                case "3":
                    System.out.println("****** Register New User **********");
                    Users users = bookMyShowCLI.createNewUsers();
                    usersHashMap.put(users.getName(), users);
                    break;

                case "4":
                    System.out.println("You have exited from the BookMyShow");
                    System.exit(0);
                    condition = false;
                    break;

                default:
                    System.out.println("Enter wrong info, Please put proper Info");
                    break;
            }
        }
        scanner.close();
    }

    public List<Object> userMenu(HashMap<String, AddMovies> moviesHashMap) {

        List<Object> list = new ArrayList<>();
        AddMovies movies = null;
        String movieName = null;
        if (!(moviesHashMap.isEmpty())) {
            Set set = moviesHashMap.keySet();

            System.out.println("This is Default list of Movies");
            System.out.println("Select Movie Name from below list");
            System.out.println(set);
            Scanner scanner = new Scanner(System.in);
            movieName = String.valueOf(scanner.next());
            movieName += scanner.nextLine();
            System.out.println("Your Selected Movie is :-" + movieName);
            movies = showMovieInfo(movieName, moviesHashMap);
        } else {
            System.out.println("No movie is available");
        }
        list.add(0, movieName);
        if (!(movies == null))
            list.add(1, movies);

        return list;
    }

    public AddMovies showMovieInfo(String movieTitle, HashMap<String, AddMovies> moviesHashMap) {

        AddMovies movies = moviesHashMap.get(movieTitle);
        System.out.println("********** Welcome ************");
        System.out.println("********** Movie Name - :" + movies.getTitle() + " ************");
        System.out.println("Name :- " + movies.getTitle());
        System.out.println("Genre :- " + movies.getGenre());
        System.out.println("Cast :- " + movies.getCast());
        System.out.println("Director :- " + movies.getDirector());
        System.out.println("Admin Rating :- " + movies.getAdminRating());
        System.out.println("Movie Timing :- " + movies.getFirstShow());
        System.out.println("**************** END *****************");

        AddMovies movie = movieBookingCancelRatingMenu(movieTitle, moviesHashMap);
        return movie;

    }

    public AddMovies movieBookingCancelRatingMenu(String movieTitle, HashMap<String, AddMovies> moviesHashMap) {

        Scanner scanner = new Scanner(System.in);
        AddMovies bookedMovie = null;
        AddMovies movies = moviesHashMap.get(movieTitle);
        String operation;
        boolean condition = true;
        String menu = "Welcome To BookMyShow Movie Booking / Cancle / Rating Screen for " + movieTitle.toUpperCase() + " movie :\n1 Book Tickets :- \n2 Cancel Tickets :-\n3 Give User Rating :- \n4 Exit";
        while (condition == true) {
            menu(menu);
            operation = scanner.next();

            switch (operation) {
                case "1":
                    System.out.println("***********************");
                    System.out.println("You select Book Ticket");
                    bookedMovie = bookMovieTicket(movies);
                    System.out.println("***********************");
                    condition = false;
                    break;

                case "2":
                    System.out.println("***********************");
                    System.out.println("You select Cancel Tickets");
                    System.out.println("***********************");
                    bookedMovie = cancelMovie(movies);

                    condition = false;
                    break;

                case "3":
                    System.out.println("***********************");
                    System.out.println("You select Give User Rating");
                    System.out.println("***********************");
                    condition = false;
                    break;

                case "4":
                    System.out.println("Exited from Booking area");
                    condition = false;
                    break;
            }
        }
        return bookedMovie;
    }

    public AddMovies cancelMovie(AddMovies movies) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Remaining Seats :- " + movies.getCapacity());
        System.out.println("Please select Seats which you want to CANCEL :");
        String capacity = scanner.next();
        capacity += scanner.nextLine();

        while (Integer.parseInt(capacity) >= movies.getCapacity()) {
            if (movies.getCapacity() < Integer.parseInt(capacity)) {
                System.out.println("Remaining Seats :- " + movies.getCapacity());
                System.out.println("Please select Seats :");
                capacity = scanner.next();
                capacity += scanner.nextLine();

            }
        }
        movies.setCapacity(movies.getCapacity() + Integer.parseInt(capacity));
        System.out.println("Thanks for Canceling Ticked, You Give a Chance to other to watch that movie");

        return movies;
    }

    public AddMovies bookMovieTicket(AddMovies movies) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select Timings :");
        System.out.println(movies.getStartTimings());
        String startedTiming = String.valueOf(scanner.next());
        startedTiming += scanner.nextLine();

        System.out.println("Remaining Seats :- " + movies.getCapacity());
        System.out.println("Please select Seats :");
        String capacity = scanner.next();
        capacity += scanner.nextLine();

        while (Integer.parseInt(capacity) >= movies.getCapacity()) {
            if (movies.getCapacity() < Integer.parseInt(capacity)) {
                System.out.println("Remaining Seats :- " + movies.getCapacity());
                System.out.println("Please select Seats :");
                capacity = scanner.next();
                capacity += scanner.nextLine();

            }
        }
        movies.setCapacity(movies.getCapacity() - Integer.parseInt(capacity));
        System.out.println("Thanks for booking");

        return movies;


    }

    public Users createNewUsers() {

        Scanner scanner = new Scanner(System.in);
        String phoneNo = null;
        String age = null;

        System.out.println("Please Enter user name");
        String name = String.valueOf(scanner.next());
        name += scanner.nextLine();

        System.out.println("Please Enter E-mail address");
        String email = String.valueOf(scanner.next());
        email += scanner.nextLine();

        System.out.println("Please Enter phone Number");
        try {
            phoneNo = String.valueOf(scanner.nextLong());
        } catch (NumberFormatException e) {
            System.out.println("You have entered 'Phone Number' in wrong Format");
        }
        phoneNo += scanner.nextLine();

        System.out.println("Please Enter your age");

        try {
            age = String.valueOf(scanner.nextInt());
        } catch (NumberFormatException e) {
            System.out.println("You have entered your 'AGE' in wrong Format");
        }
        age += scanner.nextLine();

        Users users = new Users();
        users.setName(name);
        users.setEmail(email);
        users.setPhoneNo(Long.parseLong(phoneNo));
        users.setAge(Integer.parseInt(age));
        return users;


    }

    public void adminLogin(Scanner scanner, HashMap<String, AddMovies> addMoviesHashMap) {

        System.out.println("login as admin Login method");
        String operation;
        String menu = "Welcome To BookMyShow Admin Screen:\n1 Add New Movie Info\n2 Edit Movie Info\n3 Delete Movies\n4 Logout";
        menu(menu);

        while (condition == true) {
            menu(menu);
            operation = scanner.next();

            switch (operation) {
                case "1":
                    System.out.println("you want to add Movie");
                    AddMovies movie = addMovies();

                    addMoviesHashMap.put(movie.getTitle(), movie);
                    break;
                case "2":
                    System.out.println("you want to Edit Movie info");
                    List<Object> list = editMovie(addMoviesHashMap);
                    addMoviesHashMap.remove(list.get(0));
                    AddMovies movie1 = (AddMovies) list.get(1);
                    addMoviesHashMap.put(movie1.getTitle(), movie1);
                    System.out.println(addMoviesHashMap);
                    break;
                case "3":
                    System.out.println("you want to Delete Movie");
                    List<Object> deleteMovie = deleteMovie(addMoviesHashMap);
                    addMoviesHashMap.remove(deleteMovie.get(0));
                    System.out.println(addMoviesHashMap);
                    break;
                case "4":
                    System.out.println("logout you want");
                    System.out.println(addMoviesHashMap);
                    System.exit(0);
                    condition = false;
                    break;
            }

        }

    }

    public void menu(String menu) {
        System.out.println(menu);
    }

    public List<Object> deleteMovie(HashMap map) {
        List<Object> list = new ArrayList<Object>();

        if (!(map.isEmpty())) {
            Set set = map.keySet();

            System.out.println(set);
            Scanner scanner = new Scanner(System.in);
            String title = String.valueOf(scanner.next());
            title += scanner.nextLine();
            list.add(0, title);
        } else {
            System.out.println("No movie is available here to edit");
        }
        return list;

    }

    public String showAllUsers(HashMap map) {

        String title = null;
        if (!(map.isEmpty())) {
            Set set = map.keySet();

            System.out.println("Type user name from below list");
            System.out.println(set);
            Scanner scanner = new Scanner(System.in);
            title = String.valueOf(scanner.next());
            title += scanner.nextLine();
        } else {
            System.out.println("No movie is available here to edit");
        }
        return title;

    }

    public List<Object> editMovie(HashMap map) {
        List<Object> list = new ArrayList<Object>();

        AddMovies editedMovies = null;
        if (!(map.isEmpty())) {
            Set set = map.keySet();

            System.out.println(set);
            Scanner scanner = new Scanner(System.in);
            String title = String.valueOf(scanner.next());
            title += scanner.nextLine();
            list.add(0, title);
            editedMovies = addMovies();

        } else {
            System.out.println("No movie is available here to edit");
        }
        list.add(1, editedMovies);
        return list;

    }

    public AddMovies addMovies() {

        Scanner scanner = new Scanner(System.in);
        AddMovies movie = new AddMovies();

        HashMap<String, AddMovies> addMoviesHashMap = new HashMap<>();

        System.out.println("Enter Movie Title : ");
        movie.setTitle(addMovieProperties(scanner));

        System.out.println("Enter Movie Genre : ");
        movie.setGenre(addMovieProperties(scanner));

        System.out.println("Enter Movie length : ");
        movie.setLength(addMovieProperties(scanner));

        System.out.println("Enter Movie cast : ");
        movie.setCast(addMovieProperties(scanner));

        System.out.println("Enter Movie director : ");
        movie.setDirector(addMovieProperties(scanner));

        System.out.println("Enter Movie adminRating : ");
        movie.setAdminRating(addMovieProperties(scanner));

        System.out.println("Enter Movie language : ");
        movie.setLanguage(addMovieProperties(scanner));

        System.out.println("Enter Movie Interval Time : ");
        movie.setIntervalTime(addMovieProperties(scanner));

        try {
            System.out.println("Enter Movie Start Timings : ");
            movie.setStartTimings(Integer.parseInt(addMovieProperties(scanner)));

            System.out.println("Enter Movie End Timings : ");
            movie.setEndTimings(Integer.parseInt(addMovieProperties(scanner)));

            System.out.println("Enter Movie number Of Shows In a Day : ");
            movie.setNumberOfShowsInDay(Integer.parseInt(addMovieProperties(scanner)));

            System.out.println("Enter Movie First Show : ");
            movie.setFirstShow(Integer.parseInt(addMovieProperties(scanner)));

            System.out.println("Enter Movie Gap Between Shows : ");
            movie.setGapBetweenShows(Integer.parseInt(addMovieProperties(scanner)));

            System.out.println("Enter Movie Capacity in per Show : ");
            movie.setCapacity(Integer.parseInt(addMovieProperties(scanner)));
        } catch (NumberFormatException e) {
            System.out.println("You have Enter value in Wrong Format ");
            System.out.println("Please try again or take a Helps from other to do that ");
        }

        addMoviesHashMap.put("title", movie);
        System.out.println(addMoviesHashMap.get("title"));
        System.out.println("Add movie Successfully");

        return movie;

    }

    public List<AddMovies> addDefaultMovie() {

        List<AddMovies> moviesList = new ArrayList<AddMovies>();

        AddMovies firstMovies = new AddMovies("3Idoits", "Comedy", "1h 45m", "AamirKhan,R Madhawan, Sharman Joshi", "Raju Hirani", "9/10", "Hindi", 8, 10, 3, 8, 30, 30, 50);
        AddMovies secondMovies = new AddMovies("Chhichhore", "Comedy", "1h 45m", "Shushant Shingh,Sharadha Kapoor", "Ram Gopal Verma", "9.5/10", "Hindi", 2, 4, 3, 2, 30, 30, 50);

        moviesList.add(firstMovies);
        moviesList.add(secondMovies);
        return moviesList;
    }

    public String addMovieProperties(Scanner scanner) {
        String capacity = String.valueOf(scanner.next());
        capacity += scanner.nextLine();
        return capacity;

    }

}
