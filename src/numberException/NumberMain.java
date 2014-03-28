package numberException;

import java.util.Scanner;


public class NumberMain {

	
	public static void main(String[] args) {
		
		boolean flag = true;
		
		int num1 = 0;
		int num2 = 0;
		String input = new String();
		Scanner kb = new Scanner(System.in);
		
		while (flag) {
		
			try {
			
				System.out.println ("Inserisci Un Numero Non Negativo");
				input = kb.nextLine();
			
				num1 = Integer.parseInt(input);
			
				if (num1 < 0) {
			
					throw new NegativeNumberException();
				
				} else {
				
					flag = false;
						
				}
			
			} catch (NumberFormatException e) {
		
				System.out.println ("Input Non Numerico!");
			
			} catch (NegativeNumberException e) {
		
				System.out.println ("I numeri negativi non sono ammessi!");
			
			}
		
		}
		
		flag = true;
		
		while (flag) {
			
			try {
			
				System.out.println ("Inserisci Un Numero Non Negativo");
				input = kb.nextLine();
			
				num2 = Integer.parseInt(input);
			
				if (num2 < 0) {
			
					throw new NegativeNumberException();
				
				} else {
				
					flag = false;
						
				}
			
			} catch (NumberFormatException e) {
		
				System.out.println ("Input Non Numerico!");
			
			} catch (NegativeNumberException e) {
		
				System.out.println ("I numeri negativi non sono ammessi!");
			
			}
		
		}
		
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		
		
	}

}



