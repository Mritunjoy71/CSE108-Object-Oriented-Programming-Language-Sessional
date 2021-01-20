package offline;



class ShopItem{
    private String name ;
    private double sellingPricePerUnit=0;
    private double buyingPricePerUnit=0;
    int temp=0;

    public void setName(int type){
        switch (type)
        {
            case 1:
                name = "Green Apple" ;
            case 2:
                name = "Red Apple" ;
            case 3:
                name = "Orange" ;
            case 4:
                name = "Canned Strawberries" ;
            case 5:
                name= "Packed Strawberries" ;
                
                
                
                
                
        }
                
       
    }
     public void setBuy(int type){
        switch(type)
        {
            case 1:
                 buyingPricePerUnit = 3 ;
                
            case 2:
                buyingPricePerUnit = 3 ;
                    
            case 3:
                 buyingPricePerUnit = 3 ;
            case 4:
                buyingPricePerUnit = 8 ;
            case 5:
                buyingPricePerUnit = 5;
            
        }
    }
    public void setSel(int type){
        switch(type){
            
            case 1:
                sellingPricePerUnit = 5 ;
            case 2:
                sellingPricePerUnit = 5 ;
            case 3:
                sellingPricePerUnit = 6 ;
            case 4:
                sellingPricePerUnit = 10;
            case 5:
                sellingPricePerUnit = 8 ;
        }
    }
                
                
                
      
    public void setTemp(int type){
        temp = type;
    }
    public String getName(){
        return name ;
    }

    public double getSellingPricePerUnit(){
        return sellingPricePerUnit ;
    }


    public double getBuyingPricePerUnit(){
        return buyingPricePerUnit ;
    }

    public int getTemp(){
        return temp ;
    }

    public String toString(){
        return name + " " + buyingPricePerUnit + " " + sellingPricePerUnit +"\n";
    }
}
interface Shop{
    void buy(int type,int amount);
    void sell(int type, int amount);
    LogEntry[] getLog();
    double getBalance() ;
    ShopItem[] getInventory() ;
}
class FruitShop implements Shop{
    private int buycount ;
    private int capacity ;
    private int current ;
    private int logcount;
    private double balance ;
    private LogEntry logEntry[] = new LogEntry[10] ;
    private ShopItem shopItem[] = new ShopItem[100] ;
    FruitShop(int m, double n){
        capacity = m;
        balance = n ;
        buycount= 0 ;
        current = 0 ;
        logcount = 0 ;
        
        for(int i=0;i<100;i++){
            shopItem[i] = new ShopItem() ;
        }

        for(int i=0;i<10;i++){
            logEntry[i] = new LogEntry() ;
        }
        
    }

    @Override
    public void buy(int type, int amount) {
        ShopItem temp = new ShopItem();
        temp.setName(type);
        temp.setBuy(type);
        if(amount*temp.getBuyingPricePerUnit()>balance){
            System.out.println("Not enough balance");
        }

        else {
            if (amount <= capacity - current) {
                int i = 0 ;
                while (i<amount) {
                    shopItem[i+buycount].setName(type);
                    shopItem[i+buycount].setSel(type);
                    shopItem[i+buycount].setBuy(type);
                    shopItem[i+buycount].setTemp(type);
                    i++;
                }
                buycount += amount ;
                balance -= amount * temp.getBuyingPricePerUnit();
                current += amount;
                
            }
            if(amount>capacity-current) {
                System.out.println("Not enough space in inventory.");
            }
            else{
                
            }
            
        }
    }

    /*@Override
    public void sell(int type, int amount) {
        
        }
        
    }

    @Override
    public LogEntry[] getLog() {
        
    }
    @Override
    public double getBalance() {
        
    }

    @Override
    public ShopItem[] getInventory() {
        
}
class LogEntry{
    

}*/
public class Offline {

    public static void main(String[] args) {
        
        FruitShop fruitShop= new FruitShop(20, 60);
//System.out.println(fruitShop.getBalance());
fruitShop.buy(1, 20);
/*System.out.println(fruitShop.getBalance());
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
        }*/
       
        
    }
}
