package com.tiendavirtual.dao;

import java.util.List;

import com.tiendavirtual.entity.Categoria;

public interface CategoriasDAO {
	//obtiene la categoria
	public Categoria getCategoria(int id);
	
	//obtiene el listado de categorias
    public List<Categoria> getCategorias();
    
    //actualiza la categoria 
    public void updateCategorias(Categoria categoria);
    
    //elimina la categoria
    public void deleteCategoria(int id);
}
