package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Crop;

public interface ICropAdminDao extends JpaRepository<Crop, Integer> {

}
