package com.two.armies;

import static java.lang.String.format;

import org.javatuples.Pair;

/**
 * Resolves combat between two squads.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
public class SquadCombatResolver {
    private static final String LOSS_MESSAGE = "Squad of %s lost=%s, left=%s";
    private final PartitionCreator partitionCreator;
    private final SquadLossMerger squadLossMerger;

    public SquadCombatResolver(PartitionCreator partitionCreator, SquadLossMerger squadLossMerger)
    {
        this.partitionCreator = partitionCreator;
        this.squadLossMerger = squadLossMerger;
    }

    public SquadCombatResult apply(Squad first, Squad second) {

        Pair<Squad, Integer> firstCasualties = squadLossMerger.apply(first, partitionCreator.attackPartition(second));
        Pair<Squad, Integer> secondCasualties = squadLossMerger.apply(second, partitionCreator.attackPartition(first));


        Squad newFirst = firstCasualties.getValue0();
        Squad newSecond = secondCasualties.getValue0();

        return ImmutableSquadCombatResult.builder()
                .first(newFirst)
                .second(newSecond)
                .putMessages(newFirst, format(LOSS_MESSAGE, newFirst.name(), firstCasualties.getValue1(), newFirst.size()))
                .putMessages(newSecond, format(LOSS_MESSAGE, newSecond.name(), secondCasualties.getValue1(), newSecond.size()))
                .build();
    }
}
