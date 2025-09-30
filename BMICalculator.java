package healthcalculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BMICalculator {
	public static double calculateBmi(double height , double weight) {
		
		double bmi_result = (weight/(height * height)) * 703;
		return bmi_result;
	}	
	public static void main(String[] args) {
		double height = 0;
		double weight = 0;
		boolean validHeight = false;
		Scanner scanner = new Scanner(System.in);
		while (!validHeight) {
			System.out.println("What's your height in inches?: ");
			try {
				height = scanner.nextDouble();
				if (height <= 0) {
					System.out.println("Height must be greater than 0.");
				}
				else {
					validHeight = true;
				}
			 }
				catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a number");
					scanner.next();
				}								
			}
						
		boolean validWeight = false;
		while (!validWeight) {
			System.out.println("What's your weight in LBS?: ");
			try {
				weight = scanner.nextDouble();
				if (weight <= 0) {
					System.out.println("Weight must be greater than 0.");
				} else {
					validWeight = true;
				  }
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number");
				scanner.next();
			}
			
		}
		System.out.printf("Your BMI is: %.2f%n " , calculateBmi(height , weight));
		scanner.close();
		}
	}
