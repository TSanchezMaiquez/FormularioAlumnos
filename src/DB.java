import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	private final String SERVER = "localhost";
	private final String PORT = "3306";
	private final String DB = "alumno";
	private final String USER = "root";
	private final String PASS = "1234";
	private final String URL = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DB;

	public ArrayList<Alumno> buscarAlumnos(String busqueda, String ordenar, String ordenacion, String cantidad, String por) {
		ArrayList<Alumno> listado = new ArrayList<Alumno>();

		try {

			// Lineas esenciales para la conexion con base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();
			// -----------------------------------------------------

			//Falta modificar aqui
			// Query si no se ha pasado una cadena de texto
			String query = "SELECT nombre, apellido1, apellido2, poblacion FROM alumno a INNER JOIN codigopostal cp ON a.cp = cp.cp";
			
			//Query si se ha introducido una cadena de texto
			if (busqueda.length() > 0) {
				query += this.buildWhere(busqueda, por);
				query = query.replaceAll("<<busqueda>>", busqueda);

			}
			query += " ORDER BY " + ordenar + " " + ordenacion + " LIMIT " + cantidad;
			 
			query += ";";
			
			System.out.println(query);
			// Ejecutar query
			ResultSet rs = stmt.executeQuery(query);
			
			// Bucle que recore los datos recogidos en la query "rs" y los añade a listado
			while (rs.next()) {
				Alumno aux = new Alumno(
						rs.getString("nombre"), 
						rs.getString("apellido1"), 
						rs.getString("apellido2"),
						rs.getString("poblacion")
						);
				listado.add(aux);
			}
			//--------------------------------------------------------
			//Cerrar conexiones
			rs.close();
			stmt.close();
			conn.close();
			//--------------------------------------------------------
			
		} catch (Exception e) {
			System.err.println("Error" + e);
		}

		return listado;
	}
	
	
	private String buildWhere(String terminos, String por) {
		String where = " Where ";
		String[] campo = terminos.split(" ");

		for (int i = 0; i < campo.length; i++) {

			where += "(nombre like '%" + campo[i] + "%' or apellido1 like '%" + campo[i] + "%' or apellido2 like '%"
					+ campo[i] + "%' or poblacion like '%" + campo[i] + "%') ";

			if (i < campo.length - 1) {
				where += por;

			}
		}
		return where;
	}
	
}
