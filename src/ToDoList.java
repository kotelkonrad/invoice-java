import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoList {
    List<ToDoItem> toDoItems = new ArrayList<>();

    void add(String[] args) {
        ToDoItem toDoItem = createToDoItem(args);
        toDoItems.add(toDoItem);
        System.out.println("Dodano zadanie: "+toDoItem.name);
    }
    void edit(String[] args) {
        ToDoItem toDoItem = createToDoItem(args);
        int index = findIndex(args[1]);
        if (index < 0) {
            System.out.println("Podano nieprawidłową nazwę zadania");
            return;
        }
        toDoItems.set(index, toDoItem);
        System.out.println("Zaktualizowano zadanie: "+ toDoItem.name);
    }
    void delete(String name) {
        int index = findIndex(name);
        if (index < 0) {
            System.out.println("Podano nieprawidłową nazwę zadania");
            return;
        }
        toDoItems.remove(index);
        System.out.println("Usunięto zadanie: " + name);
    }
    void readall() {
        System.out.println("Wszystkie zadania: ");
        for (ToDoItem toDoItem : toDoItems) {
            System.out.println(toDoItem);
        }

    }

    void deadlineCount() {
        Map<LocalDate, Integer> deadlineCount = new HashMap<>();
        for (ToDoItem toDoItem : toDoItems) {
            if (deadlineCount.get(toDoItem.deadline) == null) {
                deadlineCount.put(toDoItem.deadline, 1);
            } else {
                int oldCounter = deadlineCount.get(toDoItem.deadline);
                deadlineCount.put(toDoItem.deadline, oldCounter + 1);
            }
        }
        for (Map.Entry<LocalDate, Integer> entry : deadlineCount.entrySet()) {
            System.out.println("Deadline: [" + entry.getKey() + "], has: [" + entry.getValue() + "] items");
        }
    }

    ToDoItem createToDoItem(String[] input) {
        return new ToDoItem(input[1], LocalDate.parse(input[2]), Integer.parseInt(input[3]));
    }

    int findIndex(String name) {
        int expectedIndex = -1;
        for (int i = 0; i < toDoItems.size(); i++) {
            if (toDoItems.get(i).name.equals(name)) {
                expectedIndex = i;
                break;
            }
        }
        return expectedIndex;
    }
}
