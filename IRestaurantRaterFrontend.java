import java.util.List;
public interface IRestaurantRaterFrontend {
    /**
     * runs the command loop for the frontend program
     */
    public void runCommandLoop();

    /**
     * displays main menu for the frontend program
     */
    public void displayMainMenu();

    /**
     * displays restaurants from the red black tree
     *
     * @param books
     */
    public void displayRestaurant(RedBlackTreePH<IRestaurant> restaurants);

    /**
     * looks up name
     */
    public void nameLookup();

    /**
     * looks up cuisines
     */
    public void cuisineSearch();

    public void ratingSearch();
}
