package dungeons;

import stuff.Stuff;


public class TreasureRoom extends Room {
	private Stuff loot;

	public Stuff getLoot() {
		return loot;
	}

	public void setLoot(Stuff loot) {
		this.loot = loot;
	}
}
