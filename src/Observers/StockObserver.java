package Observers;



public class StockObserver implements Observer {
    
    private double price;
    private String stockName;
    private Subject subject;
    private double oldPrice;
    
    // static used as a counter
    private static int observerIDTracker = 0;
    
    // to track the observers
    private int observerID;
    
    // a reference to concrete subject
    private Subject stockGrabber;
    
    public StockObserver(String stockName, Subject stockGrabber){
        setStockName(stockName);
        setStockGrabber(stockGrabber);
        setObserverID(++observerIDTracker);
        stockGrabber.register(this);
        System.out.println(String.format("New Observer: %s", this));
    }
    
    // update all observers
    public void update(double price) {
        //StockGrabber test = (StockGrabber)stock.getUpdate(this);

        setPrice(price);

        printThePrice();
    }
    public void setPrice(double price) {
        this.oldPrice = this.price;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    private Subject getStockGrabber() {
        return stockGrabber;
    }
    private void setStockGrabber(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
    }
    private int getObserverID() {
        return observerID;
    }

    private void setObserverID(int observerID) {
        this.observerID = observerID;
    }
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public void printThePrice(){

        System.out.println(String.format("Observer Update: %s \t Old Price: %s \t New Price: %s", this, oldPrice, price));

    }
    public void setSubject(Subject subject) {
        this.subject=subject;
    }
}
