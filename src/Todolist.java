import scenes.MainPanel;
import task.TaskList;

import javax.swing.*;

public class Todolist extends JFrame {

    private TaskList taskManager;
    private MainPanel mainPanel;

    {
        taskManager = new TaskList();
        mainPanel = new MainPanel(taskManager);
    }
    public Todolist() {
        setVisible(true);
        setResizable(false);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        Todolist app = new Todolist();
    }

}
