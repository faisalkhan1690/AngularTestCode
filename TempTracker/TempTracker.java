/**
 * Q2: Write a class TempTracker with these methods:
 * insert() - records a new temperature
 * get_max() - returns the highest temp we've seen so far
 * get_min() - returns the lowest temp we've seen so far
 * get_mean() - returns the mean of all temps we've seen so far
 * get_mode() - returns a mode of all temps we've seen so far
 * Favour speeding up the getter methods get_max(), get_min(), get_mean(), and get_mode()
 * over speeding up the insert() method.get_mean() should return a float, but the rest of the
 * getter methods can return integers. Temperatures will all be inserted as integers and we can
 * assume they will be in the range 0 ℃ to 150 ℃.If there is more than one mode, return any of the modes.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to insert and get maximum, minimum, mean and mode temperature 
 * 
 * @author Faisal Khan
 */
public class TempTracker {

	private static final int NO_DATA = -1;

	private List<Integer> mListTemperatures = new ArrayList<Integer>(); // list of all inserted temperatures
	private int sumOftemperatures = 0; //sum of all inserted temperatures

	/**
	 * To insert temperature
	 * 
	 * @temperature temperature integer
	 * @return integer -1 if fails else 0
	 */
	public int insert(int temperature) {
		// returns  -1 if the temperature is less then 0 of grater then 150
		if (temperature < 0 || temperature > 150) 
			return NO_DATA;
		mListTemperatures.add(temperature);
		Collections.sort(mListTemperatures);
		sumOftemperatures += temperature;
		
		//to print all inserted temperatures 
		System.out.print("All Temperatures Are :- ");
		for (int i = 0; i < mListTemperatures.size(); i++)
			System.out.print(" " + mListTemperatures.get(i)); 
		return 0; // return 0 if temperature inserts successfully
	}

	/**
	 * To get the maximum temperature of the list of all inserted temperatures
	 * 
	 * @return maximum temperature integer
	 */
	public int get_max() {
		//returns no data if there is no temperature inserted  
		if (mListTemperatures.size() == 0)
			return NO_DATA;
		
		//returns temperature without any calculation if there is only one temperature
		if (mListTemperatures.size() == 1)
			return mListTemperatures.get(0);
		
		//returns maximum temperature
		return mListTemperatures.get(mListTemperatures.size() - 1);
	}

	/**
	 * To get minimum temperature
	 * 
	 * @return minimum temperature in integer
	 */
	public int get_min() {
		//returns no data if there is no temperature inserted  
		if (mListTemperatures.size() == 0)
			return NO_DATA;
		return mListTemperatures.get(0); //returns minimum temperature
	}

	/**
	 * To get mean of all inserted temperatures 
	 * 
	 * return mean of temperatures float
	 */
	public float get_mean() {
		//returns no data if there is no temperature inserted  
		if (mListTemperatures.size() == 0)
			return NO_DATA;
		
		return (float) sumOftemperatures / mListTemperatures.size();
	}

	/**
	 * To get temperature that is entered by user maximum time
	 * 
	 * @return mode temperature in integer
	 */
	public int get_mode() {
		//returns no data if there is no temperature inserted  
		if (mListTemperatures.size() == 0)
			return NO_DATA;
		
		//returns temperature without any calculation if there is only one temperature
		if (mListTemperatures.size() == 1)
			return mListTemperatures.get(0);

		Map<Integer, Integer> map = new HashMap<>();
		int mode = 0;
		int modeValue = 0;
		
		//Loop through all the records and add it to the map with temperature as key and number of repetition as value
		for (int i : mListTemperatures) {
			if (map.containsKey(i)) {
				int value = map.get(i);
				map.put(i, value + 1);
			} else
				map.put(i, 1);
		}
		
		//Loop through the map and check for the highest count.
		Set<Integer> keySet = map.keySet();
		for (int key : keySet) {
			if (map.get(key) > modeValue) {
				mode = key;
				modeValue = map.get(key);
			}
		}
		return mode;
	}

	/**
	 * Main Method to get input from user using command line. Here user will select from given 
	 * options to perform specific operation those are
	 * 
	 * A: To insert new temperature
	 * B: To get Max Temperature
	 * C: To get Minimum Temperature
	 * D: To get Mean Temperature
	 * E: To get Mode Temperature
	 * Q: To quit
	 * 
	 * @param args StringArray not in use
	 */
	public static void main(String args[]) {
		TempTracker object = new TempTracker();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("");
			System.out.println("------------------------------------");
			System.out.println("Enter A to insert Temperature");
			System.out.println("Enter B to get Max Temperature");
			System.out.println("Enter C to get Minimum Temperature");
			System.out.println("Enter D to get Mean Temperature");
			System.out.println("Enter E to get Mode Temperature");
			System.out.println("Enter Q to Quit");
			char option = scanner.nextLine().toLowerCase().charAt(0); // to get option from user 
			boolean isQuit = false;
			switch (option) {
			case 'a':
				System.out.println("Enter Temperature");
				String temp = scanner.nextLine(); // to get tempature from user 
				try {
					int insertData = object.insert(Integer.parseInt(temp));
					if (insertData == NO_DATA) {
						System.out.println("temperature should be between  0 ℃ to 150 ℃.");
					}
				} catch (Exception e) {
					System.out.println("Please enter a valid number");
				}
				break;
				
			case 'b':
				// get max temperature
				int maxTemp = object.get_max();
				if (maxTemp == NO_DATA) 
					System.out.println("There is not temperature recored available");
				else 
					System.out.println("Max temperature is = " + maxTemp);
				break;
				
			case 'c':
				// get minimum temperature
				int minTemp = object.get_min();
				if (minTemp == NO_DATA) 
					System.out.println("There is not temperature recored available");
				else
					System.out.println("Min temperature is = " + minTemp);
				break;
				
			case 'd':
				// get mean temperature
				float meanTemp = object.get_mean();
				if (meanTemp == NO_DATA) 
					System.out.println("There is not temperature recored available");
				else
					System.out.println("Mean temperature is = " + meanTemp);
				break;
				
			case 'e':
				// get mean temperature
				int modeTemp = object.get_mode();
				if (modeTemp == NO_DATA) 
					System.out.println("There is not temperature recored available");
				else
					System.out.println("Mode temperature is = " + modeTemp);
				break;
				
			case 'q':
				isQuit = true;
				break;
				
			default:
				System.out.println("Enter wrong option Please try again");
			}
			if (isQuit) {
				scanner.close(); //quit and close the connection 
				break;
			}
		}
	}
}
