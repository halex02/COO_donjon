import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import stuff.Stuff;
import localisation.Local;
import mob.Mob;
import dungeons.RoomGenerator;
import dungeons.Room;


public class Main {
	private static Room room;
	private static Mob player;
	
	private static Integer lootXp(Integer xp){
		return (xp/10) + 1;
	}
	
	private static void attaque(Mob source, Mob taget){
		System.out.println(String.format(Local.ACTION_ATTAQUE, source.getName(), source.getWeapon().getName()));
		source.getWeapon().use(taget);
		if(taget.getPv()>0){
			System.out.println(String.format(Local.LAST_PV, taget.getPv()));
		}else{
			System.out.println(String.format(Local.DEATH, taget.getName()));
			if(taget.equals(player)){
				//TODO
			}else{
				room.getMobs().remove(taget);
				source.getStuff().addAll(taget.getStuff());
				source.setPo(source.getPo() + taget.getPo());
				source.setXp(source.getXp() + lootXp(taget.getXp()));
				System.out.println(String.format(Local.DEATH, taget.getName()));
				System.out.println();
				System.out.println(Local.LOOT);
				for(Stuff stuff : taget.getStuff()){
					System.out.println(" - " + stuff.getName());
				}
				if(taget.getPo() > 0){
					System.out.println(" - " + taget.getPo() + "PO");
				}
				System.out.println(" - " + lootXp(taget.getXp()) + 1 + "XP");
			}
		}
	}
	
	private static void action(){
		Collections.shuffle(room.getMobs());
		for(Mob mob : room.getMobs()){
			if(mob.equals(player)){
				System.out.println(Local.ACTION_TEXT);
				System.out.println(Local.ACTION_LIST);
				if(room.getMobs().size()>1){
					System.out.println(Local.ACTION_ATTAQUER);
				}
			}else{
				attaque(mob,player);
			}
		}
	}

	public static void main(String[] args) {
		RoomGenerator generator = new RoomGenerator();
		room = generator.generate();
		player = new Mob(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		room.getMobs().add(player);
		do{
			action();
		}while(!room.getName().equals(Local.ENDING_ROOM_NAME));
	}

}
