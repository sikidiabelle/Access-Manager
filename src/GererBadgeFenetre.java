import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import javax.swing.*;

public class GererBadgeFenetre extends JFrame implements ActionListener {

	/**
	 * Fenetre Gerer badge
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JButton boutonCreerBadge;
	JButton boutonSupprimerBadge;
	JButton boutonRetour;
	
	public GererBadgeFenetre() {
		this.setSize(425,300);
		this.setTitle("Gérer Badge");
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		boutonCreerBadge = new JButton("Creer");
		boutonSupprimerBadge = new JButton("Supprimer");
		boutonRetour = new JButton("Retour");
		boutonCreerBadge.setBounds(160,60,100,30);
		boutonSupprimerBadge.setBounds(50,110,100,30);
		boutonRetour.setBounds(270, 110, 100, 30);
		
		containerPanel.add(boutonCreerBadge);
		containerPanel.add(boutonSupprimerBadge);
		containerPanel.add(boutonRetour);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		boutonCreerBadge.addActionListener((ActionListener) this);
		boutonSupprimerBadge.addActionListener((ActionListener) this);
		boutonRetour.addActionListener((ActionListener) this);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		dispose();
		try {
			if (ae.getSource() == boutonCreerBadge) {
				new CreerBadgeFenetre();
			}
			if(ae.getSource() == boutonSupprimerBadge) {
				new SupprimerBadgeFenetre();		
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
