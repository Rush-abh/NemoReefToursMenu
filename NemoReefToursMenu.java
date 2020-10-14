// RUSHABH PANCHOLI
// 12096494
// 15-Jan-2019
// NemoReefTours.java
// Assignment 2 Nemo Reef Tour Program


import java.util.Scanner;
import javax.swing.JOptionPane;


public class NemoReefToursMenu
{
	// Variables for menu display
	final int ENTER_BOOKING = 1;
	final int DISPLAY_BOOKINGS = 2;
	final int DISPLAY_STATISTICS = 3;
	final int SEARCH_BOOKINGS = 4;
	final int SORT_BOOKINGS = 5;
	final int EXIT = 6;

	// Declare common variables
	String bookingName = new String();
	String passengerCount = new String();

	final int Size = 10;
	Booking [] entriesList = new Booking[Size];

	// Array of booking objects of maximum size 10
	int[] bookingobjects = new int[10];

	// Variable for the current booking entered (integer)
	int currentBookingEntered = 0;

	// Declaring scanner objects
	Scanner inputMenuChoice = new Scanner(System.in);

	Booking obj = new Booking();


	// Method to display menu item and check validation
	private int getMenuItem()
	{
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of passengers");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of passengers and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(SORT_BOOKINGS + ". Sort the bookings");
		System.out.println(EXIT + ". Exit the application\n");
		System.out.print("Enter choice==> ");

		String choice = inputMenuChoice.nextLine();
		// Validation for menu choice
		while (choice.equals("") || !isStringNumeric(choice))
		{
			JOptionPane.showMessageDialog(null, "Error - Menu selection name cannot be blank and must be numeric",
											"Input Menu Choice", JOptionPane.ERROR_MESSAGE);

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
	}


	private boolean isStringNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}


