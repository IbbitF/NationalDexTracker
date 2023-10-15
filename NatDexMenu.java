import java.io.*;
import java.util.*;

class NatDexMenu
{
	public static void main(String[] args){
        char input;
        String line;		//Defines variables for the given do while loop
        String info;
	try{
		System.out.println("Welcome to my silly nat dex placement :) \n");
	    printMenu();

	    InputStreamReader isr = new InputStreamReader(System.in);	//Definies input reader
	    BufferedReader stdin = new BufferedReader(isr);

	    	do{
				System.out.println("What action would you like to perform?");
	            line = stdin.readLine().trim();
	            input = line.charAt(0);
	            input = Character.toUpperCase(input);		//auto-converts lowercase letters to uppercase
	            if(line.length() == 1){
                switch (input){
					case 'A':
						System.out.println("Please enter the National Dex Number");
						info = stdin.readLine().trim();
						int entry = Integer.parseInt(info);		//takes number input
						System.out.println("");
						System.out.println(calculate(entry) + "\n");
						printMenu();
						break;

					case 'Q':
						break;	//quits
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for using this!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
	}

	public static void printMenu()
	{
		System.out.println("A. Add New Entry");
		System.out.println("Q. Quit");
	}
	public static String calculate(int dex)
	{
			int temp, row, column;	//Variables for position
			int box = 1;
			temp = dex;

		while(dex > 30)	//Subtracts number by 30 repeatedly until it is 30 or below, increasing the box count each time
			{
				dex = dex - 30;
				box++;
			}

			if(dex <= 6)	//Using the above number, the leftover value is appropriately placed into its row
			{
				row = 1;
			}
			else if(dex <= 12)
			{
				row = 2;
			}
			else if(dex <= 18)
			{
				row = 3;
			}
			else if(dex <= 24)
			{
				row = 4;
			}
			else
			{
				row = 5;
			}

			while(dex > 6)	//Simplifies number down to 6 or below, allowing for column to be picked
			{
				dex = dex - 6;
			}

			column = dex;

			String result = "The position for #" + temp + " is:\n" +
							"Box " + box + "\n" +
							"Row " + row + "\n" +
							"Column " + column;
			return result;
	}
}