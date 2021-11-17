
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyFrame extends JFrame {
    List<Person> person = new ArrayList<>();

    MyFrame() {
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("LogIn");
        this.setResizable(false);
        person.add(new Person("Pochelov", "255920"));
        person.add(new Person("Anton", "4482"));
        person.add(new Person("Tomas", "123354"));
        person.add(new Person("Przemek", "TTTTTT"));
        person.add(new Person("Mateo", "1870"));
        person.add(new Person("Anna", "9999"));
        person.add(new Person("Elizabeth", "qqqqqq"));
        person.add(new Person("Katherina", "45948"));
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 300);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);

        JTextField Name = new JTextField();
        Name.setBackground(Color.white);
        Name.setBounds(200, 50, 100, 25);

        JPasswordField password = new JPasswordField();
        password.setBackground(Color.white);
        password.setBounds(200, 100, 100, 25);

        JLabel labelID = new JLabel();
        labelID.setText("Name");
        labelID.setForeground(Color.black);
        labelID.setBounds(110, 30, 60, 60);

        JLabel labelPassword = new JLabel();
        labelPassword.setText("Password");
        labelID.setForeground(Color.black);
        labelPassword.setBounds(110, 90, 110, 60);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 190, 90, 40);
        loginButton.setBackground(Color.white);

        loginButton.addActionListener(e -> {

            for (Person person : person) {
                if (Objects.equals(Name.getText(), person.getLogin())) {
                    if (Objects.equals(String.valueOf(password.getPassword()), person.getPassword())) {
                        loginButton.setBackground(Color.green);
                    } else
                        loginButton.setBackground(Color.red);
                } else if (Objects.equals(String.valueOf(password.getPassword()), person.getPassword())) {
                    if (Objects.equals(Name.getText(), person.getLogin())) {
                        loginButton.setBackground(Color.green);
                    } else
                        loginButton.setBackground(Color.red);
                }
            }
        });
        JButton cancelButton = new JButton("Clear");
        cancelButton.setBounds(200, 250, 90, 40);
        cancelButton.setBackground(Color.white);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Name.setText("");
                password.setText("");
                loginButton.setBackground(Color.white);
            }

        });
        this.setVisible(true);
        panel.add(Name);
        panel.add(password);
        panel.add(labelID);
        panel.add(labelPassword);
        panel.add(loginButton);
        panel.add(cancelButton);
        this.add(panel);
    }

}

