package mob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobNameGenetaror {

	public String getGobelineName(){
		List<String> frstSillable = new ArrayList<String>();
		frstSillable.add("Dob");
		frstSillable.add("Gub");
		frstSillable.add("Lak");
		frstSillable.add("Voc");
		frstSillable.add("Dab");
		frstSillable.add("Dub");
		List<String> secSillable = new ArrayList<String>();
		secSillable.add("");
		secSillable.add("niak");
		secSillable.add("voc");
		secSillable.add("lar");
		secSillable.add("scion");
		secSillable.add("couen");
		secSillable.add("vion");
		secSillable.add("at");
		secSillable.add("uk");
		secSillable.add("ak");
		List<String> trdSillable = new ArrayList<String>();
		trdSillable.add("gax");
		trdSillable.add("gix");
		trdSillable.add("bax");
		trdSillable.add("bix");
		trdSillable.add("cax");
		trdSillable.add("vax");
		Collections.shuffle(frstSillable);
		Collections.shuffle(secSillable);
		Collections.shuffle(trdSillable);
		return frstSillable.get(0) + secSillable.get(0) + trdSillable.get(0);
	}

	public String getOrcName(){
		List<String> frstSillable = new ArrayList<String>();
		frstSillable.add("Kal");
		frstSillable.add("Kul");
		frstSillable.add("Kol");
		frstSillable.add("Arg");
		frstSillable.add("Aro");
		frstSillable.add("Vul");
		List<String> secSillable = new ArrayList<String>();
		secSillable.add("");
		secSillable.add("rog");
		secSillable.add("go");
		secSillable.add("ra");
		secSillable.add("ro");
		secSillable.add("ki");
		List<String> trdSillable = new ArrayList<String>();
		trdSillable.add("nar");
		trdSillable.add("r");
		trdSillable.add("kar");
		trdSillable.add("var");
		trdSillable.add("vor");
		Collections.shuffle(frstSillable);
		Collections.shuffle(secSillable);
		Collections.shuffle(trdSillable);
		return frstSillable.get(0) + secSillable.get(0) + trdSillable.get(0);
	}

	public String getTrollName(){
		List<String> frstSillable = new ArrayList<String>();
		frstSillable.add("Mar");
		frstSillable.add("Mug");
		frstSillable.add("Mog");
		frstSillable.add("Dar");
		frstSillable.add("Dur");
		frstSillable.add("Dor");
		List<String> secSillable = new ArrayList<String>();
		secSillable.add("nar");
		secSillable.add("nor");
		secSillable.add("nur");
		secSillable.add("gar");
		secSillable.add("gor");
		secSillable.add("gur");
		secSillable.add("rog");
		secSillable.add("gar");
		secSillable.add("rug");
		Collections.shuffle(frstSillable);
		Collections.shuffle(secSillable);
		return frstSillable.get(0) + secSillable.get(0);
	}
}
