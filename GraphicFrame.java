import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class GraphicFrame extends JFrame {
    public GraphicFrame(){
        setTitle("Chat");
        setBounds(new Rectangle(50,50,600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        add(top, BorderLayout.NORTH);
        top.setLayout(new BorderLayout());

        JPanel center = new JPanel();
        add(center, BorderLayout.CENTER);
        center.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        center.add(textArea, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(sayAboutOrExit());
        top.add(menuBar);

        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(new BorderLayout());

        JTextField  messageArea = new JTextField();
        bottom.add(messageArea, BorderLayout.CENTER);

        JButton submitBtn = new JButton("SEND");
        bottom.add(submitBtn, BorderLayout.EAST);

        ActionListener sendMessage = new SendMessage(textArea, messageArea);
        submitBtn.addActionListener(sendMessage);
        messageArea.addActionListener(sendMessage);

//        submitBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.append(new Date() + ": " +  sendMessage.sendMessage(messageArea.getText()) + "\n");
//                messageArea.setText("");
//            }
//        });

        setVisible(true);
    }

    private JMenu sayAboutOrExit(){
        JMenu program = new JMenu("Program");
        JMenuItem about = new JMenuItem("About");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new MenuBarAction(exit));

        program.add(about);
        program.add(exit);

        return program;
    }
}
