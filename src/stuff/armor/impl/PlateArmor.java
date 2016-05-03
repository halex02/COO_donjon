package stuff.armor.impl;

import localisation.Local;
import stuff.armor.Armor;

public class PlateArmor extends Armor {
	public PlateArmor(){
		name = Local.ARMOR_PLATE_NAME;
		setDescription(Local.ARMOR_PLATE_DESCRIPTION);
		setDef(15);
	}
}
