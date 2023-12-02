package day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) {
        try {
            File myFile = new File("values.txt");
            Scanner scan = new Scanner(myFile);
            int sum = 0;

            StringBuilder numbersConcat = new StringBuilder();
            ArrayList<String> numbersOnLine = new ArrayList<>();

            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                for (int i = 0; i < data.length(); i++) {
                    char letter = data.charAt(i);
                    for (int n = 0; n < 10; n++) {
                        if (Character.toString(letter).equals(Integer.toString(n))) {
                            numbersOnLine.add(Integer.toString(n));
                            numbersConcat.append(n);
                        }
                    }
                }
                numbersConcat.setLength(0);
                numbersConcat.append(numbersOnLine.getFirst());
                numbersConcat.append(numbersOnLine.getLast());

                sum += Integer.parseInt(numbersConcat.toString());
                numbersOnLine.clear();
            }
            System.out.println(sum);
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
