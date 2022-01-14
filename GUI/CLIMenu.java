import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIMenu {

    static ArrayList<Todo> todos = new ArrayList<>();


    public boolean filePersistence(){   //method to load from file

        try{
            Scanner file = new Scanner(new File("todosfile.txt"));  //finding file path
            while (file.hasNextLine()) {    //loading all the todos to the arrayList
                String next = file.nextLine();
                String[] todoSpecs = next.split(", ");

                LocalDateTime date = LocalDateTime.parse(todoSpecs[1]);
                todos.add(new Todo(todoSpecs[0], date, Category.valueOf(todoSpecs[2]), Importance.valueOf(todoSpecs[3]), Status.valueOf(todoSpecs[4])));
            }
        }catch(FileNotFoundException e){
            return false;   //if file not found return false
        }
        return true;
    }

    public void saveToFile(){   //method to save to file when closing
        try{
            FileWriter writer = new FileWriter("todosfile.txt");    //empty file and save new arraylist
            writer.write("");

            for (Todo todo : todos) {
                writer.append("").append(todo.getText()).append(", ").append(String.valueOf(todo.getDue())).append(", ").append(String.valueOf(todo.getCat())).append(", ").append(String.valueOf(todo.getImportance())).append(", ").append(String.valueOf(todo.getCompletion())).append(System.lineSeparator());
            }
            writer.close();

        }catch(IOException ignored){}
    }

    //function addTodos
    public void  addTodos(String title, LocalDateTime date, Category category, Importance importance, Status status){
        todos.add(new Todo(title,date,category,importance,status));
    }


    //function update
    public void updateTodo(Todo todo, String title, LocalDateTime date, Category category, Importance importance, Status status){
        todo.setText(title);
        todo.setDue(date);
        todo.setCat(category);
        todo.setImportance(importance);
        todo.setCompletion(status);
    }

    //function delete
    public void deleteTodo(Todo todo){
        todos.remove(todo);
    }

    //Constructor
    public CLIMenu(ArrayList<Todo> todos) {
        this.todos = todos;
    }
}