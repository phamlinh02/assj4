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

import dao.VideoDAO;
import model.Video;
import utils.Hepler;

/**
 * Servlet implementation class ServletVideo
 */
@WebServlet({"/video/index","/video/edit/*","/video/create","/video/update","/video/delete"})
public class ServletVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();
		String uri = req.getRequestURI();
		if(uri.contains("edit")) {
			String id = uri.substring(uri.lastIndexOf("/")+1);
			video= dao.findById(id);
		} else if(uri.contains("create")) {
			try {
				BeanUtils.populate(video, req.getParameterMap());
				//if(!Hepler.checkRong(video)) {
				video.setId(req.getParameter("id"));
				System.out.print(video.getId());
					dao.insert(video);
					JOptionPane.showMessageDialog(null, "them thanh cong");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "khong duoc trong");
//				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				JOptionPane.showMessageDialog(null, "them that bai");
				e.printStackTrace();
			}
			
		}else if(uri.contains("update")) {
			try {
				BeanUtils.populate(video, req.getParameterMap());
				//if(!Hepler.checkRong(video)) {
					dao.update(video);
					JOptionPane.showMessageDialog(null, "sua thanh cong");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "khong duoc trong");
//				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				JOptionPane.showMessageDialog(null, "sua that bai");
				e.printStackTrace();
			}
		}
		else if (uri.contains("delete")) {
			try {
				String id = req.getParameter("id");
				dao.remove(id);
				req.setAttribute("mess", "xoa ok");
				
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("mess", "xoa khong ok");
				
			}
	} 
		req.setAttribute("form", video);
		req.setAttribute("items", dao.findAll());
		req.getRequestDispatcher("/views/ManageVideo.jsp").forward(req, res);
	}

}
