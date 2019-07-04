import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AssocierProfilFenetre2 extends JFrame implements ActionListener{
	/**
	 * Deuxieme fenetre associer profil
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonAssocier = new JButton("Associer");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private PersonneDAO personneDAO = new PersonneDAO();
	int ids;
	
	public AssocierProfilFenetre2(int id) {
		String titre[] = {"IdPersonne", "Nom", "Prenom", "Date de Naissance", "Fonction"};
		ids = id;
		int n = personneDAO.getListePersonne().size();		
		for(int i = 0; i<n; i++) {
			data[i][0] = String.valueOf(personneDAO.getListePersonne().get(i).getIdPersonne());
			data[i][1]= personneDAO.getListePersonne().get(i).getNom();
			data[i][2]= personneDAO.getListePersonne().get(i).getPrenom();
			data[i][3]= personneDAO.getListePersonne().get(i).getDate();
			data[i][4]= personneDAO.getListePersonne().get(i).getFonction();
		}
		
		table = new JTable(data, titre);
		jscroll = new JScrollPane(table);
		this.setTitle("Associer Personne/Profil");
		this.setSize(500, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		pan.setLayout(null);
		pan.add(boutonAnnuler);
		pan.add(boutonAssocier);
		pan.add(jscroll);
		this.setVisible(true);
		this.setContentPane(pan);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jscroll.setBounds(25, 50, 400, 500);
		boutonAnnuler.setBounds(200, 600, 100, 50);
		boutonAssocier.setBounds(325, 600, 100, 50);
		boutonAnnuler.addActionListener(this);
		boutonAssocier.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {

		
		try {
			if (ae.getSource() == boutonAssocier) {
				ProfilDAO profilDAO = new ProfilDAO();
				int id2 = 0;
				id2 = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				dispose();
				profilDAO.associer(ids, id2);
				JOptionPane.showMessageDialog(this,"Association réussie", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				new GererProfilFenetre();
				
			}
			if (ae.getSource() == boutonAnnuler) {
				dispose();
				new GererProfilFenetre();
			}
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contrôler vos saisies1", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contrôler vos saisies");
		}

	}
	
}
