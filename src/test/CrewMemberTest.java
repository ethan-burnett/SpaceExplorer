package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.CrewMember;
import main.FoodItem;
import main.MedicalItem;

class CrewMemberTest {

	@Test
	public void healthTest() {
		CrewMember member = new CrewMember("Oakley", "2");
		CrewMember other = new CrewMember("Bob", "5");
		assertEquals("Medic", member.getType());
		assertEquals(100, member.getHealth());
		member.damage(50);
		assertEquals(25, member.getHealth());
		assertEquals(false, member.isInfected());
		member.infect();
		assertEquals(true, member.isInfected());
		MedicalItem med = new MedicalItem("Strepsils", 25, false, 5);
		member.heal(med, other);
		assertEquals(50, member.getHealth());
		assertEquals(true, member.isAlive());
		member.damage(100);
		assertEquals(0, member.getHealth());
		assertEquals(false, member.isAlive());
	}
	
	@Test
	public void hungertest() {
		CrewMember member = new CrewMember("Oakley", "1");
		assertEquals("Pilot", member.getType());
		assertEquals(0, member.getHunger());
		member.increaseHunger();
		assertEquals(50, member.getHunger());
		FoodItem food = new FoodItem("Chips", 10, 2);
		member.feed(food);
		assertEquals(40, member.getHunger());
	}
	
	@Test
	public void tirednessTest() {
		CrewMember member = new CrewMember("Oakley", "3");
		assertEquals("Cyborg", member.getType());
		assertEquals(0, member.getTiredness());
		member.increaseTiredness();
		assertEquals(25, member.getTiredness());
		member.sleep(10);
		assertEquals(15, member.getTiredness());
	}
	
	@Test
	public void actionPtTest() {
		CrewMember member = new CrewMember("Oakley", "4");
		assertEquals("Scavenger", member.getType());
		assertEquals(5, member.getActionPt());
		member.removeActionPt(2);
		assertEquals(3, member.getActionPt());
		member.resetActionPt();
		assertEquals(5, member.getActionPt());
	}

}
