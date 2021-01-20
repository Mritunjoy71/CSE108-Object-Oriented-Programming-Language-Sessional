/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class LogMonitor {
   public static void main(String[] args) throws IOException {
       int num,temp;
       ServerSocket s1=new ServerSocket(3600);
       Socket ss=s1.accept();
       
       Scanner sc=new Scanner(ss.getInputStream());
       num=sc.nextInt();
       temp=num*2;
       PrintStream p=new PrintStream(ss.getOutputStream());
       p.println(temp);
       
       

        
        }
    
   }

