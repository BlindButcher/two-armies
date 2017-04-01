package com.two.armies;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;

import static com.google.common.collect.Ranges.closed;
import static com.google.common.collect.Ranges.greaterThan;
import static com.google.common.collect.Ranges.singleton;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

/**
 * Squad type based on its size. Mechanic can depend upon that.
 * <p>
 * Squad of size 2 is typed as FEW etc.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
public enum SquadSizeCategory {
    FEW(closed(1, 3), singleton(100)),
    SEVERAL(closed(4, 10), singleton(90)),
    GROUP(closed(11, 30), closed(80, 90)),
    LOTS(closed(30, 60), closed(50, 60)),
    LOTS_PLUS(greaterThan(61), closed(30, 50));

    SquadSizeCategory(Range<Integer> sizeRange, Range<Integer> percentInBattle) {
        this.sizeRange = requireNonNull(sizeRange);
        this.percentInBattle = requireNonNull(percentInBattle);

    }

    public Range<Integer> sizeRange;

    /**
     * What default percent range of squad take part in battle.
     * This can be modified by squad leader etc.
     */
    public Range<Integer> percentInBattle;

    /**
     * Find SquadSizeCategory, last one can match any size.
     */
    public static SquadSizeCategory bySize(int size) {
        Preconditions.checkArgument(size > 0, "Squad size should be more than zero.");
        return stream(values()).filter(v -> v.sizeRange.contains(size))
                .findFirst().get();
    }
}
