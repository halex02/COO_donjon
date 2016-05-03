package dungeons.trapRoom;

import dungeons.Room;
import localisation.Local;
import mob.Mob;

public class TrapRoom extends Room {

	public TrapRoom(String description, String name) {
		super(description, name);
	}
	
	public void effect(Mob player) {
		System.out.println(Local.ROOM_TRIGGERED);
	}
}
