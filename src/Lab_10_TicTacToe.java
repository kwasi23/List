import java.util.ArrayList;
import java.util.Scanner;//These are import statements that bring in the arraylist and scanner classes from the java standard library.
public class Lab_10_TicTacToe {//Declaration of a public class named list
    static ArrayList<String> list = new ArrayList<>();//Creates a static arraylist of string named list that holds items in the users list
    public static void main(String[] args) {//Main method that runs when program is ran
        Scanner scanner = new Scanner(System.in);//Creates a new scanner object that will read input from the console.
        String menu = "A - add, D - delete, P - print, Q - quit";
        boolean done = false;
        String command = "";//The 3 lines above create variables that are used to display a menu of options to the user and keep track of the choices.
        do {
            SafeInput.prettyHeader("ListMaker");
            displayList();
            System.out.println(menu);
            command = SafeInput.getNonZeroLenString(scanner, "Enter command");
            switch (command.toUpperCase()) {//This Java code uses a switch statement to control the execution flow based on the value of the command variable. The command variable is assumed to be a String.
                case "A":
                    addItem(scanner);//if the command is equal to "A" (ignoring case), the addItem(scanner) method will be called.
                    break;
                case "D"://If the command is equal to "D" (ignoring case), the deleteItem(scanner) method will be called.
                    deleteItem(scanner);
                    break;
                case "P"://If the command is equal to "P" (ignoring case), the displayList() method will be called.
                    displayList();
                    break;
                case "Q"://If the command is equal to "Q" (ignoring case), the done variable will be set to true, which could be used to exit from the loop or terminate the program.
                    done = true;
                    break;
                default:
                    System.out.println("Invalid command!");//If the command doesn't match any of the above cases, the default case will be executed, which prints "Invalid command!" to the console.
            }
        } while (!done);//This is the main loop of the program. It displays the list of items, shows the menu of options, and waits for the user to enter a command. Based on the user's choice, it calls the appropriate method (addItem, deleteItem, or displayList) or exits the loop (done = true).
        System.out.println("Exiting ListMaker...");
    }
    private static void addItem(Scanner scanner) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        list.add(item);//This is a method that adds an item to the list. It prompts the user to enter the item and then adds it to the list ArrayList.
    }
    private static void deleteItem(Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int index = SafeInput.getRangedInt(scanner, "Enter item number to remove", 1, list.size());
        list.remove(index - 1);
        System.out.println("Item removed from the list.");
    }//This is a method that deletes an item from the list. If the list is empty, it displays a message and returns. Otherwise, it prompts the user to enter the number of the item to be removed, removes it from the list, and displays a confirmation message.
    private static void displayList() {
        SafeInput.prettyHeader("List");//When called, the method prints a header "List" using the prettyHeader() method of the SafeInput class (assumed to be available). Then, it prints a separator line "----- List -----" to separate the header from the list of items.
        System.out.println("----- List -----");
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
        System.out.println("----------------");
    }
}// This is a method that displays the current contents of the list. It first displays a header, then loops through the list ArrayList and displays each item with its corresponding index number. If the list is empty, it displays a message indicating that.
