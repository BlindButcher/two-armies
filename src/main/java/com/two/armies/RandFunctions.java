package com.two.armies;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.Random;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Range;


public class RandFunctions
{
    private static final Random RANDOM = new Random();

    public static int randomInRange(Range<Integer> range)
    {
        checkArgument(range.hasLowerBound() && range.hasUpperBound(),
                "Cannot select a random element from unbounded range %s", range);
        Range<Integer> canonical = range.canonical(DiscreteDomains.integers());

        return RANDOM.nextInt(canonical.upperEndpoint() - canonical.lowerEndpoint())
                + canonical.lowerEndpoint();
    }
}
