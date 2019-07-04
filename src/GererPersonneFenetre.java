import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import javax.swing.*;

public class GererPersonneFenetre extends JFrame implements ActionListener {

	/**
	 * Fenetre gerer personne
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JButton boutonCreerPersonne;
	JButton boutonModifierPersonne;
	JButton boutonSupprimerPersonne;
	JButton boutonRetour;
	
	public GererPersonneFenetre() {
		this.setSize(425,300);
		this.setTitle("Gérer Personne");
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		boutonCreerPersonne = new JButton("Creer");
		boutonModifierPersonne = new JButton("Modifier");
		boutonSupprimerPersonne = new JButton("Supprimer");
		boutonRetour = new JButton("Retour");
		boutonCreerPersonne.setBounds(160,60,100,30);
		boutonModifierPersonne.setBounds(50,110,100,30);
		boutonSupprimerPersonne.setBounds(270, 110, 100, 30);
		boutonRetour.setBounds(160,160,100,30);
		
		containerPanel.add(boutonCreerPersonne);
		containerPanel.add(boutonModifierPersonne);
		containerPanel.add(boutonSupprimerPersonne);
		containerPanel.add(boutonRetour);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		boutonCreerPersonne.addActionListener((ActionListener) this);
		boutonModifierPersonne.addActionListener((ActionListener) this);
		boutonSupprimerPersonne.addActionListener((ActionListener) this);
		boutonRetour.addActionListener((ActionListener) this);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		dispose();
		try {
			if (ae.getSource() == boutonCreerPersonne) {
				new CreerPersonneFenetre();
			}
			if(ae.getSource() == boutonModifierPersonne) {
				new ModifierPersonneFenetre();			}
			if(ae.getSource() == boutonSupprimerPersonne) {
				new SupprimerPersonneFenetre();
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
