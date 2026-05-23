package calanch.todoapplication.Service;

import calanch.todoapplication.Entity.Task;
import calanch.todoapplication.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findByTaskId(id);
    }

    @Override
    public Task updateTask(Task task, Long id) {
        Task task1 = taskRepository.findByTaskId(id);
        if(task.getTaskTitle() != null){
            task1.setTaskTitle(task.getTaskTitle());
        }
        if(task.getTaskDescription() != null){
            task1.setTaskDescription(task.getTaskDescription());
        }
        return taskRepository.save(task1);
    }

    @Override
    public String deleteTask(Long id) {
         taskRepository.deleteById(id);
         return "Task Deleted";
    }
}
