package org.xproc.locages.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproc.locages.dao.entities.Car;

public interface CarRepository extends JpaRepository<Car,Long>{
    Page<Car> findByNbrPlate(String keyword, Pageable pageable);




}
