package mob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import localisation.Local;
import stuff.Stuff;
import stuff.armor.Armor;
import stuff.weapon.Weapon;
import stuff.weapon.impl.Fist;
import stuff.weapon.impl.IronSword;
import stuff.weapon.impl.WoodenSword;

public class MobGenerator {

	List<Mob> mobs = new ArrayList<Mob>();

	public MobGenerator() {
		Random rand = new Random();
		MobNameGenetaror nameGenetaror = new MobNameGenetaror();
		Map<Stuff, Integer> stuffs = new HashMap<Stuff, Integer>();
		Weapon wSword = new WoodenSword();
		stuffs.put(wSword, 1);
		mobs.add(new Mob(Local.MOB_GOBELIN + " "
				+ nameGenetaror.getGobelineName(), rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " "
				+ nameGenetaror.getGobelineName(), rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " "
				+ nameGenetaror.getGobelineName(), rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));

		Weapon iSword = new IronSword();
		stuffs = new HashMap<Stuff, Integer>();
		stuffs.put(iSword, 1);

		mobs.add(new Mob(Local.MOB_GOBELIN + " "
				+ nameGenetaror.getGobelineName(), rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, iSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " "
				+ nameGenetaror.getGobelineName(), rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, iSword, new Armor(), rand.nextInt(5)));

		mobs.add(new Mob(Local.MOB_ORC + " " + nameGenetaror.getOrcName(), rand
				.nextInt(6) + 10, rand.nextInt(20) + 10, 1, stuffs, iSword,
				new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " " + nameGenetaror.getOrcName(), +10,
				rand.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand
						.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " " + nameGenetaror.getOrcName(), +10,
				rand.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand
						.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " " + nameGenetaror.getOrcName(), rand
				.nextInt(6) + 10, rand.nextInt(20) + 10, 1, stuffs, iSword,
				new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " " + nameGenetaror.getOrcName(), rand
				.nextInt(6) + 10, rand.nextInt(20) + 10, 1, stuffs, iSword,
				new Armor(), rand.nextInt(10)));

		mobs.add(new Mob(Local.MOB_TROLL + " " + nameGenetaror.getTrollName(),
				rand.nextInt(10) + 20, rand.nextInt(25) + 15, 1, stuffs,
				iSword, new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " " + nameGenetaror.getTrollName(),
				rand.nextInt(10) + 20, rand.nextInt(25) + 15, 1, stuffs,
				iSword, new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " " + nameGenetaror.getTrollName(),
				rand.nextInt(10) + 20, rand.nextInt(25) + 15, 1,
				new HashMap<Stuff, Integer>(), new Fist(), new Armor(), rand
						.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " " + nameGenetaror.getTrollName(),
				rand.nextInt(10) + 20, rand.nextInt(25) + 15, 1,
				new HashMap<Stuff, Integer>(), new Fist(), new Armor(), rand
						.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " " + nameGenetaror.getTrollName(),
				rand.nextInt(10) + 20, rand.nextInt(25) + 15, 1,
				new HashMap<Stuff, Integer>(), new Fist(), new Armor(), rand
						.nextInt(100)));
	}

	public List<Mob> generate() {
		List<Mob> newMobs = new ArrayList<Mob>();
		Random random = new Random();

		for (int i = 0; i < random.nextInt(7); i++) {
			Collections.shuffle(mobs);
			if (!newMobs.contains(mobs.get(0))) {
				mobs.get(0).setXp(random.nextInt(300) + 50);
				newMobs.add(mobs.get(0));
			}
		}

		return newMobs;
	}

	public Mob generateBoss() {
		Random random = new Random();

		Mob newMob = new Mob(Local.MOB_BOSS, random.nextInt(70) + 200,
				random.nextInt(10) + 1, random.nextInt(10) + 1,
				random.nextInt(10) + 1, random.nextInt(10) + 1,
				random.nextInt(10) + 1, 0, 0, 1, new HashMap<Stuff, Integer>(),
				new Fist(), new Armor(), random.nextInt(1000) + 1000, false);
		newMob.setXp(random.nextInt(2000) + 1000);
		return newMob;
	}
}
