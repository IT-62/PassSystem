package src.edu;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class TurnstileTest {

	@Test
	public void pass()
		throws IOException {

		Date now = new Date();
		Date seasonEnd = (Date)now.clone();
		seasonEnd.setTime((long)(seasonEnd.getTime() + 30.0 * 24.0 * 60.0 * 60.0 * 1000.0));
		PassSystem system = PassSystem.newInstance(now, seasonEnd);
		Turnstile turn = new Turnstile(system);

		system.createWeekdayPass(5);
		system.createWeekdayPass(now, 10);
		system.createWeekendPass(-1);
		system.createWeekendPass(now, 3);
		system.createSeasonPass();

		Assert.assertEquals(true, system.pass(0, turn.getID()));
		for (int i = 0; i < 4; i++) {
			turn.pass(0);
		}
		Assert.assertEquals(false, system.pass(0, turn.getID()));
		Assert.assertEquals(false, system.pass(2, turn.getID()));
		Assert.assertEquals(true, system.pass(1, turn.getID()));
		Assert.assertEquals(false, system.pass(3, turn.getID()));
		Assert.assertEquals(true, system.pass(4, turn.getID()));
		system.block(4);
		Assert.assertEquals(false, system.pass(4, turn.getID()));
		system.unblock(4);
		Assert.assertEquals(true, system.pass(4, turn.getID()));
	}
}