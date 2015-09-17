package mob;
import java.util.List;

import stuff.Stuff;
import stuff.armor.Armor;
import stuff.weapon.Weapon;

public class Mob {

    private String nom;
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
    private List<Stuff> stuff;
    private Weapon weapon;
    private Armor armor;
    private Integer po;
    
	public String getNom() {
		return nom;
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
	public List<Stuff> getStuff() {
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
	public void setNom(String nom) {
		this.nom = nom;
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
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public void setLive(Integer live) {
		this.live = live;
	}
	public void setStuff(List<Stuff> stuff) {
		this.stuff = stuff;
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
}
