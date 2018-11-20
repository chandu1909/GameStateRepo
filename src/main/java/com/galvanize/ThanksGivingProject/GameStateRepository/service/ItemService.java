package com.galvanize.ThanksGivingProject.GameStateRepository.service;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.repository.GameStateRepo;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@Service
public class ItemService {
    private final GameStateRepo gameStateRepo;
    private final Logger slf4jLogger = LoggerFactory.getLogger(ItemService.class);

    public ItemService(GameStateRepo gameStateRepo){
        this.gameStateRepo = gameStateRepo;
    }
    //method to add new item to the game state datastore
    public Item addItem(Item item) {

        //checking if the item already exists in the database
        if (gameStateRepo.existsById(item.getItem_id())){
            slf4jLogger.info("ID already exists..Updating the value to the respective ID..!!");
            return gameStateRepo.save(item);
        }
         else {
             slf4jLogger.info("New entry created on datasource..!!");
             return gameStateRepo.save(item);
         }

    }
    //method that deletes the existing item by ID
    public void deleteItem(Long id) throws ResourceNotFoundException,GreenLightException{
        if (gameStateRepo.existsById(id)){
            slf4jLogger.info("Item found and Deleted the record..!!!");
            gameStateRepo.deleteById(id);
            throw new GreenLightException();
        }
        else {
            throw new ResourceNotFoundException();
        }

    }

    public Optional<Item> getById(Long id) {
        return gameStateRepo.findById(id);
    }
}
