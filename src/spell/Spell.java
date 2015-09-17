package spell;
import java.util.List;

import mob.Mob;


public abstract class Spell {
	public abstract void use(List<Mob> targets);
	public abstract void use(Mob targets);
}
