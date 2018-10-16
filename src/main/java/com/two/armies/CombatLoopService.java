package com.two.armies;

import java.util.List;

/**
 * Given initial combat setup and sides. Service make combat loop till the moment one of the side wins.
 */
public class CombatLoopService
{
    private final SquadCombatResolver squadCombatResolver;

    public CombatLoopService(SquadCombatResolver squadCombatResolver)
    {
        this.squadCombatResolver = squadCombatResolver;
    }

    public List<SquadCombatResult> loop(List<Squad> left, List<Squad> right)
    {
        return null;
    }
}
