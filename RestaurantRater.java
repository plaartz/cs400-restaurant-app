import java.util.Scanner;

public class RestaurantRater {

	public static void main(String[] args) {
		IRestaurantRaterFrontend frontend = new RestaurantRaterFrontend(new Scanner(System.in),new RestaurantRaterBackend());
		frontend.runCommandLoop();
	}

}

