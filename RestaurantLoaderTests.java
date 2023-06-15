import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

/**
 * Test class for the functionality of Restaurant.java and RestaurantLoader.java
 */
public class RestaurantLoaderTests {
    private RestaurantLoader _loadInstance;
    private Restaurant _restaurantInstance;

    @BeforeEach
    public void createInstance() {
        _loadInstance = new RestaurantLoader();
        _restaurantInstance = new Restaurant("name", "address", "city", 53706, 5.0, 123,
                new String[] { "American,Sushi" });
    }

    /**
     * Tests the functionality of Restaurant.java methods getName(), getRating(),
     * and getReviewCount()
     */
    @Test
    public void roleTest1() {
        assertEquals(_restaurantInstance.getName(), "name");
        assertEquals(_restaurantInstance.getRating(), 5.0);
        assertEquals(_restaurantInstance.getReviewCount(), 123);
    }

    /**
     * Tests the functionality of Restaurant.java method getAddress
     */
    @Test
    public void roleTest2() {
        assertEquals(_restaurantInstance.getAddress(), "address, city, FL 53706");
    }

    /**
     * Tests the functionality of Restaurant.java toString representation
     */
    @Test
    public void roleTest3() {
        assertEquals(_restaurantInstance.toString(), "name, address, city, FL 53706, Rating: 5.0, Reviews: 123");
    }

    /**
     * Tests the functionality of trying to load in a xml that doesn't exist
     */
    @Test
    public void roleTest4() {
        try {
            _loadInstance.loadRestaurants("gibberish.xml");
        } catch (FileNotFoundException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    /**
     * Tests the functionality of loading in a xml
     */
    @Test
    public void roleTest5() {
        try {
            _loadInstance.loadRestaurants("restaurantData.xml");
        } catch (Exception e) {
        }
        assertEquals(_loadInstance.getList().size, 5762);
    }

    /**
     * Tests toString() when iterating through tree
     */
    @Test
    public void integrationTest1() {
        RedBlackTreePH<IRestaurant> tree = new RedBlackTreePH<>();
        tree.insert(new Restaurant("name", "address", "city", 53706,
                5.0, 123, new String[] { "American,Sushi" }));
        tree.insert(new Restaurant("name2", "address2", "city2", 53707,
                5.0, 123, new String[] { "American,Mexican" }));
        String output = "";
        String expectedOutput = "name, address, city, FL 53706, Rating: 5.0, Reviews: 123\n" +
                "name2, address2, city2, FL 53707, Rating: 5.0, Reviews: 123";
        for (IRestaurant restaurant : tree) {
            output += restaurant + "\n";
        }
        assertEquals(output, expectedOutput);
    }

    /**
     * Tests that getName() works when iterating through tree of restaurants
     */
    @Test
    public void integrationTest2() {
        RedBlackTreePH<IRestaurant> tree = new RedBlackTreePH<>();
        tree.insert(new Restaurant("name", "address", "city", 53706,
                5.0, 123, new String[] { "American,Sushi" }));
        tree.insert(new Restaurant("name2", "address2", "city2", 53707,
                5.0, 123, new String[] { "American,Mexican" }));
        String output = "";
        String expectedOutput = "name\nname2";
        for (IRestaurant restaurant : tree) {
            output += restaurant.getName() + "\n";
        }
        assertEquals(output, expectedOutput);
    }

    /**
     * Tests that setting and getting filters of backend works
     */
    @Test
    public void CodeReviewOfBackendTest1() {
        IRestaurantRaterBackend backend = new RestaurantRaterBackend();
        assertEquals(backend.getCuisineFilter(),"");
        assertEquals(backend.getRatingFilter(),0.0);
        backend.setCuisineFilter("American");
        backend.setRatingFilter(3.0);
        assertEquals(backend.getCuisineFilter(),"American");
        assertEquals(backend.getRatingFilter(),3.0);
    }

    /**
     * Tests that getNumberOfRestaurants() method works as expected. Also tests that searchByWord works as expected.
     */
    @Test
    public void CodeReviewOfBackendTest2() {
        IRestaurantRaterBackend backend = new RestaurantRaterBackend();
        assertEquals(backend.getNumberOfRestaurants(),5762);

        RedBlackTreePH<IRestaurant> tree = backend.searchByWord("Alessi Bakery");
        assertEquals(tree.root.data.getName(),"Alessi Bakery");
    }
}
