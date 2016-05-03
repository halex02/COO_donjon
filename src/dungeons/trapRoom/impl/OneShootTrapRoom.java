package dungeons.trapRoom.impl;

import dungeons.trapRoom.TrapRoom;
import localisation.Local;
import mob.Mob;

public class OneShootTrapRoom extends TrapRoom {

	boolean triggered;

	public OneShootTrapRoom(String description, String name) {
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
