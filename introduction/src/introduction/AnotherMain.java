/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduction;

import java.util.Scanner;







/**
 *
 * @author user
 */
public class AnotherMain {
    
    public static void main(String[] args) {
        
        System.out.println("Another Main");
        
        
        
        Scanner in=new Scanner(System.in);
        
        int n=in.nextInt();
        
        int[] numbers=new int[n];
        
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();        
        }
        
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        
        System.out.println("");
        
        
        
        
        
    }
    
}
