package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Componente da camada de acesso a dados
@Repository
//JpaRepository já é um componente registrado no Spring então essa classe funciona sem a anotação
public interface GameRepository extends JpaRepository<Game, Long> {
}
