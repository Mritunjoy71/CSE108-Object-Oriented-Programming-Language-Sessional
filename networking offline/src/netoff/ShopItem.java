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
public class ShopItem {

	private String name;
	private double sellingPricePerUnit;
	private double buyingPricePerUnit;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSellingPricePerUnit() {
		return sellingPricePerUnit;
	}
	public void setSellingPricePerUnit(double sellingPricePerUnit) {
		this.sellingPricePerUnit = sellingPricePerUnit;
	}
	public double getBuyingPricePerUnit() {
		return buyingPricePerUnit;
	}
	public void setBuyingPricePerUnit(double buyingPricePerUnit) {
		this.buyingPricePerUnit = buyingPricePerUnit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+buyingPricePerUnit+" "+ sellingPricePerUnit;
	}
	
}
