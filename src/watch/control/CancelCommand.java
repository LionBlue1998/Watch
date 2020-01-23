package watch.control;

import javax.swing.JTextField;
import watch.model.Watch;
import watch.presenter.WatchPresenter;

public class CancelCommand implements Command {

    private final WatchPresenter watchPresenter;
    private final Watch watch;
    
    public CancelCommand(WatchPresenter watchPresenter, Watch watch) {
        this.watchPresenter = watchPresenter;
        this.watch = watch;
    }

    @Override
    public void toExecute(JTextField hours, JTextField minutes) {
        hours.setText("");
        minutes.setText("");
    }
    
}
