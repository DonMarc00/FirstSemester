package databases;


public class EffectMonster extends MonsterCard {

	public EffectMonster(String name, String eigenschaft, String text, int stufe, String typ1, int angriff,
			int verteidigung) {
		super(name, eigenschaft, text, stufe, typ1, angriff, verteidigung);
		this.setTyp2("Effekt");
	}

	

}
