//intento de array dinamico

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        int[] history = {0,0,0,0,0,0};
        int total = 0;
        int counter = 0;
        int start = 1;
        
        while (start > 0) {            
            
        System.out.println("[TOTAL = " + total + "]");
        System.out.print("HISTORY = {");
        for (int i = 0; i < history.length; i++){
            System.out.print(history[i]+ ",");
        }
            System.out.println("...0}");
        System.out.println("Ingrese un numero...");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        history[counter] = input;
        total = total + input;
        counter++;
        }
        
       
