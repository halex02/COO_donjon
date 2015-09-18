package mob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import localisation.Local;
import stuff.Stuff;
import stuff.weapon.impl.WoodenSword;

public class MobGenerator {

	List<Mob> mobs = new ArrayList<Mob>();

	public MobGenerator() {
		Random rand = new Random();
		List<Stuff> stuffs = new ArrayList<Stuff>();
		WoodenSword sword = new WoodenSword();
		stuffs.add(sword);
		mobs.add(new Mob(Local.MOB_GOBELIN + " 1", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, sword, null, rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 2", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, sword, null, rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 3", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, sword, null, rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 4", rand.nextInt(5) + 7, rand
				.nextInt(20), 1, stuffs, sword, null, rand.nextInt(5)));
		mobs.add(new Mob(Local.MOB_GOBELIN + " 5", rand.nextInt(5) + 7, rand
				.nextInt(10) + 5, 1, stuffs, sword, null, rand.nextInt(5)));

		mobs.add(new Mob(Local.MOB_ORC + " 1", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, sword, null, rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 2", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, sword, null, rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 3", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, sword, null, rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 4", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, sword, null, rand.nextInt(10)));
		mobs.add(new Mob(Local.MOB_ORC + " 5", rand.nextInt(6) + 10, rand
				.nextInt(20) + 10, 1, stuffs, sword, null, rand.nextInt(10)));

		mobs.add(new Mob(Local.MOB_TROLL + " 1", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, sword, null, rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 2", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, sword, null, rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 3", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, sword, null, rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 4", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, sword, null, rand.nextInt(100)));
		mobs.add(new Mob(Local.MOB_TROLL + " 5", rand.nextInt(10) + 20, rand
				.nextInt(25) + 15, 1, stuffs, sword, null, rand.nextInt(100)));
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
}
