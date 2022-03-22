package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager implements Repository{
	
	private DataManager() {
		
	}
	
	private static DataManager instance = new DataManager();
	
	public static DataManager getInstance() {
		return instance;
	}

	@Override
	public void storeCard(Card card) {
		
		String query = "INSERT INTO public.sammelkarten(name, eigenschaft, text, nummer) VALUES (?, ?, ?, ?);";
		
		//Monster update querys
		
		String monquery = "UPDATE public.Sammelkarten SET stufe = ?, typ1=?, angriff=?, verteidigung=? WHERE nummer = ?;";
		String effquery = "UPDATE public.Sammelkarten SET typ2=? WHERE nummer = ?;";
		String specquery = "UPDATE public.Sammelkarten SET  typ3=?,WHERE nummer = ?;";
		try (Connection conn = DataSource.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				PreparedStatement mps = conn.prepareStatement(monquery);
				PreparedStatement eps = conn.prepareStatement(effquery);
				PreparedStatement sps = conn.prepareStatement(specquery);) {
			
			ps.setString(1, card.getName());
			ps.setString(2, card.getEigenschaft());
			ps.setString(3, card.getText());
			ps.setInt(4, card.getNummer());
			ps.executeUpdate();
			
			if(card instanceof MonsterCard) {
				
				mps.setInt(1, card.getStufe());
				mps.setString(2, card.getTyp1());
				mps.setInt(3, card.getAngriff());
				mps.setInt(4, card.getVerteidigung());
				mps.setInt(5, card.getNummer());
				
			}
			if(card instanceof EffectMonster) {
				eps.setString(1, card.getTyp2());
				eps.setInt(2, card.getNummer());
			}
			if(card instanceof SpecialMonster) {
				sps.setString(1, card.getTyp3());
				sps.setInt(2, card.getNummer());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showData(card);
			System.out.println("SQL Error: Card was not stored");
		}

		
	}

	@Override
	public Card loadCard(int id) {

		String query = "SELECT name, eigenschaft, text,nummer ,stufe,typ1 , typ2, typ3, angriff, verteidigung FROM public.Sammelkarten WHERE nummer = ?; ";
		try (Connection conn = DataSource.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			// Holt Daten der Karte, speichert in RS
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			 String name;
			 String eigenschaft;
			 String text;
			 String typ1;
			 String typ2; 
			 String typ3;
			 int stufe;
			 int nummer = id;
			 int angriff;
			 int verteidigung;
			 
			 Card card = null;
			
			while (rs.next()) {

				name = rs.getString("name");
				eigenschaft = rs.getString("eigenschaft");
				text = rs.getString("text");
				stufe = rs.getInt("stufe");
				typ1 = rs.getString("typ1");
				typ2 = rs.getString("typ2");
				typ3 = rs.getString("typ3");
				angriff = rs.getInt("angriff");
				verteidigung = rs.getInt("verteidigung");


			if (eigenschaft.equals("Zauber")) {

				card = new MagicCard(name, text);

			} else if (eigenschaft.equals("Falle")) {

				card = new TrapCard(name, text);

			} else if (typ3 != null) {

				card = new SpecialMonster(name, eigenschaft, text, stufe, typ1, typ3, angriff, verteidigung);

			} else if (typ2 != null) {

				card = new EffectMonster(name, eigenschaft, text, stufe, typ1, angriff, verteidigung);

			} else if (typ1 != null) {

				card = new MonsterCard(name, eigenschaft, text, stufe, typ1, angriff, verteidigung);

			}

			card.setNummer(nummer);
			
			}
			return card;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return null;
	}
	
	public void deleteCard(int id) {

		String query = "DELETE FROM public.sammelkarten WHERE nummer = ?;";
		try (Connection conn = DataSource.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Card was not deleted");
		} 
	}
	
	public void showData(Card c) {
		System.out.println("Name: " + c.getName());
		System.out.println("Eigenschaft: "+c.getEigenschaft());
		System.out.println("Text: "+c.getText());
		System.out.println("Nummer: "+c.getNummer());
		System.out.println("Stufe: " + c.getStufe());
		System.out.println("Typ1: "+c.getTyp1());
		System.out.println("Typ2: "+c.getTyp2());
		System.out.println("Typ3: "+c.getTyp3());
		System.out.println("Angriff: "+c.getAngriff());
		System.out.println("Verteidigung: "+c.getVerteidigung());
		
	}

}

