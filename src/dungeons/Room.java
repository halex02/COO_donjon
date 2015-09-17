package dungeons;

import java.util.List;
import java.util.Map;

import mob.Mob;


public class Room {
	private String description;
	private String name;
	private Map<String, Room> issues;
	private List<Mob> mobs;
	
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
