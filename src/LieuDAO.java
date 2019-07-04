import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LieuDAO {
	
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "sys as sysdba";  
	final static String PASS = "0000";
	
	public LieuDAO() {
	// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err
			.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
		
		}

	public int ajouter(Lieu lieu) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// préparation de l'instruction SQL, chaque ? représente une valeur
			// à communiquer dans l'insertion
			// les getters permettent de récupérer les valeurs des attributs
			// souhaités
			ps = con.prepareStatement("INSERT INTO lieu (idLieu, emplacement, horaire, nbreAcces) VALUES (personne_seq.NEXTVAL, ?, ?, ?)");
			ps.setString(1, lieu.getEmplacement());
			ps.setString(2, lieu.getHoraire());
			ps.setInt(3, lieu.getNbreAcces());

			// Exécution de la requête
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
		return retour;
	}
		
		int supprimer(int id) {
			Connection con = null;
			PreparedStatement ps = null;
			int retour = 0;
			System.out.println("erreur 1");
			// connexion à la base de données
			try {
				System.out.println("erreur 2");
				// tentative de connexion
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				System.out.println("erreur 3");
				// préparation de l'instruction SQL, chaque ? représente une valeur
				// à communiquer dans l'insertion
				// les getters permettent de récupérer les valeurs des attributs
				// souhaités
				ps = con.prepareStatement("DELETE FROM lieu WHERE idLieu = ?");
				ps.setInt(1, id);
				System.out.println("erreur 4");
				// Exécution de la requête
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
		public List<Lieu> getListeLieu() {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Lieu> retour = new ArrayList<Lieu>();
			
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM lieu ");
				rs = ps.executeQuery();
				while (rs.next()) {
					retour.add(new Lieu(rs.getInt("idlieu"),rs.getString("emplacement"),
							rs.getString("horaire"),
							rs.getInt("nbreacces")));
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
