import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SendMessage implements ActionListener {

    private JTextArea textArea;
    private JTextField messageArea;

    public SendMessage(JTextArea textArea, JTextField messageArea) {
        this.textArea = textArea;
        this.messageArea = messageArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent component = (JComponent) e.getSource();
        String val = e.getActionCommand();

        textArea.append(new Date() + ": " + val + "\n");
        messageArea.setText("");
    }
}
