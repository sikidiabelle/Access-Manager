import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class AuthentificationFenetre extends JFrame implements ActionListener {
	/**
	 * Fenetre authentification 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerPanel;
	private JLabel labelIdentifiant;
	private JLabel labelPassword;
	private JPasswordField fieldPassword;
	private JTextField textFieldIdentifiant;
	private JButton boutonConnexion;
	
	public AuthentificationFenetre(){
		this.setTitle("S'authentifier/Register");
		this.setSize(600,400);
		this.setLayout(null);
		containerPanel = new JPanel ();
		containerPanel.setLayout(null);
		labelIdentifiant = new JLabel("Utilisateur/Username");
		fieldPassword = new JPasswordField();
		labelPassword = new JLabel("Mot de passe/Password");
		boutonConnexion = new JButton("Connexion");
		textFieldIdentifiant = new JTextField();
		containerPanel.setBackground(Color.CYAN);
		labelPassword.setBounds(30,150, 200, 30);
		fieldPassword.setBounds(240, 150, 200, 30);
		textFieldIdentifiant.setBounds(240, 100, 200, 30);
		labelIdentifiant.setBounds(30, 100, 200, 30);
		boutonConnexion.setBounds(340,200,100,30);
		containerPanel.add(labelIdentifiant);
		containerPanel.add(fieldPassword);
		containerPanel.add(labelPassword);
		containerPanel.add(textFieldIdentifiant);
		containerPanel.add(boutonConnexion);
		
		

		this.setLocationRelativeTo(null);
		boutonConnexion.addActionListener(this);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {

		try {
			if (ae.getSource() == boutonConnexion) {
				if(textFieldIdentifiant.getText().equals("SIKI")||(textFieldIdentifiant.getText().equals("LAMINE"))){
					this.dispose();
					new Accueil();
				}
				else {
					JOptionPane.showMessageDialog(this,
							"Identifiant incorrect", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
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

	