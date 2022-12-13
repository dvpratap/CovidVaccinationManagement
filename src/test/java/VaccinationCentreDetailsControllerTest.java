import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.VaccinationCentreDetailsController;
import model.VaccinationCenterDatabaseColumns;
import model.VaccinationCentreDetails;
import model.VaccinationCentreDetailsImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class VaccinationCentreDetailsControllerTest {
	
	VaccinationCentreDetailsController vaccinationCentreDetailsController;
	VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl;
	VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails();
	
	@BeforeAll
	public void setup() {
		vaccinationCentreDetailsImpl= Mockito.mock(VaccinationCentreDetailsImpl.class);
		vaccinationCentreDetailsController=new VaccinationCentreDetailsController(vaccinationCentreDetailsImpl);
	}
	
	@BeforeAll
	public void mockObject() {
		vaccinationCentreDetails.setCentre_id("1298");
		vaccinationCentreDetails.setCentre_name("dal hospital");
		vaccinationCentreDetails.setCentre_address("university");
		vaccinationCentreDetails.setCentre_city("halifax");
		vaccinationCentreDetails.setCentre_code("5691000");
		vaccinationCentreDetails.setCentre_zip("B3L987");
	}
	
	@Test
	public void updateVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl
				.updateVaccinationCentreDetails(vaccinationCentreDetails.getCentre_id(),VaccinationCenterDatabaseColumns.centre_city, "vancouver"))
		.thenReturn("update successful");
		assertEquals("update successful",vaccinationCentreDetailsController
				.updateVaccinationCentreDetailsController(vaccinationCentreDetails.getCentre_id(),VaccinationCenterDatabaseColumns.centre_city, "vancouver"));
	}
	
	@Test
	public void updateVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl
				.updateVaccinationCentreDetails("1234",VaccinationCenterDatabaseColumns.centre_city, "vancouver"))
		.thenReturn("wrong centre code");
		assertEquals("wrong centre code",vaccinationCentreDetailsController
				.updateVaccinationCentreDetailsController("1234",VaccinationCenterDatabaseColumns.centre_city, "vancouver"));
}
	
	@Test
	public void deleteVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails(vaccinationCentreDetails.getCentre_id())).thenReturn("deleted successfully");
		assertEquals("deleted successfully",vaccinationCentreDetailsController
				.deleteVaccinationCentreDetailsController(vaccinationCentreDetails.getCentre_id()));
	}
	
	@Test
	public void deleteVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails("1234")).thenReturn("wrong centre code");
		assertEquals("wrong centre code",vaccinationCentreDetailsController
				.deleteVaccinationCentreDetailsController("1234"));
	}
	
	@Test
	public void addVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails)).thenReturn(true);
		assertEquals(true,vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails));
	}
	
	@Test
	public void addVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails)).thenReturn(false);
		assertEquals(false,vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails));
	}
//	
//	@Test
//	public void updateVaccinationCentreDetailsTestFailure() {
//		String updationResult=VaccinationCentreDetailsController.instance()
//				.updateVaccinationCentreDetailsController("11002",VaccinationCenterDatabaseColumns.centre_name,"iwk hospital");
//		assertEquals(updationResult, "wrong centre code");
//	}
	
//	@Test
//	public void deleteVaccinationCentreDetailsTestSuccess() {
//		VaccinationCentreDetailsController.instance()
//		.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject());
//		String deletionResult=VaccinationCentreDetailsController.instance()
//				.deleteVaccinationCentreDetailsController("2006");
//		assertEquals(deletionResult, "deleted successfully");
//	}
//	
//	@Test
//	public void deleteVaccinationCentreDetailsTestFailure() {
//		String deletionResult=VaccinationCentreDetailsController.instance()
//				.deleteVaccinationCentreDetailsController("2010");
//		assertEquals(deletionResult, "wrong centre code");
//	}
//	
//	@Test
//	public void addVaccinationCentreDetailsTestSuccess() {
//		boolean insertionResult=VaccinationCentreDetailsController.instance()
//				.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject());
//		assertEquals(insertionResult,true);
//		VaccinationCentreDetailsController.instance()
//		.deleteVaccinationCentreDetailsController("2006");
//	}
	
//	@Test
//	public void addVaccinationCentreDetailsTestFailure() {
//		boolean insertionResult=VaccinationCentreDetailsController.instance()
//				.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject2());
//		assertEquals(insertionResult,false);
//	}
//	
	
	public VaccinationCentreDetails vaccinationCentreDetailsTestObject() {
		VaccinationCentreDetails vaccinationCentreDetailsTestObject=new VaccinationCentreDetails();
		vaccinationCentreDetailsTestObject.setCentre_name("northwood");
		vaccinationCentreDetailsTestObject.setCentre_city("halifax");
		vaccinationCentreDetailsTestObject.setCentre_address("gottingen street");
		vaccinationCentreDetailsTestObject.setCentre_zip("B30H72");
		vaccinationCentreDetailsTestObject.setCentre_code("2006");
		return vaccinationCentreDetailsTestObject;
	}
	
	public VaccinationCentreDetails vaccinationCentreDetailsTestObject2() {
		VaccinationCentreDetails vaccinationCentreDetailsTestObject=new VaccinationCentreDetails();
		vaccinationCentreDetailsTestObject.setCentre_name("");
		vaccinationCentreDetailsTestObject.setCentre_city("halifax");
		vaccinationCentreDetailsTestObject.setCentre_address("gottingen street");
		vaccinationCentreDetailsTestObject.setCentre_zip("B30H72");
		vaccinationCentreDetailsTestObject.setCentre_code("2006");
		return vaccinationCentreDetailsTestObject;
	}

}
