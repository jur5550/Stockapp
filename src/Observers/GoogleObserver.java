package Observers;

/**
 * Created by Jur on 2-10-2017.
 */
public class GoogleObserver extends StockObserver{
    public String stockName = "GOOGLE";

    public GoogleObserver(String stockName,Subject stockGrabber) {
        super(stockName, stockGrabber);
    }

    public void update(double ibmPrice, double aaplPrice, double googPrice)
    {


    }
    @Override
    public void setSubject(Subject sub) {

    }

}
