package edu;

import edu.Cards.CumulativeCard;
import edu.Cards.MultiJourneyCard;
import edu.Cards.TemporaryCard;
import edu.ControlSystem;
import edu.Pass;
import edu.Turnstile;
import edu.options.DurationType;
import edu.options.OwnerType;
import edu.options.TravelsCountType;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ControlSystemTest {
    ControlSystem controlSystem;
    @Before
    public void setUp() throws Exception {
        addCardsAndTurnstiles();
    }

    @After
    public void tearDown() throws Exception {
        controlSystem.deleteInstance();
       // controlSystem.passes = new  ArrayList<>();
    }
    @Test
    public void testPasses(){
        System.out.println(controlSystem.getCountOfTriesByCumulativeCard());
        for (Pass pass : controlSystem.passes) {
            System.out.println(pass.toString());
        }

    }

    public void addCardsAndTurnstiles() {
        controlSystem = ControlSystem.getInstance();

        controlSystem.createCard(7);
        controlSystem.createCard(44);
        controlSystem.createCard(OwnerType.PUPIL, TravelsCountType.FIVE);
        controlSystem.createCard(OwnerType.STUDENT, TravelsCountType.TEN);
        controlSystem.createCard(OwnerType.PUPIL, DurationType.MONTH);
        controlSystem.createCard(OwnerType.DEFAULT, DurationType.TEN_DAYS);
        controlSystem.createTurnstile();
        controlSystem.createTurnstile();
        controlSystem.createTurnstile();
        controlSystem.createTurnstile();

        controlSystem.turnstiles.get(0).acceptPass((CumulativeCard) controlSystem.getCardByIndex(0));
        controlSystem.turnstiles.get(0).acceptPass((CumulativeCard) controlSystem.getCardByIndex(0));
        controlSystem.turnstiles.get(1).acceptPass((CumulativeCard) controlSystem.getCardByIndex(1));
        controlSystem.turnstiles.get(2).acceptPass((CumulativeCard) controlSystem.getCardByIndex(1));
        controlSystem.turnstiles.get(3).acceptPass((MultiJourneyCard) controlSystem.getCardByIndex(2));
        controlSystem.turnstiles.get(0).acceptPass((TemporaryCard) controlSystem.getCardByIndex(4));


    }

    @Test
    public void testGetCountOfTries() {
        assertEquals(6,controlSystem.getCountOfTries());
    }

    @Test
    public void testGetCountOfPasses() {
        assertEquals(5, controlSystem.getCountOfPasses());
        assertNotEquals(6, controlSystem.getCountOfPasses());
        assertNotEquals("*", controlSystem.getCountOfPasses());
        assertNotEquals(0, controlSystem.getCountOfPasses());
    }

    @Test
    public void testGetCountOfFailes() {
        assertEquals(1, controlSystem.getCountOfFailes());
    }
    

}