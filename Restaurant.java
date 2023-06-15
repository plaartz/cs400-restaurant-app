/**
 * Restaurant Object that stores data on a restaurant
 * 
 * @author Porter Laartz
 */
public class Restaurant implements IRestaurant {
    private String name;
    private String address;
    private String city;
    private String[] categories;
    private double rating;
    private int reviewCount;

    /**
     * Constructor for restaurant object
     * 
     * @param name        name of the restaurant
     * @param address     street address of the restaurant
     * @param city        city the restaurant is located in
     * @param postalCode  zip code the restaurant is located in
     * @param stars       rating the restaurant has reviewed between 0.0-5.0
     * @param reviewCount number of reviews
     * @param categories  categories of food (Ex. American, Sushi, Steak etc.)
     */
    public Restaurant(String name, String address, String city, int postalCode, double stars, int reviewCount,
            String[] categories) {
        this.name = name;
        this.address = address + ", " + city + ", FL " + postalCode;
        this.city = city;
        this.categories = categories;
        this.rating = stars;
        this.reviewCount = reviewCount;
    }

    /**
     * Gets the name of the restaurant
     * 
     * @return the name of the restaurant
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the rating of the restaurant
     * 
     * @return the rating of the restaurant
     */
    @Override
    public double getRating() {
        return this.rating;
    }

    /**
     * Gets the review count of the restaurant
     * 
     * @return the review count of the restaurant
     */
    @Override
    public int getReviewCount() {
        return this.reviewCount;
    }

    /**
     * Gets the categories of the restaurant
     * 
     * @return the categories of the restaurant in a array of Strings
     */
    @Override
    public String[] getCategories() {
        return this.categories;
    }

    /**
     * Gets the city of the restaurant
     * 
     * @return the city of the restaurant
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     * Gets the address of the restaurant
     * 
     * @return the address of the restaurant
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns a string representation of the restaurant object
     * 
     * @return a string representation of the restaurant containing the name,
     *         address, rating, and review count
     */
    @Override
    public String toString() {
        return this.name + ", " + this.address + ", Rating: " + this.rating + ", Reviews: " + this.reviewCount;
    }

    /**
     * Compares this restaurant instance to another instance (o), compares in the
     * order of rating, reviewCount, name, address
     * 
     * @return -1 if the restaurant is less than o, 1 if the restaurant is greater
     *         than o, 0 if exactly equal
     */
    @Override
    public int compareTo(IRestaurant o) {
        if (this.getRating() > o.getRating()) {
            return 1;
        } else if (this.getRating() < o.getRating()) {
            return -1;
        } else {
            if (this.getReviewCount() > o.getReviewCount()) {
                return 1;
            } else if (this.getReviewCount() < o.getReviewCount()) {
                return -1;
            } else {
                if (this.name.compareTo(o.getName()) == 0) {
                    return this.address.compareTo(o.getAddress());
                } else {
                    return this.name.compareTo(o.getName());
                }
            }
        }
    }

}