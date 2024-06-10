import java.util.ArrayList;
import java.util.List;

public class Youtube implements Subject {

    List<Observer> subscribers = new ArrayList<>();
    @Override
    public void subScribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void newVideoUpload() {
        for(Observer observer : subscribers){
            observer.getNotified();
        }
    }
    
}
