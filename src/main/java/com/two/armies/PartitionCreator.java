package com.two.armies;

import java.util.Optional;
import java.util.function.Function;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.Ranges;

import static com.two.armies.SquadSizeCategory.bySize;

/**
 * Perform partition calculation for squads.
 */
public class PartitionCreator
{
    private final Function<Range<Integer>, Integer> randomInRange;

    public PartitionCreator(Function<Range<Integer>, Integer> randomInRange)
    {
        this.randomInRange = Optional.ofNullable(randomInRange).orElse(RandFunctions::randomInRange);
    }

    public SquadPartion attackPartition(Squad squad)
    {
        return ImmutableSquadPartion.builder().count(combatantsSize(squad)).squad(squad).build();
    }

    private int combatantsSize(Squad squad) {
        Range<Integer> sizeRange = bySize(squad.size()).percentInBattle;
        int discipline = squad.race().discipline();

        Range<Integer> intersection = Ranges.closed(sizeRange.lowerEndpoint(),
                Math.min(100, sizeRange.upperEndpoint() + discipline));

        Preconditions.checkArgument(intersection.upperEndpoint() <= 100, "Squad partition no more than 100%");

        return (squad.size() / 100) * randomInRange.apply(intersection);
    }

}
