package mob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		List<Stuff> stuffs = new ArrayList<Stuff>();
		Weapon wSword = new WoodenSword();
		stuffs.add(wSword);
		mobs.add(new Mob(Local.MOB_GOBELIN + " 1", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 2", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 3", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, wSword, new Armor(), rand.nextInt(5)));
		
		Weapon iSword = new IronSword();
		stuffs = new ArrayList<Stuff>();
		stuffs.add(iSword);
		
		mobs.add(new Mob(Local.MOB_GOBELIN + " 4", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, iSword, new Armor(), rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 5", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, iSword, new Armor(), rand.nextInt(5)));
		
		
		mobs.add(new Mob(Local.MOB_ORC + " 1", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 2", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 3", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 4", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 5", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, iSword, new Armor(), rand.nextInt(10)));

		mobs.add(new Mob(Local.MOB_TROLL + " 1", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, iSword, new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 2", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, iSword, new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 3", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, new ArrayList<Stuff>(), new Fist(), new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 4", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, new ArrayList<Stuff>(), new Fist(), new Armor(), rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 5", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, new ArrayList<Stuff>(), new Fist(), new Armor(), rand.nextInt(100)));
	}

	public List<Mob> generate() {
		List<Mob> newMobs = new ArrayList<Mob>();
		Random random = new Random();

		for (int i = 0; i < random.nextInt(7); i++) {
			Collections.shuffle(mobs);
			if (!newMobs.contains(mobs.get(0))) {
				newMobs.add(mobs.get(0));
			}
		}

		return newMobs;
	}

	public Mob generateBoss() {
		Random random = new Random();
		
		Mob newMob = new Mob(Local.MOB_BOSS, random.nextInt(70) + 200, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, 0, 0, 1, new ArrayList<Stuff>(), new Fist(), new Armor(), random.nextInt(1000) + 1000, false);
		newMob.setXp(random.nextInt(2000) + 1000);
		return newMob;
	}
}
