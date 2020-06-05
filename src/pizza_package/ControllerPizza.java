package pizza_package;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class ControllerPizza
 */
@WebServlet("/ControllerPizza")
public class ControllerPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.List<Pizza> listpizza;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerPizza() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
//		 response.getWriter().append(" je suis dans le controler pizza ")
//		 .append(" et l'action est : " + action );

		if (action.equalsIgnoreCase("modifpizza"))
			try {
				modifOnePizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("modifpizzavalid"))
			try {
				modifOnePizzaValid(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("editpizza"))
			try {
				editOnePizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("addpizza"))
			try {
				addPizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("addpizzavalid"))
			try {
				addOnePizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		if (action.equalsIgnoreCase("deletepizza"))
			try {
				deletePizza(request, response);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		if (action.equalsIgnoreCase("listpizza"))
			try {
				affichelistepizza(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private void modifOnePizza(HttpServletRequest request, HttpServletResponse response) 
		throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		int idpizza = Integer.parseInt(request.getParameter("idpizza"));
		Pizza modifpizza = PizzaDAO.getPizzaById(idpizza);
		// response.getWriter().append("i must edit pizza num : "+ idpizza );
		request.setAttribute("modifpizza", modifpizza);
		request.getRequestDispatcher("PizzaModifView.jsp").forward(request, response);
		

		}
	
	private void modifOnePizzaValid(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
			
			int idpizza = Integer.parseInt(request.getParameter("idpizza"));
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et l'id pizza est : " + idpizza );
			
		    
			String DesignPizz = request.getParameter("DesignPizz");
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et le designPizz est : " + DesignPizz );
			
		    
			double TarifPizz = Double.parseDouble(request.getParameter("TarifPizz"));
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et le prix est : " + TarifPizz );
			
			String Description = request.getParameter("Description");
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et la descriptio, est : " + Description );
			

			 PizzaDAO.updatePizza(idpizza, DesignPizz, TarifPizz, Description);

			request.getRequestDispatcher("PizzaImage.jsp").forward(request, response);
			

			}
	
	
	
	
	private void addPizza(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
			
		request.getRequestDispatcher("PizzaAddView.jsp").forward(request, response);

			}
	
	private void addOnePizza(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		    
			String DesignPizz = request.getParameter("DesignPizz");
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et le designPizz est : " + DesignPizz );
			
		    
			double TarifPizz = Double.parseDouble(request.getParameter("TarifPizz"));
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et le prix est : " + TarifPizz );
			
			String Description = request.getParameter("Description");
//			response.getWriter().append(" <br>je suis dans le controler modifOnePizzaValid ")
//			 .append(" et la descriptio, est : " + Description );
		
			 PizzaDAO.ajouterPizza(DesignPizz, TarifPizz, Description);
			 
			request.getRequestDispatcher("PizzaImage.jsp").forward(request, response);
			

			}
	
	
	
	private void deletePizza(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, ServletException, IOException {
			
		int idpizza = Integer.parseInt(request.getParameter("idpizza"));
		PizzaDAO.deletePizzaById(idpizza);
		
		//response.getWriter().append("<script> alert('Etes-vous certains de suppimer cette pizza ?')</script>");
		
		request.getRequestDispatcher("PizzaDeleteView.jsp").forward(request, response);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.getWriter().append(" <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n" + 
//				"  <strong>Vous avez supprimer la pizza !</strong>\r\n" + 
//				"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
//				"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
//				"  </button>\r\n" + 
//				"</div> ");

	}
	
	private void affichelistepizza(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException, IOException {

		listpizza = PizzaDAO.listAllPizzas();
		request.setAttribute("listpizza", listpizza);
		request.getRequestDispatcher("PizzaListView.jsp").forward(request, response);

	}

	private void editOnePizza(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException, ServletException {

		int idpizza = Integer.parseInt(request.getParameter("idpizza"));
		Pizza maPizza = PizzaDAO.getPizzaById(idpizza);
		request.setAttribute("mapizza", maPizza);
		request.getRequestDispatcher("PizzaOneView.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
