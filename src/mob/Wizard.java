package mob;

import java.util.List;
import java.util.Map;

import spell.Spell;
import stuff.Stuff;
import stuff.armor.Armor;
import stuff.weapon.Weapon;

public class Wizard extends Mob {

	private List<Spell> spell;

	public Wizard(String nom, Integer maxPv, Integer strenth,
			Integer toughness, Integer acuracy, Integer intelligence,
			Integer charisma, Integer xp, Integer lvl, Integer live,
			Map<Stuff, Integer> stuff, Weapon weapon, Armor armor, Integer po,
			List<Spell> spell, Boolean isPlayer) {
		super(nom, maxPv, strenth, toughness, acuracy, intelligence, charisma,
				xp, lvl, live, stuff, weapon, armor, po, isPlayer);
		this.spell = spell;
	}

	public Wizard(String nom, Integer maxPv, Integer xp, Integer lvl,
			Map<Stuff, Integer> stuff, Weapon weapon, Armor armor, Integer po,
			List<Spell> spell) {
		super(nom, maxPv, xp, lvl, stuff, weapon, armor, po);
		this.spell = spell;
	}

	public List<Spell> getSpell() {
		return spell;
	}

	public void setSpell(List<Spell> spells) {
		this.spell = spells;
	}
}
