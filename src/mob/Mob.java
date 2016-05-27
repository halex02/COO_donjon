package mob;

import java.util.List;
import java.util.Map;
import java.util.Random;

import localisation.Local;
import stuff.Stuff;
import stuff.armor.Armor;
import stuff.weapon.Weapon;

public class Mob implements Comparable<Mob> {

	private String name;
	protected Integer pv;
	protected Integer maxPv;
	protected Integer strenth;
	protected Integer toughness;
	protected Integer acuracy;
	protected Integer intelligence;
	protected Integer charisma;
	private Integer xp;
	private Integer lvl;
	private Integer live;
	private Map<Stuff, Integer> stuff;
	private Weapon weapon;
	private Armor armor;
	private Integer po;
	private Boolean isPlayer;

	private static final Integer lvlTab[] = { 0, 100, 300, 600, 1000, 1500,
			2100, 2800, 3600, 4500 };

	public Mob(String nom, Integer maxPv, Integer xp, Integer lvl,
			Map<Stuff, Integer> stuff, Weapon weapon, Armor armor, Integer po) {
		super();
		this.name = nom;
		this.pv = maxPv;
		this.maxPv = maxPv;
		this.strenth = 0;
		this.toughness = 0;
		this.acuracy = 0;
		this.intelligence = 0;
		this.charisma = 0;
		this.xp = xp;
		this.lvl = lvl;
		this.stuff = stuff;
		this.weapon = weapon;
		this.armor = armor;
		this.po = po;
		this.isPlayer = false;
	}

	public Mob(String nom, Integer maxPv, Integer strenth, Integer toughness,
			Integer acuracy, Integer intelligence, Integer charisma,
			Integer xp, Integer lvl, Integer live, Map<Stuff, Integer> stuff,
			Weapon weapon, Armor armor, Integer po, Boolean isPlayer) {
		super();
		this.name = nom;
		this.pv = maxPv;
		this.maxPv = maxPv;
		this.strenth = strenth;
		this.toughness = toughness;
		this.acuracy = acuracy;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.xp = xp;
		this.lvl = lvl;
		this.live = live;
		this.stuff = stuff;
		this.weapon = weapon;
		this.armor = armor;
		this.po = po;
		this.isPlayer = isPlayer;
	}

	public String getName() {
		return name;
	}

	public Integer getPv() {
		return pv;
	}

	public Integer getMaxPv() {
		return maxPv;
	}

	public Integer getStrenth() {
		return strenth;
	}

	public Integer getToughness() {
		return toughness;
	}

	public Integer getAcuracy() {
		return acuracy;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public Integer getXp() {
		return xp;
	}

	public Integer getLvl() {
		return lvl;
	}

	public Integer getLive() {
		return live;
	}

	public Map<Stuff, Integer> getStuff() {
		return stuff;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public Integer getPo() {
		return po;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public void setMaxPv(Integer maxPv) {
		this.maxPv = maxPv;
	}

	public void setStrenth(Integer strenth) {
		this.strenth = strenth;
	}

	public void setToughness(Integer toughness) {
		this.toughness = toughness;
	}

	public void setAcuracy(Integer acuracy) {
		this.acuracy = acuracy;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
		while (lvlTab[lvl] < xp) {
			lvl = lvl + 1;
			Random random = new Random();
			int gain = random.nextInt(4) + 2;
			if (isPlayer) {
				System.out.println(String.format(Local.LVL_UP, name, lvl));
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_STRENTH));
			}
			strenth += gain;
			gain = random.nextInt(4) + 2;
			if (isPlayer) {
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_TOUGHNESS));
			}
			toughness += gain;
			gain = random.nextInt(4) + 2;
			if (isPlayer) {
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_ACURACY));
			}
			acuracy += gain;
			gain = random.nextInt(4) + 2;
			if (isPlayer) {
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_INTELLIGENCE));
			}
			intelligence += gain;
			gain = random.nextInt(4) + 2;
			if (isPlayer) {
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_CHARISMA));
			}
			charisma += gain;
			gain = (random.nextInt(4) + 2) * toughness;
			if (isPlayer) {
				System.out.println(String.format(Local.ACTION_GAIN, name, gain,
						Local.STATS_PV));
			}
			maxPv += gain;
			pv = maxPv;
		}
	}

	public void setLvl(Integer lvl) {
		if (lvl > this.lvl) {
			pv = maxPv;
		}
		this.lvl = lvl;
	}

	public void setLive(Integer live) {
		this.live = live;
	}

	public void setStuff(Map<Stuff, Integer> stuff) {
		this.stuff = stuff;
	}

	public void addStuff(Stuff stuff) {
		this.stuff
				.put(stuff,
						(this.stuff.get(stuff) != null ? this.stuff.get(stuff)
								: 0) + 1);
	}

	public void addStuff(Stuff stuff, Integer nb) {
		this.stuff.put(stuff,
				(this.stuff.get(stuff) != null ? this.stuff.get(stuff) : 0)
						+ nb);
	}

	public void addAllStuff(List<Stuff> stuffs) {
		for (Stuff stuff : stuffs) {
			addStuff(stuff);
		}
	}

	public void addAllStuff(Map<Stuff, Integer> stuffs) {
		for (Stuff stuff : stuffs.keySet()) {
			addStuff(stuff, stuffs.get(stuff));
		}
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setPo(Integer po) {
		this.po = po;
	}

	@Override
	public int compareTo(Mob o) {
		return name.compareTo(o.name);
	}
}
