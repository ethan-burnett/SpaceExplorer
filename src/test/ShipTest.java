package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.CrewMember;
import main.Ship;

class ShipTest {

	@Test
	public void damageTest() {
		Ship ship = new Ship("Rocket");
		CrewMember member = new CrewMember("Oakley", "6");
		assertEquals(100, ship.getShieldHealth());
		ship.damage(25);
		assertEquals(75, ship.getShieldHealth());
		ship.repair(10, member);
		assertEquals(90, ship.getShieldHealth());
		ship.damage(100);
		assertEquals(0, ship.getShieldHealth());
	}
	
	@Test
	public void isReadyTest() {
		Ship ship = new Ship("Rocket");
		assertEquals(false, ship.isReady());
		ship.changeReadyStatus();
		assertEquals(true, ship.isReady());
		ship.changeReadyStatus();
		ship.changeReadyStatus();
		ship.changeReadyStatus();
		assertEquals(false, ship.isReady());
	}

}
