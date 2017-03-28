import java.util.Scanner;

public class Main {
    public static void print(String msg)
    {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namep1, namep2;
        print("Name of PlayerImpl 1: ");
        namep1 = scanner.nextLine();
        print("Name of PlayerImpl 2: ");
        namep2 = scanner.nextLine();
        print(String.format("Welcome to %s and %s ure gay", namep1, namep2));
        Player player1 = new PlayerImpl(namep1,1,10,100);
        Player player2 = new GodImpl(namep2, 1,10,100);
        Player attacker = player1;
        Player attacked = player2;
        String action;
        while (player1.isAlive() && player2.isAlive())
        {
            print("What do u wanna do bitch ?: write `Attack` or `Defense`");
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("attack"))
                attacker.attack(attacked);
            else if (action.equalsIgnoreCase("defense"))
                attacker.addLife();
            else {
                print(String.format("Action: %s not found", action));
                continue;
            }
            if (attacker.getName().equals(player1.getName()))
                attacker = player2;
            else
                attacker = player1;
            if (attacked.getName().equals(player2.getName()))
                attacked = player1;
            else
                attacked = player2;
        }
        print("Game Over");
    }

}
