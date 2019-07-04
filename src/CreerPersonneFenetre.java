import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class CreerPersonneFenetre extends JFrame implements ActionListener {
	/**
	 * Fenetre creer personne
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JLabel labelNom;
	JLabel labelPrenom;
	JLabel labelDateDeNaissance;
	JLabel labelFonction;
	JTextField textFieldNom;
	JTextField textFieldPrenom;
	JTextField textFieldDateDeNaissance;
	JComboBox<String> comboBoxFonction;
	JButton boutonCreer;
	JButton boutonRetour;
	Personne personne;
	
	public CreerPersonneFenetre(){
		this.setTitle("Creer Personne");
		this.setSize(550,500);
		this.setLayout(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		String[] tab= {"Etudiant", "Enseignant", "Personnel Administratif", "Stagiaire", "Autre"};
		labelNom = new JLabel("NOM");
		labelPrenom = new JLabel("PRENOM");
		labelDateDeNaissance = new JLabel("DATE DE NAISSANCE");
		labelFonction = new JLabel("FONCTION");
		textFieldNom = new JTextField();
		textFieldPrenom = new JTextField();
		textFieldDateDeNaissance = new JTextField();
		comboBoxFonction = new JComboBox<String>(tab);
		boutonCreer = new JButton("Créer");
		boutonRetour = new JButton("Retour");
		labelNom.setBounds(50, 50, 100, 30);
		labelPrenom.setBounds(50,100, 100, 30);
		labelDateDeNaissance.setBounds(50, 150, 100, 30);
		labelFonction.setBounds(50, 200, 100, 30);
		textFieldNom.setBounds(180, 50, 300, 30);
		textFieldPrenom.setBounds(180,100,300,30);
		textFieldDateDeNaissance.setBounds(180, 150, 300, 30);
		comboBoxFonction.setBounds(180, 200, 300, 30);
		boutonRetour.setBounds(290, 300, 80, 30);
		boutonCreer.setBounds(400, 300, 80, 30);
			
		boutonRetour.addActionListener(this);
		boutonCreer.addActionListener(this);
		
		containerPanel.add(labelNom);
		containerPanel.add(labelPrenom);
		containerPanel.add(labelDateDeNaissance);
		containerPanel.add(labelFonction);
		containerPanel.add(textFieldNom);
		containerPanel.add(textFieldPrenom);
		containerPanel.add(comboBoxFonction);
		containerPanel.add(textFieldDateDeNaissance);
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
				PersonneDAO persDAO = new PersonneDAO();
				Personne personne = new Personne();
				personne.nom = textFieldNom.getText();
				personne.prenom = textFieldPrenom.getText();
				personne.date = textFieldDateDeNaissance.getText();
				personne.fonction = comboBoxFonction.getSelectedItem().toString();
				persDAO.ajouter(personne);
				JOptionPane.showMessageDialog(this,"Une nouvelle personne a été ajoutée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				new GererPersonneFenetre();
				
				
			}
			if(ae.getSource() == boutonRetour) {
				this.dispose();
				new GererPersonneFenetre();
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,
					"Veuillez contrôler vos saisies", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contrôler vos saisies");
		}	
	}
}
