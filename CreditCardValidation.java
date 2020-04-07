import java.util.Scanner;

public class CreditCardValidation {
	static Long num = new Long(0);	//var for credit card num
	static int i=0, j=0;
	
	public static void main(String[] args) //main
	{
		System.out.println("Enter Credit Card number as Long Integer:");
		Scanner input = new Scanner(System.in);
	    num = input.nextLong();
	    input.close();	   
	    
	    if(isValid(num) == true)
	    	System.out.println(num + " is Valid Credit Card number");
	    else
	    	System.out.println(num + " is Invalid Credit Card number");
		
	}
	
	//Return if the card number is valid 
	public static Boolean isValid(long num)
	{
		boolean x;
		int size = getSize(num/10);
		if((size>=13 && size<=16) && ((sumOfDoubleEvenPlace(num) + sumOfOddPlace(num)) % 10 == 0))
			x=true;
			
		else
			x=false;
		return x;
	}

	//Get the result from step 2
	public static int sumOfDoubleEvenPlace(Long num)
	{
		i++;
		if (num == 0)
			return 0;
		else if(i%2 == 0)
		{
			return getDigit((int) (2*(num%10))) + sumOfDoubleEvenPlace(num/10);
		}
		else
			return sumOfDoubleEvenPlace(num/10);
	}

	//Return this number it is a single digit, otherwise, return the sum of the two //digits
	public static int getDigit(int num)
	{
		if (num == 0) 
            return 0; 
        return (num % 10 + getDigit(num / 10)); 
	}

	//Return sum of sumOfOddPlace( long number )
	public static int sumOfOddPlace(long num)
	{
		j++;
		if (num == 0)
			return 0;
		else if(j%2 != 0)
		{
			return (int) (num%10 + sumOfOddPlace(num/10));
		}
		else
			return sumOfOddPlace(num/10);
	}
	
	//Return the number of digits in digit
	public static int getSize(long num)
	{
		if (num == 0)
			return 1;
	    else
	    	return 1 + getSize(num/10);
	}
}
