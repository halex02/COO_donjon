import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import localisation.Local;
import mob.Mob;
import stuff.Stuff;
import stuff.armor.Armor;
import stuff.armor.impl.WodenArmor;
import stuff.consomable.Consommable;
import stuff.consomable.potion.Potion;
import stuff.consomable.potion.impl.HealPotion;
import stuff.consomable.scroll.impl.ScrollOfFireBall;
import stuff.weapon.Weapon;
import stuff.weapon.impl.Fist;
import stuff.weapon.impl.IronSword;
import dungeons.Room;
import dungeons.RoomGenerator;


public class Main {
	private static Room room;
	private static Mob player;
	private static RoomGenerator generator;
	private static Scanner scanner = new Scanner(System.in);
	
	private static Integer lootXp(Integer xp){
		return (xp/10) + 1;
	}
	
	public static Integer getInput(){
		String input = scanner.nextLine();
		Integer output = -1;
		try{
			output = Integer.parseInt(input);
		}catch(NumberFormatException e){
			System.out.println(String.format(Local.IDIOT_CHOICE, input));
		}
		return output;
	}
	
	private static void loot(Mob source, Mob target){
		room.getStuffs().addAll(target.getStuff());
		source.setPo(source.getPo() + target.getPo());
		source.setXp(source.getXp() + lootXp(target.getXp()));
		System.out.println();
		System.out.println(Local.LOOT);
		if(target.getPo() > 0){
			System.out.println(" - " + target.getPo() + " PO");
		}
		System.out.println(" - " + lootXp(target.getXp()) + " XP");
	}
	
	private static void respown(){
		player.setLive(player.getLive() - 1);
		if(player.getLive() >= 0){
			System.out.println(String.format(Local.RESPOWN, player.getLive()));
			List<Stuff> stuffs = new ArrayList<Stuff>(player.getStuff());
			for(Stuff stuff : stuffs){
				loseStuff(stuff);
			}
			room.getMobs().remove(player);
			for(Mob mob : room.getMobs()){
				mob.setXp(mob.getXp() + 200);
			}
			room = generator.getStartingRoom();
			room.getMobs().add(player);
			player.setPv(player.getMaxPv());
		}
	}
	
	private static void fouille(){
		if(room.getStuffs().size() > 0){
			System.out.println(Local.FOUILLE);
			System.out.println(Local.LOOT);
			for(Stuff stuff : room.getStuffs()){
				System.out.println(" - " + stuff.getName());
			}
			player.getStuff().addAll(room.getStuffs());
			room.getStuffs().clear();
		}else{
			System.out.println(Local.FOUILLE_VIDE);
		}
	}
	
	private static void attaque(Mob source, Mob target){
		System.out.println(String.format(Local.ACTION_ATTAQUE, source.getName(), source.getWeapon().getName()));
		source.getWeapon().use(source, target);
		if(target.getPv()>0){
			System.out.println(String.format(Local.LAST_PV, target.getPv()));
		}else{
			System.out.println(String.format(Local.DEATH, target.getName()));
			if(target.equals(player)){
				respown();
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
				respown();
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
		int choix = getInput();
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
	
	private static void loseStuff(Stuff stuff){
		if(player.getArmor() == stuff){
			player.setArmor(new Armor());
		}
		if(player.getWeapon() == stuff){
			player.setWeapon(new Fist());
		}
		room.getStuffs().add(stuff);
		player.getStuff().remove(stuff);
	}
	
	private static void inventaire(){
		int i = 1;
		for(Stuff stuff : player.getStuff()){
			System.out.println(i + " - " + stuff.getName() + ((player.getWeapon().equals(stuff) || player.getArmor().equals(stuff))?Local.EQUIPED:""));
			i = i + 1;
		}
		int choix = getInput();
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
			choix = getInput();
			if(choix > 0 && choix <= 2){
				switch (choix) {
				case 1:
					loseStuff(stuff);
					break;
				case 2:
					if(stuff instanceof Armor){
						player.setArmor((Armor) stuff);
					}else if(stuff instanceof Weapon){
						player.setWeapon((Weapon) stuff);
					}else if(stuff instanceof Consommable){
						Mob target = null;
						if(room.getMobs().size()>1 && !(stuff instanceof Potion)){
							Collections.sort(room.getMobs());
							int i2 = 1;
							System.out.println(Local.ACTION_PASS);
							for(Mob mob2 : room.getMobs()){
								System.out.println((i2) + " - " + mob2.getName());
								i2 = i2 + 1;
							}
							int c = getInput();
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
				switch (getInput()){
				case 1://Changer de salle
					move();
					break;
				case 2://Foullier
					fouille();
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
						int c = getInput();
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
		generator = new RoomGenerator();
		room = generator.generate();
		Weapon weapon = new IronSword();
		Armor armor = new WodenArmor();
		List<Stuff> stuffs = new ArrayList<Stuff>();
		stuffs.add(weapon);
		stuffs.add(armor);
		stuffs.add(new ScrollOfFireBall());
		for(int i = 0; i < 5; i++){
			stuffs.add(new HealPotion());
		}
		player = new Mob("Dudule", 100, 15, 2, 2, 2, 2, 0, 1, 3, stuffs, weapon, armor, 0, true);
		if(room.getMobs() == null){
			room.setMobs(new ArrayList<Mob>());
		}
		room.getMobs().add(player);
		do{
			action();
		}while(!room.getName().equals(Local.ENDING_ROOM_NAME) && player.getLive() >= 0);
	}
}
