package hello;

public class Task {

    private String name;
    private String executable;
    private String arguments;


    public Task(String name, String executable, String arguments) {
        this.name = name;
        this.executable = executable;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecutable() {
        return executable;
    }

    public void setExecutable(String executable) {
        this.executable = executable;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
}