package stuff.consomable.scroll;

import localisation.Local;
import mob.Mob;
import stuff.consomable.Consommable;

public abstract class Scroll extends Consommable {

	@Override
	public void use(Mob source, Mob target) {
		System.out.println(String.format(Local.ACTION_READ_SCROLL, source.getName()));
	}

}
