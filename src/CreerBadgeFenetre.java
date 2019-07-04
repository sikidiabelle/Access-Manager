import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class CreerBadgeFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre creer badge
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonEnregistrer = new JButton("Creer");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private PersonneDAO personneDAO = new PersonneDAO();
	
	public CreerBadgeFenetre() {
		String titre[] = {"IdPersonne", "Nom", "Prenom", "Date de Naissance", "Fonction"};
		
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
		this.setTitle("Créer Badge");
		this.setSize(500, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		pan.setLayout(null);
		pan.add(boutonAnnuler);
		pan.add(boutonEnregistrer);
		pan.add(jscroll);
		this.setVisible(true);
		this.setContentPane(pan);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jscroll.setBounds(25, 50, 400, 500);
		boutonAnnuler.setBounds(200, 600, 100, 50);
		boutonEnregistrer.setBounds(325, 600, 100, 50);
		boutonAnnuler.addActionListener(this);
		boutonEnregistrer.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {

		
		try {
			if (ae.getSource() == boutonEnregistrer) {
				BadgeDAO badge = new BadgeDAO();
				int id =0;
				id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				JOptionPane.showMessageDialog(this,"Un badge a été créé pour cette personne", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				badge.ajouter(id);
				new GererBadgeFenetre();
			}
			if (ae.getSource() == boutonAnnuler) {
				dispose();
				new GererBadgeFenetre();
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
