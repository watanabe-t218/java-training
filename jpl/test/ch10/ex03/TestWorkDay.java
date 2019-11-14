package ex03;

import static org.junit.jupiter.api.Assertions.*;
import ex03.EnumDays;
import org.junit.jupiter.api.Test;

class TestWorkDay {

	@Test
	void testWorkDay() {
		WorkDay workDay = new WorkDay();
		assertEquals(true, workDay.isWorkDay(EnumDays.MONDAY));
		assertEquals(true, workDay.isWorkDay(EnumDays.TUESDAY));
		assertEquals(true, workDay.isWorkDay(EnumDays.WEDNESDAY));
		assertEquals(true, workDay.isWorkDay(EnumDays.THURSDAY));
		assertEquals(true, workDay.isWorkDay(EnumDays.FRIDAY));
		assertEquals(false, workDay.isWorkDay(EnumDays.SATURDAY));
		assertEquals(false, workDay.isWorkDay(EnumDays.SUNDAY));
	}

}
