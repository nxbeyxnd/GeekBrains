import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarAction implements ActionListener {

    private JMenuItem exit;

    public MenuBarAction(JMenuItem exit) {
        this.exit = exit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
