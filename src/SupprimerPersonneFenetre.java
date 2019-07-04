import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class SupprimerPersonneFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre supprimer personne
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonSupprimer = new JButton("Supprimer");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private PersonneDAO personneDAO = new PersonneDAO();
	
	public SupprimerPersonneFenetre() {
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
		this.setTitle("Accueil");
		this.setSize(500, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		pan.setLayout(null);
		pan.add(boutonAnnuler);
		pan.add(boutonSupprimer);
		pan.add(jscroll);
		this.setVisible(true);
		this.setContentPane(pan);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jscroll.setBounds(25, 50, 400, 500);
		boutonAnnuler.setBounds(200, 600, 100, 50);
		boutonSupprimer.setBounds(325, 600, 100, 50);
		boutonAnnuler.addActionListener(this);
		boutonSupprimer.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {

		
		try {
			if (ae.getSource() == boutonSupprimer) {
				PersonneDAO personneDAO = new PersonneDAO();
				dispose();
				int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				personneDAO.Supprimer(id);
				JOptionPane.showMessageDialog(this,"La personne a été supprimée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				new GererPersonneFenetre();
			}
			if (ae.getSource() == boutonAnnuler) {
				dispose();
				new GererPersonneFenetre();
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
