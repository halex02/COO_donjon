import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import dungeons.Room;
import dungeons.RoomGenerator;
import localisation.Local;
import mob.Mob;
import stuff.Stuff;
import stuff.armor.Armor;
import stuff.consomable.Consommable;
import stuff.consomable.scroll.impl.ScrollOfFireBall;
import stuff.weapon.Weapon;
import stuff.weapon.impl.Fist;
import stuff.weapon.impl.IronSword;
import stuff.weapon.impl.WoodenSword;


public class Main {
	private static Room room;
	private static Mob player;
	private static Scanner scanner = new Scanner(System.in);
	
	private static Integer lootXp(Integer xp){
		return (xp/10) + 1;
	}
	
	private static void loot(Mob source, Mob target){
		source.getStuff().addAll(target.getStuff());
		source.setPo(source.getPo() + target.getPo());
		source.setXp(source.getXp() + lootXp(target.getXp()));
		System.out.println();
		System.out.println(Local.LOOT);
		for(Stuff stuff : target.getStuff()){
			System.out.println(" - " + stuff.getName());
		}
		if(target.getPo() > 0){
			System.out.println(" - " + target.getPo() + " PO");
		}
		System.out.println(" - " + lootXp(target.getXp()) + 1 + " XP");
	}
	
	private static void attaque(Mob source, Mob target){
		System.out.println(String.format(Local.ACTION_ATTAQUE, source.getName(), source.getWeapon().getName()));
		source.getWeapon().use(source, target);
		if(target.getPv()>0){
			System.out.println(String.format(Local.LAST_PV, target.getPv()));
		}else{
			System.out.println(String.format(Local.DEATH, target.getName()));
			if(target.equals(player)){
				//TODO
			}else{
				room.getMobs().remove(target);
				loot(source, target);
			}
		}
	}
	
	private static void consommable(Mob source, Mob target, Consommable consommable){
		consommable.use(source, target);
		source.getStuff().remove(consommable);
		if(target.getPv()>0){
			System.out.println(String.format(Local.LAST_PV, target.getPv()));
		}else{
			System.out.println(String.format(Local.DEATH, target.getName()));
			if(target.equals(player)){
				//TODO
			}else{
				room.getMobs().remove(target);
				loot(source, target);
			}
		}
	}
	
	private static void move(){
		System.out.println(Local.ACTION_CHANGER_SALLE);
		int i = 1;
		for(String porte : room.getIssues().keySet()){
			System.out.println((i) + " - " + porte);
			i = i + 1;
		}
		int choix = Integer.parseInt(scanner.nextLine());
		if(choix > 0 && choix <= room.getIssues().size()){
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
	}
	
	private static void inventaire(){
		int i = 1;
		for(Stuff stuff : player.getStuff()){
			System.out.println(i + " - " + stuff.getName() + ((player.getWeapon().equals(stuff) || player.getArmor().equals(stuff))?Local.EQUIPED:""));
			i = i + 1;
		}
		int choix = Integer.parseInt(scanner.nextLine());
		if(choix > 0 && choix <= player.getStuff().size()){
			Stuff stuff = player.getStuff().get(choix - 1);
			System.out.println(stuff.getDescription());
			System.out.println();
			System.out.println(Local.ACTION_TEXT);
			System.out.println(Local.ACTION_PASS);
			System.out.println(Local.ACTION_TROW);
			if(stuff instanceof Armor || stuff instanceof Weapon){
				System.out.println(Local.ACTION_EQUIP);
			}else if(stuff instanceof Consommable){
				System.out.println(Local.ACTION_USE);
			}
			choix = Integer.parseInt(scanner.nextLine());
			if(choix > 0 && choix <= 2){
				switch (choix) {
				case 1:
					if(player.getArmor() == stuff){
						player.setArmor(new Armor());
					}
					if(player.getWeapon() == stuff){
						player.setWeapon(new Fist());
					}
					player.getStuff().remove(stuff);
					break;
				case 2:
					if(stuff instanceof Armor){
						player.setArmor((Armor) stuff);
					}else if(stuff instanceof Weapon){
						player.setWeapon((Weapon) stuff);
					}else if(stuff instanceof Consommable){
						Mob target = null;
						if(room.getMobs().size()>1){
							Collections.sort(room.getMobs());
							int i2 = 1;
							System.out.println(Local.ACTION_PASS);
							for(Mob mob2 : room.getMobs()){
								System.out.println((i2) + " - " + mob2.getName());
								i2 = i2 + 1;
							}
							int c = Integer.parseInt(scanner.nextLine());
							if(c > 0 && c <= room.getMobs().size()){
								target = room.getMobs().get(c - 1);
							}
						}else{
							target = player;
						}
						consommable(player, target, (Consommable) stuff);
					}
					break;

				default:
					break;
				}
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
					move();
					break;
				case 2://Foullier
					
					break;
				case 3://Iventaire
					inventaire();
					break;
				case 4://Danser
					System.out.println(String.format(Local.IDIOT_DANSE, player.getName()));
					break;
				case 5://Attaquer
					if(room.getMobs().size()>1){
						Collections.sort(room.getMobs());
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
		Weapon weapon = new IronSword();
		List<Stuff> stuffs = new ArrayList<Stuff>();
		stuffs.add(weapon);
		stuffs.add(new ScrollOfFireBall());
		player = new Mob("Dudule", 100, 6, 2, 2, 2, 2, 0, 1, null, stuffs, weapon, new Armor(), 0);
		if(room.getMobs() == null){
			room.setMobs(new ArrayList<Mob>());
		}
		room.getMobs().add(player);
		do{
			action();
		}while(!room.getName().equals(Local.ENDING_ROOM_NAME));
	}
}
