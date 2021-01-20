/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadoffline;

/**
 *
 * @author Dell
 */
class ShopItem {

    private String name;
    private double sellingPricePerUnit = 0;
    private double buyingPricePerUnit = 0;
    int temp = 0;

    public void setName(int type) {
        switch (type) {
            case 1:
                name = "Green Apple";
            case 2:
                name = "Red Apple";
            case 3:
                name = "Orange";
            case 4:
                name = "Canned Strawberries";
            case 5:
                name = "Packed Strawberries";
        }
    }

    public void setBuy(int type) {
        switch (type) {
            case 1:
                buyingPricePerUnit = 3;

            case 2:
                buyingPricePerUnit = 3;

            case 3:
                buyingPricePerUnit = 3;
            case 4:
                buyingPricePerUnit = 8;
            case 5:
                buyingPricePerUnit = 5;

        }
    }

    public void setSel(int type) {
        switch (type) {

            case 1:
                sellingPricePerUnit = 5;
            case 2:
                sellingPricePerUnit = 5;
            case 3:
                sellingPricePerUnit = 6;
            case 4:
                sellingPricePerUnit = 10;
            case 5:
                sellingPricePerUnit = 8;
        }
    }

    public void setTemp(int type) {
        temp = type;
    }

    public String getName() {
        return name;
    }

    public double getSellingPricePerUnit() {
        return sellingPricePerUnit;
    }

    public double getBuyingPricePerUnit() {
        return buyingPricePerUnit;
    }

    public int getTemp() {
        return temp;
    }

    public String toString() {
        return name + " " + buyingPricePerUnit + " " + sellingPricePerUnit + "\n";
    }
}