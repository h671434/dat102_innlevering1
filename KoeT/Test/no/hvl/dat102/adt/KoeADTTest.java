package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * Test for KoeADT
 */
public abstract class KoeADTTest {

	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Test at koen er tom når den er ny.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	/**
	 * Test at koen tar inn og ut element.
	 */
	@Test
	public void innUt() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch(EmptyCollectionException e) {
			fail("Ut feil uventet: " + e.getMessage());
		}
	}
	
	@Test
	public void innUtMedDuplikater() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e0);
		koe.innKoe(e1);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
		} catch(EmptyCollectionException e) {
			fail("Ut feil uventet: " + e.getMessage());
		}
	}
	
	/**
	 * Test at foerste er riktig når element er tatt ut.
	 */
	@Test
	public void innInnUtFoerste() {
		koe.innKoe(e3);
		koe.innKoe(e2);
		
		try {
			koe.utKoe();
			assertEquals(e2, koe.foerste());
		}  catch(EmptyCollectionException e) {
			fail("Ut eller foerste feil uventet: " + e.getMessage());
		}
	}
	
	/**
	 * Test at erTom gir tom hvis alle elementer er fjernet.
	 */
	@Test
	public void innUtErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("Inn eller ut feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Test at en får exception om man prøver å ta ut element fra tom koe
	 */
	@Test
	public void utFraTomGirException() {
		assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
	
}
