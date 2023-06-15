run: RestaurantRater.class
	java RestaurantRater

RestaurantRater.class: RestaurantRater.java
	javac RestaurantRater.java

runTests: runDataWranglerTests runBackendTests

runDataWranglerTests: RestaurantLoaderTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=RestaurantLoaderTests


RestaurantLoaderTests.class: RestaurantLoaderTests.java
	javac -cp .:junit5.jar RestaurantLoaderTests.java

clean: 
	rm *.class
runBackendTests: RestaurantRaterBackendTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=RestaurantRaterBackendTests
RestaurantRaterBackendTests.class: RestaurantRaterBackendTests.java
	javac -cp .:junit5.jar RestaurantRaterBackendTests.java

