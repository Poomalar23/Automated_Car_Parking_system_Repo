package CarParking;

public class Slots {

	private Integer number;
	private boolean isEmpty;
	private Cars parkCar;

	public Slots(Integer number) {
		this.number = number;
	}

	public Cars getParkCar() {
		return parkCar;
	}

	public void setParkCar(Cars parkCar) {
		this.parkCar = parkCar;
	}

	public void unParkCar() {
		parkCar = null;
		this.isEmpty = false;
	}

	public void placeCar(Cars parkCar) {
		this.parkCar = parkCar;
		this.isEmpty = true;
	}

	public Integer getSlotNumber() {
		return number;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}

}
