/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadoffline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;





interface Shop {

    void buy(int type, int amount);

    boolean sell(int type, int amount);

    LogEntry[] getLog();

    double getBalance();

    ShopItem[] getInventory();
}

class FruitShop implements Shop {

    private int buycount;
    private int capacity;
    private int current;
    private int logcount;
    private double balance;
    private LogEntry logEntry[] = new LogEntry[10];
    private ShopItem shopItem[] = new ShopItem[100];

    FruitShop(int m, double n) {
        capacity = m;
        balance = n;
        buycount = 0;
        current = 0;
        logcount = 0;

        for (int i = 0; i < 100; i++) {
            shopItem[i] = new ShopItem();
        }

        for (int i = 0; i < 10; i++) {
            logEntry[i] = new LogEntry();
        }

    }

    @Override
    public synchronized void buy(int type, int amount) {
        ShopItem temp = new ShopItem();
        temp.setName(type);
        temp.setBuy(type);
        if (amount * temp.getBuyingPricePerUnit() > balance) {
            System.out.println("Not enough balance");
        } else {
            if (amount <= capacity - current) {
                int i = 0;
                while (i < amount) {
                    shopItem[i + buycount].setName(type);
                    shopItem[i + buycount].setSel(type);
                    shopItem[i + buycount].setBuy(type);
                    shopItem[i + buycount].setTemp(type);
                    i++;
                }
                buycount += amount;
                balance -= amount * temp.getBuyingPricePerUnit();
                current += amount;
                

            }
            if (amount > capacity - current) {
                System.out.println("Not enough space in inventory.");
            }

        }
    }

    @Override
    public synchronized boolean sell(int type, int amount) {
        ShopItem shopItem1[] = new ShopItem[buycount];
        ShopItem temp = new ShopItem();
        int index1 = 0;
        int index2= 0;
        
        int j = 0;
        int i = 0;
        temp.setName(type);
        temp.setTemp(type);
        temp.setSel(type);
        
        do{
                shopItem1[i] = new ShopItem();
                i++;
        }while(i < buycount);
        
        boolean Enough = false;
        i = 0;
        int count = 0;
        do{
                if (shopItem[i].getTemp() == temp.getTemp()) {
                count++;
                if (count == amount) {
                    Enough = true;
                    break;
                }
            }
            i++;
        }while(i < buycount);

        if (Enough ==true) {
            i = 0;
            do{
                 if (shopItem[i].getTemp() == type) {
                    index1 = i;
                    index2= index1 + amount - 1;
                    break;
                }
                i++;
            }while(i < buycount);
            if (index1 == 0) {
                j = 0;
                i = index2;
                do{
                    shopItem1[j++] = shopItem[i];
                    i++;
                }while(i < buycount - 1);
            } else {
                i = 0;
                do  {
                     shopItem1[j++] = shopItem[i];
                     i++;
                }while(i < index1);
                i = index2;
                do {
                    shopItem1[j++] = shopItem[i];
                    i++;
                }while(i < buycount - 1);
            }
            current = j;
            
            buycount = j;
            
            
            System.out.println(index1 + " " + index2);
            balance += amount * temp.getSellingPricePerUnit();
            logEntry[logcount].setItemName(temp.getName());
            logEntry[logcount].setAmountUnit(amount);
            logEntry[logcount].bs("sold");
            logcount++;
            return true;
        } else {
            System.out.printf("Not Enough Amount");
            return false;
        }
    }

    @Override
    public LogEntry[] getLog() {
        LogEntry resultant[] = new LogEntry[logcount];
        int i = 0;
        while (i < logcount) {
            resultant[i] = logEntry[i];
            i++;
        }
        return resultant;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public ShopItem[] getInventory() {
        ShopItem resultant[] = new ShopItem[buycount];
        int i = 0;
        do {
            resultant[i] = shopItem[i];
            i++;
        }while(i < buycount);
        return resultant;
    }
}

class LogEntry {
    private String itemName;
    private int amountUnit;
    private String borS;

    String timestamp = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy").format(new Date());
    

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setAmountUnit(int amountUnit) {
        this.amountUnit = amountUnit;
    }

    public void bs(String a) {
        borS = a;
    }

    public String toString() {
        return timestamp + " " + itemName + " " + amountUnit + " " + borS + "\n";
    }

}

/*public class Threadoffline {

    public static void main(String[] args) {
        
        FruitShop fruitShop= new FruitShop(20, 60);
System.out.println(fruitShop.getBalance());
fruitShop.buy(1, 20);
System.out.println(fruitShop.getBalance());
fruitShop.sell(1, 5);
System.out.println(fruitShop.getBalance());
fruitShop.buy(4, 5);
fruitShop.buy(4, 10);
fruitShop.sell(4, 5);
fruitShop.sell(1, 15);
fruitShop.buy(3, 10);
fruitShop.buy(4, 2);
fruitShop.buy(5, 3);
fruitShop.sell(4,1);
System.out.println(fruitShop.getBalance());
for(ShopItem shopItem: fruitShop.getInventory()){
            System.out.println(shopItem.toString());
        }

        for(LogEntry logEntry: fruitShop.getLog()){
            System.out.println(logEntry.toString());
        }
    }
}*/
public class SalesmanThread extends Thread {

    FruitShop fruitShop;
    int salesmanIndex;
    String fileName = "input";
    Thread t;

    public SalesmanThread(FruitShop fs, int salesnamIndex) {
        fruitShop = fs;
        salesmanIndex = salesmanIndex;
        t=new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        if (salesmanIndex == 1) {
            try {
                sc = new Scanner(new File("src/input1.txt"));
                Thread.sleep(30);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if (salesmanIndex == 2) {
            try {
                sc = new Scanner(new File("src/input2.txt"));
                Thread.sleep(20);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else {
            try {
                sc = new Scanner(new File("src/input3.txt"));
                Thread.sleep(40);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SalesmanThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        int n = sc.nextInt();
        System.out.println(n);
        int choice, type, amount;
        for (int i = 0; i < n; i++) {
            choice = sc.nextInt();
            if (choice == 1) {
                type = sc.nextInt();
                amount = sc.nextInt();
                fruitShop.buy(type, amount);
               // System.out.println(choice + " " + type + " " + amount);
            } else if (choice == 2) {
                type = sc.nextInt();
                amount = sc.nextInt();
                fruitShop.sell(type,amount);
                
                if(fruitShop.sell(type,amount)==false){
                fruitShop.buy(type, amount);
                fruitShop.sell(type, amount);
            }
                //System.out.println(choice + " " + type + " " + amount);
            } else if (choice == 3) {
                fruitShop.getBalance();
                //System.out.println(choice);
            }

        }
    }
    public static void main(String[] args) {
		FruitShop fs=new FruitShop(20, 500);
                //SalesmanThread salesmanThread=new SalesmanThread(fs,1);
		
		SalesmanThread salesmanThread[]=new SalesmanThread[3];
		
		for (int i = 0; i < salesmanThread.length; i++) {
			salesmanThread[i]= new SalesmanThread(fs,i+1);
			salesmanThread[i].start();
		}
                try {
                        salesmanThread[1].t.join();
                        salesmanThread[1].t.join();
                        salesmanThread[1].t.join();
                      
                } catch(InterruptedException e) {
                    System.out.println("Interrupted");
}
               
		
				
		for (ShopItem s : fs.getInventory()) {
			System.out.println(s);
		}
	}
}



