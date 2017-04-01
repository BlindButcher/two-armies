package com.two.armies;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Range;

import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;
import static com.two.armies.SquadSizeCategory.bySize;
import static java.lang.String.format;

/**
 * Resolves combat between two squads.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
public class SquadCombatResolver {
    private static final String LOSS_MESSAGE = "Squad of %s lost %s";
    private static final Random random = new Random();

    public SquadCombatResult apply(Squad first, Squad second) {
        int firstSize = combatantsSize(first);
        int secondSize = combatantsSize(second);

        ImmutableSquad newFirst = ImmutableSquad.copyOf(first).withSize(first.size() - secondSize);
        ImmutableSquad newSecond = ImmutableSquad.copyOf(second).withSize(second.size() - firstSize);

        return ImmutableSquadCombatResult.builder()
                .first(newFirst)
                .second(newSecond)
                .putMessages(newFirst, format(LOSS_MESSAGE, newFirst.name(), secondSize))
                .putMessages(newSecond, format(LOSS_MESSAGE, newSecond.name(), firstSize))
                .build();
    }

    private int combatantsSize(Squad squad) {
        return squad.size() * randomInRange(bySize(squad.size()).percentInBattle) / 100;
    }

    public static int randomInRange(Range<Integer> range) {
        checkArgument(range.hasLowerBound() && range.hasUpperBound(),
                "Cannot select a random element from unbounded range %s", range);
        Range<Integer> canonical = range.canonical(DiscreteDomains.integers());

        return random.nextInt(canonical.upperEndpoint() - canonical.lowerEndpoint())
                + canonical.lowerEndpoint();
    }
}
