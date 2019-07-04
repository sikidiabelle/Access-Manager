import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class ModifierPersonneFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre modifier personne
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonEnregistrer = new JButton("Modifier");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private PersonneDAO personneDAO = new PersonneDAO();
	
	public ModifierPersonneFenetre() {
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
		this.setTitle("Modifier Personne");
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
				Personne personne = new Personne();
				dispose();
				personne.idPersonne = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				personne.nom = (String) table.getValueAt(table.getSelectedRow(), 1);
				personne.prenom = (String) table.getValueAt(table.getSelectedRow(), 2);
				personne.date = (String) table.getValueAt(table.getSelectedRow(), 3);
				personne.fonction = (String) table.getValueAt(table.getSelectedRow(), 4);
				new ModifierPersonneFenetre2(personne);
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
