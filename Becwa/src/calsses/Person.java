package calsses;

public class Person {
    int personalnummer;
    String nachname;
    double gehalt;
    
    public Person(int personalnummer, String nachname, double gehalt) {
    	this.personalnummer = personalnummer;
    	this.nachname = nachname;
    	this.gehalt = gehalt;
    }
    
    public void setPersonalnummer(int personalnummer) {
    	this.personalnummer = personalnummer;
    }
    
    public void setNachname(String nachname) {
    	this.nachname = nachname;
    }
    
    public void setGehalt(double gehalt) {
    	this.gehalt = gehalt;
    }
    
    public int getPersonalnummer() {
    	return personalnummer;
    }
    
    public String getNachname() {
    	return nachname;
    }
    
    public double getGehalt() {
    	return gehalt;
    }
    
    public void gehaltHoch(double erhoehung) {
    	gehalt += erhoehung; 
    }
    public void getAll() {
    	System.out.println("Personalnummer: " + personalnummer);
    	System.out.println("Nachname: " + nachname);
    	System.out.println("Gehalt: " + gehalt);
    }
}
