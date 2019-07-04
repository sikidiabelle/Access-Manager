
public class Badge {
	/**
	 * Classe badge 
	 * @param idPersonne et idBadge qui sont des entiers
	 */
	int idPersonne;
	int idBadge;
	
	public Badge() {
		
	}
	
	public Badge(int idPersonne, int idBadge) {
		this.idPersonne = idPersonne;
		this.idBadge = idBadge;
	}
	
	int getidPersonne() {
		return idPersonne;
	}
	
	int getIdBadge() {
		return idBadge;
	}
}
