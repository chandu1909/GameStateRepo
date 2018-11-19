package com.galvanize.ThanksGivingProject.GameStateRepository.service;

import com.galvanize.ThanksGivingProject.GameStateRepository.GameStateRepositoryApplication;
import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.repository.GameStateRepo;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final GameStateRepo gameStateRepo;
    public ItemService(GameStateRepo gameStateRepo){
        this.gameStateRepo = gameStateRepo;
    }
    //method to add new item to the game state datastore
    public Item addItem(Item item) {
        return gameStateRepo.save(item);
    }
}
