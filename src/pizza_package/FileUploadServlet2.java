package pizza_package;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class 
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
@WebServlet("/FileUpload")
public class FileUploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				Part filePart = request.getPart("fileToUpload");
		        String appPath = request.getServletContext().getRealPath("PizzaAddView.jsp");
			    InputStream fileInputStream = filePart.getInputStream();
		        
		        
		        String imagePath = appPath + "images";
		        System.out.println(imagePath);
		        
		        File fileDir = new File(imagePath);
		        if (!fileDir.exists()) {
		            fileDir.mkdirs();
		        }
		        System.out.println("******** Nom du fichier ********");
		        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			    System.out.println( fileName);
			    System.out.println("-----------------------");  
		        System.out.println( request.getSession().getServletContext(). getRealPath ("/"));
		        
		     
		        String imageName = filePart.getSubmittedFileName();
		        System.out.println("***** Nom de l'image ********");
		        System.out.println(imageName);
		        
		         String path = this.getServletContext().getRealPath("/WebContent/uploadFiles"); 
		         System.out.println(path);
		       
		         request.getRequestDispatcher("index.jsp").forward(request, response);
				
		      
		}
	
	}
	 

