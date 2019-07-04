
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO{
	
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "sys as sysdba";  
	final static String PASS = "0000";
	
	public PersonneDAO(){
		//Chargement du pilote de base de donn�es
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, "
					+ "ne pas oublier d'importer le fichier .jar dans le projet");
		}
		
	}
	
	int ajouter(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		System.out.println("erreur 1");
		// connexion � la base de donn�es
		try {
			System.out.println("erreur 2");
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr�paration de l'instruction SQL, chaque ? repr�sente une valeur
			// � communiquer dans l'insertion
			// les getters permettent de r�cup�rer les valeurs des attributs
			// souhait�s
			ps = con.prepareStatement("INSERT INTO personne (idPersonne, nom, prenom, fonction, dateNaissance) VALUES (personne_seq.NEXTVAL, ?, ?, ?, ?)");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setString(3, personne.getFonction());
			ps.setString(4, personne.getDate());
			// Ex�cution de la requ�te
			retour = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		System.out.println("erreur6");
		return retour;		
	}
	
	int Supprimer(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		System.out.println("erreur 1");
		// connexion � la base de donn�es
		try {
			System.out.println("erreur 2");
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("erreur 3");
			// pr�paration de l'instruction SQL, chaque ? repr�sente une valeur
			// � communiquer dans l'insertion
			// les getters permettent de r�cup�rer les valeurs des attributs
			// souhait�s
			ps = con.prepareStatement("DELETE FROM personne WHERE idPersonne = ?");
			ps.setInt(1, id);
			System.out.println("erreur 4");
			// Ex�cution de la requ�te
			retour = ps.executeUpdate();
			System.out.println("erreur 5");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		System.out.println("erreur6");
		return retour;	
	}
	
	int modifier(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		System.out.println("erreur 1");
		// connexion � la base de donn�es
		try {
			System.out.println("erreur 2");
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("erreur 3");
			// pr�paration de l'instruction SQL, chaque ? repr�sente une valeur
			// � communiquer dans l'insertion
			// les getters permettent de r�cup�rer les valeurs des attributs
			// souhait�s
			ps = con.prepareStatement("UPDATE personne SET nom = ?, prenom = ?, fonction = ?, dateNaissance = ? WHERE idPersonne = ?");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setString(3, personne.getFonction());
			ps.setString(4, personne.getDate());
			ps.setInt(5, personne.getIdPersonne());
			System.out.println("erreur 4");
			// Ex�cution de la requ�te
			retour = ps.executeUpdate();
			System.out.println("erreur 5");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		System.out.println("erreur6");
		return retour;	
	}
	public Personne getPersonne(int idPersonne) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personne retour = null;

		// connexion � la base de donn�es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personne WHERE idPersonne = ?");
			ps.setInt(1, idPersonne);

			// on ex�cute la requ�te
			// rs contient un pointeur situ� juste avant la premi�re ligne
			// retourn�e
			rs = ps.executeQuery();
			// passe � la premi�re (et unique) ligne retourn�e
			if (rs.next())
				retour = new Personne(rs.getInt("IdPersonne"),rs.getString("nom"),
				rs.getString("prenom"),
				rs.getString("fonction"), rs.getString("dateNaissance"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}
	
	/**
	 * Permet de r�cup�rer toutes les personnes stock�es dans la table article
	 * 
	 * @return une ArrayList de Personnes
	 */
	public List<Personne> getListePersonne() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personne> retour = new ArrayList<Personne>();
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personne ");
			rs = ps.executeQuery();
			while (rs.next()) {
				retour.add(new Personne(rs.getInt("idpersonne"),rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("dateNaissance"), rs.getString("fonction")));
			}
		} 
		catch (Exception ee) {
			ee.printStackTrace();
		} 
		finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
	}

}