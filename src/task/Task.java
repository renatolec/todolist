package task;

import java.util.Objects;

public class Task implements Comparable<Task>{

    private final String title;
    private String description;
    private Priority priority;
    private Status status;

    private Task(String title, String description, String priority, String status) {
        this.title = title;
        this.description = description;
        this.priority = Priority.getPriority(priority);
        this.status = Status.getStatus(status);
    }

    public static Task getTask(String title, String description, String priority, String status){
        if(title.isEmpty())
            return null;
        return new Task(title, description, priority, status);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = Priority.getPriority(priority);
    }

    public void setStatus(String status) {
        this.status = Status.getStatus(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "%s".formatted(title);
    }

    @Override
    public int compareTo(Task o) {
        return title.compareTo(o.title);
    }
}
