package _20240918.principal;
import java.sql.*;
import java.util.Enumeration;

public class Conexion {
	public Conexion() {
		// Paso 1
		// import a java.sql.*
		
		// Paso 2 Carga del driver (PostgreSQL)
		
		// Paso 2.1 Registrar el driver
		try {
			Class.forName("org.postgresql.Driver");
			Enumeration ee = DriverManager.getDrivers();
			while(ee.hasMoreElements()) {
				Driver d = (Driver) ee.nextElement();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Paso 3 Establecer la conexión
		//DriverManager.getConnection("");
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://192.168.1.254:5432/UniversidadEducomser", "super_user", "123456Ax+");
		
			// Paso 4 Crear un statement
			Statement st = con.createStatement();
			
			// Paso 5 Ejecutar la consulta
			ResultSet rs = st.executeQuery("select * from estudiante");
			
			rs.next();
			
			String nom = rs.getString(2);
			String ap = rs.getString("apellido");
			/*	  
			 * [] <----
			 * []
			 * []
			 * []
			 * 
			 * */
			
			con.close();
			st.close();
			rs.close();
			System.out.println(String.format("Nombre completo: %s %s", nom, ap));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
