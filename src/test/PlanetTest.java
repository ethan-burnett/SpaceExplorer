package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Planet;

class PlanetTest {

	@Test
	public void partTest() {
		Planet endor = new Planet("Endor", true);
		assertEquals(false, endor.isPartFound());
		endor.foundPart();
		assertEquals(true, endor.isPartFound());
	}

}
