import java.io.FileNotFoundException;

public interface IRestaurantLoader {
    RedBlackTreePH<IRestaurant> loadRestaurants(String filePath) throws FileNotFoundException;
}
