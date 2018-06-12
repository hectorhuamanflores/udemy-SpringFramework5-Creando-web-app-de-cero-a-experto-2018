package com.example.demo.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Factura;
import com.example.demo.models.entity.Producto;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);

	public Cliente findOne(long id);

	public void delete(long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Producto findProductoById(Long id);
	
	public Factura findFacturabyId(Long id); 
	
	public void deleteFactura(Long id);
}
