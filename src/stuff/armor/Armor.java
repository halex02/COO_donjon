package stuff.armor;

import stuff.Stuff;


public class Armor extends Stuff{
	private Integer def;

	public Armor() {
		def = 0;
	}
	
	public Integer getDef() {
		return def;
	}

	public void setDef(Integer def) {
		this.def = def;
	}
}
