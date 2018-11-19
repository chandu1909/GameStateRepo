package com.galvanize.ThanksGivingProject.GameStateRepository.repository;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface GameStateRepo extends CrudRepository<Item, Long> {
}
