package stuff.armor.impl;

import localisation.Local;
import stuff.armor.Armor;

public class WodenArmor extends Armor {
	public WodenArmor(){
		name = Local.ARMOR_WOODEN_NAME;
		setDescription(Local.ARMOR_WOODEN_DESCRIPTION);
		setDef(5);
	}
}
