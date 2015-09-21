package spell;
import java.util.List;

import mob.Mob;


public abstract class Spell {
	public enum TargetType {
		Solo,
		Multi
	}
	private final TargetType targetType;
	protected String name;
	
	public Spell(TargetType targetType) {
		this.targetType = targetType;
	}
	
	public TargetType getTargetType() {
		return targetType;
	}

	public abstract void use(Mob source,List<Mob> targets);
	public abstract void use(Mob source,Mob target);
}
