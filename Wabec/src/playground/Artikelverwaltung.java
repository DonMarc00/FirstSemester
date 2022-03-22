package playground;

import java.util.ArrayList;



public class Artikelverwaltung {
	
    public static ArrayList<Artikel> inventory = new ArrayList<Artikel>();
    public static ArrayList<String> nameList = new ArrayList<String>();
    static double kontostand = 10000; 
    
    public static void getKontostand(){
    	System.out.println(kontostand);
    }
	
	public static class Artikel{
		String name;
		String description;
		double price;
		
		public Artikel(String name, String description, double price){
			this.name = name;
			this.description = description;
			this.price = price;
		}
		
		public void priceTag() {
			System.out.println("Name: " + name);
			System.out.println("Description: " + description);
			System.out.println("Price: " + price + "€");
			if(nameList.contains(name)) {
				System.out.println("Ist Vorhanden");
			}
			else
				System.out.println("Ist nicht vorhanden");
		}

		
		public static void printAll() {
			for(int i=0; i < inventory.size(); i++) {
				System.out.println("ID:" + i);
				inventory.get(i).priceTag();
				System.out.println();
			}
		}
		
		public static void sell(int ID) {
			kontostand = kontostand + inventory.get(ID).price;
			nameList.remove(inventory.get(ID).name);
			inventory.remove(ID);
		}
	}
	
	public static class DVD extends Artikel{
          int usk;
		DVD(String name, String description, double price, int usk) {
			super(name, description, price);
			this.usk = usk;
			
		}
		
		public static void add(String name, String description, double price, int usk) {
			DVD wabec = new DVD(name, description, price, usk);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
		
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: " );
			System.out.println("USK: " + usk);
		}
		
	}
	
	public static class Games extends Artikel{
         int usk;
		Games(String name, String description, double price, int usk) {
			super(name, description, price);
			this.usk = usk;
			
		}
		
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: " );
			System.out.println("USK: " + usk);
		}
		
		public static void add(String name, String description, double price, int usk) {
			Games wabec = new Games(name, description, price, usk);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
		
	}
	
	public static class Waschmaschiene extends Artikel{
        int mass; 
		Waschmaschiene(String name, String description, double price,int mass) {
			super(name, description, price);
			this.mass = mass;
		}
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: " );
			System.out.println("Mass: " + mass);
		}
		
		public static void add(String name, String description, double price, int mass) {
			Waschmaschiene wabec = new Waschmaschiene(name, description, price, mass);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
	}
	
	public static class Kaffemaschiene extends Artikel{
        double vol;
		Kaffemaschiene(String name, String description, double price, double vol) {
			super(name, description, price);
			this.vol = vol;

		}
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: " );
			System.out.println("Volume: " + vol);
		}
		
		public static void add(String name, String description, double price, double vol) {
			Kaffemaschiene wabec = new Kaffemaschiene(name, description, price, vol);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
		
	}
	
	public static class PC extends Artikel{
        int ram; double storage;
		PC(String name, String description, double price, int ram, double storage) {
			super(name, description, price);
			this.ram = ram;
			this.storage = storage;
		}
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: ");
			System.out.println("RAM: " + ram);
			System.out.println("Storage: " + storage);
		}
		
		public static void add(String name, String description, double price, int ram, int storage) {
			PC wabec = new PC(name, description, price, ram, storage);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
		
	}
	
	public static class Konsole extends Artikel{
        String manu;
		Konsole(String name, String description, double price, String manu) {
			super(name, description, price);
			this.manu = manu;
			
		}
		public void priceTag() {
			super.priceTag();
			System.out.println("Inv: ");
			System.out.println("Manufacturer: " + manu);
		}
		
		public static void add(String name, String description, double price, String manu) {
			Konsole wabec = new Konsole(name, description, price, manu);
			inventory.add(wabec);
			nameList.add(wabec.name);
			kontostand = kontostand - (price*0.8);
		}
		
	}
	
	public static void main(String[] args) {
		DVD.add("GayShit", "Eww", 5.95, 18);
		inventory.get(0).priceTag();
		DVD.add("HarryPotter", "Wabec", 10.50, 18);
		DVD.add("HarryPotter", "Wabec", 10.50, 18);
		DVD.add("HarryPotter", "Wabec", 10.50, 18);
		DVD.sell(3);
        System.out.println(inventory.get(0).name);
        inventory.get(0).priceTag();
        inventory.get(1).priceTag();
        
        Artikel.printAll();
        Artikelverwaltung.getKontostand();
        
	}
	

	}


