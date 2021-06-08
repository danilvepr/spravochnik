//package ru.vsu;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import ru.vsu.model.abonent;
//
//import javax.swing.*;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.transaction.Transactional;
//import java.awt.*;
//
//@Component
//public class gui {
//    private DefaultListModel<abonent> listModel = new DefaultListModel<>();
//    private GridBagConstraints gbc;
//    JList<abonent> list;
//    Manager yprav;
//    @Autowired
//    public gui(Manager yprav) {
//        this.yprav = yprav;
//    }
//    public void sozdat() {
//        JFrame frame = new JFrame("Телефонный справочник");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(710, 350);
//        for (abonent chelovec : yprav.abonen()) {
//            listModel.add(listModel.getSize(), chelovec);
//        }
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridBagLayout());
//        list = new JList<>(listModel);
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        panel.add(new JScrollPane(list), gbc);
//        JTextField spoisk = new JTextField();
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.weighty = 1;
//        gbc.weightx= 1;
//        gbc.fill=GridBagConstraints.HORIZONTAL;
//        panel.add(spoisk, gbc);
//        spoisk.getDocument().addDocumentListener(new DocumentListener() {
//            public void insertUpdate(DocumentEvent e) {
//                poisk(spoisk.getText());
//            }
//            public void removeUpdate(DocumentEvent e) {
//                poisk(spoisk.getText());
//            }
//            public void changedUpdate(DocumentEvent e) {
//                poisk(spoisk.getText());
//            }
//        });
//        JButton button1 = new JButton("Добавить абонента");
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        panel.add(button1, gbc);
//        button1.addActionListener(e -> {
//            add();
//        });
//        JButton button2 = new JButton("Изменить");
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        panel.add(button2, gbc);
//        button2.addActionListener(e -> {
//            izmen(listModel.get(list.getSelectedIndex()).gid());
//        });
//        JButton button = new JButton("Удалить абонента ");
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        panel.add(button, gbc);
//        button.addActionListener(e -> {
//            delet(listModel.get(list.getSelectedIndex()).gid());
//        });
//        frame.setLocationRelativeTo(null);
//        frame.setContentPane(panel);
//        frame.setVisible(true);
//    }
//    public void add() {
//        JFrame frame = new JFrame("Добавить");
//        frame.setLayout(new GridLayout(6, 1));
//        JTextField surname = new JTextField("");
//        frame.getContentPane().add(new JLabel("Фамилия:"));
//        frame.getContentPane().add(surname);
//        JTextField name = new JTextField("");
//        frame.getContentPane().add(new JLabel("Имя:"));
//        frame.getContentPane().add(name);
//        JTextField telefon1 = new JTextField("");
//        frame.getContentPane().add(new JLabel("Телефон 1:"));
//        frame.getContentPane().add(telefon1);
//        JTextField telefon2 = new JTextField("");
//        frame.getContentPane().add(new JLabel("Телефон 2:"));
//        frame.getContentPane().add(telefon2);
//        JTextField telefon3 = new JTextField("");
//        frame.getContentPane().add(new JLabel("Телефон 3:"));
//        frame.getContentPane().add(telefon3);
//        JButton button = new JButton("Добавить");
//        frame.getContentPane().add(button);
//        button.addActionListener(e -> {
//            int size = yprav.abonen().size();
//            yprav.add(new abonent(size,
//                    surname.getText(),
//                    name.getText(),
//                    telefon1.getText(),
//                    telefon2.getText(),
//                    telefon3.getText()));
//            obnov();
//            frame.setVisible(false);
//        });
//        frame.setSize(200,200);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    public void izmen(int id) {
//        JFrame frame = new JFrame("Изменение");
//        frame.setLayout(new BorderLayout());
//        frame.setLayout(new GridLayout(6, 1));
//        abonent chelovec = yprav.chel(id);
//        JTextField surname = new JTextField(chelovec.gsurname());
//        frame.getContentPane().add(new JLabel("Фамилия:"));
//        frame.getContentPane().add(surname);
//        JTextField name = new JTextField(chelovec.gname());
//        frame.getContentPane().add(new JLabel("Имя:"));
//        frame.getContentPane().add(name);
//        JTextField telefon1 = new JTextField(chelovec.gtelefon1());
//        frame.getContentPane().add(new JLabel("Телефон 1:"));
//        frame.getContentPane().add(telefon1);
//        JTextField telefon2 = new JTextField(chelovec.gtelefon2());
//        frame.getContentPane().add(new JLabel("Телефон 2:"));
//        frame.getContentPane().add(telefon2);
//        JTextField telefon3 = new JTextField(chelovec.gtelefon3());
//        frame.getContentPane().add(new JLabel("Телефон 3:"));
//        frame.getContentPane().add(telefon3);
//        JButton button = new JButton("Изменить");
//        frame.getContentPane().add(button);
//        button.addActionListener(e -> {
//            abonent c = new abonent(id,surname.getText(),name.getText(),telefon1.getText(),telefon2.getText(),telefon3.getText());
//            yprav.edit(id, c);
//            obnov();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(false);
//        });
//        frame.setSize(200,200);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    public void delet(int id) {
//        yprav.delete(id);
//        listModel.remove(list.getSelectedIndex());
//    }
//
//    public void obnov() {
//        listModel.removeAllElements();
//        for (abonent chelovec : yprav.abonen()) {
//            listModel.add(listModel.getSize(), chelovec);
//        }
//    }
//
//    public void poisk(String str) {
//        listModel.removeAllElements();
//        for (abonent chelovec : yprav.poisk(str)) {
//            listModel.add(listModel.getSize(), chelovec);
//        }
//    }
//}