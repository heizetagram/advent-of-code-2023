package day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) {
        try {
            // Create new variables
            File myFile = new File("values.txt");
            Scanner scan = new Scanner(myFile);
            StringBuilder numbersConcat = new StringBuilder();
            ArrayList<String> numbersOnLine = new ArrayList<>();
            int sum = 0;


            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                // Loop through each character of a line
                for (int i = 0; i < data.length(); i++) {
                    char letter = data.charAt(i);
                    // Check if character is 0-9
                    for (int n = 0; n < 10; n++) {
                        if (Character.toString(letter).equals(Integer.toString(n))) {
                            // Concatenate each number
                            numbersOnLine.add(Integer.toString(n));
                            numbersConcat.append(n);
                        }
                    }
                }
                // Reset
                numbersConcat.setLength(0);

                // Concatenate first and last number
                numbersConcat.append(numbersOnLine.getFirst());
                numbersConcat.append(numbersOnLine.getLast());

                // Get sum
                sum += Integer.parseInt(numbersConcat.toString());

                // Reset
                numbersOnLine.clear();
            }
            System.out.println(sum);
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
