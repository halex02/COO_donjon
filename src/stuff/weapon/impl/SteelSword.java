package stuff.weapon.impl;

import java.util.Random;

import stuff.weapon.Weapon;
import localisation.Local;
import mob.Mob;

public class SteelSword extends Weapon{

	public SteelSword() {
		setWeight(10);
		setValue(10);
		setDescription(Local.WEAPON_STEEL_SWORD_DESCRIPTION);
		name = Local.WEAPON_STEEL_SWORD_NAME;
	}

	@Override
	public void use(Mob source, Mob target) {
		Random rand = new Random();
		Integer degat = source.getStrenth() + rand.nextInt(5) + 8 - target.getArmor().getDef();
		if(degat < 0) degat = 0;
		System.out.println(String.format(Local.WEAPON_SWORD_EFFECT,
				target.getName(), degat));
		target.setPv(target.getPv() - degat);
	}
}
