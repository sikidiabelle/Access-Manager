
public class Lieu {
	/**
	 * Classe lieu
	 * @param idLieu et nbreAcces_entier , emplacement et horaire constantes 
	 */
	int idLieu;
	String emplacement;
	String horaire;
	int nbreAcces;
	
	public Lieu () {
		/**
		 *  
		 */
	}
	
	public Lieu(int idLieu, String emplacement, String horaire, int nbreAcces) {
		this.idLieu = idLieu;
		this.emplacement = emplacement;
		this.horaire = horaire;
		this.nbreAcces = nbreAcces;
	}
	
	int getIdLieu() {
		return idLieu;
	}
	
	String getEmplacement() {
		return emplacement;
	}
	
	String getHoraire() {
		return horaire;
	}
	
	int getNbreAcces() {
		return nbreAcces;
	}
}
