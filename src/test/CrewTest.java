package test;

import main.Crew;
import main.CrewMember;
import main.GameEnvironment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CrewTest {

	@Test
	public void isGameOverTest() {
		Crew newCrew = new Crew("Bois");
		assertEquals(true, newCrew.isGameOver());
		newCrew.addCrewMember(new CrewMember("Oakley", "6"));
		assertEquals(false, newCrew.isGameOver());
	}
	
	@Test
	public void changeMoneyTest() {
		Crew newCrew = new Crew("Bois");
		assertEquals(10, newCrew.getMoney());
		newCrew.changeMoney(10);
		assertEquals(20, newCrew.getMoney());
		newCrew.changeMoney(-30);
		assertEquals(20, newCrew.getMoney());
	}
	
	@Test
	public void findItemTest() {
		GameEnvironment gameEnv = new GameEnvironment();
		gameEnv.setCrew("Bois");
		assertEquals(0, gameEnv.getCrew().findFood("Rice").getCount());
		gameEnv.getCrew().findFood("Rice").addCount();
		assertEquals(1, gameEnv.getCrew().findFood("Rice").getCount());
		gameEnv.getCrew().stealItem(gameEnv);
		assertEquals(0, gameEnv.getCrew().findFood("Rice").getCount());
		
		assertEquals(0, gameEnv.getCrew().findMed("Medkit").getCount());
		gameEnv.getCrew().findMed("Medkit").addCount();
		assertEquals(1, gameEnv.getCrew().findMed("Medkit").getCount());
		gameEnv.getCrew().stealItem(gameEnv);
		assertEquals(0, gameEnv.getCrew().findMed("Medkit").getCount());
	}
}