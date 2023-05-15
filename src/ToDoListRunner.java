import java.util.Scanner;

public class ToDoListRunner {

    public static void main(String[] args) {
        System.out.println("Witaj w TODO liście.");
        System.out.println("Wprowadź operację w formacie: operacja;nazwa;deadline;priorytet");
        System.out.println("Jeżeli chcesz zakończyć program, wpisz: koniec");

        ToDoList toDoList = new ToDoList();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();

            if (command.equals("koniec")) {
                break;
            }

            String[] split = command.split(";");
            String operation = split[0];
            switch (operation) {
                case "new" -> toDoList.add(split);
                case "edit" -> toDoList.edit(split);
                case "delete" -> toDoList.delete(split[1]);
                case "read_all" -> toDoList.readall();
                case "deadline_count" -> toDoList.deadlineCount();
            }
        }
    }
}
