package com.example.storeJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeJPA.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
