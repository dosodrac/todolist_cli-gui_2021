import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class TodoGUI implements ActionListener {

//    JLabel tempLabel1;
//    JLabel tempLabel2;
//    JLabel tempLabel3;
//    JLabel tempLabel4;
//    JLabel tempLabel5;
//    JLabel tempLabel6;
//    JLabel tempLabel7;
//    JLabel tempLabel8;
    JButton bt1;
    JButton bt2;
    JButton bt3;
    JButton bt4;
    JButton bt5;
    //JTextField tempTxt;

    TodoGUI() {
        JFrame frm = new JFrame("Todo GUI");
        frm.setSize(400, 400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the program when X is pressed
        frm.setLocation(500,300); //window starting point position
        frm.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lab0 = new JLabel(" ");
        frm.add(lab0);
        lab0.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lab1 = new JLabel("Welcome to my Todo GUI");
        frm.add(lab1);
        lab1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lab2 = new JLabel("Select an option: ");
        frm.add(lab2);
        lab2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lab3 = new JLabel(" ");
        frm.add(lab3);
        lab3.setAlignmentX(Component.CENTER_ALIGNMENT);

        bt1 = new JButton("1. List todo");
        bt1.addActionListener(this);
        frm.add(bt1);
        bt1.setAlignmentX(Component.CENTER_ALIGNMENT);

        bt2 = new JButton("2. Add todo");
        bt2.addActionListener(this);
        frm.add(bt2);
        bt2.setAlignmentX(Component.CENTER_ALIGNMENT);

        bt3 = new JButton("3. Update todo");
        bt3.addActionListener(this);
        frm.add(bt3);
        bt3.setAlignmentX(Component.CENTER_ALIGNMENT);

        bt4 = new JButton("4. Delete todo");
        bt4.addActionListener(this);
        frm.add(bt4);
        bt4.setAlignmentX(Component.CENTER_ALIGNMENT);

        bt5 = new JButton("5. Quit");
        bt5.addActionListener(this);
        frm.add(bt5);
        bt5.setAlignmentX(Component.CENTER_ALIGNMENT);
        frm.setVisible(true);

        JLabel lab4 = new JLabel(" ");
        frm.add(lab4);
        lab4.setAlignmentX(Component.CENTER_ALIGNMENT);

//        tempLabel1 = new JLabel(" ");
//        frm.add(tempLabel1);
//        tempLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        tempLabel2 = new JLabel(" ");
//        frm.add(tempLabel2);
//        tempLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel2.setVisible(false);
//
//        tempLabel3 = new JLabel(" ");
//        frm.add(tempLabel3);
//        tempLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel3.setVisible(false);
//
//        tempLabel4 = new JLabel(" ");
//        frm.add(tempLabel4);
//        tempLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel4.setVisible(false);
//
//        tempLabel5 = new JLabel(" ");
//        frm.add(tempLabel5);
//        tempLabel5.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel5.setVisible(false);
//
//        tempLabel6 = new JLabel(" ");
//        frm.add(tempLabel6);
//        tempLabel6.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel6.setVisible(false);
//
//        tempLabel7 = new JLabel(" ");
//        frm.add(tempLabel7);
//        tempLabel7.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel7.setVisible(false);
//
//        tempLabel8 = new JLabel(" ");
//        frm.add(tempLabel8);
//        tempLabel8.setAlignmentX(Component.CENTER_ALIGNMENT);
//        tempLabel8.setVisible(false);


//        tempTxt = new JTextField(" ");
//        frm.add(tempTxt);
//        tempTxt.setAlignmentX(Component.CENTER_ALIGNMENT);


    }

//    public String enterTitle(){
//        tempLabel1.setText("Enter a title for the todo:");
//        String temp = tempTxt.getText();
//        return temp;
//    }
//
//    public LocalDateTime enterDate(){
//        tempLabel1.setText("Enter a due date for the todo in the format YYYY-MM-DDTHH:MM");
//        String temp = tempTxt.getText();
//        return LocalDateTime.parse(temp);
//    }
//
//    public Category enterCategory(){
//        tempLabel1.setText("Select a category");
//        tempLabel2.setVisible(true);
//        tempLabel3.setVisible(true);
//        tempLabel4.setVisible(true);
//        tempLabel5.setVisible(true);
//        tempLabel6.setVisible(true);
//        tempLabel7.setVisible(true);
//        tempLabel8.setVisible(true);
//        tempLabel2.setText("Select an item between 1 and 6 and press enter");
//        tempLabel3.setText("1. Red");
//        tempLabel4.setText("2. White");
//        tempLabel5.setText("3. Blue");
//        tempLabel6.setText("4. Purple");
//        tempLabel7.setText("5. Yellow");
//        tempLabel8.setText("6. Green");
//        int temp = Integer.parseInt(tempTxt.getText());
//
//        if ((temp > 0) && (temp < 7)){
//            Category [] cats = Category.values();
//            return cats[temp-1];
//        }
//        else{tempLabel2.setVisible(false);
//            tempLabel3.setVisible(false);
//            tempLabel4.setVisible(false);
//            tempLabel5.setVisible(false);
//            tempLabel6.setVisible(false);
//            tempLabel7.setVisible(false);
//            tempLabel8.setVisible(false);
//            tempLabel1.setText("Invalid selection. Try again!");
//            return enterCategory();
//        }
//    }
//
//    public Importance enterPriority(){
//        tempLabel1.setText("Select a priority");
//        tempLabel2.setVisible(true);
//        tempLabel3.setVisible(true);
//        tempLabel4.setVisible(true);
//        tempLabel5.setVisible(true);
//        tempLabel2.setText("Select an item between 1 and 3 and press enter");
//        tempLabel3.setText("1. Low");
//        tempLabel4.setText("2. Medium");
//        tempLabel5.setText("3. High");
//        int temp = Integer.parseInt(tempTxt.getText());
//
//        if ((temp > 0) && (temp < 4)){
//            Importance [] impt = Importance.values();
//            return impt[temp-1];
//        }
//        else{tempLabel2.setVisible(false);
//            tempLabel3.setVisible(false);
//            tempLabel4.setVisible(false);
//            tempLabel5.setVisible(false);
//            tempLabel1.setText("Invalid selection. Try again!");
//            return enterPriority();
//        }
//    }
//
//    public void actionPerformed(ActionEvent ae){
//
//        if(ae.getSource () == bt1){ //listTodos
//            if(CLIMenu.todos.size() != 0) {
//                for (int i = 0; i < CLIMenu.todos.size(); i++) {
//                    tempLabel1.setText((i + 1) + ": " + CLIMenu.todos.get(i));
//                }
//            }else {
//                tempLabel1.setText("There are no todos saved.");
//            }
//        }
//        else if(ae.getSource () == bt2){ //addTodos
//            String title = enterTitle();
//            LocalDateTime date = enterDate();
//            Category category = enterCategory();
//            Importance importance = enterPriority();
//            CLIMenu.todos.add(new Todo(title,date,category,importance,Status.pending));
//        }
//        else if(ae.getSource () == bt3){ //updateTodo
//
//            tempLabel1.setText("Test3");
//        }
//        else if(ae.getSource () == bt4){ //deleteTodo
//
//            tempLabel1.setText("Test4");
//        }
//        else if(ae.getSource () == bt5) {
//            System.exit(0); // close the program when pressed
//        }
//    }
}
