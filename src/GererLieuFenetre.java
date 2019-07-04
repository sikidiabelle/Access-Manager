import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import javax.swing.*;

public class GererLieuFenetre extends JFrame implements ActionListener {

	/**
	 * Fenetre gerer lieu
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JButton boutonCreerLieu;
	JButton boutonSupprimerLieu;
	JButton boutonBloquerLieu;
	JButton boutonRetour;
	
	public GererLieuFenetre() {
		this.setSize(425,300);
		this.setTitle("Gérer Lieu");
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		boutonCreerLieu = new JButton("Creer");
		boutonSupprimerLieu = new JButton("Supprimer");
		boutonBloquerLieu = new JButton("Bloquer");
		boutonRetour = new JButton("Retour");
		boutonCreerLieu.setBounds(160,60,100,30);
		boutonSupprimerLieu.setBounds(50,110,100,30);
		boutonBloquerLieu.setBounds(270, 110, 100, 30);
		boutonRetour.setBounds(160,160,100,30);
		
		containerPanel.add(boutonCreerLieu);
		containerPanel.add(boutonSupprimerLieu);
		containerPanel.add(boutonBloquerLieu);
		containerPanel.add(boutonRetour);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		boutonCreerLieu.addActionListener((ActionListener) this);
		boutonSupprimerLieu.addActionListener((ActionListener) this);
		boutonBloquerLieu.addActionListener((ActionListener) this);
		boutonRetour.addActionListener((ActionListener) this);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		dispose();
		try {
			if (ae.getSource() == boutonCreerLieu) {
				new CreerLieuFenetre();
			}
			if(ae.getSource() == boutonSupprimerLieu) {
				new SupprimerLieuFenetre();			}
			if(ae.getSource() == boutonBloquerLieu) {
				JOptionPane.showMessageDialog(this, "Pas opértionnel");
			}
			if(ae.getSource() == boutonRetour) {
				this.dispose();
				new Accueil();
			}
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contrôler vos saisies", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contrôler vos saisies");
		}

	}
}
