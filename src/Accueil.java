import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Accueil extends JFrame implements ActionListener{
	/**
	 * C'est la fenêtre accueil de l'application
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel = new JPanel();
	JButton boutonGererPersonne = new JButton("Gerer Personne");
	JButton boutonGererLieu = new JButton("Gerer Lieu");
	JButton boutonGererBadge = new JButton("Gerer Badge");
	JButton boutonReporting = new JButton("Gerer Profil");
	JButton boutonQuitter = new JButton("Retour");

	public Accueil() {
		this.setTitle("Accueil");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		containerPanel.setLayout(null);
		this.setVisible(true);
		this.setContentPane(containerPanel);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boutonGererPersonne.setBounds(150,100, 200, 50);
		boutonGererLieu.setBounds(150, 175, 200, 50);
		boutonGererBadge.setBounds(150, 250, 200, 50);
		boutonReporting.setBounds(150,325, 200, 50);
		boutonQuitter.setBounds(150, 400, 200, 50);
		
		
		boutonReporting.addActionListener(this);
		boutonGererLieu.addActionListener(this);
		boutonGererPersonne.addActionListener(this);
		boutonGererBadge.addActionListener(this);
		containerPanel.add(boutonGererPersonne);
		containerPanel.add(boutonGererLieu);
		containerPanel.add(boutonGererBadge);
		containerPanel.add(boutonReporting);
		containerPanel.add(boutonQuitter);
	}
	
	public void actionPerformed(ActionEvent ae) {

		try {
			dispose();
			if (ae.getSource() == boutonGererPersonne) {
				new GererPersonneFenetre();
			}
			if (ae.getSource() == boutonGererLieu) {
				new GererLieuFenetre();
			}
			if (ae.getSource() == boutonGererBadge) {
				new GererBadgeFenetre();
			}
			if (ae.getSource() == boutonReporting) {
				new GererProfilFenetre();
			}
			if (ae.getSource() == boutonQuitter) {
				new AuthentificationFenetre();
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
