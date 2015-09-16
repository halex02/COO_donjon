package dungeon ;

import java.util.Scanner ;

public class Dungeon {
    
    protected Room currentRoom ;

    /**<code>getCurrentRoom()</code> gives the location of the player.
       @return room : the room in which the player is located.
     */
    public Room getCurrentRoom() ;

    /** <code>interpretCommand(c)</code> analyses the String in parameter 
	and select the corresponding action for the player.
	@param c : a command entered by the player.
     */
    public void interpretCommand(String command) ;
    
    public static void main(String[] args) ;

    /** <code>start()</code> : launch the game, ie spawn the player in the labyrinth.
     */
    public void start() ;

    /**Constructor for the class Dungeon. Initiates the entrance Room and generates the labyrinth.
     */
    public Dungeon() ;

    
    
}
