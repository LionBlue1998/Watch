package watch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import watch.presenter.Observer;

public class Watch {
    private double seconds = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double hours = Math.PI / 2;
    private List<Observer> observers = new ArrayList<>();

    public Watch() {
        Timer timer = new Timer();
        timer.schedule(task(), 0, 1000);
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    // no hay setSeconds porque carece de sentido //
    
    public void setMinutes(double n) {
        if (n <= 60){
            this.minutes = (Math.PI/2) - ((Math.PI/30) * n);
            notifyObservers();
        }
    }

    public void setHours(double n) {
        if (n <= 24){
            this.hours = (Math.PI/2) - ((Math.PI/6) * n);
            notifyObservers();
        }
    }

    private TimerTask task() {
        return new TimerTask() {
            private static final double PI2 = Math.PI * 2;
            private static final double DegreesPerSecond = PI2 / 60;
            private static final double DegreesPerMinute = DegreesPerSecond / 60;
            private static final double DegreesPerHour = DegreesPerMinute / 12;
            @Override
            public void run() {
                seconds = normalize(seconds - DegreesPerSecond);
                minutes = normalize(minutes - DegreesPerMinute);
                hours = normalize(hours - DegreesPerHour);
                notifyObservers();
            }
            
            public double normalize(double angle) {
                return (angle + PI2) % PI2;
            }

        };
    }

    public void add(Observer observer) {
        observers.add(observer);
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) 
            observer.update();
    }
    
    
}
