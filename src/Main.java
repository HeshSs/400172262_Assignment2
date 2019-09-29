import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operation;

        HashMap<String, CarModel> carModels = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        List<Integer> successfulTripsPlateNumbers = new ArrayList<>();
        List<Integer> successfulTripsDistance = new ArrayList<>();

        List<String> tripPrintList = new ArrayList<>();
        ArrayList<String> longTripsPrintList = new ArrayList<>();

        label:
        do {
            operation = scanner.next();

            switch (operation) {
                case "MODEL":

                    String modelName = scanner.next();
                    float fuelEconomy = Float.parseFloat(scanner.next());
                    float gasTankSize = Float.parseFloat(scanner.next());
                    carModels.put(modelName, new CarModel(modelName, fuelEconomy, gasTankSize));

                    break;
                case "CAR": {

                    String model = scanner.next();
                    int plateNumber = Integer.parseInt(scanner.next());
                    cars.add(new Car(carModels.get(model), plateNumber));

                    break;
                }
                case "TRIP": {

                    int plateNumber = Integer.parseInt(scanner.next());
                    double distance = Double.parseDouble(scanner.next());

                    for (Car car : cars) {

                        if (car.getPlateNumber() == plateNumber) {
                            if (car.trip(distance)) {

                                successfulTripsPlateNumbers.add(plateNumber);
                                successfulTripsDistance.add((int) distance);

                                tripPrintList.add("Trip completed successfully for #" + plateNumber);
                                System.out.println("Trip completed successfully for #" + plateNumber);
                            } else {
                                tripPrintList.add("Not enough fuel for #" + plateNumber);
                                System.out.println("Not enough fuel for #" + plateNumber);
                            }
                        }
                    }
                    break;
                }
                case "LONGTRIPS": {

                    int plateNumber = Integer.parseInt(scanner.next());
                    double longerDistanceThan = Double.parseDouble(scanner.next());
                    int counter = 0;

                    for (int i = 0; i < successfulTripsPlateNumbers.size(); i++) {
                        if (successfulTripsPlateNumbers.get(i) == plateNumber && successfulTripsDistance.get(i) > longerDistanceThan) {
                            counter++;
                        }
                    }

                    longTripsPrintList.add("#" + plateNumber + " made " + counter + " trips longer than " + (int) longerDistanceThan);
                    System.out.println("#" + plateNumber + " made " + counter + " trips longer than " + (int) longerDistanceThan);

                    break;
                }
                case "REFILL":

                    int plateNum = Integer.parseInt(scanner.next());

                    for (Car car : cars) {
                        if (car.getPlateNumber() == plateNum) {
                            car.refill();
                        }
                    }

                    break;
                default:
                    break label;
            }
        } while (!operation.equals("FINISH"));

        /*
        for (String line : tripPrintList) {
            System.out.println(line);
        }

        for (String line : longTripsPrintList) {
            System.out.println(line);
        }

         */
    }
}