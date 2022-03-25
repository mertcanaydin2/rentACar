package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementDao extends JpaRepository<Statement,Integer> {


}
