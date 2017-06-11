package com.alecktos.marketopen;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenStockHandlerTest {

	@Test
	public void testIsOpen() {

		OpenStockHandler openStockHandler = new OpenStockHandler();

		boolean isOpen = openStockHandler.isOpen(DateTime.createFromDateTimeString("01/01/2016 20:00:00"), "14:30:00", "21:00:00");
		assertFalse(isOpen);

		isOpen = openStockHandler.isOpen(DateTime.createFromDateTimeString("01/04/2016 20:00:00"), "14:30:00", "21:00:00");
		assertTrue(isOpen);


		isOpen = openStockHandler.isOpen(DateTime.createFromDateTimeString("02/01/2016 21:00:00"), "14:30:00", "21:00:00");
		assertFalse(isOpen);

		isOpen = openStockHandler.isOpen(DateTime.createFromDateTimeString("01/31/2016 20:00:00"), "14:30:00", "21:00:00");
		assertFalse(isOpen);
	}

}
