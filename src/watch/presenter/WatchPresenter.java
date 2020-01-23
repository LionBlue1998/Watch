package watch.presenter;

import watch.model.Watch;
import watch.view.WatchDisplay;
import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class WatchPresenter implements Observer {
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watchDisplay = watchDisplay;
        this.watch.add(this);
    }

    @Override
    public void update() {
        watchDisplay.paint(points());
    }
    
    private Point[] points() {
        Point[] points = new Point[3];
        points[0] = pointAt(200, watch.getSeconds());
        points[1] = pointAt(150, watch.getMinutes());
        points[2] = pointAt(100, watch.getHours());
        return points;
    }

    private Point pointAt(int length, double angle) {
        return new Point((int) (length*cos(angle)), (int) (length*sin(angle)));
    }

    
    
    
    
    
    
}
