import java.util.Scanner;

public class RestaurantRaterFrontend implements IRestaurantRaterFrontend {
    private Scanner scnr;
    private IRestaurantRaterBackend backend;

    public RestaurantRaterFrontend(Scanner scnr, IRestaurantRaterBackend backend) {
        this.scnr = scnr;
        this.backend = backend;
    }

    @Override
    public void runCommandLoop() {
        System.out.println("Welcome to the Restaurant Rater Application!");
        System.out.println("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x");
        System.out.println();
        displayMainMenu();

    }

    @Override
    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");
        System.out.println("\t1) Lookup Name ");
        System.out.println("\t2) Cuisine Filter");
        System.out.println("\t3) Rating Filter");
        System.out.println("\t4) Exit Application");
        try {
            int input = scnr.nextInt();
            scnr.nextLine();
            if (input == 1) {
                nameLookup();
                displayMainMenu();
            } else if (input == 2) {
                cuisineSearch();
                displayMainMenu();
            } else if (input == 3) {
                ratingSearch();
                displayMainMenu();
            } else if (input == 4) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid input! Please enter either 1, 2, 3, or 4");
                displayMainMenu();
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter either 1, 2, 3, or 4");
            displayMainMenu();
        }

    }

    @Override
    public void displayRestaurant(RedBlackTreePH<IRestaurant> restaurants) {
        int i=1;
        if (restaurants == null || restaurants.size==0) {
            System.out.println("0 Matches");
        }
        System.out.println("Matches: " + restaurants.size() + " of " + backend.getNumberOfRestaurants());
        // Needs AE implementation
        // for (IRestaurant restaurant: restaurants) {
        //     System.out.println(i++);
        //     //System.out.println(i++ + ". " + restaurant.getName() + "\n");
        // }
        System.out.println("Results...\n"); // Remove on merge to main
        System.out.println("Matches: " + restaurants.size() + " of " + backend.getNumberOfRestaurants());

    }

    @Override
    public void nameLookup() {
        System.out.println("You are in the Lookup Name Menu:");
        System.out.print("\t(Rating Filter: " + backend.getRatingFilter() + " stars, ");
        System.out.println(
                "Cuisine Filter: " + (backend.getCuisineFilter().isEmpty() ? "none" : backend.getCuisineFilter()) + ")");
        System.out.print("\tEnter Restaurant Name to lookup: ");
        String name = "";
        name = scnr.nextLine();
        System.out.println(name);
        
        
        RedBlackTreePH<IRestaurant> results = backend.searchByWord(name.trim());
        displayRestaurant(results);

    }

    @Override
    public void cuisineSearch() {
        System.out.println("You are in the Set Cuisine Filter Menu:");
        System.out.println("\tCuisine Filter currently set to: "
                + (backend.getCuisineFilter().isEmpty() ? "none" : backend.getCuisineFilter()));
        System.out.print("\tEnter Cuisine Type: ");
        try {
            String filter = scnr.nextLine();
            if (filter == null || filter.trim().length() == 0) {
                backend.resetCuisineFilter();
            } else {
                backend.setCuisineFilter(filter.trim());
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            cuisineSearch();
        }

    }

    @Override
    public void ratingSearch() {
        System.out.println("You are in the Set Rating Filter Menu:");
        System.out.println("\tRating must currently be at least " + backend.getRatingFilter() + " stars");
        System.out.print("\tEnter Minimum Rating: ");

        try {
            double rating = scnr.nextDouble();
            if (rating<=0.0) {
                backend.setRatingFilter(0.0);
            } else if (rating>5.0) {
                backend.setRatingFilter(5.0);
            } else {
                backend.setRatingFilter(rating);
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            ratingSearch();
        }
    }

    public static void main(String[] args) {
        IRestaurantRaterFrontend frontend = new RestaurantRaterFrontend(new Scanner(System.in),
                new RestaurantRaterBackend());
        frontend.runCommandLoop();
    }

}