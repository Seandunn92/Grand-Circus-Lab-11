import java.util.ArrayList;

/**
 * Created by seandunn92 on 4/21/17.
 */
public class CarLot
{
   private ArrayList<Car> carsInLot;

   public CarLot(ArrayList<Car> carsInLot){
       this.carsInLot=carsInLot;
   }

   public void listAllCars(){
       for(int i=0; i<carsInLot.size(); i++){
           System.out.println("Car "  + (i+1) + ": " +carsInLot.get(i));
           System.out.println();
       }
   }

   public void removeCar(int carIndex){
       carsInLot.remove(carIndex);
   }
   public void replaceCar(int index,Car replacement){

       carsInLot.remove(index);
      carsInLot.add(index, replacement);

       }
   public void addCar(Car addCar){
       carsInLot.add(addCar);
   }
   public Car findCar(int carIndex){
       return carsInLot.get(carIndex);
   }
}
