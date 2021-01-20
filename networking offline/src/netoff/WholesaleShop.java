/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;

import java.util.Date;

public class WholesaleShop extends FruitShop{

	public WholesaleShop(int capacity, double balance) {
		super(capacity, balance);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void buy(int type, int amount) {
		// TODO Auto-generated method stub
		
		if(amount<1000){
			System.out.println("Invalid buy operation.");
		}
		else if (amount%1000!=0){
			System.out.println("Invalid buy operation.");
		}
		else{
			
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
					
					
					
					this.si[inventoryCount]=si;
					inventoryCount++;
					balance-=si.getBuyingPricePerUnit();
					
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
				
			}	
			
		}
	}
	
	
	@Override
	public void sell(int type, int amount) {
		// TODO Auto-generated method stub
		
		if(amount<500){
			System.out.println("I am a wholesaler. I don't sell less than 500 items.");
		}
		else if (amount%500!=0){
			System.out.println("I am a wholesaler. I only sell in chunks of 500 items.");
		}
		else{
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
				System.out.println("Not enough amount in the inventory. "
						+ "Trying to buy required amount.");
				buy(type, amount-availableAmount);
			}
			availableAmount=0;
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
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		WholesaleShop wholesaleShop= new WholesaleShop(5000, 20000);
		
		System.out.println(wholesaleShop.getBalance());
		wholesaleShop.buy(1, 6000);
		wholesaleShop.buy(1, 100);
		wholesaleShop.buy(1, 1005);
		wholesaleShop.buy(1, 2000);
		System.out.println(wholesaleShop.getBalance());
		wholesaleShop.sell(1, 1000);
		System.out.println(wholesaleShop.getBalance());
		wholesaleShop.buy(3, 3000);
		System.out.println(wholesaleShop.getBalance());
		wholesaleShop.sell(3, 15000);
		wholesaleShop.sell(3, 4000);
		System.out.println(wholesaleShop.getBalance());
		
		
	}

}

