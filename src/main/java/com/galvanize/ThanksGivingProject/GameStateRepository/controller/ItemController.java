package com.galvanize.ThanksGivingProject.GameStateRepository.controller;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.GreenLightException;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ItemService;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final Logger slf4jLogger = LoggerFactory.getLogger(ItemController.class);
    public ItemController(ItemService service){
        itemService = service;
    }

    //creating new item/updating an existing item on datastore
    @PostMapping("/create")
    public Item addItem(@RequestBody Item item){
        try {
            return itemService.addItem(item);
        }
        catch (Exception e){
            slf4jLogger.info("exception raised : " +e);
        }
        return null;

    }

    //deleting existing item from the datastore
    @PostMapping("/delete/{id}")
    public  Item deleteItem(@PathVariable Long id) throws ResourceNotFoundException, GreenLightException {
        try{

            itemService.deleteItem(id);

        }
        catch (ResourceNotFoundException notFound){

            slf4jLogger.error("Item Not Found" +notFound);

            throw new ResourceNotFoundException();
        }
        catch (GreenLightException found){
            slf4jLogger.error("Item Found and Deleted" +found);
            throw new GreenLightException();
        }

        return null;
    }

    //Get specificItem Based on ID
    @GetMapping("/get/{id}")
    public Optional<Item> getItemById (@PathVariable Long id) throws ResourceNotFoundException, GreenLightException {
        try{
            return itemService.getById(id);
        }
        catch (ResourceNotFoundException notFound){
            throw new ResourceNotFoundException();
        }
        catch (GreenLightException found){
            throw new GreenLightException();
        }

    }

    //Get Items by the class Name..
    @GetMapping("/get/class/{name}")
    public Iterable<Item> getItemsByClass(@PathVariable String name){
        try{
            return itemService.getByClass(name);
        }
        catch (Exception e){
            slf4jLogger.info("Item fetching failed");
        }

        return null;
    }

    //Get all Items from the datastore...
    @GetMapping("/get")
    public Iterable<Item> getItems(){
        return  itemService.getItems();
    }


}
