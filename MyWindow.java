package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JTextField field;
    private JTextArea jta;
    private JButton button;
    
    public MyWindow(){
        setTitle("Simple chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(100, 100, 400, 400));

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        jta = new JTextArea();
        jta.setLineWrap(true);
        jta.setEditable(false);
        jta.setBackground(new Color(232, 227, 254));
        JScrollPane jsp = new JScrollPane(jta);
        jp.add(jsp, BorderLayout.CENTER);

        JPanel bottomJp = new JPanel();
        bottomJp.setLayout(new BorderLayout());

        addTextField();
        bottomJp.add(field, BorderLayout.CENTER);

        addButton();
        bottomJp.add(button, BorderLayout.SOUTH);
        jp.add(bottomJp, BorderLayout.SOUTH);
        add(jp);

        setVisible(true);
        field.grabFocus();
    }

    private void addButton() {
        button = new JButton("Отправить");
        button.setBackground(new Color(156, 130, 183));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void addTextField() {
        field = new JTextField();
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        if(!field.getText().isEmpty()){
            jta.append(field.getText()+"\n");
            field.setText("");
            field.grabFocus();
        }
    }
}

