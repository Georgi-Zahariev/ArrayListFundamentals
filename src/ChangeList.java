import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //"1 2 3 4" -> split(" ") -> ["1", "2", "3", "4"] -> map -> [1, 2, 3, 4] -> {1, 2, 3, 4}

        String command = scanner.nextLine(); // "Delete {element}" or "Insert {element} {position}"
        //•   "Delete 5" -> split -> ["Delete", "5"]
        //•   "Insert 10 1" -> split -> ["Insert", "10", "1"]
        while(!command.equals("end")) {
            String commandName = command.split(" ")[0]; //"Delete" or "Insert"
            int element = Integer.parseInt(command.split(" ")[1]);
            if (commandName.equals("Delete")) {
                numbers.removeAll(Arrays.asList(element));
            } else if (commandName.equals("Insert")) {
                int position = Integer.parseInt(command.split(" ")[2]);
                numbers.add(position, element);
            }
            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
