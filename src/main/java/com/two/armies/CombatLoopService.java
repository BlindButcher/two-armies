package com.two.armies;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

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
        Preconditions.checkArgument(left.size() > 0);
        Preconditions.checkArgument(right.size() > 0);

        List<SquadCombatResult> results = new ArrayList<>();

        left = new ArrayList<>(left);
        right = new ArrayList<>(right);

        while (!done(left) || !done(right)) {
            Squad leftSquad = left.remove(0);
            Squad rightSquad = right.remove(0);
            results.add(squadCombatResolver.apply(leftSquad, rightSquad));
        }


        return results;
    }

    private boolean lost(List<Squad> squads) {
        return squads.stream().allMatch(Squad::destroyed);
    }

    private boolean done(List<Squad> squads) {
        return squads.isEmpty() || lost(squads);
    }
}
