/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;

/**
 *
 * @author Dell
 */
public interface Shop {

	void buy(int type,int amount);
	
	void sell(int type,int amount);
	
	LogEntry[] getLog();
	
	ShopItem[] getInventory();
	
	double getBalance();
	
}