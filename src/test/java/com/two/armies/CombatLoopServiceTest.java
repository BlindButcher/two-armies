package com.two.armies;

import java.util.List;

import org.junit.Test;

import static com.two.armies.TestUtils.humanInfantrySquad;
import static com.two.armies.TestUtils.orcInfantrySquad;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CombatLoopServiceTest
{
    @Test
    public void loop() throws Exception
    {
        SquadCombatResolver resolver = new SquadCombatResolver(new PartitionCreator(RandFunctions::randomInRange),
                new SquadLossMerger());

        CombatLoopService service = new CombatLoopService(resolver);

        List<SquadCombatResult> loop = service.loop(singletonList(humanInfantrySquad()),
                singletonList(orcInfantrySquad()));

        assertFalse(loop.isEmpty());
        assertEquals(loop.size(), 1);

        loop.forEach(System.out::println);
    }

}