package com.two.armies;

import static org.junit.Assert.*;

import org.javatuples.Pair;
import org.junit.Test;

public class SquadLossMergerTest
{
    @Test
    public void apply() throws Exception
    {
        SquadLossMerger merger = new SquadLossMerger();

        ImmutableRace testRace = ImmutableRace.builder().name("test").build();

        ImmutableSquad squad1 = ImmutableSquad.builder().name("test").race(testRace).size(10).build();

        ImmutableSquad squad2 = ImmutableSquad.builder().name("test").race(testRace).size(20).build();

        Pair<Squad, Integer> apply = merger.apply(squad1, ImmutableSquadPartion.builder()
                .squad(squad2).count(10).build());

        assertEquals(apply.getValue0().size(), 0);
        assertEquals((int) apply.getValue1(), 10);
    }

}