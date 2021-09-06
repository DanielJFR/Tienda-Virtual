package com.tiendavirtual.dao;

import java.util.List;

import com.tiendavirtual.entity.Producto;

public interface ProductoDAO {
	
	//obtiene el producto
	public Producto getProducto(int id);
	
	//obtiene el listado de productos
    public List<Producto> getProductos();
    
    //actualiza el producto 
    public void updateProducto(Producto producto);
    
    //elimina el producto
    public void deleteProducto(int id);
}
