public class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
    }

    // Add at the end 
    public static Task addTask(Task head, Task newTask) {
        if (head == null) {
            return newTask;
        }
        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newTask;
        return head;
    }

    // Search taskId
    public static Task searchTask(Task head, int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print tasks
    public static void traverseTasks(Task head) {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Delete task by taskId
    public static Task deleteTask(Task head, int taskId) {
        if (head == null) {
            return null;
        }
        if (head.taskId == taskId) {
            return head.next;
        }
        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == taskId) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Task taskList = null;

        Task task1 = new Task(1, "Task 1", "Pending");
        Task task2 = new Task(2, "Task 2", "Completed");
        Task task3 = new Task(3, "Task 3", "In Progress");

        taskList = Task.addTask(taskList, task1);
        taskList = Task.addTask(taskList, task2);
        taskList = Task.addTask(taskList, task3);

        System.out.println("All Tasks:");
        Task.traverseTasks(taskList);

        System.out.println("\nSearching for Task with ID 2:");
        Task foundTask = Task.searchTask(taskList, 2);
        if (foundTask != null) {
            System.out.println(foundTask);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 2:");
        taskList = Task.deleteTask(taskList, 2);
        System.out.println("All Tasks after deletion:");
        Task.traverseTasks(taskList);
    }
}
