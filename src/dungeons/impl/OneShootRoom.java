package dungeons.impl;

import localisation.Local;
import mob.Mob;
import dungeons.TrapRoom;

public class OneShootRoom extends TrapRoom {

	boolean triggered;

	public OneShootRoom(String description, String name) {
		super(description,name);
		triggered = false;
	}
	
	@Override
	public void effect(Mob player) {
		if(!triggered){
			triggered = true;
			super.effect(player);
			System.out.println(Local.ROOM_OS_ROOM);
			player.setPv(0);
			setName(Local.ROOM_TRAP_NAME);
			setDescription(Local.ROOM_TRAP_DESCRIPTION);
		}
	}
}
