package databases;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Table {

	String eigenschaft;
	String name;
	String text;
	int nummer;
	int stufe;
	String typ1;
	String typ2;
	String typ3;
	int angriff;
	int verteidigung;
	
	JFrame tablef;
	
	JTable table;
	
	DefaultTableModel dtm = new DefaultTableModel(0,0);
	
	//Table Design 
	Table(){
		
		table = new JTable();
		
		//Header 
		String header[] = new String[]{"Name", "Eigenschaft", "Text", "Nummer", "Stufe", "Typ1", "Typ2", "Typ3", "Angriff", "Verteidigung" };
		
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		
		fillTable();
		
		//Table Bounds etc.
		table.setBounds(30, 40, 700, 400);
		JScrollPane sp = new JScrollPane(table);
		
		
		//Frame
		tablef = new JFrame();
		
		tablef.add(sp);
		tablef.setSize(800, 500);
		tablef.setVisible(true);
	}
	
	void fillTable(){
		String query = "SELECT * FROM public.Sammelkarten";
		try (Connection conn = DataSource.getInstance().getConnection();
				Statement ps = conn.createStatement();) {
			// Holt Daten der Karte, speichert in RS
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				name = rs.getString("name");
				eigenschaft = rs.getString("eigenschaft");
				text = rs.getString("text");
				nummer = rs.getInt("nummer");
				stufe = rs.getInt("stufe");
				typ1 = rs.getString("typ1");
				typ2 = rs.getString("typ2");
				typ3 = rs.getString("typ3");
				angriff = rs.getInt("angriff");
				verteidigung = rs.getInt("verteidigung");
				
				dtm.addRow(new Object[] {name, eigenschaft, text, nummer, stufe, typ1, typ2, typ3, angriff, verteidigung});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	void refreshTable() {
		if(dtm.getRowCount() > 0) {
			for (int i = dtm.getRowCount() - 1; i > -1; i--) {
		        dtm.removeRow(i);
		    }
			
			fillTable();
		}
	}
	
}
