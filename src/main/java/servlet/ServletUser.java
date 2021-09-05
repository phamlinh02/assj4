package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;

import dao.NguoidungDAO;
import model.*;
import utils.Hepler;



/**
 * Servlet implementation class Admin
 */
@WebServlet({"/user/index","/user/edit/*","/user/create","/user/update","/user/delete"})
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NguoidungDAO dao = new NguoidungDAO();
		Nguoidung user= new Nguoidung();
		String uri = request.getRequestURI();
		
		if(uri.contains("edit")) {
			String id =uri.substring(uri.lastIndexOf("/")+1);
			user= dao.findById(id);
		}else if (uri.contains("update")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				if(!Hepler.checkRong(user)) {
					dao.update(user);
					request.setAttribute("mess", "sua ok");
					
				} else {
					JOptionPane.showMessageDialog(null, "Email không được trống");
					
				}
				
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				request.setAttribute("mess", "sua khong ok");
				
				e.printStackTrace();
			}

			
			
		} else if (uri.contains("delete")) {
			try {
				String id = request.getParameter("id");
				dao.remove(id);
				request.setAttribute("mess", "xoa ok");
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mess", "xoa khong ok");
				
			}
			
		
	}
		 else if (uri.contains("create")) {
			 
				try {
					
					BeanUtils.populate(user, request.getParameterMap());
					if(!Hepler.checkRong(user)) {
						user.setId(request.getParameter("id"));
						System.out.print(user.getId());
						dao.insert(user);
						request.setAttribute("mess", "Them ok");
					} else {

						JOptionPane.showMessageDialog(null,  "không được trống");

					}
					
					
				} catch (IllegalAccessException | InvocationTargetException e) {
					request.setAttribute("mess", "Them khong ok");
					
					e.printStackTrace();
				}

		}

		request.setAttribute("form", user);
		request.setAttribute("items", dao.findAll());
		
		request.getRequestDispatcher("/views/ManageUser.jsp").forward(request, response);
    }
	
}
