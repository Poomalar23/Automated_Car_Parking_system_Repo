package CarParking;

import java.util.ArrayList;

import Exceptions.ColourNotFoundException;
import Exceptions.NoEmptySlotAvailable;
import Exceptions.RegistractionNumberNotFoundException;

public class Parking {

	private static Parking parkingLot;
	private static int space;
	private ArrayList<Slots> slotsNo;

	public Parking(int space) {
		
		Parking.space = space;
		this.slotsNo = new ArrayList<>();
	}

	public static Parking getParkingSpace(int i) {
		
		if (parkingLot == null)
			parkingLot = new Parking(space);
		return parkingLot;
	}

	public static void clearAll() {
		parkingLot = null;
	}
/**
 * To create a No Parking Slot Starting at 1 Increasing with Increasing Distance from the Entry Point.
 * @param numberOfSlots
 * @return
 */
	public boolean createParkingSLot(int numberOfSlots) {
		
		if (numberOfSlots>0)
		{
			for (int i = 1; i <= numberOfSlots; i++) {
				slotsNo.add(new Slots(i));
			}
			System.out.println("Created a parking lot with slotsNo : "+numberOfSlots);
			return true;
		}
		else {
			return false;
		}
	}
/**
 * To check whether there are any Empty slot Nearest to the Entry.
 * @return
 * @throws NoEmptySlotAvailable
 */
	private Slots getNextEmptySlotNearestEntry() throws NoEmptySlotAvailable {
		
		for (Slots i : slotsNo) {
			if (!i.isEmpty()) {
				return i;
			}
		}
		throw new NoEmptySlotAvailable("No Empty Slot Available");
	}
/**
 * To Park the Cars in Nearest Empty slot of Parking Space from Entry.
 * @param car
 * @return
 * @throws NoEmptySlotAvailable
 */
	public boolean parkCar(Cars car) throws NoEmptySlotAvailable {
		
		Slots nextEmptySlot = getNextEmptySlotNearestEntry();
		nextEmptySlot.placeCar(car);
		System.out.println("Allocated slot number : "+ nextEmptySlot.getSlotNumber());
		return true;
	}
/**
 * To UnPark Cars from the Parking Space, This Removes the Data of Parked Car Details.
 * @param slotNumber
 * @return
 */
	public int unParkingCar(int slotNumber) {
		
		Slots slot = slotsNo.get(slotNumber - 1);
		if (slot != null) {
			slot.unParkCar();
		}  
		return slotNumber;
	}
/**
 * To Print Details of the Parked Car in Parking Space
 */
	public void printDetails() {
		
		System.out.println("|Slot No.\t|Registration No|\tColour\t|");
		System.out.println("=================================================");
		slotsNo.forEach(slot->{
			if (!slotsNo.isEmpty()) {
				Cars parkCar = slot.getParkCar();
				if (parkCar != null)
					System.out.printf("|\t%d\t|\t%s\t|\t%s\t|\n", slot.getSlotNumber(), parkCar.getCarNumber(), parkCar.getCarColour());
					System.out.println("-------------------------------------------------");
			}
		});
	}
/**
 * get the Details of Car registration Number by Providing Car Colour as input.
 * @param colour
 * @return
 * @throws ColourNotFoundException
 */
	public ArrayList<String> getCarNumbersByColour(String colour) throws ColourNotFoundException  {

		ArrayList<String> carNumbers = new ArrayList<>();

		for (Slots slot : slotsNo) {
			Cars car = slot.getParkCar();
			if (car != null && car.getCarColour().equals(colour)) {
				carNumbers.add(car.getCarNumber());
			}
		}
		if(carNumbers.isEmpty()) {
			throw new ColourNotFoundException ("Car not Found for colour : "+colour);
		}
		return carNumbers;
	}
/**
 * To Get the Details of Parking Slot Number providing Car Colour as Input.
 * @param colour
 * @return
 * @throws ColourNotFoundException
 */
	public ArrayList<Integer> getSlotNumbersByColor(String colour) throws ColourNotFoundException {
		
		ArrayList<Integer> slotnumber = new ArrayList<>();

		for (Slots slot : slotsNo) {
			Cars car = slot.getParkCar();
			if (car != null && car.getCarColour().equals(colour)) {
				slotnumber.add(slot.getSlotNumber());
			}
		}
		if(slotnumber.isEmpty()) {
			throw new ColourNotFoundException ("Car not Found for colour : "+colour);
		}
		return slotnumber;
	}
/**
 * To Get the Parking Slot Number Detail of the Particular Car with input Provided as CarNumber. 
 * @param carNumber
 * @return
 * @throws RegistractionNumberNotFoundException
 */
	public ArrayList<Integer> getSlotNumberByCarNumber(String carNumber) throws RegistractionNumberNotFoundException {
		
		ArrayList<Integer> slotnumber = new ArrayList<>();

		for (Slots slot : slotsNo) {
			Cars car = slot.getParkCar();
			if (car != null && car.getCarNumber().equals(carNumber)) {
				slotnumber.add(slot.getSlotNumber());
			}
		}
		if(slotnumber.isEmpty()) {

			throw new RegistractionNumberNotFoundException("Car not Found for number : "+carNumber);
		}
		return slotnumber;
	}

}