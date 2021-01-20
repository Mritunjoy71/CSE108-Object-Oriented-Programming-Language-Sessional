/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticprogram;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    
    public static void doSomething(Student temp){
        temp.id=5;
    }
    
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        String name=in.next();        
        String anotherName=in.next();
        
        //name.equals("abc");
        
        if(name.compareTo(anotherName)==0){
            System.out.println("Equal");
        }
        else{
            System.out.println("Not");
        }
        
        /*
        Student.counter=5;
        
        Student obj1=new Student("Arif");
        Student obj2=new Student("Rakib");
        Student obj3=new Student("Shaheen");
        
        
        obj1.printInfo();
        obj2.printInfo();
        obj3.printInfo();
        
        
        System.out.println(obj1.counter);
        obj2.counter=10;
        System.out.println(obj1.counter);
        
        */
        
        
  //      Student[] students=new Student[5];
        
       /* Student obj=new Student("Azad");
        
        obj.printInfo();
        
        doSomething(obj);        
        
        obj.printInfo();
        */
        
    
        
        
        
        
        
        /*
        Student obj2;        
        obj.printInfo();        
        obj2=obj;        
        obj2.id=1;        
        obj.printInfo();
        */
        
        
        
        
        
    }
}
