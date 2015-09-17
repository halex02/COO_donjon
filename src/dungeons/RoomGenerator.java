package dungeons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mob.Mob;
import mob.MobGenerator;
import Localisation.Local;

public class RoomGenerator {

	private static List<Room> rooms;

	public RoomGenerator() {
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
		Room room = new Room();
		Random rand = new Random();
		MobGenerator generator = new MobGenerator();

		Room curentRoom = room;
		for (int i = 0; i < (rand.nextInt(3) + 3); i++) {
			Collections.shuffle(rooms);
			Room newRoom = new Room(rooms.get(0));
			if (curentRoom.getIssues() == null) {
				curentRoom.setIssues(new HashMap<String, Room>());
			}
			curentRoom
					.getIssues()
					.put(Local.ISSUE_STANDAR[rand
							.nextInt(Local.ISSUE_STANDAR.length)],
							newRoom);
			curentRoom.getIssues().putAll(
					subGenerate(rand.nextInt(5) + 1, curentRoom));
			if (newRoom.getIssues() == null) {
				newRoom.setIssues(new HashMap<String, Room>());
			}
			newRoom.getIssues().put(Local.ISSUE_PREVIOUS, curentRoom);
			if (newRoom.getMobs() == null) {
				newRoom.setMobs(new ArrayList<Mob>());
			}
			newRoom.getMobs().addAll(generator.generate());
			curentRoom = newRoom;
		}

		rooms.add(new Room(Local.ROOM_BOSS_DESCRIPTION, Local.ROOM_BOSS_NAME));
		rooms.add(new Room(Local.ENDING_ROOM_DESCRIPTION,
				Local.ENDING_ROOM_NAME));
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

				newRoom.setIssues(subGenerate(rand.nextInt(lenth), newRoom));
				if (newRoom.getMobs() == null) {
					newRoom.setMobs(new ArrayList<Mob>());
				}
				newRoom.getMobs().addAll(generator.generate());
				issues.put(Local.ISSUE_STANDAR[rand
						.nextInt(Local.ISSUE_STANDAR.length)], newRoom);
			}
			issues.put(Local.ISSUE_PREVIOUS, previousRoom);
			return issues;
		} else {
			return null;
		}
	}
}
