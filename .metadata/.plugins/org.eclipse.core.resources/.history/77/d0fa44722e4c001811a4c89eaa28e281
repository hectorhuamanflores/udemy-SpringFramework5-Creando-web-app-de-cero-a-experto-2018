package com.example.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
    @PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
    
	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(long id) { // Obtener los datos y mostralo (editar)
		return em.find(Cliente.class,id );
	}
	
	@Override
	@Transactional
	public void save(Cliente cliente) {  //editar como insertar nuevo
		if(cliente.getId() != null && cliente.getId()>0){
			em.merge(cliente);    //actualizamos ya que existe el elemento id
		}else{
			em.persist(cliente);  //creamos un nuevo cliente ya que id es nulo
		}	
	}

	@Override
	@Transactional
	public void delete(long id) {
		Cliente cliente = findOne(id);
		em.remove(cliente);
	}

}
