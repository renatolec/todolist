package task;

import java.util.*;
public class TaskList {

    NavigableSet<Task> tasks;
    List<Task> tasksOrderedBy;
    public TaskList() {
        tasks = new TreeSet<>();
        tasksOrderedBy = new ArrayList<>(32);
    }

    public boolean add(Task task){
        if(tasks.add(task))
            return tasksOrderedBy.add(task);
        return false;
    }

    public boolean delete(Task task){
        return tasks.remove(task);
    }

    public Task find(String title){
        Task temp = Task.getTask(title, "", "Baixa", "Para fazer");
        Task taskFound = tasks.floor(temp);
        if(taskFound == null){
            return null;
        }
        else if(temp.compareTo(taskFound) == 0){
            return taskFound;
        }
        return null;
    }

    public List<Task> sortBy(String attribute){
        if(attribute.equals("Prioridade"))
            tasksOrderedBy.sort(Comparator.comparing(Task::getPriority).reversed().thenComparing(Task::getTitle));
        else if(attribute.equals("Andamento"))
            tasksOrderedBy.sort(Comparator.comparing(Task::getStatus).reversed().thenComparing(Task::getTitle));
        else
            tasksOrderedBy.sort(Comparator.comparing(Task::getTitle));
        return new ArrayList<>(tasksOrderedBy);
    }

}
