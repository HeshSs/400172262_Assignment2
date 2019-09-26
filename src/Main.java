import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String operation = "";

        HashMap<String, CarModel> carModels = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        HashMap<Integer, Float> trips = new HashMap<>();
        List<Integer> refills = new ArrayList<>();



        do {
            operation = scanner.next();
            if (operation.equals("FINISH")) {
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

            } else if (operation.equals("REFILL")) {

                int plateNumber = Integer.parseInt(scanner.next());

            }

        } while (true);


/*
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
        boolean[] tripResults = new boolean[4];
        boolean everybodyStillHasFuel = true;
        while(everybodyStillHasFuel) {
            for (int j = 0; j < numCars; j++) {
                tripResults[j] = cars[j].trip(350);
                if (tripResults[j]) {
                    System.out.println("Trip completed successfully for #" + cars[j].getPlateNumber());
                } else {
                    System.out.println("Not enough fuel for #" + cars[j].getPlateNumber());
                    everybodyStillHasFuel = false;
                }
            }
        }
    }
}
