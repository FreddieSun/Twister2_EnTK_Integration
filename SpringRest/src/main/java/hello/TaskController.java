package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/task")
    public Task task() {
        return new Task("demo", "/bin/echo",  "Hello World");
    }
}