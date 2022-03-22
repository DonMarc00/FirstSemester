package databases;


public class MonsterCard extends Card {
	

	public MonsterCard(String name, String eigenschaft, String text, int stufe, String typ1, int angriff,
			int verteidigung) {
		this.setName(name);
		this.setEigenschaft(eigenschaft);
		this.setText(text);
		this.setStufe(stufe);
		this.setTyp1(typ1);
		this.setAngriff(angriff);
		this.setVerteidigung(verteidigung);
		this.setNummer((int) (Math.random() * 1000000 + 1));
	}
	
	public MonsterCard() {
		
	}

	

}
