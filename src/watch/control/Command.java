package watch.control;

import javax.swing.JTextField;

public interface Command {
    
    /**
     * execute the command function
     * @param hours
     * @param minutes
     */
    public void toExecute(JTextField hours, JTextField minutes);
    
}
