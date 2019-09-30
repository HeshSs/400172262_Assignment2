import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner Object to ask for input from the user
        String operation;

        HashMap<String, CarModel> carModels = new HashMap<>();  // A HashMap that saves all the CarModels inputted by the user
        List<Car> cars = new ArrayList<>();     // A List that saves all the Cars that the user inputs

        List<Integer> successfulTripsPlateNumbers = new ArrayList<>();  // A List that saves the plateNumbers of the cars that successfully made a trip
        List<Integer> successfulTripsDistance = new ArrayList<>();  // A List that saves the Distance travelled by the cars that successfully made a trip

        label:
        do {
            operation = scanner.next();

            switch (operation) {
                case "MODEL":   // If the input starts with MODEL do this:

                    String modelName = scanner.next();  // Asks for modelName as the 1st argument
                    float fuelEconomy = Float.parseFloat(scanner.next());   // Asks for fuelEconomy as the 2nd argument
                    float gasTankSize = Float.parseFloat(scanner.next());   // Asks for gasTankSize as the 3rd argument
                    carModels.put(modelName, new CarModel(modelName, fuelEconomy, gasTankSize));    // Adds the new CarModel to the carModels HashMap

                    break;
                case "CAR": {   // If the input starts with CAR do this:

                    String model = scanner.next();  // Asks for model as the 1st argument
                    int plateNumber = Integer.parseInt(scanner.next());     // Asks for plateNumber as the 2nd argument
                    cars.add(new Car(carModels.get(model), plateNumber));   // Adds the new Car to the cars List

                    break;
                }
                case "TRIP": {  // If the input starts with TRIP do this:

                    int plateNumber = Integer.parseInt(scanner.next());     // Asks for plateNumber as the 1st argument
                    double distance = Double.parseDouble(scanner.next());   // Asks for distance as the 2nd argument

                    for (Car car : cars) {      //for every car in the List cars

                        if (car.getPlateNumber() == plateNumber) {
                            if (car.trip(distance)) {

                                successfulTripsPlateNumbers.add(plateNumber);   // Adds the plateNumber to the List of successful trips (plate number)
                                successfulTripsDistance.add((int) distance);    // Adds the distance to the List of successful trips (distance)

                                System.out.println("Trip completed successfully for #" + plateNumber);  // Prints the trip was successful for the car with the plate#

                            } else {
                                System.out.println("Not enough fuel for #" + plateNumber);  //  Prints the trip wasn't successful for the car with plate#
                            }
                        }
                    }
                    break;
                }
                case "LONGTRIPS": {     // If the input starts with LONGTRIPS do this:

                    int plateNumber = Integer.parseInt(scanner.next());     // Asks for plateNumber as the 1st argument
                    double longerDistanceThan = Double.parseDouble(scanner.next());     // Asks for longerDistanceThan as the 2nd argument
                    int counter = 0;    // keeps the number of successful trips made with a distance longer than (longerDistanceThan)

                    for (int i = 0; i < successfulTripsPlateNumbers.size(); i++) {
                        if (successfulTripsPlateNumbers.get(i) == plateNumber && successfulTripsDistance.get(i) > longerDistanceThan) {
                            counter++;  // Increments the counter by one if the trip was successful and the distance was longer than specified
                        }
                    }

                    // Prints the number of successful trips made by the car with plate# and longer than the specified distance
                    System.out.println("#" + plateNumber + " made " + counter + " trips longer than " + (int) longerDistanceThan);


                    break;
                }
                case "REFILL":  // If the input starts with REFILL do this:

                    int plateNum = Integer.parseInt(scanner.next());    // Asks for plateNum as the 1st argument

                    for (Car car : cars) {
                        if (car.getPlateNumber() == plateNum) {
                            car.refill();   // Refills the car's gasTank for the specified plate#
                        }
                    }

                    break;
                default:
                    break label;
            }
        } while (!operation.equals("FINISH")); //If the Input says "FINISH" stop asking for inputs and end the do-while loop

    }
}