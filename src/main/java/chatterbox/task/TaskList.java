package chatterbox.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTasks(int index) {
        assert index >= 0 && index < tasks.size() : "index out of the limit";
        return tasks.get(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addTag(int index, String tag) {   
        tasks.get(index).setTag(tag);
        
    }

    public void removeTask(int index) {
        assert index >= 0 && index < tasks.size() : "index out of the limit";
        tasks.remove(index);
    }

    public int getSize() {
        return tasks.size();
    }

}
