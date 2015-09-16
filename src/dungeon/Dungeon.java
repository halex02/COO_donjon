package dungeon ;

import java.util.Scanner ;

public class Dungeon {
    
    protected Room currentRoom = new Entrance() ;

    public Room getCurrentRoom() ;

    public void interpretCommand(String command) ;
    
    public static void main(String[] args) ;

    public void start() ;

    
    
}
