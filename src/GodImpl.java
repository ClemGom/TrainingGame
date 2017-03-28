/**
 * Created by Clement Gomis on 27/03/2017.
 */
public class GodImpl implements Player {
    private String name;
    private int level;
    private int strenght;
    private int life;

    public GodImpl(String name, int level, int strenght, int life) {
        this.name = name;
        this.level = level;
        this.strenght = strenght * 10;
        this.life = life * 10;
    }

    @Override
    public void redrawLife(int number) {
        Main.print("You can't attack a god.");
    }

    @Override
    public int getLife()
    {
        return this.life;
    }

    @Override
    public void attack(Player player)
    {
        if (this.life <= 0)
            System.out.println("You can't attack during you're dead");
        else if (player.getLife() <= 0)
            System.out.println("You can't attack a dead player");
        else {
            int dammages = 5 * strenght;
            System.out.println(name + " attacks " + player.getName() + "...");
            player.redrawLife(dammages);
        }
    }

    @Override
    public void addLife()
    {
        this.life += 500;
        Main.print(String.format("Player %s add 50 HP", this.name));
    }

    @Override
    public void addStrength() {

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
