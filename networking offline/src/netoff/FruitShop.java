/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;

import java.util.Date;
import java.util.Scanner;

public class FruitShop implements Shop{

	double balance;
	
	ShopItem[] si;
	int inventoryCount,logCount;
	LogEntry[] log;
	
	@Override
	synchronized public void buy(int type, int amount) {
		// TODO Auto-generated method stub
		if(inventoryCount+amount>this.si.length){
			System.out.println("Not enough space in inventory.");
		}
		else {
			
			int i;
			ShopItem si=null;
			for (i = 0; i < amount; i++) {
				if(type==1)si=new Apples(false);
				else if (type==2) si= new Apples(true);
				else if (type==3) si= new Oranges();
				else if (type==4) si= new Strawberries(true);
				else  si= new Strawberries(false);
				
				
				synchronized (this) {
					this.si[inventoryCount]=si;
					inventoryCount++;
					balance-=si.getBuyingPricePerUnit();
				}
				
			}
			
			if(balance<0){
				System.out.println("Not enough balance");
				
				
					for(int j=inventoryCount-1;j>inventoryCount-amount-1;j--){
						balance+=this.si[j].getBuyingPricePerUnit();
						this.si[j]=null;
					}
					inventoryCount-=amount;
			}
			
			LogEntry logEntry= new LogEntry(new Date(),si.getName(), i, true);
			
				log[logCount]=logEntry;
				logCount++;
			
			
		}	
		
	}

	@Override
	synchronized public void sell(int type, int amount) {
		// TODO Auto-generated method stub
		
		String nameToCheck="";
		if(type==1 || type==2){
			nameToCheck="Apples";				
		}else if(type==3){
			nameToCheck="Oranges";
		}else if (type==4){
			nameToCheck="Canned Strawberries";
		}else if (type==5){
			nameToCheck="Packed Strawberreis";
		}
		
		
		int availableAmount=0;
		for (int i = 0; i < this.inventoryCount; i++) {
			if(si[i].getName().equals(nameToCheck))availableAmount++;
		}
		
		if(availableAmount<amount){
			System.out.println("Not enough Amount");
		}
		else{
			int totalSold=0;
			for (int i = 0; i < inventoryCount; i++) {
				if(si[i].getName().equals(nameToCheck)){
					balance+=si[i].getSellingPricePerUnit();
					si[i]=si[inventoryCount-1];
					si[inventoryCount-1]=null;
					i--;
					inventoryCount--;
					totalSold++;
				}
				if(totalSold==amount)break;
			}
			LogEntry logEntry= new LogEntry(new Date(),nameToCheck, amount, true);
			log[logCount]=logEntry;
			logCount++;
		}
		
	}

	@Override
	public LogEntry[] getLog() {
		// TODO Auto-generated method stub
		
		LogEntry[] newLogEntry= new LogEntry[logCount];
		
		for (int i = 0; i < newLogEntry.length; i++) {
			newLogEntry[i]=log[i];
		}
		
		return newLogEntry;
	}

	@Override
	public ShopItem[] getInventory() {
		// TODO Auto-generated method stub
		
		ShopItem[] newInventory= new ShopItem[inventoryCount];
		
		for (int i = 0; i < newInventory.length; i++) {
			newInventory[i]=this.si[i];
		}
		
		return newInventory;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public FruitShop(int capacity,double balance) {
		
		si= new ShopItem[capacity];
		this.balance= balance;
		inventoryCount=0;
		log=new LogEntry[100];
		logCount=0;
	}
	
	
	


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
        
        System.out.println("Generated Logs...");
        System.out.println("Time Stamp"+"\t"+"Name"+"\t"+"Amount"+"\t"+"BoughtOrSold");
        
        for (LogEntry logEntry : fruitShop.getLog()) {
            System.out.println(logEntry.toString());
        }
        
        
        System.out.println("Items in inventory...");
        System.out.println("Name"+" " +"Buying Price"+" " +"Selling Price");
        for (ShopItem shopItem : fruitShop.getInventory()) {
            System.out.println(shopItem.toString());
        }
    }

	
}
