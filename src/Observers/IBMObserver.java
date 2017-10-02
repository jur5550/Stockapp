package Observers;

/**
 * Created by Jur on 2-10-2017.
 */
public class IBMObserver extends StockObserver{
    public String stockName = "IBM";

    public IBMObserver(String stockName,Subject stockGrabber) {
        super(stockName, stockGrabber);
    }
}
