// RUSHABH PANCHOLI
// 12096494
// 15-Jan-2019
// File Name: Booking
// Assignment 2 Nemo Reef Tour Program

public class Booking
{

	// variables for name and passenger input
	private String bookingName;
	private int passengerCount;

	// variables for charges calculations
	final double FEE = 85.50;
	double includingDiscountCharges;
	double excludingDiscountCharges;

	// Discounts calculation variables
	int onePassenger = 1;
	int twoPassenger = 2;
	int threePassenger = 3;
	int fivePassenger = 5;
	int sixPassenger = 6;
	int tenPassenger = 10;
	final double DISCOUNT_1 = 0.10;
	final double DISCOUNT_2 = 0.15;
	final double DISCOUNT_3 = 0.20;


	// Default constructor for booking
	public Booking ()
	{
		bookingName = null;
		passengerCount = 0;
	}


	// Parameterized constructor for booking
	public Booking (String bookingName, int passengers)
	{
	    this.bookingName = bookingName;
		passengerCount = passengers;
	}

	// Setter for booking name, writes value of field
	public void setBookingName (String bookingName)
	{
		this.bookingName =  bookingName;
	}


	// Getter for booking name, reads value of field
	public String getBookingName ()
	{
		return bookingName;
	}

	// Setter for passengers input, writes value of field
	public void setpassengerCount (int passengers)
	{
		passengerCount = passengers;
	}

	// Getter for passengers input, reads value of field
	public int getpassengerCount ()
	{
		return passengerCount;
	}

	// Calculating charges including discounts if applicable
	public double calculateCharges (int passengerCount)
	{
		// Charge calculation for 1 to 2 passengers, no discount
		if (passengerCount >= onePassenger && passengerCount <= twoPassenger )
			{
				includingDiscountCharges = FEE * passengerCount;
			}
		// Charge calculation for 3 to 5 passengers, 10% discount
		else if (passengerCount >= threePassenger && passengerCount <= fivePassenger )
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_1);
			}
		// Charge calculation for 6 to 10 passengers, 15% discount
		else if (passengerCount >= sixPassenger && passengerCount <= tenPassenger )
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_2);
			}
		// Charge calculation for more than 10 passengers, 20% discount
		else
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_3);
			}
		return includingDiscountCharges;

	}

}