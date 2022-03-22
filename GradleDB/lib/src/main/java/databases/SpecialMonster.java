package databases;


public class SpecialMonster extends EffectMonster {
	

	public SpecialMonster(String name, String eigenschaft, String text, int stufe, String typ1, String typ3,
			int angriff, int verteidigung) {
		super(name, eigenschaft, text, stufe, typ1, angriff, verteidigung);
		this.setTyp3(typ3);

		
	}
	
	
}
