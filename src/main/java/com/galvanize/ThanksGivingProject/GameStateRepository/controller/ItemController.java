package com.galvanize.ThanksGivingProject.GameStateRepository.controller;

import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    public ItemController(ItemService service){
        itemService = service;
    }

    //creating new item to the datastore
    @PostMapping("/create")
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }



}
