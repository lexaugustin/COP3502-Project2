import java.util.Scanner;
import java.lang.Math;
import java.security.cert.PKIXRevocationChecker.Option;
import java.text.SimpleDateFormat;
import java.util.Date;

// This program takes a radius or side and compute both the area and the perimeter or circumference of a selected shape.

public class ShapeMachine {
	public static void main(String[] arg){

		Scanner input = new Scanner(System.in);

		System.out.println("Shape Machine login");

		// Current Date
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


		// User input and comparison to current date.
		
		for (int n = 1; n <= 3; n++){
			System.out.print("What is today's day? ");
			String day = input.nextLine();
			System.out.print("What is today's month? ");
			String month = input.nextLine();
			System.out.print("What is today's year? ");
			String year = input.nextLine();

			String userDate = day + "-" + month + "-" + year;


			if (userDate.equals(date) == false && n < 3){
				System.out.println("#ERROR Login attempt #" + n + " Invalid input. Please try again." + "\n");
			}
			else if (n == 3){
				System.out.println("#ERROR 3rd invalid login attempt. Terminating program.");
				System.exit(0);
			}
			else {
				System.out.println("Correct date. Welcome!" + "\n");
				break;
			} 
		}

		// Shape Machine Menu

		String userChoice = "";

		do {
			System.out.println("---Welcome to the Shape Machine--- \nAvailable Options: \nCircles \nRectangles \nTriangles \nExit");
			userChoice = input.next();


			if (userChoice.equals("Circles") == false && userChoice.equals("Rectangles") == false && userChoice.equals("Triangles") == false && userChoice.equals("Exit") == false){
				System.out.println("#ERROR Invalid option. Please try again." + "\n");

			}


			// If the user selects Circles.
			
			if (userChoice.equals("Circles")){
				System.out.print("Circles selected. Please enter the radius: ");

				do {
					double radius = input.nextDouble();
					if (radius < 0){
						System.out.print("#ERROR Negative input. Please input the radius again: ");
						continue;
					}   

					// Calculating the circumference and area of the circle.
					
					double circumference = 2 * Math.PI * radius;
					double area = Math.PI * radius * radius;
					int circumferenceLength = Double.toString(circumference).length();
					int areaLength = Double.toString(area).length();

					System.out.println("The circumference is: " + circumference);
					System.out.println("The area is: " + area);
					System.out.println("Total number of digits in the circumference is: " + (circumferenceLength - 1));
					System.out.println("Total number of digits in the area is: " + (areaLength - 1) + "\n");
					break;
				} while (true);
			}

			// If the user selects Rectangles.
			
			if (userChoice.equals("Rectangles")){
				System.out.print("Rectangles selected. Please enter the 2 sides: ");

				do {
					double side1 = input.nextDouble();
					double side2 = input.nextDouble();

					if (side1 < 0 || side2 < 0){
						System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
						continue;
					}

					// Calculating the perimeter and the area of the rectangle.
					
					double area = side1 * side2;
					double perimeter = (side1 + side2) * 2;
					int areaLength = Double.toString(area).length();
					int perimeterLength = Double.toString(perimeter).length();

					System.out.println("The area is: " + area);
					System.out.println("The perimeter is: " + perimeter);
					System.out.println("Total number of digits in the area is: " + (areaLength - 1));
					System.out.println("Total number of digits in the perimeter is: " + (perimeterLength - 1) + "\n");
					break;
				} while (true);
			} 

			// If the user selects Triangles.
			
			if (userChoice.equals("Triangles")){
				System.out.print("Triangles selected. Please enter the 3 sides: ");

				do {
					double side1 = input.nextDouble();
					double side2 = input.nextDouble();
					double side3 = input.nextDouble();

					if (side1 < 0 || side2 < 0 || side3 < 0){
						System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
						continue;
					}
					if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1){
						System.out.println("#ERROR Triangle is not valid. Returning to menu." + "\n");
						break;
					}

					// Calculating the perimeter and the area of the triangle and verifying if it is equilateral, isosceles or scalene.

					if (side1 == side2 && side1 == side3){
						System.out.println("The triangle is: Equilateral");
					}
					else if ((side1 == side2 && side1 != side3) || (side1 == side3 && side1 != side2) || (side2 == side3 && side2 != side1)){
						System.out.println("The triangle is: Isosceles");
					}
					else {
						System.out.println("The triangle is: Scalene");
					}

					double s = (side1 + side2 + side3)/2;
					double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
					double perimeter = side1 + side2 + side3;
					int perimeterLength = Double.toString(perimeter).length();
					int areaLength = Double.toString(area).length();

					System.out.println("The perimeter is: " + perimeter);
					System.out.println("The area is: " + area);
					System.out.println("Total number of digits in the perimeter is: " + (perimeterLength - 1));
					System.out.println("Total number of digits in the area is: " + (areaLength - 1) + "\n");
					break;
				} while(true);
			}

			// If the user selects Exit.

			if (userChoice.equals("Exit")){
				System.out.print("Terminating the program. Have a nice day!");
				System.exit(0);
			}

		} while (!userChoice.equals("Exit"));

	}
}
