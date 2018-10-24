package com.two.armies;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static com.two.armies.TestUtils.humanInfantrySquad;
import static com.two.armies.TestUtils.oneHumanSquad;
import static com.two.armies.TestUtils.orcInfantrySquad;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CombatLoopServiceTest
{
    private CombatLoopService combatLoopService;

    @Before
    public void setUp() throws Exception
    {
        SquadCombatResolver resolver = new SquadCombatResolver(new PartitionCreator(RandFunctions::randomInRange),
                new SquadLossMerger());
        combatLoopService = new CombatLoopService(resolver);
    }

    @Test
    public void sampleLoop() throws Exception
    {

        List<SquadCombatResult> loop = combatLoopService.loop(singletonList(humanInfantrySquad()),
                singletonList(orcInfantrySquad()));

        assertFalse(loop.isEmpty());
        assertEquals(loop.size(), 1);

        loop.forEach(System.out::println);
    }

    @Test
    public void sureWinLoop() throws Exception
    {

        List<SquadCombatResult> loop = combatLoopService.loop(singletonList(oneHumanSquad()),
                singletonList(humanInfantrySquad()));

        assertFalse(loop.isEmpty());
        assertEquals(loop.size(), 1);

        assertTrue(loop.get(0).first().destroyed());
        assertFalse(loop.get(0).second().destroyed());

    }

}