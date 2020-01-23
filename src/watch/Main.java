package watch;
import watch.presenter.WatchPresenter;
import watch.model.Watch;
import watch.view.WatchDisplay;
import watch.control.OkCommand;
import watch.control.Command;
import watch.control.CancelCommand;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {
    
    private final Map<String,Command> commands = new HashMap<>();
    private final JTextField hoursField;
    private final JTextField minutesField;

    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        init();
        
        hoursField = new JTextField(2);
        minutesField = new JTextField(2);
        
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        
        commands.put("  Ok  ", new OkCommand(watchPresenter, watch));
        commands.put("Cancel", new CancelCommand(watchPresenter, watch));
        
        add(watchDisplay, BorderLayout.CENTER);
        add(toolbar(), BorderLayout.SOUTH);
        repaint();
    }
    
    public final JPanel toolbar(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.lightGray);
        
        panel.add(createButton("  Ok  "));
        panel.add(hoursField);
        panel.add(minutesField);
        panel.add(createButton("Cancel"));
        
        return panel;
    }
    
    private JButton createButton(String name) {
        JButton button = new JButton(name);
        if ("  Ok  ".equals(name)) button.setBackground(Color.green);
        if ("Cancel".equals(name)) button.setBackground(Color.red);
        button.setForeground(Color.white);
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException{
                commands.get(name).toExecute(hoursField, minutesField);
            }
        });
        return button;
    }
    
    private void execute() {
        setVisible(true);
    }

    private void init() {
        setTitle("Watch");
        setSize(600,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
