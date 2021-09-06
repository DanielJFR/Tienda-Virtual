package com.tiendavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiendavirtual.dao.ProductoDAO;
import com.tiendavirtual.entity.Producto;

@Controller
@RequestMapping("/producto")
public class ProductsController {

	@Autowired 
	ProductoDAO productoDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getProducts(Model model) {
		//Realizamos la consulta de productos y la introducimos al modelo
		model.addAttribute("productos",productoDAO.getProductos());
		//retornamos lista de productos
		return "listaProductos";
	}
	
    @RequestMapping(path="/actualizaFormulario")
    public String viewUpdateForm(@RequestParam(name="id")int id,Model model)
    {
    	//obtenemos el producto que queremos actualizar
    	Producto producto=productoDAO.getProducto(id);
    	//Introducimos el producto en el modelo
    	model.addAttribute("producto", producto);
    	//Llamamos al formulario de actualizacion
    	return "formularioProducto2";
    }
    
    @RequestMapping(path="/altaFormulario")
    public String viewInsertForm(Model model)
    {
    	//Inicializamos el modelo
    	model.addAttribute("producto",new Producto());
    	//Llamamos al formulario de actualizacion
    	return "formularioProducto2";
    }
	
	@RequestMapping(path="/insertarProducto",method=RequestMethod.POST)
	public String actualizaProduct(@ModelAttribute("producto") Producto product,Model model) {
		//Realizamos la insercion del producto
		productoDAO.updateProducto(product);
		//retornamos lista de productos
	    return "redirect:/producto";
	}
	
	@RequestMapping(path="/eliminar", method=RequestMethod.GET)
	public String deleteProduct(@RequestParam(name="id")int id,Model model) {
		//Realizamos la consulta de productos y la introducimos al modelo
		productoDAO.deleteProducto(id);
		//retornamos lista de productos
		return "redirect:/producto";
	}
}