package stuff.weapon.impl;

import java.util.Random;

import localisation.Local;
import mob.Mob;
import stuff.weapon.Weapon;

public class WoodenSword extends Weapon {

	public WoodenSword() {
		setWeight(2);
		setValue(1);
		setDescription(Local.WEAPON_WOODEN_SWORD_DESCRIPTION);
		name = Local.WEAPON_WOODEN_SWORD_NAME;
	}

	@Override
	public void use(Mob source, Mob target) {
		Random rand = new Random();
		Integer degat = source.getStrenth() + rand.nextInt(2) + 1;
		System.out.println(String.format(Local.WEAPON_WOODEN_SWORD_EFFECT,
				target.getName(), degat));
		target.setPv(target.getPv() - degat);
	}

}
