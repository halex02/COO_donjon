package dungeons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import localisation.Local;
import mob.Mob;

public class Room {

	private String description;
	private String name;
	private Map<String, Room> issues;
	private List<Mob> mobs;

	public Room() {
		super();
		this.description = Local.STARTING_ROOM_DESCRIPTION;
		this.name = Local.STARTING_ROOM_NAME;
	}

	public Room(Room room) {
		super();
		this.description = new String(room.description);
		this.name = new String(room.name);
		if (room.issues != null)
			this.issues = new HashMap<String, Room>(room.issues);
		if (room.mobs != null)
			this.mobs = new ArrayList<Mob>(room.mobs);
	}

	public Room(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public Room(String description, String name, Map<String, Room> issues,
			List<Mob> mobs) {
		super();
		this.description = description;
		this.name = name;
		this.issues = issues;
		this.mobs = mobs;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Map<String, Room> getIssues() {
		return issues;
	}

	public List<Mob> getMobs() {
		return mobs;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIssues(Map<String, Room> issues) {
		this.issues = issues;
	}

	public void setMobs(List<Mob> mobs) {
		this.mobs = mobs;
	}
}
