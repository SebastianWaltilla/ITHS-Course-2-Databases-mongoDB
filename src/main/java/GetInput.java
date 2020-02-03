package main.java;
import java.util.Scanner;

public class GetInput {

    static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        try {
            return  scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "invalid input";
        }
    }

    public static int getInt() {
        try {
           return Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            return 0;
        }
    }

    public static double getInputDouble() {
        try{
            return Double.parseDouble(scanner.nextLine());
         } catch (Exception e) {
            return 0;
        }
    }
}
