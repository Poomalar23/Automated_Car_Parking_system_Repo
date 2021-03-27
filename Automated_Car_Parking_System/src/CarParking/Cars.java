package CarParking;

public class Cars {

	private String CarNumber;
	private String CarColor;

	public Cars(String carNumber, String carColor) {
		this.CarNumber = carNumber;
		this.CarColor = carColor;
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String vehicleNumber) {
		this.CarNumber = vehicleNumber;
	}

	public String getCarColour() {
		return CarColor;
	}

	public void setCarColor(String vehicleColor) {
		this.CarColor = vehicleColor;
	}
}

