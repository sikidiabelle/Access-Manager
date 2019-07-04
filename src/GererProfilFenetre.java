import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GererProfilFenetre extends JFrame implements ActionListener{
	/**
	 * Fenetre gerer profil
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel = new JPanel();
	JButton boutonCreerProfil = new JButton("Créer Profil");
	JButton boutonAssocierProfil = new JButton("AssocierProfil");
	JButton boutonSupprimerProfil = new JButton("Supprimer Profil");
	JButton boutonListePersonne = new JButton("Liste des Personnes/Profil");
	JButton boutonQuitter = new JButton("Retour");
	
	public GererProfilFenetre() {
		this.setTitle("Gerer Profil");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		containerPanel.setLayout(null);
		this.setVisible(true);
		this.setContentPane(containerPanel);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boutonCreerProfil.setBounds(150,100, 200, 50);
		boutonAssocierProfil.setBounds(150, 175, 200, 50);
		boutonSupprimerProfil.setBounds(150, 250, 200, 50);
		boutonListePersonne.setBounds(150, 250, 200, 50);
		boutonQuitter.setBounds(150, 325, 200, 50);
		
		
		
		boutonCreerProfil.addActionListener(this);
		boutonAssocierProfil.addActionListener(this);
		boutonSupprimerProfil.addActionListener(this);
		boutonListePersonne.addActionListener(this);
		boutonQuitter.addActionListener(this);
		containerPanel.add(boutonCreerProfil);
		containerPanel.add(boutonAssocierProfil);
		containerPanel.add(boutonCreerProfil);
		containerPanel.add(boutonListePersonne);
		containerPanel.add(boutonQuitter);
	}
	
	public void actionPerformed(ActionEvent ae) {

		try {
			dispose();
			
			if (ae.getSource() == boutonCreerProfil) {
				new CreerProfilFenetre();
			}
			
			if (ae.getSource() == boutonAssocierProfil) {
				new AssocierProfilFenetre();
			}
			
			if (ae.getSource() == boutonSupprimerProfil) {
				new SupprimerProfilFenetre();
			}
			
			if (ae.getSource() == boutonListePersonne) {
				new ListePersonnePPFenetre();
			}

			if (ae.getSource() == boutonQuitter) {
				new Accueil();
			}	
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(this,
				"Veuillez contrôler vos saisies0", "Erreur",
				JOptionPane.ERROR_MESSAGE);
		System.err.println("Veuillez contrôler vos saisies");
		}

	}
}
