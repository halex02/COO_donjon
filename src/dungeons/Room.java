package dungeons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stuff.Stuff;
import localisation.Local;
import mob.Mob;

public class Room {

	private String description;
	private String name;
	private Map<String, Room> issues;
	private List<Mob> mobs;
	private List<Stuff> stuffs;

	public Room() {
		super();
		this.description = Local.STARTING_ROOM_DESCRIPTION;
		this.name = Local.STARTING_ROOM_NAME;
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new ArrayList<>();
	}

	public Room(Room room) {
		super();
		this.description = new String(room.description);
		this.name = new String(room.name);
		if (room.issues != null)
			this.issues = new HashMap<String, Room>(room.issues);
		if (room.mobs != null)
			this.mobs = new ArrayList<Mob>(room.mobs);
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new ArrayList<>();
	}

	public Room(String description, String name) {
		super();
		this.description = description;
		this.name = name;
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new ArrayList<>();
	}

	public Room(String description, String name, Map<String, Room> issues,
			List<Mob> mobs) {
		super();
		this.description = description;
		this.name = name;
		this.issues = issues;
		this.mobs = mobs;
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new ArrayList<>();
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

	public List<Stuff> getStuffs() {
		return stuffs;
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

	public void setStuffs(List<Stuff> stuffs) {
		this.stuffs = stuffs;
	}
}
