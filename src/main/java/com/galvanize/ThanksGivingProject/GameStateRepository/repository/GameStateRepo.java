package com.galvanize.ThanksGivingProject.GameStateRepository.repository;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface GameStateRepo extends CrudRepository<Item, Long> {

    @Query(value = "SELECT g.id, g.name FROM gamestate g WHERE g.name =:name", nativeQuery = true)
    Iterable<Item> findByName(String name);
}
