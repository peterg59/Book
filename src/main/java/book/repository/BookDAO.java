package book.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	@Transactional
	public void persist(Object entity) {
		em.persist(entity);
	}
	
	@Transactional
	public void delete(Object entity) {
		try {
		em.remove(entity);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional
	public void add(Object entity) {
		try {
			em.persist(entity);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Transactional
	public void update(Object entity) {
		em.merge(entity);
	}
	
	@Transactional
	public List<Book> getAll() {
		return em.createQuery("select b from Book b",Book.class).getResultList();
	}
}
