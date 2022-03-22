package databases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class Window {

	JFrame frame;

	JTextField tfname, tfeig, tfnum, tfstufe, tftyp1, tftyp2, tfang, tfvert, tfid;
	JTextArea tatext, talog;
	JLabel lname, leig, ltext, lnum, lstufe, ltyp1, ltyp2, ltyp3, lang, lvert, llog;

	JButton submit, delete, update, load;

	DefaultListModel<String> l1 = new DefaultListModel<>();
	JList<String> lityp3;

	JRadioButton magic, trap, mon, effmon, specmon;
	
	DataManager manager;

	// Definition of GUI
	public Window() {
		// Window Creation
		frame = new JFrame();
		
		Table table = new Table();
		
		// Gets DataManager
		manager = DataManager.getInstance();

		// ActionListener for Radio
		ActionListener radioListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideBot();
				tfeig.setEnabled(false);
				if (magic.isSelected() || trap.isSelected()) {
					if (magic.isSelected())
						tfeig.setText("Zauber");
					else
						tfeig.setText("Falle");

				} else if (mon.isSelected()) {
					showMon();
					resetProperty();
				} else if (effmon.isSelected()) {
					showMon();
					resetProperty();
					tftyp2.setVisible(true);
				} else if (specmon.isSelected()) {
					showMon();
					resetProperty();
					tftyp2.setVisible(true);
					lityp3.setVisible(true);
				}

			}

		};

		// ActionListener for SubmitButton

		ActionListener submitListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (magic.isSelected()) {
					createMagic();
				} else if (trap.isSelected()) {
					createTrap();
				} else if (mon.isSelected()) {
					createMon();
				} else if (effmon.isSelected()) {
					createEffMon();
				} else if (specmon.isSelected()) {
					createSpecMon();
				}
				table.refreshTable();
				talog.setText("Successfully added new Card!");

			}

		};

		// ActionListener for LoadButton

		ActionListener loadListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfid.getText());
				Card tempCard = new MonsterCard();
				tempCard = manager.loadCard(id);

				// Felder beschreiben
				tfname.setText(tempCard.getName());
				tatext.setText(tempCard.getText());
				tfeig.setText(tempCard.getEigenschaft());
				tfnum.setText(Integer.toString(id));
				tfstufe.setText(Integer.toString(tempCard.getStufe()));
				tftyp1.setText(tempCard.getTyp1());
				tftyp2.setText("Effekt");
				lityp3.setSelectedValue(tempCard.getTyp3(), true);
				tfang.setText(Integer.toString(tempCard.getAngriff()));
				tfvert.setText(Integer.toString(tempCard.getVerteidigung()));

			}

		};

		// ActionListener for DeleteButton

		ActionListener deleteListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfid.getText());
				manager.deleteCard(id);
				talog.setText("Successfully deleted!");
				table.refreshTable();

			}

		};

		// ActionListener for updateButton

		ActionListener updateListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfid.getText());
				updateCard(id);
				talog.setText("Successfully updated card: " + id);
				table.refreshTable();

			}

		};

		// Radios and dimensions,positions
		magic = new JRadioButton("Magic");
		magic.setBounds(50, 20, 100, 30);
		magic.addActionListener(radioListener);

		trap = new JRadioButton("Trap");
		trap.setBounds(50, 50, 100, 30);
		trap.addActionListener(radioListener);

		mon = new JRadioButton("Normal Monster");
		mon.setBounds(50, 80, 100, 30);
		mon.addActionListener(radioListener);

		effmon = new JRadioButton("Effekt Monster");
		effmon.setBounds(50, 110, 100, 30);
		effmon.addActionListener(radioListener);

		specmon = new JRadioButton("Special Monster");
		specmon.setBounds(50, 140, 100, 30);
		specmon.addActionListener(radioListener);

		// Grouping
		ButtonGroup bg = new ButtonGroup();

		bg.add(magic);
		bg.add(trap);
		bg.add(mon);
		bg.add(effmon);
		bg.add(specmon);

		frame.add(magic);
		frame.add(trap);
		frame.add(mon);
		frame.add(effmon);
		frame.add(specmon);

		// Textarea

		tatext = new JTextArea();
		tatext.setBounds(450, 40, 200, 200);
		ltext = new JLabel("Beschreibung/Effekt:");
		ltext.setBounds(450, 20, 200, 15);
		tatext.setLineWrap(true);
		tatext.setWrapStyleWord(true);
		frame.add(ltext);
		frame.add(tatext);

		// Log
		talog = new JTextArea();
		talog.setBounds(700, 40, 250, 400);
		llog = new JLabel("Log:");
		llog.setBounds(700, 20, 200, 15);
		talog.setLineWrap(true);
		talog.setWrapStyleWord(true);
		frame.add(llog);
		frame.add(talog);

		// TextField and labels

		lname = new JLabel("Name:");
		tfname = new JTextField();
		lname.setBounds(200, 20, 200, 15);
		tfname.setBounds(200, 40, 200, 20);

		leig = new JLabel("Eigenschaft:");
		tfeig = new JTextField();
		leig.setBounds(200, 60, 200, 15);
		tfeig.setBounds(200, 80, 200, 20);

		lnum = new JLabel("Nummer:");
		tfnum = new JTextField("Automatically generated");
		lnum.setBounds(200, 100, 200, 15);
		tfnum.setBounds(200, 120, 200, 20);
		tfnum.setEnabled(false);

		lstufe = new JLabel("Stufe(Integer):");
		tfstufe = new JTextField();
		lstufe.setBounds(200, 140, 200, 15);
		tfstufe.setBounds(200, 160, 200, 20);

		ltyp1 = new JLabel("Tyo 1:");
		tftyp1 = new JTextField();
		ltyp1.setBounds(200, 180, 200, 30);
		tftyp1.setBounds(200, 200, 200, 20);

		ltyp2 = new JLabel("Typ 2:");
		tftyp2 = new JTextField("Effekt");
		ltyp2.setBounds(200, 220, 200, 30);
		tftyp2.setBounds(200, 240, 200, 20);
		tftyp2.setEnabled(false);

		// Typ 3 List
		ltyp3 = new JLabel("Special:");
		ltyp3.setBounds(450, 260, 200, 30);
		l1.addElement("Ritual");
		l1.addElement("Fusion");
		l1.addElement("Synchro");
		l1.addElement("XYZ");
		lityp3 = new JList<>(l1);
		lityp3.setBounds(450, 280, 100, 75);
		frame.add(ltyp3);
		frame.add(lityp3);

		lang = new JLabel("Angriff(Int):");
		tfang = new JTextField();
		lang.setBounds(200, 260, 200, 30);
		tfang.setBounds(200, 280, 200, 20);

		lvert = new JLabel("Verteidigung(Int):");
		tfvert = new JTextField();
		lvert.setBounds(200, 300, 200, 30);
		tfvert.setBounds(200, 320, 200, 20);

		// CreateCard Button
		submit = new JButton("Create Card");
		submit.setBounds(200, 360, 150, 30);
		submit.addActionListener(submitListener);

		// UpdateCard Button
		update = new JButton("Update Card");
		update.setBounds(370, 360, 150, 30);
		update.addActionListener(updateListener);

		// DeleteCard Button
		delete = new JButton("Delete Card");
		delete.setBounds(200, 410, 150, 30);
		delete.addActionListener(deleteListener);

		// LoadCard Button
		load = new JButton("Load Card");
		load.setBounds(370, 410, 150, 30);
		load.addActionListener(loadListener);

		// idField
		tfid = new JTextField();
		tfid.setBounds(370, 460, 150, 20);

		// KeyValidation
		tfstufe.addKeyListener(numcheck(tfstufe));
		tfang.addKeyListener(numcheck(tfang));
		tfvert.addKeyListener(numcheck(tfvert));
		tfid.addKeyListener(numcheck(tfid));

		// AddElements
		frame.add(submit);
		frame.add(update);
		frame.add(delete);
		frame.add(load);

		frame.add(lname);
		frame.add(leig);
		frame.add(lnum);
		frame.add(lstufe);
		frame.add(ltyp1);
		frame.add(ltyp2);
		frame.add(lang);
		frame.add(lvert);
		frame.add(tfname);
		frame.add(tfeig);
		frame.add(tfnum);
		frame.add(tfstufe);
		frame.add(tftyp1);
		frame.add(tftyp2);
		frame.add(tfang);
		frame.add(tfvert);
		frame.add(tfid);
		
		

		// Configure frame
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void hideBot() {
		tfstufe.setVisible(false);
		tftyp1.setVisible(false);
		tftyp2.setVisible(false);
		tfang.setVisible(false);
		tfvert.setVisible(false);
		lityp3.setVisible(false);
	}

	public void resetProperty() {
		tfeig.setEnabled(true);
		tfeig.setText(null);
	}

	public void showMon() {
		tfstufe.setVisible(true);
		tftyp1.setVisible(true);
		tfang.setVisible(true);
		tfvert.setVisible(true);
	}

	public void createMagic() {
		String name = tfname.getText();
		String text = tatext.getText();
		Card m = new MagicCard(name, text);
		manager.storeCard(m);
	}

	public void createTrap() {
		String name = tfname.getText();
		String text = tatext.getText();
		new TrapCard(name, text);
		Card t = new TrapCard(name, text);
		manager.storeCard(t);
	}

	public void createMon() {

		String name = tfname.getText();
		String text = tatext.getText();
		String eig = tfeig.getText();
		int stufe = Integer.parseInt(tfstufe.getText());
		String typ1 = tftyp1.getText();
		int ang = Integer.parseInt(tfang.getText());
		int vert = Integer.parseInt(tfvert.getText());
		Card mo = new MonsterCard(name, text, eig, stufe, typ1, ang, vert);
		manager.storeCard(mo);
	}

	public void createEffMon() {
		String name = tfname.getText();
		String text = tatext.getText();
		String eig = tfeig.getText();
		int stufe = Integer.parseInt(tfstufe.getText());
		String typ1 = tftyp1.getText();
		int ang = Integer.parseInt(tfang.getText());
		int vert = Integer.parseInt(tfvert.getText());
		Card e = new EffectMonster(name, eig, text, stufe, typ1, ang, vert);
		manager.storeCard(e);
	}

	public void createSpecMon() {
		String name = tfname.getText();
		String text = tatext.getText();
		String eig = tfeig.getText();
		int stufe = Integer.parseInt(tfstufe.getText());
		String typ1 = tftyp1.getText();
		String typ3 = lityp3.getSelectedValue();
		int ang = Integer.parseInt(tfang.getText());
		int vert = Integer.parseInt(tfvert.getText());
		Card s = new SpecialMonster(name, eig, text, stufe, typ1, typ3, ang, vert);
		manager.storeCard(s);
	}

	public KeyAdapter numcheck(JTextField tf) {
		KeyAdapter numcheck = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {

				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					tf.setEditable(true);
				} else {
					tf.setEditable(false);

				}
			}
		};
		return numcheck;
	}
	
	public void updateCard(int id) {
		String query = "UPDATE public.sammelkarten SET name=?, eigenschaft=?, text=?, nummer=?, stufe=?,typ1=?, typ2=?, typ3=?, angriff=?, verteidigung=? WHERE nummer =?;";
		try (Connection conn = DataSource.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, tfname.getText());
			ps.setString(2, tfeig.getText());
			ps.setString(3, tatext.getText());
			ps.setInt(4, Integer.parseInt(tfid.getText()));
			ps.setInt(5, Integer.parseInt(tfstufe.getText()));
			ps.setString(6, tftyp1.getText());
			ps.setString(7, tftyp2.getText());
			ps.setString(8, lityp3.getSelectedValue());
			ps.setInt(9, Integer.parseInt(tfang.getText()));
			ps.setInt(10, Integer.parseInt(tfvert.getText()));
			ps.setInt(11,  Integer.parseInt(tfid.getText()));
			ps.executeUpdate();

		} catch (SQLException er) {
			// TODO Auto-generated catch block
			er.printStackTrace();
			talog.setText(er.toString());
			
		}
		
	}

}
