package stuff.weapon.impl;

import java.util.Random;

import localisation.Local;
import mob.Mob;
import stuff.weapon.Weapon;

public class IronSword extends Weapon {

	public IronSword() {
		setWeight(10);
		setValue(6);
		setDescription(Local.WEAPON_IRON_SWORD_DESCRIPTION);
		name = Local.WEAPON_IRON_SWORD_NAME;
	}

	@Override
	public void use(Mob source, Mob target) {
		Random rand = new Random();
		Integer degat = source.getStrenth() + rand.nextInt(5) + 5 - target.getArmor().getDef();
		if(degat < 0) degat = 0;
		System.out.println(String.format(Local.WEAPON_IRON_SWORD_EFFECT,
				target.getName(), degat));
		target.setPv(target.getPv() - degat);
	}

}
