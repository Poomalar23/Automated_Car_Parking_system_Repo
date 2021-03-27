package CarParking;

import Exceptions.ColourNotFoundException;
import Exceptions.NoEmptySlotAvailable;
import Exceptions.RegistractionNumberNotFoundException;
import Interface.CommandInterface;

public enum Command implements CommandInterface {
	parking_slot {
		public void runCommand(String[] details) {
			Parking.getParkingSpace(1).createParkingSLot(Integer.parseInt(details[1]));
		}
	},
	park_car {
		public void runCommand(String[] details) {
			try {
				Parking.getParkingSpace(1).parkCar(new Cars(details[1], details[2]));
			} catch (NoEmptySlotAvailable noEmptySlotAvailable) {
				System.out.println(noEmptySlotAvailable.getMessage());
			}
		}
	},
	unPark_Car {
		public void runCommand(String[] details) {
			try {
				int slotNumber = Parking.getParkingSpace(1).unParkingCar(Integer.parseInt(details[1]));
				System.out.printf("Slot number %d is free \n", slotNumber);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	},
	details_of_the_car_parking {
		public void runCommand(String[] details) {
			Parking.getParkingSpace(1).printDetails();

		}
	},
	registration_numbers_for_cars_with_colour {
		public void runCommand(String[] details) {
			try {
				Parking.getParkingSpace(1).getCarNumbersByColour(details[1]).forEach(carNumber->{
					System.out.print(carNumber + ", ");
				});
			} catch (ColourNotFoundException e) {
				System.out.println(e.getMessage());

			}
			System.out.println();
		}
	},
	slot_numbers_for_cars_with_colour {
		public void runCommand(String[] details) {
			try {
				Parking.getParkingSpace(1).getSlotNumbersByColor(details[1]).forEach(num->System.out.print(num + ","));
			} catch (ColourNotFoundException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}
	},
	slot_number_for_registration_number {
		public void runCommand(String[] details) {
			try {
				System.out.println(Parking.getParkingSpace(1).getSlotNumberByCarNumber(details[1]));
			} catch (RegistractionNumberNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	},
	exit() {
		public void runCommand(String[] details) {

		}
	}; 
}
