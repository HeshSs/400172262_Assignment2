import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String operation = "";

        HashMap<String, CarModel> carModels = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        HashMap<Integer, Float> trips = new HashMap<>();
        List<Integer> refills = new ArrayList<>();
        HashMap<Integer, Boolean> tripResults = new HashMap<>();


        do {
            operation = scanner.next();
            if (operation.equals("FINISH")) {
                System.out.println();
                break;
            } else if (operation.equals("MODEL")) {

                String modelName = scanner.next();
                float fuelEconomy = Float.parseFloat(scanner.next());
                float gasTankSize = Float.parseFloat(scanner.next());
                carModels.put(modelName, new CarModel(modelName, fuelEconomy, gasTankSize));

            } else if (operation.equals("CAR")) {

                String model = scanner.next();
                int plateNumber = Integer.parseInt(scanner.next());
                cars.add(new Car(carModels.get(model), plateNumber));

            } else if (operation.equals("TRIP")) {

                int plateNumber = Integer.parseInt(scanner.next());
                int distance = Integer.parseInt(scanner.next());

                for (Car car : cars) {

                    if (car.getPlateNumber() == plateNumber) {
                        tripResults.put(plateNumber, car.trip(distance));
                        if (car.trip(distance)) {
                            System.out.println("Trip completed successfully for #" + plateNumber);
                        } else {
                            System.out.println("Not enough fuel for #" + plateNumber);
                        }
                    }
                }
            } else if (operation.equals("REFILL")) {

                int plateNum = Integer.parseInt(scanner.next());

                for (Car car : cars) {

                    if (car.getPlateNumber() == plateNum) {
                        car.refill();
                    }

                }

            } else {
                System.out.println("The Code is not working as it's supposed to be");
            }

        } while (!operation.equals("FINISH"));

    }
}
/*
        final int numTrips = tripResults.size();

        Set<Integer> plateNumbers = new HashSet<>();
        plateNumbers = tripResults.keySet();

        Set<Boolean> results = new HashSet<>();
        results = (Set<Boolean>) tripResults.values();

        //boolean everybodyStillHasFuel = true;
        for (int j = 0; j < numTrips; j++) {
            if () {
                System.out.println("Trip completed successfully for #" + mapElement.getKey());
            } else {
                System.out.println("Not enough fuel for #" + mapElement.getKey());
                //everybodyStillHasFuel = false;
            }
        }

        // Creating two different car models
        CarModel model1 = new CarModel("Camry", 6.5, 58);
        CarModel model2 = new CarModel("Civic", 7.5, 52);

        // For this particular example, we have only 4 cars.
        final int numCars = 4;
        Car[] cars = new Car[numCars];
        cars[0] = new Car(model1, 1111);
        cars[1] = new Car(model1, 2222);
        cars[2] = new Car(model2, 3333);
        cars[3] = new Car(model2, 4444);

 */

       /* In this example, all the cars go on the same
        trips. In particular, they all go on trips of
        length 350kms until one of them runs out of fuel.
         */
       /*
Test Case1

MODEL Camry 6.5 58
MODEL Civic 7.5 52
CAR Camry 1111
CAR Camry 2222
CAR Civic 3333
CAR Civic 4444
TRIP 1111 350
TRIP 2222 350
TRIP 3333 350
TRIP 4444 350
TRIP 1111 350
TRIP 2222 350
TRIP 3333 350
TRIP 4444 350
FINISH

----

MODEL X5 10 68
CAR X5 787878
TRIP 787878 500
TRIP 787878 500
TRIP 787878 10
REFILL 787878
TRIP 787878 500
FINISH
        */