package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Video;
import utils.jpaUtils;

public class VideoDAO {
	private EntityManager em = jpaUtils.getEntityManager();
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	public void insert(Video x) {
		try {
			em.getTransaction().begin();
			em.persist(x);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
	}
	public void update(Video x) {
		try {
			em.getTransaction().begin();
			em.merge(x);
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
	}
	public void remove(String x) {
		try {
			Video video = findById(x);
			em.getTransaction().begin();
			em.remove(video);
			JOptionPane.showMessageDialog(null, "Xóa thành công");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}
	public List<Video> findAll(){
		String hpl="SELECT v FROM Video v";
		TypedQuery<Video> query = em.createQuery(hpl,Video.class);
		List<Video> lst = query.getResultList();
		return lst;
	}
	public Video findById(String id) {
		Video x = em.find(Video.class, id);
		return x;
	}
}
