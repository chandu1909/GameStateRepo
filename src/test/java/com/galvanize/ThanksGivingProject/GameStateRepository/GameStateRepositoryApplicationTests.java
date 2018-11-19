package com.galvanize.ThanksGivingProject.GameStateRepository;

import com.galvanize.ThanksGivingProject.GameStateRepository.controller.ItemController;
import com.galvanize.ThanksGivingProject.GameStateRepository.model.Item;
import com.galvanize.ThanksGivingProject.GameStateRepository.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
		assertTrue(true);

		//Setup
        Item expectedResult = new Item();
        ItemController itemController = new ItemController(mockItemService);
        when(mockItemService.addItem(expectedResult)).thenReturn(expectedResult);

        //Execute
        Item actualResult = itemController.addItem(expectedResult);
        //Assert
        assertEquals(expectedResult,actualResult);

        //TearDown


	}

}
