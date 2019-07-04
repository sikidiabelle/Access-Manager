import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class CreerLieuFenetre extends JFrame implements ActionListener {
	/**
	 * Fenetre creer lieu
	 */
	private static final long serialVersionUID = 1L;
	JPanel containerPanel;
	JLabel labelEmplacement;
	JLabel labelHoraire;
	JLabel labelNbreAcces;
	JTextField textFieldEmplacement;
	JTextField textFieldHoraire;
	JTextField textFieldNbreAcces;
	JComboBox<String> comboBoxFonction;
	JButton boutonCreer;
	JButton boutonRetour;
	Personne personne;
	
	public CreerLieuFenetre(){
		this.setTitle("Creer Lieu");
		this.setSize(550,500);
		this.setLayout(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		labelEmplacement = new JLabel("EMPLACEMENT");
		labelHoraire = new JLabel("HORAIRE");
		labelNbreAcces = new JLabel("NOMBRE D'ACCES");
		textFieldEmplacement = new JTextField();
		textFieldHoraire = new JTextField();
		textFieldNbreAcces = new JTextField();
		boutonCreer = new JButton("Créer");
		boutonRetour = new JButton("Retour");
		labelEmplacement.setBounds(50, 50, 100, 30);
		labelHoraire.setBounds(50,100, 100, 30);
		labelNbreAcces.setBounds(50, 150, 100, 30);
		textFieldEmplacement.setBounds(180, 50, 300, 30);
		textFieldHoraire.setBounds(180,100,300,30);
		textFieldNbreAcces.setBounds(180, 150, 300, 30);
		boutonRetour.setBounds(290, 300, 80, 30);
		boutonCreer.setBounds(400, 300, 80, 30);
			
		boutonRetour.addActionListener(this);
		boutonCreer.addActionListener(this);
		
		containerPanel.add(labelEmplacement);
		containerPanel.add(labelHoraire);
		containerPanel.add(labelNbreAcces);
		containerPanel.add(textFieldEmplacement);
		containerPanel.add(textFieldHoraire);
		containerPanel.add(textFieldNbreAcces);
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
				LieuDAO lieuDAO = new LieuDAO();
				Lieu lieu = new Lieu();
				lieu.emplacement = textFieldEmplacement.getText();
				lieu.horaire = textFieldHoraire.getText();
				lieu.nbreAcces = Integer.parseInt(textFieldNbreAcces.getText());
				lieuDAO.ajouter(lieu);
				JOptionPane.showMessageDialog(this,"Un nouveau lieu a été ajoutée", 
						"Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			if(ae.getSource() == boutonRetour) {
				this.dispose();
				new GererLieuFenetre();
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
