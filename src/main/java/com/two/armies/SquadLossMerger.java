package com.two.armies;

import org.javatuples.Pair;

import com.google.common.base.Preconditions;

/**
 * Merge combat losses back to the Squad.
 */
public class SquadLossMerger
{
    /**
     * Returns new squad after losses are applied and casualty number;
     */
    public Pair<Squad, Integer> apply(Squad targetSquad, SquadPartion attackPartition)
    {
        Preconditions.checkArgument(!targetSquad.equals(attackPartition.squad()), "Can't attack self");

        int count = attackPartition.count();
        int squadSize  = targetSquad.size();

        int casualties = count > squadSize ? squadSize : count;
        
        return Pair.with(ImmutableSquad.copyOf(targetSquad).withSize(squadSize - casualties), casualties);
    }
}
