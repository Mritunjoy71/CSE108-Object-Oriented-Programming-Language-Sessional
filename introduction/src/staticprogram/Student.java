/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticprogram;

/**
 *
 * @author user
 */
public class Student {
    public int id;
    public String name;
    public static int counter=1;
    
    Student(String stdName){
        name=stdName;
        id=counter;
        counter++;
    }
    
    public void printInfo(){    
        System.out.println(id+" : "+name);
    }
    
}
