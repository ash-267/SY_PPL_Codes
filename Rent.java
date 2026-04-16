import java.util.Scanner;
class Vehicle {
	protected String Brand, Model;
	protected float rentalCharge;
	
	public Vehicle (String Brd, String Mdl, float chrg) {
		Brand = Brd;
		Model = Mdl;
		rentalCharge = chrg;
	}
	
	public float calculateRent (int days) {
		return rentalCharge*days;
	}
	
	public void display () {
		System.out.println("Displaying vehicle info: ");
		System.out.println("Brand: " + Brand);
		System.out.println("Model: " + Model);
		System.out.println("Rent (per day): " + rentalCharge);
		
	}
}
class Car extends Vehicle {
	public Car (String Brd, String Mdl) {
		super(Brd, Mdl, 5000);
	}
	
	public float calculateRent (int days) {
		System.out.println("Total charge: " + days*rentalCharge + "\n");
		return rentalCharge*days;
	}
	public void Display () {
		System.out.println("Displaying vehicle info: ");
		System.out.println("Brand: " + this.Brand);
		System.out.println("Model: " + this.Model);
		System.out.println("Rent (per day): " + this.rentalCharge);
	}
}
class Bike extends Vehicle {
	public Bike (String Brd, String Mdl) {
		super(Brd, Mdl, 3500);
	}
	
	public float calculateRent (int days) {
		System.out.println("Total charge: " + days*rentalCharge + "\n");
		return rentalCharge*days;
	}
	public void Display () {
		System.out.println("Displaying vehicle info: ");
		System.out.println("Brand: " + this.Brand);
		System.out.println("Model: " + this.Model);
		System.out.println("Rent (per day): " + this.rentalCharge);
	}
}
class Van extends Vehicle {
	public Van (String Brd, String Mdl) {
		super(Brd, Mdl, 10000);
	}
	
	public float calculateRent (int days) {
		System.out.println("Total charge: " + days*rentalCharge + "\n");
		return rentalCharge*days;
	}
	public void Display () {
		System.out.println("Displaying vehicle info: ");
		System.out.println("Brand: " + this.Brand);
		System.out.println("Model: " + this.Model);
		System.out.println("Rent (per day): " + this.rentalCharge);
	}
}
class Truck extends Vehicle {
	public Truck (String Brd, String Mdl) {
		super(Brd, Mdl, 25000);
	}
	
	public float calculateRent (int days) {
		System.out.println("Total charge: " + days*rentalCharge + "\n");
		return rentalCharge*days;
	}
	public void Display () {
		System.out.println("Displaying vehicle info: ");
		System.out.println("Brand: " + this.Brand);
		System.out.println("Model: " + this.Model);
		System.out.println("Rent (per day): " + this.rentalCharge);
	}
}
class Rent {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vehicle rental System!");
		int choice = 0;
		
		do {
			System.out.print("Enter type of vehicle:\n 1. Car\n 2. Bike\n 3. Van\n 4. Truck\n 5. Exit\nChoice (number expected): ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1: {
					System.out.println("Enter car info to acquire rental info");
					System.out.print("Enter Brand name: ");
					String Brand = scanner.nextLine();
					System.out.print("Enter model name: ");
					String Model = scanner.nextLine();
					Car C1 = new Car(Brand, Model);
					System.out.println("Enter number of days you wish to rent the vehicle: ");
					int days = scanner.nextInt();
					C1.Display();
					C1.calculateRent(days);
					break;
				}
				case 2: {
					System.out.println("Enter car info to acquire rental info");
					System.out.print("Enter Brand name: ");
					String Brand = scanner.nextLine();
					System.out.print("Enter model name: ");
					String Model = scanner.nextLine();
					Bike B1 = new Bike(Brand, Model);
					System.out.println("Enter number of days you wish to rent the vehicle: ");
					int days = scanner.nextInt();
					B1.Display();
					B1.calculateRent(days);
					break;
				}
				case 3: {
					System.out.println("Enter car info to acquire rental info");
					System.out.print("Enter Brand name: ");
					String Brand = scanner.nextLine();
					System.out.print("Enter model name: ");
					String Model = scanner.nextLine();
					Van V1 = new Van(Brand, Model);
					System.out.println("Enter number of days you wish to rent the vehicle: ");
					int days = scanner.nextInt();
					V1.Display();
					V1.calculateRent(days);
					break;
				}
				case 4: {
					System.out.println("Enter car info to acquire rental info");
					System.out.print("Enter Brand name: ");
					String Brand = scanner.nextLine();
					System.out.print("Enter model name: ");
					String Model = scanner.nextLine();
					Truck T1 = new Truck(Brand, Model);
					System.out.println("Enter number of days you wish to rent the vehicle: ");
					int days = scanner.nextInt();
					T1.Display();
					T1.calculateRent(days);
					break;
				}
				case 5: {
					System.out.println("Exiting Program!");
					break;
				}
				default: {
					System.out.println("ERROR!!! Incorrect input!");
					break;
				}
			}
		} while (choice != 5);
		
	}
	
}
