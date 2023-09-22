package task;

public enum Priority {
    LOW("Baixa"), MEDIUM("Média"), HIGH("Alta");

    private String priority;
    Priority(String priority){
        this.priority = priority;
    }

    @Override
    public String toString() {
        return priority;
    }

    public static Priority getPriority(String priority){
        if(priority.equals("Baixa"))
            return Priority.LOW;
        if(priority.equals("Média"))
            return Priority.MEDIUM;
        return Priority.HIGH;
    }
}
