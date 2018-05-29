package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura,Long>{

}
