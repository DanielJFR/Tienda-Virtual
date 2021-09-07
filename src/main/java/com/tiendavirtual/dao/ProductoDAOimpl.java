package com.tiendavirtual.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tiendavirtual.entity.Producto;

@Repository
public class ProductoDAOimpl implements ProductoDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Producto> getProductos() {
	    Session session=sessionFactory.getCurrentSession();
	    Query<Producto> query=session.createQuery("from Producto",Producto.class);
	    List<Producto> lista=query.getResultList();
		return lista;
	}

	@Override
	@Transactional
	public void updateProducto(Producto producto) {
		 Session session=sessionFactory.getCurrentSession();
		 session.saveOrUpdate(producto);	 
	}
	
	
	@Override
	@Transactional
	public void deleteProducto(int id) {
		 Session session=sessionFactory.getCurrentSession();
		 Producto producto= session.get(Producto.class,id);
		 session.delete(producto);	 
	}

	@Override
	@Transactional
	public Producto getProducto(int id) {
		// Obtiene el producto
		Session session=sessionFactory.getCurrentSession();
		Producto producto= session.get(Producto.class,id);
		return producto;
	}
	
     
}
