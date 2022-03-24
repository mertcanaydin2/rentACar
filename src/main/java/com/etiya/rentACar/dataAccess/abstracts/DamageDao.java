package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageDao extends JpaRepository <Damage,Integer>{
//  List<Damage> getByDate(String date);
//  List<Damage> getByDateIn(List<String> date);
//  List<Damage> getByDateContains(String date);
//  List<Damage> getByCarId(int id);
//  List<Damage> getByCarIdIn(List<Integer> carId);

}
