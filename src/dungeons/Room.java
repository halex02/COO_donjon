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
	private Map<Stuff,Integer> stuffs;

	public Room() {
		super();
		this.description = Local.STARTING_ROOM_DESCRIPTION;
		this.name = Local.STARTING_ROOM_NAME;
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new HashMap<Stuff, Integer>();
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
		stuffs = new HashMap<Stuff, Integer>();
	}

	public Room(String description, String name) {
		super();
		this.description = description;
		this.name = name;
		issues = new HashMap<>();
		mobs = new ArrayList<>();
		stuffs = new HashMap<Stuff, Integer>();
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
		stuffs = new HashMap<Stuff, Integer>();
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

	public Map<Stuff,Integer> getStuffs() {
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

	public void setStuffs(Map<Stuff,Integer> stuffs) {
		this.stuffs = stuffs;
	}
	
	public void addStuff(Stuff stuff){
		Integer nb = this.stuffs.get(stuff);
		if(nb != null){
			this.stuffs.put(stuff, nb + 1);
		}else{
			this.stuffs.put(stuff, 1);
		}
	}
	
	public void addStuff(Stuff stuff, Integer nb){
		Integer nbStuff = this.stuffs.get(stuff);
		if(nbStuff != null){
			this.stuffs.put(stuff, nbStuff + nb);
		}else{
			this.stuffs.put(stuff, nb);
		}
	}
	
	public void addAllStuff(List<Stuff> stuffs){
		for(Stuff stuff : stuffs){
			addStuff(stuff);
		}
	}
	
	public void addAllStuff(Map<Stuff, Integer> stuffs){
		for(Stuff stuff : stuffs.keySet()){
			addStuff(stuff,stuffs.get(stuff));
		}
	}
}
