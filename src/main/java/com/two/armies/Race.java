package com.two.armies;

import org.immutables.value.Value;

/**
 * Contains race data.
 */
@Value.Immutable
public interface Race
{
    public static final int DEFAULT_ATTRIBUTE_SIZE = 5;

    String name();

    /**
     * Indicates how good is race with Discipline.
     */
    @Value.Default default int discipline()
    {
        return DEFAULT_ATTRIBUTE_SIZE;
    }
}
