package com.etiya.rentACar.dataAccess.abstracts;


import com.etiya.rentACar.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ColorDao extends JpaRepository<Color,Integer> {
    Boolean existsColorByName(String name);
}
