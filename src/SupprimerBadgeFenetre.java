import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class SupprimerBadgeFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre supprimer badge
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JButton boutonEnregistrer = new JButton("Supprimer");
	private JButton boutonAnnuler = new JButton("Annuler");
	private JTable table;
	private JScrollPane jscroll;
	String data[][]= new String[30][5];
	private BadgeDAO badgeDAO = new BadgeDAO();
	
	public SupprimerBadgeFenetre() {
		String titre[] = {"IdPersonne", "Nom", "Prenom", "Date de Naissance", "Fonction"};
		
		int n = badgeDAO.getListePersonne().size();		
		for(int i = 0; i<n; i++) {
			data[i][0] = String.valueOf(badgeDAO.getListePersonne().get(i).getIdPersonne());
			data[i][1]= badgeDAO.getListePersonne().get(i).getNom();
			data[i][2]= badgeDAO.getListePersonne().get(i).getPrenom();
			data[i][3]= badgeDAO.getListePersonne().get(i).getDate();
			data[i][4]= badgeDAO.getListePersonne().get(i).getFonction();
		}
		
		table = new JTable(data, titre);
		jscroll = new JScrollPane(table);
		this.setTitle("Supprimer Badge");
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
				JOptionPane.showMessageDialog(this,"Le badge a �t� supprim�", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				badge.supprimer(id);
				new GererBadgeFenetre();
			}
			if (ae.getSource() == boutonAnnuler) {
				dispose();
				new GererBadgeFenetre();
			}
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contr�ler vos saisies1", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contr�ler vos saisies");
		}

	}
	
}
