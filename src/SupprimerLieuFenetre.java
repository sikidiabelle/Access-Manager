import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class SupprimerLieuFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre supprimer lieu
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonSupprimer = new JButton("Supprimer");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][4];
	private LieuDAO lieuDAO = new LieuDAO();
	
	public SupprimerLieuFenetre() {
		String titre[] = {"IdPersonne", "Emplacement", "Horaire", "Nbre Access"};
		
		int n = lieuDAO.getListeLieu().size();		
		for(int i = 0; i<n; i++) {
			data[i][0] = String.valueOf(lieuDAO.getListeLieu().get(i).getIdLieu());
			data[i][1] = lieuDAO.getListeLieu().get(i).getEmplacement();
			data[i][2] = lieuDAO.getListeLieu().get(i).getHoraire();
			data[i][3] = String.valueOf(lieuDAO.getListeLieu().get(i).getNbreAcces());
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
				LieuDAO lieuDAO = new LieuDAO();
				dispose();
				int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				lieuDAO.supprimer(id);
				JOptionPane.showMessageDialog(this,"Le lieu a été supprimée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				new GererLieuFenetre();
			}
			if (ae.getSource() == boutonAnnuler) {
				dispose();
				new GererLieuFenetre();
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
