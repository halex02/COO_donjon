package dungeon ;

import character.* ;

public class DeathRoom extends Room {
    
    /**<code>init()</code> : manage events triggered by player's entrance in the room :
       initial display of the room's description, monster's spawn, room locking,
       instant death of player...
    */
    public void init () ;

    public void killPlayerInstantly() ;

    public DeathRoom() ;

}
