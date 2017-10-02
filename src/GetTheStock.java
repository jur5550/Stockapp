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

        for(StockObserver observer : stockGrabber.observers){
            double randNum = (Math.random() * (.1)) + .05;
            DecimalFormat df = new DecimalFormat("#.##");
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            System.out.println(observer.getPrice());

            price = (Double.valueOf(df.format((observer.getPrice() + randNum))));
            System.out.println(price);
            observer.setPrice(price);
            //observer.update(stockGrabber.getPrice());
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }



    }
}
