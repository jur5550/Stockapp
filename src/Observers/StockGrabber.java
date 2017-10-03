package Observers;

import Observers.Observer;
import Observers.Subject;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    public ArrayList<StockObserver> observers;
    private String message;
    private double GOOGLEPrice;
    private double APPLEPrice;
    private double IBMPrice;


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
            if(observer instanceof GoogleObserver)
            {
                observer.update(getGOOGLEPrice());
            }
            else if(observer instanceof AppleObserver)
            {
                observer.update(getAPPLEPrice());

            }
            else if(observer instanceof IBMObserver)
            {
                observer.update(getIBMPrice());

            }
        }
    }

@Override
    public Object getUpdate(StockObserver obj) {
        return this.message;
    }

    public double getGOOGLEPrice() {
        return GOOGLEPrice;
    }

    public double getAPPLEPrice() {
        return APPLEPrice;
    }

    public double getIBMPrice() {
        return IBMPrice;
    }

    public void setGOOGLEPrice(double GOOGLEPrice) {
        this.GOOGLEPrice = GOOGLEPrice;
    }

    public void setAPPLEPrice(double APPLEPrice) {
        this.APPLEPrice = APPLEPrice;
    }

    public void setIBMPrice(double IBMPrice) {
        this.IBMPrice = IBMPrice;
    }
}
