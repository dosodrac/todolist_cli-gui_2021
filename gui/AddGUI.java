import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class AddGUI extends GUI {
    //add labels initiated
    JLabel titleLabel;
    JLabel dueDateLabel;
    JLabel catLabel;
    JLabel prioLabel;
    JLabel statLabel;

    //add text fields initiated
    JTextField titleTxtField;
    JTextField dueDateTxtField;

    //add combo boxes initiated
    JComboBox catComboBox;
    JComboBox prioComboBox;
    JComboBox statComboBox;

    //add button initiated
    JButton submitBttn;

    public AddGUI(){
        this.setTitle("Add GUI"); //changes the frame title extended from GUI
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //pressing the X at teh frame will not close it as a precaution to lose unsaved data

        frameTitle.setText("Please enter the todo details"); //changes the title label extended from GUI
        titleLabel = new JLabel("Enter title", SwingConstants.RIGHT);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1; //x location of the label
        c.gridy = 2; //y location of the label
        this.add(titleLabel, c);

        titleTxtField = new JTextField(20); //text field where the user inputs the to-do title
        titleTxtField.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 2;
        this.add(titleTxtField, c);

        dueDateLabel = new JLabel("Enter due date as YYYY-MM-DDTHH:MM", SwingConstants.RIGHT);
        c.gridx = 1; //x location of the label
        c.gridy = 3; //y location of the label
        this.add(dueDateLabel, c);

        dueDateTxtField = new JTextField(20);
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
        c.gridx = 2;
        c.gridy = 5;
        catComboBox.setLayout(null);
        catComboBox.setVisible(true);
        this.add(prioComboBox, c);

        statLabel = new JLabel("Select status", SwingConstants.RIGHT);
        c.gridx = 1; //x location of the label
        c.gridy = 6; //y location of the label
        this.add(statLabel, c);

        statComboBox = new JComboBox(Status.values());
        c.gridx = 2;
        c.gridy = 6;
        catComboBox.setLayout(null);
        catComboBox.setVisible(true);
        this.add(statComboBox, c);

        submitBttn = new JButton("Submit");
        submitBttn.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2; //x location of the button
        c.gridy = 7; //y location of the button
        c.gridwidth = 2;
        this.add(submitBttn, c);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
                String title;
                LocalDateTime due;
                Category cat;
                Importance importance;
                Status status;

        if (ae.getSource() == submitBttn) {
            if ((titleTxtField.getText().isEmpty() || dueDateTxtField.getText().isEmpty())){ // if statement to prevent adding an incomplete to-do
                JOptionPane.showMessageDialog(AddGUI.this, "Please fill in all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                title = titleTxtField.getText();
                cat = (Category) catComboBox.getSelectedItem();
                importance = (Importance) prioComboBox.getSelectedItem();
                status = (Status) statComboBox.getSelectedItem();
                try{ // try and catch to double check if the due date input follows the correct format
                    due = LocalDateTime.parse(dueDateTxtField.getText());
                    Main.guiCLi.addTodos(title, due, cat, importance, status); //to-do added
                    Main.guiCLi.saveToFile();//to-do saved to file.txt
                    JOptionPane.showMessageDialog(AddGUI.this, "New todo added!");
                    this.dispose();
                    JFrame listGUI = new ListGUI();
                } catch (DateTimeException e){
                    JOptionPane.showMessageDialog(AddGUI.this, "Please follow the date format provided.");
                }
            }
        } else if (ae.getSource() == addBttn){
            // nothing happens
        } else {
            this.dispose();
            new ListGUI();
        }
    }
}
