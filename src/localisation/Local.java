package localisation;

public final class Local {
	// public final static String = "";
	public final static String STARTING_ROOM_NAME = "Start";
	public final static String STARTING_ROOM_DESCRIPTION = "Bienvenus à l'entrée du Donjon";

	public final static String ENDING_ROOM_NAME = "End";
	public final static String ENDING_ROOM_DESCRIPTION = "l'anti-chambre de la sortie";

	public final static String ROOM_BOSS_NAME = "La salle du Boss";
	public final static String ROOM_BOSS_DESCRIPTION = "l'antre du Boss !";

	public final static String ROOM_COULOIR_NAME = "Couloir";
	public final static String ROOM_COULOIR_DESCRIPTION_1 = "un long couloir";
	public final static String ROOM_COULOIR_DESCRIPTION_2 = "un couloir sombre";
	public final static String ROOM_COULOIR_DESCRIPTION_3 = "un couloir glacial";
	public final static String ROOM_COULOIR_DESCRIPTION_4 = "un couloir bien decore";
	public final static String ROOM_COULOIR_DESCRIPTION_5 = "un couloir lugubre";

	public final static String ROOM_STANDAR_NAME = "Une cellule";
	public final static String ROOM_STANDAR_DESCRIPTION_1 = "une cellule";
	public final static String ROOM_STANDAR_DESCRIPTION_2 = "une cellule sombre";
	public final static String ROOM_STANDAR_DESCRIPTION_3 = "une cellule glacial";
	public final static String ROOM_STANDAR_DESCRIPTION_4 = "une cellule bien decore";
	public final static String ROOM_STANDAR_DESCRIPTION_5 = "une cellule lugubre";

	public final static String ROOM_TRAP_NAME = "la salle ensanglantée";
	public final static String ROOM_TRAP_DESCRIPTION = "la salle ensanglantée";
	
	public final static String ROOM_TRESURE_NAME = "Salle au trésore";
	public final static String ROOM_TRESURE_DESCRIPTION = "Une salle magnifique un gros coffre trône en son centre";
	
	public final static String ROOM_OS_ROOM = "Un mecanisme complexe implicant des piques, des masses, des lames et d'autres éléments que vous n'arrivez pas à definir ce met en branle et grâce à vous en son centre rebatise cette piéce \"la salle ensanglantée\"";
	public final static String ROOM_TRIGGERED = "A peine metez-vous un pied dans cette salle que votre sang ce fige quand vous entendez un petit déclic";

	public final static String[] ISSUE_STANDAR = { "Une porte en bois",
			"Une tenture", "Une grille", "Une porte" };
	public final static String ISSUE_PREVIOUS = "En arriere";

	public static final String WEAPON_WOODEN_SWORD_NAME = "Epee en bois";
	public static final String WEAPON_WOODEN_SWORD_DESCRIPTION = "En regardant cette epee vous y voyez votre tendre enfance, mais vous n'y voyez certainement pas une arme";
	public static final String WEAPON_WOODEN_SWORD_EFFECT = "L'epee s\'abbat sur %s dans un \"pof\" minable et inflige %d";
	public static final String WEAPON_IRON_SWORD_NAME = "Epee en fer";
	public static final String WEAPON_IRON_SWORD_DESCRIPTION = "Arme à pas cher";
	public static final String WEAPON_STEEL_SWORD_NAME = "Epee en acier";
	public static final String WEAPON_STEEL_SWORD_DESCRIPTION = "Bonne fracture et bien aiguiser, que demander de plus ?";
	public static final String WEAPON_SWORD_EFFECT = "L'epee s\'abbat sur %s et inflige %d";
	public static final String WEAPON_FIST_NAME = "Ses poings";
	public static final String WEAPON_FIST_EFFECT = "%s abbat son poing dans la figure de %s et lui fait %d mais se fait aussi %d de dégat";

	public static final String ARMOR_WOODEN_NAME = "Arumre en Bois";
	public static final String ARMOR_WOODEN_DESCRIPTION = "La vie de l'arbre qui à servi à fabriquer cette armure avais sans doute moins de valeur que la votre...";
	public static final String ARMOR_PLATE_NAME = "Arumre de plaque";
	public static final String ARMOR_PLATE_DESCRIPTION = "Vous ressemblez peut-être à une boite de conserve, mais à une boite de conserve vivante !";
	
	public final static String SCROLL_NAME = "Parchemin de %s";

	public static final String SPELL_FIREBALL_NAME = "Boule de feu";
	public static final String SPELL_FIREBALL_DESCRIPTION = "La boule de feu, un grand classique";
	public static final String SPELL_FIREBALL_EFFECT = "%s lance une boule de feu sur %s et lui inflique %d";
	
	public static final String POTION_HEAL_NAME = "Potion de soin";
	public static final String POTION_HEAL_DESCRIPTION = "Recette de grand-mére qui revigore";
	public static final String POTION_HEAL_EFFECT = "%s ce vois regagner %d PV";

	public final static String MOB_GOBELIN = "Gobelin";
	public final static String MOB_ORC = "Orc";
	public final static String MOB_TROLL = "Troll";
	public final static String MOB_BOSS = "Fistor";

	 public final static String ACTION_TEXT = "Que voullez-vous faire ?";
	 public final static String ACTION_LIST = "1 - Changer de salle\n"
		 		+ "2 - Foullier\n"
		 		+ "3 - Inventaire\n"
		 		+ "4 - Danser";
	 public final static String ACTION_ATTAQUER = "5 - Attaquer\n";
	 public final static String ACTION_ATTAQUE = "%s attaque avec \"%s\"";
	 public final static String ACTION_RUN = "%s tente de s'enfuir";
	 public final static String ACTION_MOVE = "%s rentre dans %s";
	 public final static String ACTION_CHANGER_SALLE_MULT = "Il y as plusieur issue :";
	 public final static String ACTION_CHANGER_SALLE_UNI = "Il n'y as qu'une issue :";
	 public final static String ACTION_PASS = "0 - retour";
	 public final static String ACTION_TROW = "1 - Jeter";
	 public final static String ACTION_USE = "2 - Utiliser";
	 public final static String ACTION_EQUIP = "2 - Equiper";
	 public final static String ACTION_READ_SCROLL = "%s lit un parchemin...";
	 public final static String ACTION_USE_POTION = "%s avale la potion d'une traite";

	 public final static String LAST_PV= "Il lui reste %d pv";
	 public final static String LVL_UP = "%s passe lvl %d";
	 public final static String DEATH= "%s est Mort";
	 public final static String LOOT = "Vous obtenez :";
	 public final static String MOBS_WAITTING = "On vous y attendait !";
	 public final static String EQUIPED= "(equipé)";
	 public final static String RESPOWN= "Respown ! Live : %d";
	 
	 

	 public final static String FOUILLE = "Un rapide tour de la salle vous revéle ces richesses";
	 public final static String FOUILLE_VIDE = "Cette salle ne contien rien de valeur";

	 public final static String IDIOT_ATTAQUE = "%s donne un coup à un enemis que lui seul semble voir";
	 public final static String IDIOT_ISSUE = "%s se cogne contre le mur";
	 public final static String IDIOT_DANSE = "%s fait une danse rigolote...";
	 public final static String IDIOT_CHOICE = "%s n'est pas un choix valide";
	 
	 public final static String STATS_SELECTOR = "Quel Statistique ameliorer ?";
	 
}
