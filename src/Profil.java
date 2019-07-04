
public class Profil {
	/**
	 * Fenetre supprimer badge
	 * @param idProfil_entier , nom et horaire_Constante
	 */
	int idProfil;
	String nom;
	String horaire;
	
	public Profil(int idProfil, String nom, String horaire) {
		this.idProfil = idProfil;
		this.nom = nom;
		this.horaire = horaire;		
	}
	/**
	 * Permet de récupérer tous les profils stockées dans la table 
	 * 
	 * @return l'entier et les constantes
	 */
	public Profil() {
		
	}
	
	/**
	 * 
	 * @return l'entier et les constantes
	 */
	int getidProfil() {
		return idProfil;
	}
	
	String getNom() {
		return nom;
	}
	
	String getHoraire() {
		return horaire;
	}
}