	// Method to excute process according to inputs entered
	private void processBookings()
	{
		int choice = getMenuItem();

		while (choice != EXIT)
		{
			switch (choice)
			{
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				case SORT_BOOKINGS:
					sortBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}

		if (choice == EXIT)
			{
				switch (choice)
				{
					case EXIT:
						exitMessage();
						break;
					default:
						System.out.println("ERROR choice not recognised");
				}

			}

	}


	// Method to execute for option 1(enter name and passenger count)
	// Takes input, checks validation and display entered details
	private void enterBooking()
	{

		int displaybookingeneterd = currentBookingEntered +1;
		System.out.println("\nDetails for booking " +displaybookingeneterd+ " entered" );

		displayHeading();

		// Check if maximum bookings has been reached (in this case 10)(validation)
		if(currentBookingEntered == Size)
			JOptionPane.showMessageDialog(null, "Maximum number of bookings has been reached" , "Nemo Reef Tours Management System" , JOptionPane.ERROR_MESSAGE) ;
		else

		// Read the booking name via a dialog (as a string)
		bookingName = JOptionPane.showInputDialog(null, "Please enter the booking name", "Input Booking name",JOptionPane.INFORMATION_MESSAGE);

		// Validation loop (for no input)
		while(bookingName.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Error - Booking name cannot be blank" , "Input Booking name", JOptionPane.ERROR_MESSAGE);
				bookingName = JOptionPane.showInputDialog(null, "Please enter the name", "Input Booking name",JOptionPane.INFORMATION_MESSAGE);
			}

		// Read the number of passengers via a dialog
		passengerCount=JOptionPane.showInputDialog(null,"Please enter number of passengers", "Input no of passengers",JOptionPane.INFORMATION_MESSAGE);

		// Validation loop (for no input)
		while(passengerCount.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Error - Number of passengers cannot be blank" , "Input no of passengers", JOptionPane.ERROR_MESSAGE);
				passengerCount = JOptionPane.showInputDialog(null,"Please enter number of passengers", "Input no of passengers",JOptionPane.INFORMATION_MESSAGE);

			}

		// Validation loop (for input 0 or negative numerics)
		while(Integer.parseInt(passengerCount) <= 0)
			{
				JOptionPane.showMessageDialog(null, "Error - Number of passengers must be atleast 1" , "Input no of passengers", JOptionPane.ERROR_MESSAGE);
				passengerCount = JOptionPane.showInputDialog(null,"Please enter number of passengers", "Input no of passengers",JOptionPane.INFORMATION_MESSAGE);
			}



		// Add the data to the array
		entriesList[currentBookingEntered] = new Booking(bookingName,Integer.parseInt(passengerCount));

		// Display the input details back
		System.out.printf("%-30s%-17s$%-6s\n", bookingName, passengerCount, obj.calculateCharges(Integer.parseInt(passengerCount)));

		// Increment the current booking variable for the next entry
		currentBookingEntered++;

	}


	// Method to display title heading (name, passenger count and charges)
	private void displayHeading()
	{
		System.out.printf("%-30s%-17s%-6s\n", "Booking Name", "Passengers", "Charge");
	}

	// Method to display all booking entered (name, passenger count and charges)
	private void displayAllBookings()
	{
		// check if there is no booking details
		if(currentBookingEntered == 0)
			{
				JOptionPane.showMessageDialog(null, "You must enter atleast one booking" , "Display all bookings" , JOptionPane.ERROR_MESSAGE) ;

			}

		else
		// Calling display method for printing titles of columns
		displayHeading();

		// Check if there has been a booking details entered
		int i;
		for (i = 0; i < currentBookingEntered; i++)

		// Display all of the entries entered so far
		System.out.printf("%-30s%-17s$%-6s\n", entriesList[i].getBookingName(), entriesList[i].getpassengerCount(), obj.calculateCharges(entriesList[i].getpassengerCount()));

	}

	// Method to display statistics for Management system (maximum, minimum, average stay and charges)
	private void displayStatistics()
	{

		// General variables for calculation
		double passengerTotal = 0;
		double averageStay;
		double totalCharges = 0;

		// Lowest and highest name calculation variables
		String nameWithLowest = " ";
		String nameWithHighest = " ";
		int lowestPassengerCount=Integer.MAX_VALUE;
		int highestPassengerCount=Integer.MIN_VALUE;

		// Check if no entries(validation)
		if(currentBookingEntered == 0)
			{
				JOptionPane.showMessageDialog(null, "You must enter atleast one booking" , "Display Statistics" , JOptionPane.ERROR_MESSAGE) ;

			}

		//Loop though the current entries in the array and calculate and display the statistics
		for (int i = 0; i < currentBookingEntered; i++)
			    {
						passengerTotal = passengerTotal + entriesList[i].getpassengerCount();

						totalCharges = totalCharges+obj.calculateCharges(entriesList[i].getpassengerCount());

						// Finding person with lowest passenger
						if(lowestPassengerCount > entriesList[i].getpassengerCount())	// comparing input number with list
						{
							lowestPassengerCount = entriesList[i].getpassengerCount();	// updating lowestPassengerCount variable
							nameWithLowest = entriesList[i].getBookingName();			// updating name with lowest passenger variable
						}

						// Finding person with highest passenger
						if(highestPassengerCount < entriesList[i].getpassengerCount())	// comparing input number with list
						{
							highestPassengerCount = entriesList[i].getpassengerCount();	// updating highestPassengerCount variable
							nameWithHighest = entriesList[i].getBookingName();			// updating name with highest passenger variable
						}
				}

			 averageStay= passengerTotal/currentBookingEntered;															// average stay calculation
			 System.out.println("\nStatistics for Nemo Reef Tours");													// statistics print statement
			 System.out.println(nameWithHighest+ " has maximum number of " + highestPassengerCount+ " passenger(s)" );	// maximum passenger statement
			 System.out.println(nameWithLowest+ " has minimum number of " + lowestPassengerCount+ " passenger(s)" );	// minimm passenger statement
			 System.out.printf("Average stay is %.2f days\n",averageStay);												// average stay statement
			 System.out.printf("Total charges are: $%.2f\n",totalCharges);												// total charges statement

	}

	// Method to execute search key for case insensitive search
	private int search(String searchName)
		{
			int position = -1;
			for (int i = 0; i < currentBookingEntered; i++)
				{
					if(searchName.equalsIgnoreCase(entriesList[i].getBookingName()))
						position = i;
				}
			return position;
	}

	// Method to executing search funtion in system
	private void searchBookings()
	{

		String searchName = null;

		// Check if there has been a booking entered (validation)
		if(currentBookingEntered == 0)
			JOptionPane.showMessageDialog(null, "Error -  must enter at least one booking to seach" , "Search booking" , JOptionPane.ERROR_MESSAGE) ;	// error prompt

		else
			searchName = JOptionPane.showInputDialog(null, "Please enter booking name", "Input Booking name",JOptionPane.INFORMATION_MESSAGE);	// input prompt

		// Read the search key using a dialog
		int found=search(searchName) ;

			if(found != -1)
				{
					System.out.println("Booking found");

					// Display the found item or report it has not been found
					// Loop though the current entries in the array to search for the search key
					displayHeading();
					System.out.printf("%-30s%-17s$%-6s\n", entriesList[found].getBookingName(), entriesList[found].getpassengerCount(), obj.calculateCharges(entriesList[found].getpassengerCount()));

				}

			else
				//Report item  has not been found
				JOptionPane.showMessageDialog(null,searchName+" not found." , "Search Booking" , JOptionPane.ERROR_MESSAGE);		// error prompt
	}



	// Method to execute sort funtion on system entries
	private void sortBookings()
	{
		// Check if there has been two bookings entered
		int smallest;
			if(currentBookingEntered < 2)
				JOptionPane.showMessageDialog(null, "Error -  must enter at least two booking to sort" , "Sort Booking" , JOptionPane.ERROR_MESSAGE);		// error prompt

			else
				for (int i = 0; i<currentBookingEntered; i++)
			  		{
						  smallest = i;
						  	for (int z = i+1; z<currentBookingEntered ; z++)
						  	{
								if (entriesList[z].getBookingName().compareToIgnoreCase(entriesList[smallest].getBookingName())<0)
								{
									smallest = z;
								}
							}

							// Sort the entries
							Booking temp = entriesList[i];
							entriesList[i] = entriesList[smallest];
							entriesList[smallest] = temp;
					}

		//Display the sorted list
		displayAllBookings();
	}

	// Method to Display exit message whenever option 6 used
	private void exitMessage()
	{
		// Exit message if option 6(exit) selected
		System.out.println("\nThank you for using Nemo Reef Tours Management System");
		System.out.println("Program written by 12096494\n");

	}

	// Main method declaration
	public static void main(String [] args)
	{
		// Welcome message for system
		System.out.println("Welcome to the Nemo Reef Tours Management System");

		NemoReefToursMenu app = new NemoReefToursMenu();

		app.processBookings();
	}
}