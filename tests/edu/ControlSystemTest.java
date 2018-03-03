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

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void testPasses(){
        ControlSystem controlSystem = ControlSystem.getInstance();
        controlSystem.createCard(OwnerType.PUPIL,44);
        controlSystem.createCard(OwnerType.STUDENT,44);
        controlSystem.createCard(OwnerType.DEFAULT,44);
        controlSystem.createCard(OwnerType.PUPIL, TravelsCountType.FIVE);
        controlSystem.createCard(OwnerType.STUDENT, TravelsCountType.TEN);
        controlSystem.createCard(OwnerType.PUPIL, DurationType.MONTH);
        controlSystem.createCard(OwnerType.DEFAULT, DurationType.TEN_DAYS);

        controlSystem.createTurnstile();
        controlSystem.createTurnstile();
        controlSystem.createTurnstile();
        controlSystem.createTurnstile();

        controlSystem.turnstiles.get(0).acceptPass((CumulativeCard) controlSystem.getCardByIndex(0));
        controlSystem.turnstiles.get(1).acceptPass((CumulativeCard) controlSystem.getCardByIndex(1));
        controlSystem.turnstiles.get(2).acceptPass((CumulativeCard) controlSystem.getCardByIndex(2));
        controlSystem.turnstiles.get(3).acceptPass((MultiJourneyCard) controlSystem.getCardByIndex(3));
        controlSystem.turnstiles.get(0).acceptPass((TemporaryCard) controlSystem.getCardByIndex(5));

        for (Pass pass : controlSystem.passes) {
            System.out.println(pass.toString());
        }

    }
    

}