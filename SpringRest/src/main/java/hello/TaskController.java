package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/task")
    public Task task() {
        Task task = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("/Users/weijiasun/Desktop/CommInfo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            task = (Task) in.readObject();
            System.out.print("task.getItr()" + task.getItr());
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Task not found");
            c.printStackTrace();
        }
        return task;
    }
}