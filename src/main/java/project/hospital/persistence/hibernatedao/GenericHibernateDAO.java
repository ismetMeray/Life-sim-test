package project.hospital.persistence.hibernatedao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import project.hospital.persistence.interfaces.IGenericDAO;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null) {
			throw new IllegalStateException("Session has not been set on DAO before usage");
		}
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	/* (non-Javadoc)
	 * @see nl.delphinity.pasimo.persistence.interfaces.GenericDAO#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public T saveOrUpdate(T entity) {
		getSession().beginTransaction();
		getSession().saveOrUpdate(entity);
		getSession().getTransaction().commit();
		getSession().close();
		return entity;
	}

	/* (non-Javadoc)
	 * @see nl.delphinity.pasimo.persistence.interfaces.GenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		getSession().beginTransaction();
		getSession().delete(entity);
		getSession().getTransaction().commit();
		getSession().close();
	}

	/* (non-Javadoc)
	 * @see nl.delphinity.pasimo.persistence.interfaces.GenericDAO#findById(java.io.Serializable)
	 */
	@Override
	public T findById(ID id) {
		return getSession().find(getPersistentClass(), id);
	}

	/* (non-Javadoc)
	 * @see nl.delphinity.pasimo.persistence.interfaces.GenericDAO#findAll()
	 */
	@Override
	public Set<T> findAll() {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		
		CriteriaQuery<T> criteria = builder.createQuery(getPersistentClass());
		Root<T> root = criteria.from(getPersistentClass());
		criteria.select(root);
		
		List<T> list = getSession().createQuery(criteria).getResultList();
		Set<T> set = new TreeSet<>();
		set.addAll(list);
		
		return set;
	}	

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
