import java.util.HashMap;
import java.util.Map;

/**
 * Created by Clement Gomis on 27/03/2017.
 */
public class PlayerImpl implements Player {
    private String name;
    private int level;
    private int strenght;
    private int life;
    private Map<Integer, Integer> bonus;
    public static final int LIFE = 1;
    public static final int STRENGTH = 2;

    public PlayerImpl(String name, int level, int strenght, int life) {
        this.name = name;
        this.level = level;
        this.strenght = strenght;
        this.life = life;
        this.bonus = new HashMap<>();
        this.bonus.put(LIFE, 0);
        this.bonus.put(STRENGTH, 0);
    }

    @Override
    public void redrawLife(int number) {
        System.out.println(name + " lost " + number + " hp");
        life -= number;
        if (life <= 0)
            System.out.println(String.format("%s got now 0 hp so he is dead", this.name));
        else
            System.out.println(String.format("%s got now %d hp", this.name, this.life));
    }

    public int getLife()
    {
        return this.life + this.bonus.get(LIFE);
    }

    @Override
    public void attack(Player player)
    {
        if (this.life + bonus.get(LIFE) <= 0)
            System.out.println("You can't attack during you're dead");
        else if (player.getLife() <= 0)
            System.out.println("You can't attack a dead player");
        else {
            int dammages = 5 * (strenght + bonus.get(STRENGTH));
            System.out.println(name + " attacks " + player.getName() + "...");
            player.redrawLife(dammages);
        }
    }

    @Override
    public void addLife()
    {
        this.bonus.put(LIFE, bonus.get(LIFE) + 50);
        Main.print(String.format("Player %s add 50 HP", this.name));
    }

    @Override
    public void addStrength()
    {
        this.bonus.put(STRENGTH, bonus.get(STRENGTH) + 50);
        Main.print(String.format("Player %s add 50 strength", this.name));
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public boolean isAlive()
    {
        return this.life > 0;
    }
}
