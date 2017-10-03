import Observers.Observer;
import Observers.StockGrabber;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import Observers.*;
/**
 * Created by Jur on 2-10-2017.
 */
public class GetTheStock implements Runnable {

    public String stock;
    public double price;
    public String Subject;
    public StockGrabber stockGrabber;
    public GetTheStock(StockGrabber stockGrabber){
        this.stockGrabber = stockGrabber;
    }
    public void run()
    {
            stockGrabber.setAPPLEPrice(newPrice(stockGrabber.getAPPLEPrice()));
            stockGrabber.setGOOGLEPrice(newPrice(stockGrabber.getGOOGLEPrice()));
            stockGrabber.setIBMPrice(newPrice(stockGrabber.getIBMPrice()));
            stockGrabber.notifyObserver();
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e) {}
    }





    public double newPrice(double price)
    {
        double randNum = (Math.random() * (.1)) + .05;
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        price = (Double.valueOf(df.format(price + randNum)));

        return price;
    }
}
