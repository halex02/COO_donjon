package dungeons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dungeons.trapRoom.impl.OneShootTrapRoom;
import dungeons.treasureRoom.impl.LegendaryTreasureRoom;
import stuff.consomable.potion.impl.HealPotion;
import stuff.consomable.scroll.impl.ScrollOfFireBall;
import localisation.Local;
import mob.MobGenerator;

public class RoomGenerator {

	private static List<Room> rooms;
	
	private Room startingRoom;

	public Room getStartingRoom() {
		return startingRoom;
	}
	
	LegendaryTreasureRoom legendaryTreasureRoom;

	public RoomGenerator() {
		legendaryTreasureRoom = new LegendaryTreasureRoom();
		
		rooms = new ArrayList<Room>();
		rooms.add(new Room(Local.ROOM_COULOIR_DESCRIPTION_1,
				Local.ROOM_COULOIR_NAME));
		rooms.add(new Room(Local.ROOM_COULOIR_DESCRIPTION_2,
				Local.ROOM_COULOIR_NAME));
		rooms.add(new Room(Local.ROOM_COULOIR_DESCRIPTION_3,
				Local.ROOM_COULOIR_NAME));
		rooms.add(new Room(Local.ROOM_COULOIR_DESCRIPTION_4,
				Local.ROOM_COULOIR_NAME));
		rooms.add(new Room(Local.ROOM_COULOIR_DESCRIPTION_5,
				Local.ROOM_COULOIR_NAME));

		rooms.add(new Room(Local.ROOM_STANDAR_DESCRIPTION_1,
				Local.ROOM_STANDAR_NAME));
		rooms.add(new Room(Local.ROOM_STANDAR_DESCRIPTION_2,
				Local.ROOM_STANDAR_NAME));
		rooms.add(new Room(Local.ROOM_STANDAR_DESCRIPTION_3,
				Local.ROOM_STANDAR_NAME));
		rooms.add(new Room(Local.ROOM_STANDAR_DESCRIPTION_4,
				Local.ROOM_STANDAR_NAME));
		rooms.add(new Room(Local.ROOM_STANDAR_DESCRIPTION_5,
				Local.ROOM_STANDAR_NAME));
	}

	public Room generate() {
		MobGenerator generator = new MobGenerator();
		Room room = new Room();
		Room bossRoom = new Room(Local.ROOM_BOSS_DESCRIPTION, Local.ROOM_BOSS_NAME);
		bossRoom.setMobs(generator.generate());
		bossRoom.getMobs().add(generator.generateBoss());
		Random rand = new Random();

		Room curentRoom = room;
		int nbRoom = (rand.nextInt(3) + 3);
		for (int i = 0; i < nbRoom; i++) {
			Collections.shuffle(rooms);
			Room newRoom = new Room(rooms.get(0));
			if(i == (nbRoom - 1)){
				newRoom.getIssues().put(Local.ISSUE_STANDAR[rand
				                							.nextInt(Local.ISSUE_STANDAR.length)], bossRoom);
			}
			curentRoom.getIssues().putAll(
					subGenerate(rand.nextInt(5) + 1, curentRoom));
			curentRoom
					.getIssues()
					.put(Local.ISSUE_STANDAR[rand
							.nextInt(Local.ISSUE_STANDAR.length)],
							newRoom);
			newRoom.getIssues().put(Local.ISSUE_PREVIOUS, curentRoom);
			
			newRoom.getMobs().addAll(generator.generate());
			if(rand.nextInt(10) == 0){
				newRoom.addStuff(new ScrollOfFireBall());
			}
			curentRoom = newRoom;
		}

		Room endRoom = new Room(Local.ENDING_ROOM_DESCRIPTION,
				Local.ENDING_ROOM_NAME);
		bossRoom.getIssues().put(Local.ISSUE_PREVIOUS, curentRoom);
		bossRoom.getIssues().put(Local.ISSUE_STANDAR[0], endRoom);
		endRoom.getIssues().put(Local.ISSUE_PREVIOUS, bossRoom);
		startingRoom = room;
		return room;
	}

	private Map<String, Room> subGenerate(int lenth, Room previousRoom) {
		if (lenth > 0) {
			Random rand = new Random();
			MobGenerator generator = new MobGenerator();

			Map<String, Room> issues = new HashMap<String, Room>();
			for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
				Collections.shuffle(rooms);
				Room newRoom = new Room(rooms.get(0));

				if(rand.nextInt(10) == 0){
					newRoom = new OneShootTrapRoom(newRoom.getDescription(), newRoom.getName());
				}
				
				if(rand.nextInt(10) == 0 && legendaryTreasureRoom != null){
					newRoom = legendaryTreasureRoom;
					legendaryTreasureRoom = null;
				}

				newRoom.setIssues(subGenerate(rand.nextInt(lenth), newRoom));
				newRoom.getIssues().put(Local.ISSUE_PREVIOUS, previousRoom);
				if(!(newRoom instanceof LegendaryTreasureRoom)){
					newRoom.getMobs().addAll(generator.generate());
				}
				if(rand.nextInt(10) == 0){
					newRoom.addStuff(new ScrollOfFireBall());
				}
				if(rand.nextInt(10) == 0){
					newRoom.addStuff(new HealPotion(),rand.nextInt(2) + 1);
				}
				issues.put(Local.ISSUE_STANDAR[rand
						.nextInt(Local.ISSUE_STANDAR.length)], newRoom);
				if(newRoom instanceof LegendaryTreasureRoom){
					Room debug = newRoom;
					while(debug.getIssues().containsKey(Local.ISSUE_PREVIOUS)){
						for(String k : debug.getIssues().get(Local.ISSUE_PREVIOUS).getIssues().keySet()){
							if(debug.getIssues().get(Local.ISSUE_PREVIOUS).getIssues().get(k).equals(debug)){
								System.out.println(k);
							}
						}
						debug = debug.getIssues().get(Local.ISSUE_PREVIOUS);
					}
				}
			}
			return issues;
		} else {
			return new HashMap<String, Room>();
		}
	}
}
