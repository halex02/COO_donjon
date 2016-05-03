package dungeons.treasureRoom.impl;

import java.util.HashMap;
import java.util.Map;

import localisation.Local;
import stuff.Stuff;
import stuff.armor.impl.PlateArmor;
import stuff.consomable.potion.impl.HealPotion;
import stuff.weapon.impl.SteelSword;
import dungeons.Room;

public class LegendaryTreasureRoom extends Room{
	public LegendaryTreasureRoom(){
		setName(Local.ROOM_TRESURE_NAME);
		setDescription(Local.ROOM_TRESURE_DESCRIPTION);
		Map<Stuff, Integer> stuffs = new HashMap<Stuff, Integer>();
		stuffs.put(new HealPotion(), 10);
		stuffs.put(new SteelSword(), 1);
		stuffs.put(new PlateArmor(), 1);
		addAllStuff(stuffs);
	}
}
