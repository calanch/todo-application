package calanch.todoapplication.Service;

import calanch.todoapplication.Entity.Task;

import java.util.List;

public interface TaskService {
    public Task addTask(Task task);
    public List<Task> getAllTask();
    public Task getTask(Long id);
    public Task updateTask(Task task, Long id);
    public String deleteTask(Long id);
}
