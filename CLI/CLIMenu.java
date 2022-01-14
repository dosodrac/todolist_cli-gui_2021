import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIMenu {

    ArrayList<Todo> todos = new ArrayList<>();

    //function addTodos
    public void addTodos(){
        String title = enterTitle();
        LocalDateTime date = enterDate();
        Category category = enterCategory();
        Importance importance = enterPriority();

        //title, due date,category,importance,status
        todos.add(new Todo(title,date,category,importance,Status.pending));
    }

    public void listTodos(){
        if(todos.size() != 0) {
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i + 1) + ": " + todos.get(i));
            }
        }else {
            System.out.println("There are no todos saved.");
        }
    }

        //function enterTitle
    public String enterTitle(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a title for the todo:");
        return in.nextLine();
    }

        //function enterDate
    public LocalDateTime enterDate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a due date for the todo in the format YYYY-MM-DDTHH:MM");
        try{
            return LocalDateTime.parse(in.next());
        } catch (DateTimeException e) {
            System.out.println("Invalid date format. Try again.");
            return enterDate();
        }
    }

        //function enterCategory
    public Category enterCategory(){

        Scanner in = new Scanner(System.in);
        System.out.println("Select a category");
        System.out.println("Select an item between 1 and 6 and press enter");
        System.out.println(Category.Red.getColour() + "1. Red"); // option will have the written colour
        System.out.println(Category.White.getColour() + "2. White");
        System.out.println(Category.Blue.getColour() + "3. Blue");
        System.out.println(Category.Purple.getColour() + "4. Purple");
        System.out.println(Category.Yellow.getColour() + "5. Yellow");
        System.out.println(Category.Green.getColour() + "6. Green" + "\033[0m"); // option will have the written colour + reset

        int cat = in.nextInt();

        if ((cat > 0) && (cat < 7)){
            Category [] cats = Category.values();
            return cats[cat-1];
        }
        else{
            System.out.println("Invalid selection. Try again!");
            return enterCategory();
        }
    }

        //function enterPriority
    public Importance enterPriority(){
        Scanner in = new Scanner(System.in);
        System.out.println("Select a priority");
        System.out.println("Select an item between 1 and 3 and press enter");
        System.out.println(Category.Green.getColour() + "1. Low");
        System.out.println(Category.Yellow.getColour() + "2. Normal");
        System.out.println(Category.Red.getColour() + "3. High" + "\033[0m");
        int pri = in.nextInt();

        if (pri > 0 && pri < 4){ // will return the importance according to the array index which starts at 0 and not 1
            Importance impt [] = Importance.values();
            return impt [pri- 1];
        }
        else{
            System.out.println("Invalid selection. Try again!");
            return enterPriority();
        }
    }

        //function enterStatus
    public Status enterStatus(){
        Scanner in = new Scanner(System.in);
        System.out.println("Select a category");
        System.out.println("Select an item between 1 and 6 and press enter");
        System.out.println("1. Pending");
        System.out.println("2. Status");
        System.out.println("3. Partial");
        System.out.println("4. Completed");
        int sta = in.nextInt();
        if (sta > 0 && sta < 5){
            Status status [] = Status.values();
            return status [sta - 1];
        }
        else{
            System.out.println("Invalid selection. Try again!");
            return enterStatus();
        }
    }

    //function update
    public void updateTodo(){

        Scanner in = new Scanner(System.in); // create a Scanner object
        listTodos();
        System.out.println("+----------------------------------------------+");
        System.out.println("Enter the number of the todo to be updated");
        int todo = in.nextInt()-1;
        System.out.println("Select an item between 1 and 5 and press enter");
        System.out.println("1. Title");
        System.out.println("2. Date");
        System.out.println("3. Category");
        System.out.println("4. Priority");
        System.out.println("5. Status");
        int up = in.nextInt();

        switch (up) {
            case 1:
                //title
                todos.get(todo).setText(enterTitle());
                break;

            case 2:
                //date
                todos.get(todo).setDue(enterDate());
                break;

            case 3:
                //category
                todos.get(todo).setCat(enterCategory());
                break;

            case 4:
                //priority
                todos.get(todo).setImportance(enterPriority());
                break;

            case 5:
                //status
                todos.get(todo).setCompletion(enterStatus());
                break;
        }
    }

    public void deleteTodo(){

        Scanner in = new Scanner(System.in); // create a Scanner object
        if(todos.size() !=0){
            listTodos();
            System.out.println("+----------------------------------------------+");
            System.out.println("Enter the number of the todo to be deleted");
            if(in.nextInt() < todos.size()+1) {
                int todo = in.nextInt() - 1;
                todos.remove(todo);
            }else{
                System.out.println("Invalid entry");
                deleteTodo();
            }
        }else{
            System.out.println("There are no todos to delete.");
        }
    }

    public CLIMenu(ArrayList<Todo> todos) {
        this.todos = todos;

        Scanner in = new Scanner(System.in); // create a Scanner object
        int n;

        do {
            System.out.println("+----------------------------------------------+");
            System.out.println("Select an item between 1 and 5 and press enter");
            System.out.println("1. List todo");
            System.out.println("2. Add todo");
            System.out.println("3. Update todo");
            System.out.println("4. Delete todo");
            System.out.println("5. Quit");

            n = in.nextInt();

            switch (n) {
                case 1:
                    //list all todos entered
                    listTodos();
                    break;

                case 2:
                    //call addTodo
                    addTodos();
                    break;

                case 3:
                    //updateTodo
                    updateTodo();
                    break;

                case 4:
                    deleteTodo();
                    break;

                case 5:
                    // quit the program
                    System.out.println("+----------------------------------------------+");
                    System.out.println("|     Closing the program. Have a great day!   |");
                    System.out.println("+----------------------------------------------+");
                    break;
            }
        } while ( n != 5); //User presses 5 to exits the menu
    }
}