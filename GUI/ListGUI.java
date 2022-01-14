import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListGUI extends GUI implements ListSelectionListener {
    public ListGUI() {
        this.setTitle("List GUI");  //changes the frame title extended from GUI

        if (CLIMenu.todos.size() == 0) { //checks if the arrayList is empty
            infoLabel.setText("There are no todos saved.");
        } else {
            /* ScrollPane settings */
            infoLabel.setText("Here are all the listed todos:");
            todos = new DefaultListModel();
            todos.addAll(CLIMenu.todos);
            cList = new JList<Todo>(todos); //passing to-dos as arguments
            cList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //gets the selected to-do
            cList.addListSelectionListener(this); //listens for the selected to-do
            JScrollPane cScroll = new JScrollPane(cList); //Scroller to allow navigate through a big list
            c.gridx = 1;
            c.gridy = 2;
            c.gridheight = 4;   //set height to match the 4 buttons
            c.gridwidth = 1;
            cScroll.setSize(new Dimension(600, 200));
            this.add(cScroll, c);   //add the element to the frame
            listBttn.setSelected(true);
        }
        this.setVisible(true);  //set the frame visible
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        selectedTodo = (Todo) cList.getSelectedValue();
    }
}

