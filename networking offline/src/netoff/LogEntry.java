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
import java.util.Date;

public class LogEntry {

	double timeStamp;
	Date date;
	String name;
	int amount;
	boolean isBought;
	public LogEntry(Date d,String name, int amount, boolean soldOrBought) {
		super();
		this.date=d;
		this.name=name;
		this.amount = amount;
		this.isBought = soldOrBought;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return date+" "+name+" "+amount+" " + isBought ;		
	}
	
}
