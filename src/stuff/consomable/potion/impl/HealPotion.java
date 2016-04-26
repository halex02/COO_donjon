package stuff.consomable.potion.impl;

import java.util.Random;

import localisation.Local;
import mob.Mob;
import stuff.consomable.potion.Potion;

public class HealPotion extends Potion {
	
	public HealPotion() {
		name = Local.POTION_HEAL_NAME;
		setDescription(Local.POTION_HEAL_DESCRIPTION);
		setValue(10);
		setWeight(0);
	}
	
	@Override
	public void use(Mob source) {
		super.use(source);
		Random random = new Random();
		Integer gain = random.nextInt(20) + 10;
		gain = source.getMaxPv() * gain / 100;
		System.out.println(String.format(Local.POTION_HEAL_EFFECT, source.getName(), gain));
		if(source.getPv() + gain <= source.getMaxPv()){
			source.setPv(source.getPv() + gain);
		}else{
			source.setPv(source.getMaxPv());
		}
	}
	
	@Override
	public void use(Mob source, Mob target) {
		use(source);
	}
}
