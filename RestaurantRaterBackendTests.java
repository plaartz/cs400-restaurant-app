import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantRaterBackendTests {

        /*
         * This test ensures the size of the loaded RBTree is accurate
         */
	@Test
    public void roleTest1() {
            RestaurantRaterBackend backend = new RestaurantRaterBackend();
            assertEquals(backend.getNumberOfRestaurants(), 5762);
    }

    /*
     * This test will ensure the rating set by user is accurate and desired
     */
    @Test
    public void roleTest2() {
            RestaurantRaterBackend backend = new RestaurantRaterBackend();
            backend.setRatingFilter(2.5);
            assertEquals(backend.getRatingFilter(),2.5);

    }

    /*
     * This test will ensure rating is set to 0.0
     */
    @Test
    public void roleTest3() {
            RestaurantRaterBackend backend = new RestaurantRaterBackend();
            backend.resetRatingFilter();
            assertEquals(backend.getRatingFilter(),0.0);
    }

    /*
     * This test will ensure the cuisine set by user is accurate and desired
     */
    @Test
    public void roleTest4() {
            RestaurantRaterBackend backend = new RestaurantRaterBackend();
            backend.setCuisineFilter("mexican");
            assertEquals(backend.getCuisineFilter(), "mexican");
    }

    /*
     * This test will ensure the cuistine filter is set to ""
     */
    @Test
    public void roleTest5() {
            RestaurantRaterBackend backend = new RestaurantRaterBackend();
            backend.resetCuisineFilter();
            assertEquals(backend.getCuisineFilter(), "");
    }
        
        @Test
        public void integrationTest1() {
        	RestaurantRaterBackend backend = new RestaurantRaterBackend();
        	RedBlackTreePH<IRestaurant> tree = backend.searchByWord(null);
        	assertEquals(tree.size(),5762);
        }
        
        @Test
        public void integrationTest2() {
        	RestaurantRaterBackend backend = new RestaurantRaterBackend();
        	RedBlackTreePH<IRestaurant> tree = backend.searchByWord("Alessi");
        	assertEquals(tree.size(),1);
        }
        
        @Test
        public void CodeReviewOfDataWranglerTest1() {
        	IRestaurantLoader loader = new RestaurantLoader();
        	try {
        		loader.loadRestaurants("asdf.xml");
        	} catch (Exception e) {
        		assertTrue(true);
        		return;
		}
        	assertTrue(false);
        	
        }
        
        @Test
        public void CodeReviewOfDataWranglerTest2() {
        	IRestaurantLoader loader = new RestaurantLoader();
        	try {
		RedBlackTreePH<IRestaurant> tree = loader.loadRestaurants("restaurantData.xml");
		assertEquals(tree.size(),5762);
		} catch(Exception e){
			assertTrue(false);
		}
        }

}
