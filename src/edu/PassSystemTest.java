package src.edu;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class PassSystemTest {

	@Test
	public void pass() {
		SkiPass passWeekend = new SkiPass(
				SkiPass.Types.Weekend,
				LocalDateTime.of(2018, Month.MARCH, 4, 9, 0),
				2
		);
		SkiPass passWeekday = new SkiPass(
				SkiPass.Types.Weekday,
				LocalDateTime.of(2018, Month.MARCH, 4, 9, 0),
				5
		);

		assertEquals(LocalDateTime.of(2018, Month.MARCH, 11, 9, 0),
				passWeekend.getDateTill());
		assertEquals(LocalDateTime.of(2018, Month.MARCH, 10, 9, 0),
				passWeekday.getDateTill());
	}
}