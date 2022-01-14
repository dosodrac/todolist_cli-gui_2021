import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    //buttons initiated
    JButton listBttn;
    JButton addBttn;
    JButton updateBttn;
    JButton deleteBttn;

    //labels initiated
    JLabel frameTitle;
    JLabel infoLabel;

    //list initiated
    JList cList;
    DefaultListModel<Todo> todos;
    Todo selectedTodo; // stores the selected to-do
    GridBagConstraints c = new GridBagConstraints();

    GUI() {
        /* To-do Frame settings */
        this.setLocation(400,300);  //frame starting point at the center of the screen
        this.setSize(1000, 450);    //frame size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close the program when X is pressed
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        //constrains
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.4;

        /* Labels settings */
        frameTitle = new JLabel("Welcome to your Personal Assistant", SwingConstants.CENTER);
        frameTitle.setFont(new Font("Verdana", Font.BOLD, 14));
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; //x location of the button
        c.gridy = 0; //y location of the button
        c.gridwidth = 2;
        this.add(frameTitle, c);    //add the element to the frame with respective constrains

        infoLabel = new JLabel(" ", SwingConstants.CENTER);
        //c.fill = GridBagConstraints.BOTH; coder dcardoso
        c.gridx = 0; //x location of the label
        c.gridy = 1; //y location of the label
        this.add(infoLabel, c);
        c.gridwidth = 1;    //resets the grid width to 1

        /* Buttons settings */
        //list button
        listBttn = new JButton("List todos");
        listBttn.addActionListener(this);
        this.add(listBttn);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0; //x location of the button
        c.gridy = 2; //y location of the button
        this.add(listBttn, c);

        //add button
        addBttn = new JButton("Add todo");
        addBttn.addActionListener(this);
        this.add(addBttn);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;

        this.add(addBttn, c);

        //update button
        updateBttn = new JButton("Update todo");
        updateBttn.addActionListener(this);
        this.add(updateBttn);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        this.add(updateBttn, c);

        // delete button
        deleteBttn = new JButton("Delete todo");
        deleteBttn.addActionListener(this);
        this.add(deleteBttn);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        this.add(deleteBttn, c);
    }

    public void listTodos() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 4; // set height to match the 4 buttons
        c.gridwidth = 2;

        if (ae.getSource() == listBttn) {
            this.dispose(); // closes the current GUI
            JFrame listGUI = new ListGUI();

        } else if (ae.getSource() == addBttn) {
            this.dispose();
            JFrame addGUI = new AddGUI();

        } else if (ae.getSource() == updateBttn) {
            if (selectedTodo==null){
                infoLabel.setForeground(Color.red); // change the label color
                infoLabel.setText("HINT: Please select a todo to update and press the button again.");
            } else{
                this.dispose();
                JFrame upGUI = new UpdateGUI(selectedTodo);
            }

        } else {
            if (selectedTodo==null){
                infoLabel.setForeground(Color.red);
                infoLabel.setText("HINT: Please select a todo to delete and press the button again.");
            } else{ // opens a dialog box to confirm deletion
               int result = JOptionPane.showConfirmDialog(GUI.this, "Are you sure?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
               if( result == JOptionPane.YES_OPTION) {
                   Main.guiCLi.deleteTodo(selectedTodo);
                   Main.guiCLi.saveToFile();
               }
               this.dispose();
               JFrame listGUI = new ListGUI();
            }
        }
    }
}


