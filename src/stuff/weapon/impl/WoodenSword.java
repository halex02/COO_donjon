package stuff.weapon.impl;

import java.util.Random;

import mob.Mob;
import stuff.weapon.Weapon;
import Localisation.Local;

public class WoodenSword extends Weapon {

	public WoodenSword() {
		weight = 2;
		value = 1;
		name = Local.WEAPON_WOODEN_SWORD_NAME;
	}

	@Override
	public void use(Mob target) {
		Random rand = new Random();
		Integer degat = rand.nextInt(2) + 1;
		System.out.println(String.format(Local.WEAPON_WOODEN_SWORD_EFFECT,
				target.getNom(), degat));
		target.setPv(target.getPv() - degat);
	}

}
