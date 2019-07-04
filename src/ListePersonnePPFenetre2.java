import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class ListePersonnePPFenetre2 extends JFrame implements ActionListener{
	/**
	 * Fenetre liste personne deuxieme
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonEnregistrer = new JButton("Retourr");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private ProfilDAO personneDAO = new ProfilDAO();
	
	public ListePersonnePPFenetre2(int id) {
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
		this.setTitle("Liste Personne par Profil");
		this.setSize(500, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		pan.setLayout(null);
		pan.add(boutonEnregistrer);
		pan.add(jscroll);
		this.setVisible(true);
		this.setContentPane(pan);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jscroll.setBounds(25, 50, 400, 500);
		boutonEnregistrer.setBounds(325, 600, 100, 50);
		boutonEnregistrer.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {

		
		try {
			if (ae.getSource() == boutonEnregistrer) {
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
