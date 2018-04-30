package com.example.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
    @PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
    
	@Override
	public Cliente findOne(long id) { // Obtener los datos y mostralo (editar)
		return em.find(Cliente.class,id );
	}
	
	@Override
	public void save(Cliente cliente) {  //editar como insertar nuevo
		if(cliente.getId() != null && cliente.getId()>0){
			em.merge(cliente);    //actualizamos ya que existe el elemento id
		}else{
			em.persist(cliente);  //creamos un nuevo cliente ya que id es nulo
		}	
	}

	@Override
	public void delete(long id) {
		Cliente cliente = findOne(id);
		em.remove(cliente);
	}

}