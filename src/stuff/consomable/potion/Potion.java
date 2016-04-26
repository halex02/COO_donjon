package stuff.consomable.potion;

import localisation.Local;
import mob.Mob;
import stuff.consomable.Consommable;

public class Potion extends Consommable {
	
	public void use(Mob source) {
		System.out.println(String.format(Local.ACTION_USE_POTION, source.getName()));
	}

	@Override
	public void use(Mob source, Mob target) {
		use(source);
	}

}
