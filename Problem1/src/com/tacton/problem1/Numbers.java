package com.tacton.problem1;

import java.util.Scanner;
public class Numbers {

    @SuppressWarnings("resource")
    public static void main(String args[]) {
 
        //input to print number series upto how many numbers
        System.out.print("Enter number for which the value is to be retreived: ");
        int number = new Scanner(System.in).nextInt();
        
        //printing the retrieved value
            System.out.print(NumberLoop(number) +" ");
    } 
 
    public static int NumberLoop(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int num1=1, num2=1, sum=1;
        for(int i= 3; i<= number; i++){
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
 
        }
        return sum; 
    }     
}
