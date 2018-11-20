package com.galvanize.ThanksGivingProject.GameStateRepository;

import com.galvanize.ThanksGivingProject.GameStateRepository.controller.ItemController;
import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.GreenLightException;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ItemService;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ResourceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameStateRepositoryApplicationTests {

	@Mock
	private ItemService mockItemService;


	@Test
	public void contextLoads() {
	}

	//Testing user scenario1 - "Create where object is not in datastore"
	@Test
	public void testCreateNewItemObject(){
		//assertTrue(true);
		//SetUp
		Item expectedResult = new Item();
		ItemController itemController = new ItemController(mockItemService);
		when(mockItemService.addItem(expectedResult)).thenReturn(expectedResult);

		//Execute
		Item actualResult = itemController.addItem(expectedResult);

		//Assert
		assertEquals(expectedResult,actualResult);

		//Teardown
	}

	//Testing user scenario2
	@Test
	public void testCreateExistingItemObject(){
		//assertTrue(true);

		//Setup
        Item expectedResult = new Item((long) 3,"Sword");
        ItemController itemController = new ItemController(mockItemService);
        when(mockItemService.addItem(expectedResult)).thenReturn(expectedResult);

        //Execute
        Item actualResult = itemController.addItem(expectedResult);
        //Assert
        assertEquals(expectedResult,actualResult);

        //TearDown
	}

	//Testing user scenario 3 & 4 - Deleting the existing and non existing item from the data store

    @Test
    public void testDeleteItemObject() throws ResourceNotFoundException, GreenLightException {

	    //Setup
        Long item_id = 4L;

        ItemController itemController = new ItemController(mockItemService);

        //Execute
		Item item = itemController.deleteItem(item_id);

		//assert
        then(mockItemService).should(times(1)).deleteItem(item_id);
        //teardown
    }
    //Testing user scenario 5 & 6 - getting item if found not returning 404 if not found
    @Test
	public void testGetSpecificItem()throws GreenLightException,ResourceNotFoundException{
		//SetUp
		Long item_id = 6L;
		Optional<Item> expectedResult = Optional.of(new Item());
		ItemController itemController = new ItemController(mockItemService);
		when(mockItemService.getById(item_id)).thenReturn(expectedResult);

		//Execute
		Optional<Item> actualResult = itemController.getItemById(item_id);

		//Assert

		assertEquals(expectedResult,actualResult);

		//TearDown
	}

	//Testing get all items of a specific type
    @Test
    public void testGetSameTypeItems(){
        //assertTrue(true);
	    //setup
        String item_name = "SWORD";
        ArrayList<Item> expectedResult = new ArrayList<Item>();
        ItemController itemController = new ItemController(mockItemService);
        when(mockItemService.getByClass(item_name)).thenReturn(expectedResult);

        //Execute
        ArrayList actualResult =  (ArrayList) itemController.getItemsByClass(item_name);

        //Assert
        assertEquals(expectedResult,actualResult);

        //Teardown
    }

    //Testing Get all items in registry
	@Test
	public void testGetAllData(){
		//setup
		ArrayList<Item> expectedResult = new ArrayList<Item>();
		ItemController itemController = new ItemController(mockItemService);
		when(mockItemService.getItems()).thenReturn(expectedResult);

		//Execute
        ArrayList actualResult = (ArrayList) itemController.getItems();

        //Assert
        assertEquals(expectedResult,actualResult);
		//Teardown
	}


}
