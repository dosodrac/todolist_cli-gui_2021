import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class UpdateGUI extends GUI {
    //update labels initiated
    JLabel titleLabel;
    JLabel dueDateLabel;
    JLabel catLabel;
    JLabel prioLabel;
    JLabel statLabel;

    //update text fields initiated
    JTextField titleTxtField;
    JTextField dueDateTxtField;

    //update combo boxes initiated
    JComboBox catComboBox;
    JComboBox prioComboBox;
    JComboBox statComboBox;

    //update button initiated
    JButton updateBttn;

    public UpdateGUI(Todo todo) {
        this.setTitle("Update GUI");  //changes the frame title extended from GUI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //resets the X button on the frame to exit the program, since updateGUI extends from AddGUI here this is set as not closing
        selectedTodo = todo;
        frameTitle.setText("Please update the todo details");

        titleLabel = new JLabel("Enter title", SwingConstants.RIGHT);
        c.gridx = 1; //x location of the label
        c.gridy = 2; //y location of the label
        this.add(titleLabel, c);

        titleTxtField = new JTextField(20);
        titleTxtField.setText(todo.getText());
        titleTxtField.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 2;
        this.add(titleTxtField, c);

        dueDateLabel = new JLabel("Enter due date as YYYY-MM-DDTHH:MM", SwingConstants.RIGHT);
        c.gridx = 1;    //x location of the label
        c.gridy = 3;    //y location of the label
        this.add(dueDateLabel, c);

        dueDateTxtField = new JTextField(20);
        dueDateTxtField.setText(todo.getDue().toString());
        dueDateTxtField.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        this.add(dueDateTxtField, c);

        catLabel = new JLabel("Select category", SwingConstants.RIGHT);
        c.gridx = 1; //x location of the label
        c.gridy = 4; //y location of the label
        this.add(catLabel, c);

        catComboBox = new JComboBox(Category.values());
        catComboBox.setSelectedItem(todo.getCat());
        c.gridx = 2;
        c.gridy = 4;
        catComboBox.setLayout(null);
        catComboBox.setVisible(true);
        this.add(catComboBox, c);

        prioLabel = new JLabel("Select priority", SwingConstants.RIGHT);
        c.gridx = 1; //x location of the label
        c.gridy = 5; //y location of the label
        this.add(prioLabel, c);

        prioComboBox = new JComboBox(Importance.values());
        prioComboBox.setSelectedItem(todo.getImportance());
        c.gridx = 2;
        c.gridy = 5;
        catComboBox.setLayout(null);
        catComboBox.setVisible(true);
        this.add(prioComboBox, c);

        statLabel = new JLabel("Select status", SwingConstants.RIGHT);
        c.gridx = 1;    //x location of the label
        c.gridy = 6;    //y location of the label
        this.add(statLabel, c);

        statComboBox = new JComboBox(Status.values());
        statComboBox.setSelectedItem(todo.getCompletion());
        c.gridx = 2;
        c.gridy = 6;
        catComboBox.setLayout(null);
        catComboBox.setVisible(true);
        this.add(statComboBox, c);

        updateBttn = new JButton("Update");
        updateBttn.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;    //x location of the button
        c.gridy = 7;    //y location of the button
        c.gridwidth = 2;
        this.add(updateBttn, c);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String title;
        LocalDateTime due;
        Category cat;
        Importance importance;
        Status status;

        if (ae.getSource() == updateBttn) {
            if ((titleTxtField.getText().isEmpty() || dueDateTxtField.getText().isEmpty())) {     // if statement to prevent adding an incomplete to-do
                JOptionPane.showMessageDialog(UpdateGUI.this, "Please fill in all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                title = titleTxtField.getText();
                cat = (Category) catComboBox.getSelectedItem();
                importance = (Importance) prioComboBox.getSelectedItem();
                status = (Status) statComboBox.getSelectedItem();
                try {    //try and catch to double check if the due date input follows the correct format
                    due = LocalDateTime.parse(dueDateTxtField.getText());
                    Main.guiCLi.updateTodo(selectedTodo, title, due, cat, importance, status);
                    Main.guiCLi.saveToFile();
                    JOptionPane.showMessageDialog(UpdateGUI.this, "Todo updated!");
                    this.dispose();
                    JFrame listGUI = new ListGUI();
                } catch (DateTimeException e) {
                    JOptionPane.showMessageDialog(UpdateGUI.this, "Please follow the date format provided.");
                }
            }
        } else if (ae.getSource() == addBttn) {
            this.dispose();
            JFrame addGUI = new AddGUI();
        } else {
            this.dispose();
            JFrame listGUI = new ListGUI();
        }
    }
}