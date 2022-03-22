package databases;


public abstract class Card {

	private String eigenschaft;
	private String name;
	private String text;
	private int nummer;
	private int stufe;
	private String typ1;
	private String typ2;
	private String typ3;
	private int angriff;
	private int verteidigung;

	

	public String getEigenschaft() {
		return eigenschaft;
	}

	public void setEigenschaft(String eigenschaft) {
		this.eigenschaft = eigenschaft;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getStufe() {
		return stufe;
	}

	public void setStufe(int stufe) {
		this.stufe = stufe;
	}

	public String getTyp1() {
		return typ1;
	}

	public void setTyp1(String typ1) {
		this.typ1 = typ1;
	}

	public String getTyp2() {
		return typ2;
	}

	public void setTyp2(String typ2) {
		this.typ2 = typ2;
	}

	public String getTyp3() {
		return typ3;
	}

	public void setTyp3(String typ3) {
		this.typ3 = typ3;
	}

	public int getAngriff() {
		return angriff;
	}

	public void setAngriff(int angriff) {
		this.angriff = angriff;
	}

	public int getVerteidigung() {
		return verteidigung;
	}

	public void setVerteidigung(int verteidigung) {
		this.verteidigung = verteidigung;
	}

	
	

	
	
}
