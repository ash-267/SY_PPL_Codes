import java.util.Scanner;

class Find {
	public static void main (String args[]) {
		System.out.println("Qs. 1: Finding the missing number");
		Calc L1 = new Calc();
		
		System.out.println("Checking for missing numbers");
		L1.find_no();
		
		/*System.out.println("\nQs. 2: Finding the largest and smallest number");
		SandLnum S1 = new SandLnum();
		S1.input();
		S1.SnL();*/
		
		System.out.println("\nQs. 3: Searching (Linear Search)");
		Search A1 = new Search();
		A1.input();
	}
};

class Calc {
	int[] sequence = {1, 2, 3, 5};
	int n=3;
	
	public int exp_Sum () {
		int sum = 0;
		int no = sequence[n];
		sum = (no*(no+1))/2;
		return sum;
	}
	
	public int act_sum () {
		int a_sum = 0;
		for (int i=0; i<=n; i++) {
			a_sum += sequence[i];
		}
		return a_sum;
	}
	
	public void find_no () {
		int diff = 0;
		System.out.println("The expected sum of all elements must be: " + exp_Sum());
		System.out.println("The expected sum of all elements must be: " + act_sum());
		System.out.println("Hence the missing number is = " + (exp_Sum() - act_sum()));
	}
}

class SandLnum {
	int[] arr;
	int n;
	
	public void input () {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		n = scanner.nextInt();
		arr = new int[n];
		System.out.println("Enter " + n + " numbers:");
		for (int i=0; i<n; i++) {
			arr[i] = scanner.nextInt();
		}
	}
	
	public int smallest_num () {
		int min = arr[0];
		for (int i=1; i<n; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public int largest_num () {
		int max = arr[0];
		for (int i=1; i<n; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public void SnL () {
		System.out.println("Smallest number in list is: " + smallest_num());
		System.out.println("Largest number in list is: " + largest_num());
	}
}

class Search {
	int[] arr;
	int n, s;
	
	public void input () {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		n = scanner.nextInt();
		arr = new int[n];
		System.out.println("Enter " + n + " numbers:");
		for (int i=0; i<n; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.print("Input the number you wish to search: ");
		s = scanner.nextInt();
		if (fnd() != -1) {
			System.out.println("The number " + s + " is present at " + fnd());
		} else {
			System.out.println("Not found");
		}
	}
	
	public int fnd () {
		int found = -1;
		for (int i=0; i<n; i++) {
			if (s == arr[i]) {
				found = i;
			} else {
				found = -1;
			}
		}
		return found;
	}
}

