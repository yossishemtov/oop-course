package tree;

/*class-ReversedWords will help to calculate same pair of words in one line.
 *one is original and one is the opposite of the other.*/
import java.util.Scanner;


public class ReversedWords {
	

	
    public static int checkReversed() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int count = 0;
        Node root = new Node();
        
        // read input from user until "X" is entered
        while (scanner.hasNext()) {
            input = scanner.next();
            if (input.equals("X")) {
                break;
            }
            String reversed = reverseString(input);
            if (root.num(reversed) > 0) {
                count++;
            }
            root.add(input);
        }
        scanner.close();
        return count;
    }
    
    private static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }
}

