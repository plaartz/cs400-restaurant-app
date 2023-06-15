import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Restaurant Loader class that allows for parsing of restaurant data from an
 * xml file and stores it into a balanced tree
 * 
 * @author Porter Laartz
 */
public class RestaurantLoader implements IRestaurantLoader {
    protected RedBlackTreePH<IRestaurant> list;

    /**
     * Constructor of RestaurantLoader
     */
    public RestaurantLoader() {
        this.list = new RedBlackTreePH<>();
    }

    /**
     * Parses a xml file and creates a balanced list containing Restaurant objects.
     * Each parameter of restaurant is gotten by finding the text between the first
     * > and last <
     * 
     * @param filePath location of the xml file to parse
     * @return a balanced tree containing IRestaurant Objects
     */
    @Override
    public RedBlackTreePH<IRestaurant> loadRestaurants(String filePath) throws FileNotFoundException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath), "UTF-8");
            scanner.nextLine();
            scanner.nextLine();
            scanner.useDelimiter("</restaurant>");
            while (scanner.hasNext()) {
                String[] current = scanner.next().trim().split("\n");
                if (current.length < 9) {
                    continue;
                }
                // String ID = current[1].substring(current[1].indexOf('>') + 1, cu
                // rent[1].lastIndexOf('<'));
                String name = current[2].substring(current[2].indexOf('>') + 1, current[2].lastIndexOf('<'));
                String address = current[3].substring(current[3].indexOf('>') + 1, current[3].lastIndexOf('<'));
                String city = current[4].substring(current[4].indexOf('>') + 1, current[4].lastIndexOf('<'));
                // String STATE = current[5].substring(current[5].indexOf('>') + 1,
                // current[5].lastIndexOf('<'));
                String zip = current[6].substring(current[6].indexOf('>') + 1, current[6].lastIndexOf('<'));
                double stars = Double
                        .parseDouble(current[7].substring(current[7].indexOf('>') + 1, current[7].lastIndexOf('<')));
                int reviewCount = Integer
                        .parseInt(current[8].substring(current[8].indexOf('>') + 1, current[8].lastIndexOf('<')));
                String[] categories = current[9].substring(current[9].indexOf('>') + 1, current[9].lastIndexOf('<'))
                        .split(", ");
                try {
                    this.list
                            .insert(new Restaurant(name, address, city, Integer.parseInt(zip), stars, reviewCount,
                                    categories));
                } catch (IllegalArgumentException error) {
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(filePath + " not a valid file path");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return this.list;
    }

    /**
     * Returns the tree containing restaurant objects
     * 
     * @return a balanced tree containing all restaurant objects
     */
    public RedBlackTreePH<IRestaurant> getList() {
        return this.list;
    }

}
