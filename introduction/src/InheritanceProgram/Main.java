/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceProgram;

/**
 *
 * @author user
 */
public class Main {
    
    public static SuperHuman[] getRandom(){
        SuperHuman []superhumans=new SuperHuman[10];
        
        for(int i=0;i<superhumans.length;i++){
            if(Math.random()>0.5){
                superhumans[i]=new Batman();
            }
            else{
                superhumans[i]=new Superman();
            }
        }
        
        return superhumans;
        
    }
    
    public static void main(String[] args) {
        
        SuperHuman []superhuman=getRandom();
        
        for(int i=0;i<superhuman.length;i++){
            superhuman[i].print();
        }
        
        
        
        /*
        SuperHuman normal=new SuperHuman();          
        Batman bruceWayne=new Batman();
        Superman clarkKent=new Superman();
        
        
        
        
        SuperHuman p1=new Batman();
        SuperHuman p2=new Superman();
        
        p1.print();
        p2.print();
        */
        
        
        
        
        
        
    }

    
    
}
