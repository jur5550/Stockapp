package Observers;

/**
 * Created by Jur on 2-10-2017.
 */
public class AppleObserver extends StockObserver{
    public String stockName = "APPLE";

    public AppleObserver(String stockName,Subject stockGrabber) {
        super(stockName, stockGrabber);
    }

}
