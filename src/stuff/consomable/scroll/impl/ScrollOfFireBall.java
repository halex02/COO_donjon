package stuff.consomable.scroll.impl;

import mob.Mob;
import spell.Spell;
import spell.impl.FireBall;
import stuff.consomable.scroll.Scroll;

public class ScrollOfFireBall extends Scroll {

	Spell fireBall;
	@Override
	public void use(Mob source, Mob target) {
		super.use(source, target);;
		fireBall = new FireBall();
		fireBall.use(source, target);
	}

}
