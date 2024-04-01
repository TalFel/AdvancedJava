import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class TextJframe {
    final int MAX_CHARS = 438;
    final int FRAME_SIZE = 300;
    private JTextArea textArea1;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextPane textPane1;
    private JPanel Jpanel;
    private JFrame frame;

    public TextJframe(int day, CalendarHelper helper) {
        textPane1.setText(day +  ", " + helper.getMonthYear());
        //textPane1.setAlignmentX();
        textArea1.setLineWrap(true);
        //JScrollPane areaScrollPane = new JScrollPane(textArea1);
        textArea1.setText(helper.getTextFromMap(day));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helper.updateMap(day, textArea1.getText());
                close();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        frame = new JFrame("calendar");
        frame.setContentPane(this.Jpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setResizable(false);
        frame.setVisible(true);
        textArea1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(textArea1.getText().length() > MAX_CHARS){
                    textArea1.setText(textArea1.getText().substring(0, MAX_CHARS));
                }
            }
        });
    }
    public void close(){
        frame.dispose();
    }
}
