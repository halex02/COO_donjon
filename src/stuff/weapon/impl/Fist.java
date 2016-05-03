package stuff.weapon.impl;

import localisation.Local;
import mob.Mob;
import stuff.weapon.Weapon;

public class Fist extends Weapon {

	public Fist() {
		name = Local.WEAPON_FIST_NAME;
		setWeight(0);
		setValue(0);
	}

	@Override
	public void use(Mob source, Mob target) {
		Integer degat1 = source.getStrenth();
		Integer degat2 = (degat1 / 2) + 1 - source.getArmor().getDef();
		degat1 -= target.getArmor().getDef();
		if(degat1 < 0) degat1 = 0;
		if(degat2 < 0) degat2 = 0;
		System.out.println(String.format(Local.WEAPON_FIST_EFFECT, source.getName(),target.getName(), degat1, degat2));
		target.setPv(target.getPv() - degat1);
		source.setPv(source.getPv() - degat2);
	}
}
