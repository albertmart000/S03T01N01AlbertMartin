package S03T01N01AlbertMartin;

import java.util.Scanner;
import java.util.Stack;

public class Undo {

    private static Undo singleInstance;

    public static Undo getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new Undo();
        } else {
            System.out.println("No es pot crear un altre objecte de la classe Undo perquè ja n'hi ha un.");
        }
        return singleInstance;
    }

    private Undo() {
    }

    public void startApplication() {
        Stack<Command> commandStack = new Stack<>();
        int menuOption;
        do {
            System.out.println("""
                    \nMENU PRINCIPAL:
                    (1) Afegir una ordre a l'historial d'ordres.
                    (2) Eliminar l'última ordre afegida a l'historial d'ordres.
                    (3) Mostrar l'historial d'ordres.
                    (0) Sortir.""");
            System.out.println("\nIntrodueix el número que es correspongui amb la teva opció.");
            Scanner sc = new Scanner(System.in);
            menuOption = sc.nextInt();
            switch (menuOption) {
                case 1 -> addCommand(commandStack);
                case 2 -> removeCommand(commandStack);
                case 3 -> showCommands(commandStack);
                case 0 -> System.out.println("Has escollit sortir: Gracies per fer servir la nostra aplicació.");
                default -> System.out.println("Ha de ser un numero entre 0 i 3");
            }
        } while (menuOption != 0);
    }

    private void showCommands(Stack<Command> commandStack) {
        System.out.println("L´historial d'ordres es:");
        for(int i = (commandStack.size()); i  > 0; i--) {
            System.out.println("[" + commandStack.get(i-1).getPosition() + "]   " +
                    commandStack.get(i-1).getCommandText());
        }
    }

    private void removeCommand(Stack<Command> commandStack) {
        System.out.println("Fet. Has eliminat de l´historial l'ordre:\n" +
                commandStack.pop());
    }

    private void addCommand(Stack<Command> commandStack) {
        Command command= createCommand(commandStack);
        commandStack.push(command);
        System.out.println("\nFet. Has afegit a l'historial d'ordres l'ordre:'\n[" + command.getPosition() + "]   " +
                command.getCommandText());
    }

    private Command createCommand(Stack<Command> commandStack) {
        System.out.println("Introdueix el text de l'ordre");
        Scanner sc = new Scanner(System.in);
        String commandText = sc.nextLine();
        int position = (commandStack.size() + 1);
        return new Command(position, commandText);
    }

}



