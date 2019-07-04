
public class Personne {
	/**
	 * Classe personne
	 * @param idPersonne entier , nom prenom date et fonction en constante 
	 */
	 int idPersonne; 
	 String nom;
	 String prenom;
	 String date;
	 String fonction;  
	 
	 public Personne () {
		 
	 }
	 
	 public Personne(int idPersonne, String nom, String prenom, String dateNaissance, String fonction) {
		 this.idPersonne = idPersonne;
		 this.nom = nom ; 
		 this.prenom = prenom;
		 this.date = dateNaissance;
		 this.fonction = fonction;
	 }
	 
	 public String getNom() {
		 return nom;
	 }
	 
	 public String getPrenom() {
		 return prenom;
	 }
	 public int getIdPersonne() {
		 return idPersonne;
	 }
	 
	 public String getDate() {
		 return date;
	 }
	 
		
	 public String getFonction() {
		 return fonction;
	 }
	 
	 
	 public void setNom(String nom) {
		 this.nom = nom;
	 }
	
	 public void setPrenom(String prenom) {
		 this.prenom = prenom;
	 }

	 public void setDate(String dateNaissance) {
		 this.date = dateNaissance;
	 }
}
