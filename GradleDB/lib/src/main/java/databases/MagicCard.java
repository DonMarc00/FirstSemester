package databases;


public class MagicCard extends Card {

	public MagicCard(String name, String text) {
		this.setName(name);
		this.setText("Zauber");
		this.setNummer((int) (Math.random() * 1000000 + 1));
		this.setText(text);
		
	}
}
