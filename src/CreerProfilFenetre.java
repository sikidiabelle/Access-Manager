import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class CreerProfilFenetre extends JFrame implements ActionListener {
	/**
	 * Fenetre creer profil
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JLabel labelNom;
	JLabel labelCreneaux;
	JTextField textFieldCreneaux;
	JTextField textFieldNom;
	JButton boutonCreer;
	JButton boutonRetour;
	
	public CreerProfilFenetre(){
		this.setTitle("Creer Profil");
		this.setSize(550,400);
		this.setLayout(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		labelNom = new JLabel("NOM");
		labelCreneaux = new JLabel("CRENEAUX");
		textFieldNom = new JTextField();
		textFieldCreneaux = new JTextField();
		boutonCreer = new JButton("Créer");
		boutonRetour = new JButton("Retour");
		labelNom.setBounds(50, 50, 100, 30);
		labelCreneaux.setBounds(50,100, 100, 30);
		textFieldNom.setBounds(175, 50, 300, 30);
		textFieldCreneaux.setBounds(175, 100, 300, 30);
		boutonRetour.setBounds(185, 150, 80, 30);
		boutonCreer.setBounds(295, 150, 80, 30);
			
		boutonRetour.addActionListener(this);
		boutonCreer.addActionListener(this);
		
		containerPanel.add(labelNom);
		containerPanel.add(labelCreneaux);
		containerPanel.add(textFieldNom);
		containerPanel.add(textFieldCreneaux);
		containerPanel.add(boutonRetour);
		containerPanel.add(boutonCreer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == boutonCreer) {
				ProfilDAO profilDAO = new ProfilDAO();
				Profil profil = new Profil();
				profil.nom = textFieldNom.getText();
				profil.horaire =  textFieldCreneaux.getText();
						profilDAO.ajouter(profil);
				JOptionPane.showMessageDialog(this,"Un nouveau profil a été ajoutée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new GererProfilFenetre();
				
			}
			if(ae.getSource() == boutonRetour) {
				this.dispose();
				new GererProfilFenetre();
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,
					"Veuillez contrôler vos saisies1", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contrôler vos saisies&");
		}	
	}
}
