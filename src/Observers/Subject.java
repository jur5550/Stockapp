package Observers;

import Observers.Observer;

public interface Subject {
    
    public void register(StockObserver o);
    public void unregister(StockObserver o);
    public void notifyObserver();
    public Object getUpdate(StockObserver obj);
}
