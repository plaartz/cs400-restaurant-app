import java.io.FileNotFoundException;
import java.util.List;

public class RestaurantRaterBackend implements IRestaurantRaterBackend {
	
	private RedBlackTreePH<IRestaurant> list;
	private String cuisineFilter;
	private double ratingFilter;
	
	public RestaurantRaterBackend() {
		RestaurantLoader loader = new RestaurantLoader();
		this.cuisineFilter = "";
		this.ratingFilter = 0.0;
		try {
			this.list = loader.loadRestaurants("restaurantData.xml");
		} catch (FileNotFoundException e) {
			this.list = new RedBlackTreePH<IRestaurant>();
		}
	}
	

	@Override
	public int getNumberOfRestaurants() {
		return this.list.size();
	}

	@Override
	public void setCuisineFilter(String filterBy) {
		if (filterBy==null || filterBy.trim().length()==0) {
			resetCuisineFilter();
			return;
		}
		this.cuisineFilter = filterBy;
		
	}

	@Override
	public String getCuisineFilter() {
		return this.cuisineFilter;
	}

	@Override
	public void resetCuisineFilter() {
		this.cuisineFilter = "";
		
	}
	
	@Override
	public void setRatingFilter(double filterBy) {
		if (filterBy<=0.0) {
			this.resetRatingFilter();
			return;
		}
		this.ratingFilter = filterBy;
		
	}
	
	@Override
	public double getRatingFilter() {
		return this.ratingFilter;
	}

	@Override	
	public void resetRatingFilter() {
		this.ratingFilter = 0.0;
	}

	@Override
	public RedBlackTreePH<IRestaurant> searchByWord(String word) {
		RedBlackTreePH<IRestaurant> tempList = new RedBlackTreePH<IRestaurant>();
		
		for (IRestaurant restaurant: this.list) {
			if (restaurant.getName().toLowerCase().contains(word.toLowerCase()))  {
				
				if (restaurant.getRating()>=this.ratingFilter) {
					
					for (String cuisine: restaurant.getCategories()) {
						if (cuisine.toLowerCase().equals(this.cuisineFilter.toLowerCase())) {
							tempList.insert(restaurant);
						}
					}
				}
			}
		}
		return tempList;
	}

}

