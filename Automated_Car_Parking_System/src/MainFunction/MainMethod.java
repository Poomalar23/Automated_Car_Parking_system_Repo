package MainFunction;

import java.io.IOException;
import java.util.Scanner;
import CarParking.Command;

/**
 * 
 * @author poomalark
 *
 */
public class MainMethod {
	
	public static void main(String[] args) throws IOException{

		System.out.println("*********************************** INPUT COMMANDS FOR PARKING***********************************");
		System.out.println("1. parking_slot {Slot Capacity}");
		System.out.println("2. park_car {Car Nmuber} {Car Color}");
		System.out.println("3. unPark_Car {Slot Number}");
		System.out.println("4. details_of_the_car_parking");
		System.out.println("5. registration_numbers_for_cars_with_colour {Car Color}");
		System.out.println("6. slot_numbers_for_cars_with_colour {Car Color}");
		System.out.println("7. slot_number_for_registration_number {Car Nmuber}");
		
		String inputLine;
		Scanner obj = new Scanner(System.in);
		do {
			inputLine = obj.nextLine();
			String[] input = inputLine.split(" ");
			Command cmd;
			try {
				cmd = Command.valueOf(input[0]);
				cmd.runCommand(input);
			} catch (Exception e) {
				System.out.println("Please provide valid command");
			}
		} while (!inputLine.equals("exit"));
	}
}
