import Observers.*;

import java.util.ArrayList;

// the Client
public class StockApp {
    public static void main(String[] args) {

        // create concrete subject
        StockGrabber stockGrabber = new StockGrabber();

        // create and register concrete observer
        StockObserver observer1 = new GoogleObserver("GOOGLE", stockGrabber);
        StockObserver observer2 = new AppleObserver("APPLE", stockGrabber);
        StockObserver observer3 = new IBMObserver("IBM", stockGrabber);

        stockGrabber.register(observer1);
        stockGrabber.register(observer2);
        stockGrabber.register(observer3);

        observer1.setPrice(197.00);
        observer2.setPrice(677.60);
        observer3.setPrice(676.40);
        observer1.printThePrice();
        observer2.printThePrice();
        observer3.printThePrice();
        GetTheStock getTheStock = new GetTheStock(stockGrabber);


        while (true) {

            getTheStock.run();
            stockGrabber.notifyObserver();
            for(StockObserver observer : stockGrabber.observers){
                observer.printThePrice();
            }
            try {
                Thread.sleep(2000);}
                catch(InterruptedException e){}

            }

        }

    }





