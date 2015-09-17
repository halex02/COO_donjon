package stuff.armor;

import stuff.Stuff;


public abstract class Armor extends Stuff{
	private Integer def;

	public Integer getDef() {
		return def;
	}

	public void setDef(Integer def) {
		this.def = def;
	}
}
