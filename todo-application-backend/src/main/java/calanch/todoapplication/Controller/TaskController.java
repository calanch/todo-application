package calanch.todoapplication.Controller;

import calanch.todoapplication.Entity.Task;
import calanch.todoapplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getall")
    public List<Task> getAllTaskMapping() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getByTaskIdMapping(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping("/create")
    public Task createTaskMapping(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTaskMapping(@RequestBody Task task, @PathVariable Long id){
        return taskService.updateTask(task, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTaskMapping(@PathVariable Long id){
        return taskService.deleteTask(id);
    }

}
