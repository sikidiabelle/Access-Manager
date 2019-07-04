import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class ModifierPersonneFenetre2 extends JFrame implements ActionListener {
	/**
	 * Fenetre modifier personne deuxieme
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
	JButton boutonRetour;
	JButton boutonModifier;
	int id = 0;

	
	public ModifierPersonneFenetre2(Personne personne){
		this.setTitle("Modifier Personne");
		this.setSize(550,500);
		this.setLayout(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		String[] tab= {"Etudiant", "Enseignant", "Personnel Administratif", "Stagiaire", "Autre"};
		labelNom = new JLabel("NOM");
		labelPrenom = new JLabel("PRENOM");
		labelDateDeNaissance = new JLabel("DATE DE NAISSANCE");
		labelFonction = new JLabel("FONCTION");
		textFieldNom = new JTextField(personne.getNom());
		textFieldPrenom = new JTextField(personne.getPrenom());
		textFieldDateDeNaissance = new JTextField(personne.getDate());
		comboBoxFonction = new JComboBox<String>(tab);
		boutonModifier = new JButton("Modifier");
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
		boutonModifier.setBounds(400, 300, 80, 30);
			
		boutonRetour.addActionListener(this);
		boutonModifier.addActionListener(this);
		
		containerPanel.add(labelNom);
		containerPanel.add(labelPrenom);
		containerPanel.add(labelDateDeNaissance);
		containerPanel.add(labelFonction);
		containerPanel.add(textFieldNom);
		containerPanel.add(textFieldPrenom);
		containerPanel.add(comboBoxFonction);
		containerPanel.add(textFieldDateDeNaissance);
		containerPanel.add(boutonRetour);
		containerPanel.add(boutonModifier);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setContentPane(containerPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		id = personne.getIdPersonne();
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == boutonModifier) {
				PersonneDAO personneDAO = new PersonneDAO();
				Personne personnes = new Personne();
				personnes.idPersonne = id;
				personnes.nom = textFieldNom.getText();
				personnes.prenom = textFieldPrenom.getText();
				personnes.date = textFieldDateDeNaissance.getText();
				personnes.fonction = comboBoxFonction.getSelectedItem().toString();
				personneDAO.modifier(personnes);
				JOptionPane.showMessageDialog(this,"La personne a été modifiée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new GererPersonneFenetre();
			}
			if(ae.getSource() == boutonRetour) {
				this.dispose();
				new GererPersonneFenetre();
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,
					"Veuillez contrôler vos saisies 22", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez contrôler vos saisies 222");
		}	
	}
}
