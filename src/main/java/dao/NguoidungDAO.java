package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Nguoidung;
import utils.jpaUtils;

public class NguoidungDAO {
	private EntityManager em = jpaUtils.getEntityManager();
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	public void insert(Nguoidung x) {
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
	public void update(Nguoidung x) {
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
			Nguoidung Nguoidung = findById(x);
			em.getTransaction().begin();
			em.remove(Nguoidung);
			JOptionPane.showMessageDialog(null, "Xóa thành công");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}
	public List<Nguoidung> findAll(){
		String hpl="SELECT u FROM Nguoidung u";
		TypedQuery<Nguoidung> query = em.createQuery(hpl,Nguoidung.class);
		List<Nguoidung> lst = query.getResultList();
		return lst;
	}
	public Nguoidung findById(String id) {
		Nguoidung x = em.find(Nguoidung.class, id);
		return x;
	}
}
