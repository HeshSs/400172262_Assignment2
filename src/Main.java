import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String operation;

        HashMap<String, CarModel> carModels = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        List<Integer> refills = new ArrayList<>();
        HashMap<Integer, Boolean> tripResults = new HashMap<>();


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
                double distance = Double.parseDouble(scanner.next());

                for (Car car : cars) {

                    if (car.getPlateNumber() == plateNumber) {
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

        } while (! operation.equals("FINISH"));
    }
}
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
Test case2

MODEL X5 10 68
CAR X5 787878
TRIP 787878 500
TRIP 787878 500
TRIP 787878 10
REFILL 787878
TRIP 787878 500
FINISH


            currentGasLevel = 0;
        */