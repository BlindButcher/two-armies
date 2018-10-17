package com.two.armies;

public class TestUtils
{
    public static Squad humanInfantrySquad()
    {
        return ImmutableSquad.builder().name("Human Infantry")
                .race(ImmutableRace.builder().name("Human").discipline(10).build())
                .size(100).build();
    }

    public static Squad orcInfantrySquad()
    {
        return ImmutableSquad.builder().name("Orc Infantry")
                .race(ImmutableRace.builder().name("Orc").discipline(10).build())
                .size(100).build();
    }
}
