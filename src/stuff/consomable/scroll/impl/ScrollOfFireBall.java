package stuff.consomable.scroll.impl;

import localisation.Local;
import mob.Mob;
import spell.Spell;
import spell.impl.FireBall;
import stuff.consomable.scroll.Scroll;

public class ScrollOfFireBall extends Scroll {

	Spell fireBall;
	
	public ScrollOfFireBall() {
		name = String.format(Local.SCROLL_NAME, Local.SPELL_FIREBALL_NAME);
		setDescription(Local.SPELL_FIREBALL_DESCRIPTION);
		setValue(10);
		setWeight(0);
	}
	
	@Override
	public void use(Mob source, Mob target) {
		super.use(source, target);;
		fireBall = new FireBall();
		fireBall.use(source, target);
	}

}
