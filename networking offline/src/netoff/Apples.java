/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netoff;

public class Apples extends ShopItem{

	boolean isGreen;
	
	Apples(boolean isGreen){
		this.isGreen=isGreen;
		setName("Apples");
		setBuyingPricePerUnit(3);
		setSellingPricePerUnit(5);
	}
	
}
