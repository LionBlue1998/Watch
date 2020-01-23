package watch.control;

import watch.control.Command;
import javax.swing.JTextField;
import watch.model.Watch;
import watch.presenter.WatchPresenter;

public class OkCommand implements Command{
    
    private final WatchPresenter watchPresenter;
    private final Watch watch;
    
    public OkCommand(WatchPresenter watchPresenter, Watch watch) {
        this.watchPresenter = watchPresenter;
        this.watch = watch;
    }

    @Override
    public void toExecute(JTextField hours, JTextField minutes) {
        try{
            watch.setHours(Double.parseDouble(hours.getText()));
            watch.setMinutes(Double.parseDouble(minutes.getText()));
        }catch(NumberFormatException nfe){}
    }
    
}
