package com.vedruna.apintom.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.apintom.persistance.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    //Entiendo que aquí únicamente es necesario poner aquellos métodos que quiera especificar. 
    //Si únicamente voy a buscar un parámetro, puedo dejarlo vacío y no hacer nada.
    //Por tanto, solo voy a incluir findAllByOrderByIdplayerAsc porque al comprobar el listado de jugadores,
    //por defecto lo ordenaban por nombre y no por id ascendente.
    
    List<Player> findAllByOrderByIdplayerAsc();
    
}