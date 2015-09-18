import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import localisation.Local;
import mob.Mob;
import stuff.Stuff;
import stuff.weapon.impl.WoodenSword;
import dungeons.Room;
import dungeons.RoomGenerator;


public class Main {
	private static Room room;
	private static Mob player;
	private static Scanner scanner = new Scanner(System.in);
	
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
					System.out.println(" - " + taget.getPo() + " PO");
				}
				System.out.println(" - " + lootXp(taget.getXp()) + 1 + " XP");
			}
		}
	}
	
	private static void action(){
		Collections.shuffle(room.getMobs());
		for(int mobIndex = 0; mobIndex < room.getMobs().size(); mobIndex++){
			if(room.getMobs().get(mobIndex).equals(player)){
				System.out.println(Local.ACTION_TEXT);
				System.out.println(Local.ACTION_LIST);
				if(room.getMobs().size()>1){
					System.out.println(Local.ACTION_ATTAQUER);
				}
				switch (Integer.parseInt(scanner.nextLine())){
				case 1://Changer de salle
					System.out.println(Local.ACTION_CHANGER_SALLE);
					int i = 1;
					for(String porte : room.getIssues().keySet()){
						System.out.println((i) + " - " + porte);
						i = i + 1;
					}
					int choix = Integer.parseInt(scanner.nextLine());
					if(choix > 0 && choix <= room.getMobs().size()){
						if(room.getMobs().size() > 1){
							System.out.println(String.format(Local.ACTION_RUN, player.getName()));
							for(Mob mob2 : room.getMobs()){
								if(!mob2.equals(player)){
									attaque(mob2, player);
								}
							}
						}
						room.getMobs().remove(player);
						room = room.getIssues().get(room.getIssues().keySet().toArray()[choix - 1]);
						room.getMobs().add(player);
						System.out.println(String.format(Local.ACTION_MOVE, player.getName(), room.getDescription()));
						if(room.getMobs().size() > 1){
							System.out.println(Local.MOBS_WAITTING);
						}
					}else{
						System.out.println(String.format(Local.IDIOT_ISSUE, player.getName()));
					}
					break;
				case 2://Foullier
					
					break;
				case 3://Iventaire
					
					break;
				case 4://Danser
					
					break;
				case 5://Attaquer
					if(room.getMobs().size()>1){
						int i2 = 1;
						for(Mob mob2 : room.getMobs()){
							System.out.println((i2) + " - " + mob2.getName());
							i2 = i2 + 1;
						}
						int c = Integer.parseInt(scanner.nextLine());
						if(c > 0 && c <= room.getMobs().size()){
							attaque(player, room.getMobs().get(c - 1));
						}else{
							System.out.println(String.format(Local.IDIOT_ATTAQUE, player.getName()));
						}
					}else{
						System.out.println(String.format(Local.IDIOT_ATTAQUE, player.getName()));
					}
					
					break;

				default:
					break;
				}
			}else{
				attaque(room.getMobs().get(mobIndex),player);
			}
		}
	}

	public static void main(String[] args) {
		RoomGenerator generator = new RoomGenerator();
		room = generator.generate();
		player = new Mob("Dudule", 100, null, null, null, null, null, 0, 1, null, new ArrayList<Stuff>(), new WoodenSword(), null, 0);
		if(room.getMobs() == null){
			room.setMobs(new ArrayList<Mob>());
		}
		room.getMobs().add(player);
		do{
			action();
		}while(!room.getName().equals(Local.ENDING_ROOM_NAME));
	}
}
