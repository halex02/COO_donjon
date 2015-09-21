package spell.impl;

import java.util.List;
import java.util.Random;

import localisation.Local;
import mob.Mob;
import spell.Spell;

public class FireBall extends Spell {

	public FireBall() {
		super(Spell.TargetType.Solo);
		name = Local.SPELL_FIREBALL_NAME;
	}

	
	@Override
	public void use(Mob source, List<Mob> targets) {
		use(source, targets.get(0));
	}

	@Override
	public void use(Mob source, Mob target) {
		Random random = new Random();
		int degats = (source.getIntelligence() * 2) + 5 + random.nextInt(10);
		System.out.println(String.format(Local.SPELL_FIREBALL_EFFECT, source.getName(), target.getName(), degats));
		target.setPv(target.getPv() - degats);
	}

}
