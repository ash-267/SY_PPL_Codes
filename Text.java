import java.util.Scanner;

class Text {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter strings for string operations:");
        System.out.print("Enter the string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the string: ");
        String str2 = scanner.nextLine();
        
        for (int i=1; i!=8;) {
            System.out.print("Enter the operation you wish to perform:\n 1. Convert to Uppercase\n 2. Convert to Lower case\n 3. Print reverse string\n 4. Compare strings\n");
            System.out.print(" 5. 1st letter of every word caps\n 6. Search and Replace \n 7. Extract digits \n 8. Exit\nChoice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Upper case string: " + str1.toUpperCase() + "\n");
                    break;
                }
                case 2: {
                    System.out.println("Lower case string: " + str1.toLowerCase() + "\n");
                    break;
                }
                case 3: {
                    String str = new StringBuilder(str1).reverse().toString();
                    System.out.println("Reverse string: " + str + "\n");
                    break;
                }
                case 4: {
                	if (str1.length() != str2.length()) {
                		System.out.println("Comparison of strings: the strings are not equal\n");
                    } else {
                        for (int k = 0; k < str1.length(); k++) {
                            if (str1.charAt(k) != str2.charAt(k)) {
                            	System.out.println("Comparison of strings: the strings are not equal\n");
                                break;
                            } else if ((k+1)==str1.length() && str1.charAt(k) == str2.charAt(k)) {
                            	System.out.println("Comparison of strings: the strings are equal\n");
                            }
                        }
                    }
                	break;
                }
                case 5: {
                    StringBuilder res = new StringBuilder();
                    String[] Words = str1.split(" ");
                    for (int j=0; j < Words.length; j++) {
                        String word = Words[j];
                        if (word.length() > 0) {
                            res.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
                        }
                    }
                    System.out.println("1st letter caps: " + res.toString().trim() + "\n");
                    break;
                }
                case 6: {
                	System.out.print("Enter substring to find: ");
                    String find = scanner.nextLine();
                    System.out.print("Enter replacement string: ");
                    String replace = scanner.nextLine();
                    
                    if (str1.contains(find)) {
                        String replacedString = str1.replace(find, replace);
                        System.out.println("Modified string: " + replacedString + "\n");
                    } else {
                        System.out.println("Substring not found in the original text.\n");
                    }
                    break;
                }
                case 7: {
                    StringBuilder digits = new StringBuilder();
                    for (int k = 0; k < str1.length(); k++) {
                        if (Character.isDigit(str1.charAt(k))) {
                            digits.append(str1.charAt(k));
                        }
                    }
                    System.out.println("Extracted digits: " + digits.toString() + "\n");
                    break;
                }
                case 8: {
                    System.out.println("Exiting program. Thank you!");
                    i=8;
                    break;
                }
            }
        }
    }
}

