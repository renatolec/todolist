package task;

public enum Status{
    TODO("Para fazer"), DOING("Em andamento"), DONE("Concluída");

    private String status;
    Status(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static Status getStatus(String status){
        if(status.equals("Para fazer"))
            return Status.TODO;
        if(status.equals("Em andamento"))
            return Status.DOING;
        return Status.DONE;
    }
}
