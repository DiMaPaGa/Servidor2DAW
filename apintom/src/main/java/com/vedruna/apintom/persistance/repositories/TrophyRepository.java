package com.vedruna.apintom.persistance.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vedruna.apintom.persistance.models.Trophy;

@Repository
public interface TrophyRepository extends JpaRepository<Trophy, Integer> {


    
    
}
