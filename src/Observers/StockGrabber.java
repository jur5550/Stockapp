package Observers;

import Observers.Observer;
import Observers.Subject;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    public ArrayList<StockObserver> observers;
    private String message;
    private double price;

    private boolean changed;

    public StockGrabber(){
        // a list to hold all observers
        observers = new ArrayList<StockObserver>();
    }

    public void register(StockObserver newObserver)
    {
        if(!observers.contains(newObserver)) {
            observers.add(newObserver);
        }
    }

    public void unregister(StockObserver newObserver) {
        observers.remove(newObserver);

    }

    public void notifyObserver() {

        for(Observer observer : observers){
            observer.update(price);
        }
    }

@Override
    public Object getUpdate(StockObserver obj) {
        return this.message;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double newPrice){

        this.price = newPrice;
        notifyObserver();

    }
}
