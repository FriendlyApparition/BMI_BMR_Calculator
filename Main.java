package healthcalculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to my health calculator.");
		boolean appOn = true;
		do {
			double age = 0;
			String userSex = null;
			String userChoice = null;
			double height = 0;
			double weight = 0;
			System.out.println("Would you like your BMR or BMI Calculated? type 'Both' if you want both calculated: ");
			while (true) {
				userChoice = scanner.nextLine().trim();
				if (userChoice.equalsIgnoreCase("bmr") || userChoice.equalsIgnoreCase("bmi") || userChoice.equalsIgnoreCase("both")) {
					break;
				}
				else {
					System.out.println("The only acceptable input is BMR, BMI, or Both: ");
				}
			}
			while (true) {
				boolean userAge = true;
				while (userAge) {
					System.out.println("What's your age?");
					try {
						age = scanner.nextDouble();
						if (age <= 0) {
							System.out.println("Age must be greater than 0");
						} else {
							userAge = false;
						  }
					} catch (InputMismatchException e){
						System.out.println("Make sure you use numbers.");
						scanner.next();
					  }	
				}
				//scanner clearer
				scanner.nextLine();
				
				boolean maleOrFemale = true;
				while (maleOrFemale) {
					if (userChoice.equalsIgnoreCase("bmr") || userChoice.equalsIgnoreCase("both")) {
						System.out.println("What's your sex?: ");
						userSex = scanner.nextLine().trim();
						if (userSex.equalsIgnoreCase("male") || userSex.equalsIgnoreCase("female")) {
							maleOrFemale = false;
						} else {
							System.out.println("Sex must be male or female.");
						  }
					} else {
						break;
					  }
				}
				boolean askUserHeight = true;
				while (askUserHeight) {
					System.out.println("What's your height in inches?: ");
					try {
						height = scanner.nextDouble();
						if (height <= 0) {
							System.out.println("Height must be greater than 0.");
						} else {
							askUserHeight = false;
						  }
					} catch (InputMismatchException e) {
						System.out.println("Please make sure you use numbers.");
						scanner.next();
					   }
				}
				scanner.nextLine();
				boolean askUserWeight = true;
				while (askUserWeight) {
						System.out.println("What's your weight in pounds?: ");
						try {
							weight = scanner.nextDouble();
							if (weight <= 0) {
								System.out.println("Weight must be greater than 0");
							} else {
								askUserWeight = false;
							  }
						} catch (InputMismatchException e) {
							System.out.println("Please make sure you use numbers.");
							scanner.next();
						  }
				}
				break;
			}
			if (userChoice.equalsIgnoreCase("bmi")) {
				System.out.printf("Your BMI is: %.2f%n", BMICalculator.calculateBmi(height, weight));
			} else if (userChoice.equalsIgnoreCase("bmr")) {
				if (userSex.equalsIgnoreCase("male")) { // male bmr
					System.out.printf("Your BMR is: %.2f%n", BMRCalculator.BMRFormulaMale(height, weight, age));
				} else { // female bmr
					System.out.printf("Your BMR is: %.2f%n", BMRCalculator.BMRFormulaFemale(height, weight, age));
				  }
			  } else { //both bmr and bmi
				  if (userSex.equalsIgnoreCase("male")) {
					  System.out.printf("Your BMI is: %.2f \nAnd your BMR is: %.2f%n", BMICalculator.calculateBmi(height, weight), BMRCalculator.BMRFormulaMale(height, weight, age));
				  } else if (userSex.equalsIgnoreCase("female")) {
					  System.out.printf("Your BMI is: %.2f \nAnd your BMR is: %.2f%n", BMICalculator.calculateBmi(height, weight), BMRCalculator.BMRFormulaFemale(height, weight, age));
				  }
				  
			  }
			//clears scanner
			scanner.nextLine();
			boolean reuseApp = true;
			System.out.println("Would you like to reuse this application? Yes or No: ");
			while (reuseApp) {
				String userReuse = scanner.nextLine().trim();
				if (userReuse.equalsIgnoreCase("no") || userReuse.equalsIgnoreCase("yes")) {
					reuseApp = false;
					if (userReuse.equalsIgnoreCase("no")){
						appOn = false;
					} 
				} else {
					System.out.println("Please enter a valid input.");
				  }
			}
		} while (appOn);
		System.out.println("Thank you for using my BMI/BMR Calculator");
		scanner.close();
	}
}
