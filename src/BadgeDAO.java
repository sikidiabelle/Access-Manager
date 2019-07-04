import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BadgeDAO {
	
	
	/**
	* Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
	* sont des constantes
	*/
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "sys as sysdba"; //
	final static String PASS = "0000"; //
	/**
	* Constructeur de la classe
	*
	*/
	public BadgeDAO() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	public int ajouter(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			 ps = con.prepareStatement("INSERT INTO badge (IdPersonneB, IdBadge) VALUES (?, personne_seq.NEXTVAL )");
			 ps.setInt(1, id);
			 retour = ps.executeUpdate();
		}
		catch (Exception e) {
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
		return retour;
	}
	
	public int supprimer(int id)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			 ps = con.prepareStatement("DELETE FROM badge WHERE idPersonneB = ?");
			 ps.setInt(1,id);
			 retour = ps.executeUpdate();
		}
		catch (Exception e) {
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
		
		return retour;
	}
	
	public List<Personne> getListePersonne() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personne> retour = new ArrayList<Personne>();
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personne INNER JOIN badge ON idpersonne = idpersonneB  ");
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


	
