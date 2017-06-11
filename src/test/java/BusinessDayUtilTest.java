package com.stocklibrary;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class BusinessDayUtilTest {

	@Test
	public void testIsBusinessDay() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(25, 3, 2016);
		boolean isBusinessDay = BusinessDayUtil.isBusinessDay(calendar.getTime());
		assertEquals(false, isBusinessDay);

		calendar.set(30, 3, 2016);
		isBusinessDay = BusinessDayUtil.isBusinessDay(calendar.getTime());
		assertEquals(true, isBusinessDay);
	}

	@Test
	public void testWeekDay() {
		Calendar date = Calendar.getInstance();
		date.set(2016, Calendar.JULY, 4); //4 of july (independence day)
		assertFalse(BusinessDayUtil.isBusinessDay(date.getTime()));

		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		assertFalse(BusinessDayUtil.isBusinessDay(date.getTime()));

		date.set(2016, Calendar.JULY, 5);
		assertTrue(BusinessDayUtil.isBusinessDay(date.getTime()));
	}

}
