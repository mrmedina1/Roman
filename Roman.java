import java.util.*;

public class Roman
{
	protected int roman;
	protected String romanString;

	public Roman()
	{
		roman = 0;
		romanString = "";
	}

	public void getRoman(int newRoman)
	{
		int counter = 0;
		int remainder = 0;
		boolean greaterThan5000;

		do
		{
		
			greaterThan5000 = false;
		
			if (newRoman >= 5000)
			{
				greaterThan5000 = true;

				while (newRoman >= 1000)
				{
					newRoman = newRoman - 1000;
					counter++;
				}

				remainder = newRoman;
				newRoman = counter;
				romanString = romanString.concat("(");

				counter = 0;
			}

			while (newRoman >= 1000)
			{
				newRoman = newRoman - 1000;
				counter++;
			}

				while (counter > 0)
				{
					romanString = romanString.concat("M");
					counter--;
				}

				if (newRoman >= 900 && newRoman < 1000)
				{
					romanString = romanString.concat("CM");
					newRoman = newRoman - 900;
				}

			while (newRoman >= 500)
			{
				newRoman = newRoman - 500;
				counter++;
			}

				while (counter > 0)
				{
					romanString = romanString.concat("D");
					counter--;
				}

				if (newRoman == 9)
				{
					romanString = romanString.concat("IX");
					newRoman = newRoman - 9;
				}

			while (newRoman >= 100)
			{
				newRoman = newRoman - 100;
				counter++;
			}

				if (counter > 3)
				{
					romanString = romanString.concat("CD");
					counter = 0;
				}
				else
				{
					while (counter > 0)
					{
						romanString = romanString.concat("C");
						counter--;
					}

					if (newRoman == 9)
					{
						romanString = romanString.concat("IX");
						newRoman = newRoman - 9;
					}
				}

				if (newRoman >= 90 && newRoman < 100)
				{
					romanString = romanString.concat("XC");
					newRoman = newRoman - 90;
				}


			while (newRoman >= 50)
			{
				newRoman = newRoman - 50;
				romanString = romanString.concat("L");
			}

				while (counter > 0)
				{
					romanString = romanString.concat("L");
					counter--;
				}

				if (newRoman == 9)
				{
					romanString = romanString.concat("IX");
					newRoman = newRoman - 9;
				}

			while (newRoman >= 10)
			{
				newRoman = newRoman - 10;
				counter++;
			}

				if (counter > 3)
				{
					romanString = romanString.concat("XL");
					counter = 0;
				}
				else
				{
					while (counter > 0)
					{
						romanString = romanString.concat("X");
						counter--;
					}
					if (newRoman == 9)
					{
						romanString = romanString.concat("IX");
						newRoman = newRoman - 9;
					}
				}

			while (newRoman >= 5)
			{
				newRoman = newRoman - 5;
				counter++;
			}

				if (counter > 3)
				{
					romanString = romanString.concat("VX");
					counter = 0;
				}
				else
				{
					while (counter > 0)
					{
						romanString = romanString.concat("V");
						counter--;
					}
					if (newRoman == 9)
					{
						romanString = romanString.concat("IX");
						newRoman = newRoman - 9;
					}
				}

			while (newRoman >= 1)
			{
				newRoman = newRoman - 1;
				counter++;
			}

				if (counter > 3)
				{
					romanString = romanString.concat("IV");
					counter = 0;
				}
				else
				{
					while (counter > 0)
					{
						romanString = romanString.concat("I");
						counter--;
					}
					if (newRoman == 9)
					{
						romanString = romanString.concat("IX");
						newRoman = newRoman - 9;
					}
				}

			newRoman = remainder;
			remainder = 0;
		
			if (greaterThan5000)
			{
				romanString = romanString.concat(")");
			}

		}
		while (greaterThan5000);
	}

	public void setRomanString()
	{
		romanString = "";
	}

	public String toString()
	{
		return romanString;
	}


	public static void main (String args [])
	{
		Scanner keyboard = new Scanner(System.in);
		Roman convertRoman = new Roman();

		int romanNum = 0;
		char userContinue = 'n';

		do
		{
			System.out.print("Please enter a a number to convert to a roman numeral: ");

			romanNum = keyboard.nextInt();

			convertRoman.getRoman(romanNum);

			System.out.println("\n" + convertRoman + "\n");

			convertRoman.setRomanString();

			System.out.print("Would you like to convert another number to roman numerals? y/n: ");

			userContinue = keyboard.next().charAt(0);

			System.out.println("\n\n");
		}
		while (userContinue != 'n' && userContinue != 'N');
	}

}
