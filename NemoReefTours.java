// RUSHABH PANCHOLI
// 12096494
// 25-Dec-2018
// File Name: NemoReefTours
// Assignment 1 Nemo Reef Tour Program

// We need to use scanner class in utility package
import java.util.Scanner;

// Creating NemoReefTours class to make that claculate charge and display Statistics, this application for employees in company.
public class NemoReefTours

// We use brackets to control the order of operations
{
	// Main method declaration
	public static void main(String [] args)
	{
		// General variables
		int passengerCount = 0;
		String bookingName = "";

		// Loop variable
		final int N = 9;
		int count = 1;

		// Charges variables
		final double FEE = 85.50;
		double includingDiscountCharges = 0;
		double excludingDiscountCharges = 0;


		// Discounts variables
		int onePassenger = 1;
		int twoPassenger = 2;
		int threePassenger = 3;
		int fivePassenger = 5;
		int sixPassenger = 6;
		int tenPassenger = 10;


		final double DISCOUNT_1 = 0.10;
		final double DISCOUNT_2 = 0.15;
		final double DISCOUNT_3 = 0.20;



		// Statistical variables
		double chargesTotal=0;
		double passengerTotal=0;
		double passengerAverage=0;


		// Lowest and highest calculation variables
		String nameWithLowest="";
		String nameWithHighest="";
		int lowestPassenger = Integer.MAX_VALUE;
		int highestPassenger = Integer.MIN_VALUE;



		// Declaring scanner objects
		Scanner name = new Scanner(System.in);
		Scanner number = new Scanner(System.in);

		// Welcome message
		System.out.println("**Welcome to the Nemo Reef Tours Management System**");

		// Creating loop for N repetations
		while(count <= N)
		{

			// Printing name message and read input
			System.out.printf("\nPlease enter booking name %d%s ",count," ==>");
       		bookingName=name.nextLine();

       		// Validation for booking name field
       		boolean nameValidation = false;
       		while(nameValidation != true)
       		{
				// If else to compare name field input
				if( bookingName.equals("") )
				{
					System.out.println("ERROR booking name cannot be blank");
					System.out.printf("\nPlease enter the booking name %d%s ",count," ==>");
					bookingName = name.nextLine();
				}
				else
				{
					nameValidation = true;
				}
			}

       		// Printing Number of passenger message and read input
       		System.out.print("Enter the number of passengers for "+bookingName+" ==> ");
       		passengerCount=number.nextInt();

       		// Validation for number of passenger input
       		boolean passengerValidation = false;
       		while(passengerValidation != true)
       		{
				// If else to compare passenger number input
				if(passengerCount <= 0)
				{
					System.out.println("ERROR number of passenger must be greater than zero");
					System.out.print("Enter the number of passengers for "+bookingName+" ==> ");
					passengerCount = number.nextInt();
				}
				else
				{
					passengerValidation = true;
				}
			}

			// Charge calculations
			// Charge calculation for 1 or 2 passengers
			if (passengerCount >= onePassenger && passengerCount <= twoPassenger )
			{
				includingDiscountCharges = FEE * passengerCount;
			}
			// Charge calculation for 3 to 5 passengers
			else if (passengerCount >= threePassenger && passengerCount <= fivePassenger )
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_1);
			}
			// Charge calculation for 6 to 10 passengers
			else if (passengerCount >= sixPassenger && passengerCount <= tenPassenger )
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_2);
			}
			// Charge calculation for more than 10 passengers
			else
			{
				excludingDiscountCharges = FEE * passengerCount;
				includingDiscountCharges = excludingDiscountCharges - (excludingDiscountCharges * DISCOUNT_3);
			}
			// Printing statement with name, passengers count and charges
			System.out.printf("Total charges for "+bookingName+" for "+passengerCount+" passenger(s) is $ %.2f\n",includingDiscountCharges );

			// Finding person with lowest passenger
			if (passengerCount <= lowestPassenger)  	 // comparing input number with lowest value( initially:2,147,483,647 )
			{
				lowestPassenger = passengerCount;    // updating lowestPassenger variable
				nameWithLowest = bookingName;    	 // updating name with lowest passenger variable
			}

			// Finding person with lowest passenger
			if (passengerCount >= highestPassenger)       // comparing input number with highest value( initially:-2,147,483,648 )
			{
				highestPassenger = passengerCount; 	  // updating highestPassenger variable
				nameWithHighest = bookingName;     	  // updating name with highest passenger variable
			}

			passengerTotal = passengerTotal + passengerCount;
			chargesTotal = chargesTotal + includingDiscountCharges; // finds sum of charges with discount and save to chargesTotal variable
			count++;    // increasing count variable
		}




		// Statistical calculations
		passengerAverage= passengerTotal/N; 					// finds average of passenger as per booking and save to passengerAverage variable

		// Printing Statistical calculation statements
		System.out.println("\n\nStatistical Information for Nemo Reef Tours ");    // prints information statement
		System.out.println("\nBooking: "+ nameWithLowest+" has the minimum number of "+lowestPassenger+" passengers(s)");    // prints lowest passenger details
		System.out.println("Booking: "+ nameWithHighest+" has the maximum number of "+highestPassenger+" passengers(s)");    // prints highest passenger details
		System.out.printf("The average number of passenger per booking is: %.2f passengers",passengerAverage);    			// prints average of passenger details
		System.out.printf("\nThe total charges collected is $ %.2f", chargesTotal);											// prints total charges collection details
		System.out.println("\n\n\nThank you for using Nemo Reef Tour Management System");									// prints ending statement
		System.out.println("Program written by 12096494");																	// prints developer details
	}
}

