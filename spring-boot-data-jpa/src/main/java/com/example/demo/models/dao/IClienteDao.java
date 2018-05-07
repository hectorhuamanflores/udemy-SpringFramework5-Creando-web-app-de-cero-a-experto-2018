package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.entity.Cliente;
//CrudRepository es una apcion para mi crud
//Usaremos PagingAndSortingRepository porque usaremos paginacion
public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
    
	
}
