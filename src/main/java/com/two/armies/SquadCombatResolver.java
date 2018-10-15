package com.two.armies;

import static java.lang.String.format;

/**
 * Resolves combat between two squads.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
public class SquadCombatResolver {
    private static final String LOSS_MESSAGE = "Squad of %s lost %s";
    private final PartitionCreator partitionCreator;


    public SquadCombatResolver(PartitionCreator partitionCreator)
    {
        this.partitionCreator = partitionCreator;
    }

    public SquadCombatResult apply(Squad first, Squad second) {
        int firstSize = partitionCreator.attackPartition(first).count();
        int secondSize = partitionCreator.attackPartition(second).count();

        ImmutableSquad newFirst = ImmutableSquad.copyOf(first).withSize(first.size() - secondSize);
        ImmutableSquad newSecond = ImmutableSquad.copyOf(second).withSize(second.size() - firstSize);

        return ImmutableSquadCombatResult.builder()
                .first(newFirst)
                .second(newSecond)
                .putMessages(newFirst, format(LOSS_MESSAGE, newFirst.name(), secondSize))
                .putMessages(newSecond, format(LOSS_MESSAGE, newSecond.name(), firstSize))
                .build();
    }
}
