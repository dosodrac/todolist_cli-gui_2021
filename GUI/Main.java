import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Todo> todos = new ArrayList<>();
    static CLIMenu guiCLi = new CLIMenu(todos);

    public static void main(String[] args) {
//        local test todos
//        todos.add(new Todo("test", LocalDateTime.parse("2021-01-01T00:01"), Category.Blue, Importance.high, Status.pending));
//        todos.add(new Todo("test3", LocalDateTime.parse("2021-01-01T00:01"), Category.Red, Importance.high, Status.pending));
//        todos.add(new Todo("test2", LocalDateTime.parse("2021-01-01T00:01"), Category.Blue, Importance.high, Status.pending));
//        todos.add(new Todo("test5", LocalDateTime.parse("2021-01-01T00:01"), Category.Green, Importance.high, Status.pending));
//        todos.add(new Todo("test22", LocalDateTime.parse("2021-01-01T00:01"), Category.Yellow, Importance.high, Status.pending));
        guiCLi.filePersistence();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListGUI();
            }
        });
    }
}


