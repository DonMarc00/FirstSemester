package databases;


public class TrapCard extends Card {
     
	public TrapCard(String name, String text) {
		this.setName(name);
		this.setText("Falle");
		this.setNummer((int) (Math.random() * 1000000 + 1));
		this.setText(text);
		
		
	}

}
