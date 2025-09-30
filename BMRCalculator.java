package healthcalculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BMRCalculator {

	public static double BMRFormulaMale(double height , double weight, double age) {
	
		double bmrmaleformula = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);	
		
		return bmrmaleformula;
	}
	
	public static double BMRFormulaFemale(double height , double weight, double age) {
		
		double bmrfemaleformula = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);	
		
		return bmrfemaleformula;
	}
	
	public static void main(String[] args) {
		boolean bmrOn = true;
		double height = 0;
		double weight = 0;
		double age = 0; 
		Scanner scanner = new Scanner(System.in);
		//boolean goagain = true;
		String userReuseResponse = null;
		do {
			while (bmrOn) { 
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
				String userSex = "";
				while (maleOrFemale) {
					System.out.println("What's your sex?: ");
					userSex = scanner.nextLine().trim();
					if (userSex.equalsIgnoreCase("male") || userSex.equalsIgnoreCase("female")) {
							maleOrFemale = false;
					} else {
						System.out.println("Sex must be male or female.");
					  }
				}
					boolean askUserHeight = true;
					while (askUserHeight) {
						System.out.println("What's your height in inches?: ");
						try {
							height = scanner.nextDouble();
							if (height <= 0) {
								System.out.println("Height must be greater than 0");
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
									System.out.println("Weight must not be greater than 0");
								} else {
									askUserWeight = false;
								  }
							} catch (InputMismatchException e) {
								System.out.println("Please make sure you use numbers.");
								scanner.next();
							  }
					}
					if (userSex.equalsIgnoreCase("male")) {
						System.out.printf("Your BMR is: %.2f%n" , BMRFormulaMale(height, weight, age));
						bmrOn = false;
					} else {
						System.out.printf("Your BMR is: %.2f%n" , BMRFormulaFemale(height, weight, age));
						bmrOn = false;
				  }
			}
				System.out.println("Would you like to go again? (Yes or No?): "); 
				boolean userReuse = true;
				while (userReuse) {
					//scanner clearer
					scanner.nextLine();
					userReuseResponse = scanner.nextLine().trim();
					if (userReuseResponse.equalsIgnoreCase("yes") || userReuseResponse.equalsIgnoreCase("no")) {
						userReuse = false;
						if (userReuseResponse.equalsIgnoreCase("yes")) {
							bmrOn = true;
						}
					} else {
						System.out.println("Make sure you say yes or no.");
					   }
			}
		} while	(userReuseResponse.equalsIgnoreCase("yes"));
		System.out.println("Thank you for using my program.");
		
	scanner.close();
	}   
}

