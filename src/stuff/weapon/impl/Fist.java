package stuff.weapon.impl;

import localisation.Local;
import mob.Mob;
import stuff.weapon.Weapon;

public class Fist extends Weapon {

	@Override
	public void use(Mob source, Mob target) {
		Integer degat1 = source.getStrenth();
		Integer degat2 = (degat1 / 2) + 1;
		System.out.println(String.format(Local.WEAPON_FIST_EFFECT, source.getName(),target.getName(), degat1, degat2));
		target.setPv(target.getPv() - degat1);
		source.setPv(source.getPv() - degat2);
	}

}
