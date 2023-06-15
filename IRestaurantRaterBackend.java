import java.util.List;

 

/**

* Instances of this interface implement the search and filter functionality

* of the Restaurant app using the red black tree.

*/

public interface IRestaurantRaterBackend {

 

    /**

     * Returns the number of restaurants stored in the backend's database.

     * @return the number of restaurants

     */

    public int getNumberOfRestaurants();

 

    /**

     * This method can be used to set a filter for the cuisine types

     * contained in the search results. A book is only returned as

     * a result for a search by title, it is also contains the string

     * filterBy for the type of cuisine.

     * @param filterBy the cuisine of the restaurants we would like to display

     */

    public void setCuisineFilter(String filterBy);

 

    /**

     * Returns the string used as the cuisine filter, null if no cuisine

     * filter is currently set.

     * @return the string used as the cuisine filter, or null if none is set

     */

    public String getCuisineFilter();

    /**

     * Resets the cuisine filter to null (no filter).

     */

    public void resetCuisineFilter();

 

    /**

     * Search through all the restaurants in the title base and return restaurants whose

     * name contains the string word (and that satisfies the cuisine filter,

     * if cuisine filter is set).

     * @param restaurant word that must be contained in a restaurant's name in result set

     * @return list of restaurants found

     */

    public RedBlackTreePH<IRestaurant> searchByWord(String word);

    public void setRatingFilter(double filterBy);

    public double getRatingFilter();

    public void resetRatingFilter();
}
