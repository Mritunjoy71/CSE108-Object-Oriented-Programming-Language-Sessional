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
public class Strawberries extends ShopItem{

	boolean isCanned;
	
	public Strawberries(boolean isCanned) {
		// TODO Auto-generated constructor stub
		
		this.isCanned=isCanned;
		if(isCanned){
			setName("Canned Strawberries");
			setBuyingPricePerUnit(8);
			setSellingPricePerUnit(10);
		}
		else
		{
			setName("Packed Strawberries");
			setBuyingPricePerUnit(5);
			setSellingPricePerUnit(8);
		}
	}
	
}
