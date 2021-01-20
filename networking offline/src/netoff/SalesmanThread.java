/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class SalesmanThread extends Thread {

    FruitShop fruitShop;
    int salesmanIndex;
    String fileName = "input";

    public SalesmanThread(FruitShop fs, int salesnamIndex) {
        // TODO Auto-generated constructor stub

        fruitShop = fs;
        this.salesmanIndex = salesnamIndex;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        Scanner sc = null;
        try {
            sc = new Scanner(new File("src//" + fileName + salesmanIndex + ".txt"));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        int n = sc.nextInt();
        int choice, type, amount;
        for (int i = 0; i < n; i++) {
            choice = sc.nextInt();
            if (choice == 1) {
                type = sc.nextInt();
                amount = sc.nextInt();
                synchronized (fruitShop) {
                    System.out.println("Worker " + salesmanIndex + " is buying");
                    fruitShop.buy(type, amount);
                }
            } else if (choice == 2) {
                type = sc.nextInt();
                amount = sc.nextInt();

                try {
                    Random rnd = new Random();
                    int random = rnd.nextInt(10);
                    System.out.println(salesmanIndex + " " + random * 2);
                    sleep(random * 2 * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                synchronized (fruitShop) {
                    System.out.println("Worker " + salesmanIndex + " is now selling.");
                    fruitShop.sell(type, amount);
                }

            } else if (choice == 3) {

                synchronized (this) {
                    System.out.println("Printing balance from salesperson " + salesmanIndex);
                    System.out.println(fruitShop.getBalance());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        FruitShop fs = new FruitShop(20, 70);

        SalesmanThread salesmanThread[] = new SalesmanThread[3];

        for (int i = 0; i < salesmanThread.length; i++) {
            salesmanThread[i] = new SalesmanThread(fs, i + 1);
            salesmanThread[i].start();
            int num, temp;
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 3600);
            Scanner sc1 = new Scanner(s.getInputStream());
            System.out.println("Enter any number");
            num = sc.nextInt();
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(num);
            temp = sc1.nextInt();
            System.out.println(temp);
        }

        int lastJoindeIndex = -1;
        for (int i = 0; i < salesmanThread.length; i++) {
            if (salesmanThread[i].isAlive()) {
                try {
                    lastJoindeIndex = i;
                    salesmanThread[i].join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Worker " + (lastJoindeIndex + 1) + " is closing the shop");

        /*for (ShopItem s: fs.getInventory()) {
			System.out.println(s);
		}*/
    }
}
