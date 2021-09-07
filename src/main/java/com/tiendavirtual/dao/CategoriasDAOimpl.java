package com.tiendavirtual.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.tiendavirtual.entity.Categoria;

public class CategoriasDAOimpl implements CategoriasDAO {

	@Autowired 
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Categoria getCategoria(int id) {
	    Session session=sessionFactory.getCurrentSession();	
	    Categoria categoria= session.get(Categoria.class, id);
		return categoria;
	}

	@Override
	@Transactional
	public List<Categoria> getCategorias() {
		Session session=sessionFactory.getCurrentSession();
		Query<Categoria> query=session.createQuery("from Categoria",Categoria.class);
		List<Categoria> categoriaList=query.getResultList();
		return categoriaList;
	}

	@Override
	@Transactional
	public void updateCategorias(Categoria categoria) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate("Categoria",categoria);
	}

	@Override
	@Transactional
	public void deleteCategoria(int id) {
		Session session=sessionFactory.getCurrentSession();
		Categoria categoria= session.get(Categoria.class, id);
		session.delete(categoria);
		
	}

}
