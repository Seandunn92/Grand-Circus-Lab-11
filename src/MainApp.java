import java.util.*;

/**
 * Created by seandunn92 on 4/20/17.
 */
public class MainApp {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        ArrayList<Car> carLot = new ArrayList<>();
        carLot.add( new Car("Ford", "Explorer", 1999, 25000.99));
        carLot.add(new UsedCar("Jeep", "Terabad", 1972, 300, 225000));
        carLot.add( new Car("Honda", "Fit", 2017, 18000));
        carLot.add(new UsedCar("Honda", "Accord", 2011, 5500, 111000));
        carLot.add( new Car("Toyata", "Camry", 2017, 15000));
        carLot.add(new UsedCar("Pontiac", "Bonneville", 1972, 300, 225000));


//        for(Car c: carLot){
//            System.out.println(c);
//            if(c instanceof UsedCar){
//                System.out.println(c + " Used Car");
//            }else{
//                System.out.println(c + " New Car");
//            }
//        }

        CarLot ourLot = new CarLot(carLot);
        ourLot.listAllCars();
        ourLot.replaceCar(1, new Car("gungan", "force", 1733, 2000));
        ourLot.listAllCars();
        int userInt=-1;
        System.out.println("Welcome to the Grand Circus Car Lot");

        do{
            System.out.println("What would you like to do: \n 1: Look at the List of all Cars \n 2: Add a Car" +
                    "\n 3: Remove a Car \n 4: Look up a Car \n 5: Replace a Car \n Any other key to quit");

            try {
                userInt = scan.nextInt();
            }catch(Exception e){
                userInt =-1;
            }
            scan.nextLine();
            switch(userInt){
                case 1: printLot(ourLot); break;
                case 2: addCar(ourLot); break;
                case 3: removeCar(ourLot); break;
                case 4: lookUpCar(ourLot); break;
                case 5: replaceCar(ourLot);break;

                default: userInt=-1;
            }
        }while (userInt>0);
    }

    private static void printLot(CarLot ourLot) {
        ourLot.listAllCars();
    }
    private static void addCar(CarLot ourLot){
       Car newCar =getNewCar();
       ourLot.addCar(newCar);

    }
    private static void removeCar(CarLot ourLot){
        System.out.println("Enter in the carNumber you want to delete");
        ourLot.removeCar(scan.nextInt()-1);
    }
    private static void lookUpCar(CarLot ourLot){
        System.out.println("Enter in the carNumber you want to look at");
        System.out.println(ourLot.findCar(scan.nextInt()-1));
    }
    private static void replaceCar(CarLot ourLot){
        Car replacement = getNewCar();
        System.out.println("Enter in the carNumber you want to replace");
        ourLot.replaceCar(scan.nextInt(), replacement);

    }
    private static Car getNewCar(){
        String make;
        String model;
        int year;
        double price;
        double mileage;


        System.out.println("Enter in the Cars make");
        make = scan.nextLine();
        System.out.println("Enter in the car's model");
        model=scan.nextLine();
        System.out.println("Enter in the car's year");
        year = scan.nextInt();
        System.out.println("Enter in the car's price");
        price = scan.nextDouble();
        System.out.println("If the car is used enter in the mileage, otherwise enter in some text");

        try{
            mileage=scan.nextDouble();
            return (new UsedCar(make,model, year, price, mileage ));
        }catch(Exception e){
            scan.nextLine();
            return (new Car(make, model, year, price));
        }
    }

}
