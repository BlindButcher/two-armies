package com.two.armies;

import org.immutables.value.Value;

/**
 * Basic squad partition, for squad tacking part in combat it can be partition which take part in melee and which doesn't.
 */
@Value.Immutable
public interface SquadPartion
{
    Squad squad();
    int count();
}
