package com.galvanize.ThanksGivingProject.GameStateRepository.controller;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ItemService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public  Item deleteItem(@PathVariable Long id){
        try{

            itemService.deleteItem(id);
        }
        catch (Exception e){
            slf4jLogger.error("Item Not Found" +e);
        }
        return null;
    }




}
