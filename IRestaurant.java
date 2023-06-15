public interface IRestaurant extends Comparable<IRestaurant>{
    String getName();

    double getRating();

    int getReviewCount();

    String getCity();

    String getAddress();

    String[] getCategories();

}
