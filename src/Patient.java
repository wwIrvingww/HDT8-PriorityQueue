public class Patient {
    //Variables
    private String name;
    private String description;
    private String priority;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    //Constructor
    public Patient (String name, String description, String priority){
        this.name = name;
        this.description = description;
        this.priority = priority;
    }






}
