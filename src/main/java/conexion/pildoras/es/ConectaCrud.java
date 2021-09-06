package conexion.pildoras.es;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaCrud
 */
@WebServlet("/ConectaCrud")
public class ConectaCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConectaCrud() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     String jdbcUrl="jdbc:mysql://localhost:3306/tiendavirtual?useSSL=false";
	     String usuario="root";
	     String password="root";
	     
	     String driver="com.mysql.cj.jdbc.Driver";
	     
	     try {
	    	 PrintWriter out=response.getWriter();
	    	 out.println("Nombre de la BBDD: "+jdbcUrl);
	    	 Class.forName(driver);
	    	 Connection miConexion=DriverManager.getConnection(jdbcUrl,usuario,password);
	    	 
	    	 out.print("Conectado");
	    	 
	    	 miConexion.close();
	    	 
	     }catch (Exception e) {
	    	 e.printStackTrace();
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
