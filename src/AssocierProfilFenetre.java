import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AssocierProfilFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre Associer profil
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonSelectionner = new JButton("Selectionner");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][3];
	private ProfilDAO profilDAO = new ProfilDAO();
	
	public AssocierProfilFenetre() {
		String titre[] = {"IdProfil", "Nom", "Creneaux"};
		
		int n = profilDAO.getListeProfil().size();		
		for(int i = 0; i<n; i++) {
			data[i][0] = String.valueOf(profilDAO.getListeProfil().get(i).getidProfil());
			data[i][1] = profilDAO.getListeProfil().get(i).getNom();
			data[i][2] = profilDAO.getListeProfil().get(i).getHoraire();
		}
		
		table = new JTable(data, titre);
		jscroll = new JScrollPane(table);
		this.setTitle("Associer Profil/Personne");
		this.setSize(500, 800);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		pan.setLayout(null);
		pan.add(boutonAnnuler);
		pan.add(boutonSelectionner);
		pan.add(jscroll);
		this.setVisible(true);
		this.setContentPane(pan);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jscroll.setBounds(25, 50, 400, 500);
		boutonAnnuler.setBounds(200, 600, 100, 50);
		boutonSelectionner.setBounds(325, 600, 100, 50);
		boutonAnnuler.addActionListener(this);
		boutonSelectionner.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {

		
		try {
			if (ae.getSource() == boutonSelectionner) {
				dispose();
				int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				new AssocierProfilFenetre2(id);
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
