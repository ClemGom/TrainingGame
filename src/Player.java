/**
 * Created by Clement Gomis on 28/03/2017.
 */
public interface Player {
    /**
     * Attack a given player
     * @param player to attack
     */
    void attack(Player player);

    /**
     * Add 50 hp the player life
     */
    void addLife();

    /**
     * @return the player name
     */
    String getName();

    /**
     * @return the life of ther player
     */
    int getLife();

    /**
     * @param life: life to redraw
     */
    void redrawLife(int life);

    /**
     * @return true if the player is alive
     */
    boolean isAlive();
}
