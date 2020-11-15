package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FoodItem;
import main.MedicalItem;

class ItemTest {

	@Test
	public void getCountTest() {
		MedicalItem med = new MedicalItem("Strepsils", 25, false, 5);
		med.removeCount();
		med.addCount();
		med.addCount();
		assertEquals(2, med.getCount());
		med.removeCount();
		assertEquals(1, med.getCount());
		
		FoodItem food = new FoodItem("Cthulhu Calamari", 100, 20);
		food.removeCount();
		food.addCount();
		food.addCount();
		assertEquals(2, food.getCount());
		food.removeCount();
		assertEquals(1, food.getCount());
	}
	
	@Test
	public void isCureTest() {
		MedicalItem cure = new MedicalItem("Plague Cure", 0, true, 20);
		assertEquals(true, cure.isCure());
		MedicalItem strep = new MedicalItem("Strepsils", 25, false, 5);
		assertEquals(false, strep.isCure());
	}
}
