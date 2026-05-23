package calanch.todoapplication.Controller;

import calanch.todoapplication.Entity.Task;
import calanch.todoapplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getall")
    public ResponseEntity<List<Task>> getAllTaskMapping() {
        return ResponseEntity.status(200)
                .body(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getByTaskIdMapping(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(taskService.getTask(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTaskMapping(@RequestBody Task task) {
        return ResponseEntity.status(201)
                .body(taskService.addTask(task));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTaskMapping(@RequestBody Task task, @PathVariable Long id){
        return ResponseEntity.status(204)
                .body(taskService.updateTask(task, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaskMapping(@PathVariable Long id){
        return ResponseEntity.status(204)
                .body(taskService.deleteTask(id));
    }

}
