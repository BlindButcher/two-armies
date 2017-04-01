package com.two.armies;

import com.google.common.collect.Multimap;
import org.immutables.value.Value;

/**
 * Contains Combat Results.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
@Value.Immutable
public interface SquadCombatResult {
    Squad first();
    Squad second();
    Multimap<Squad, String> messages();
}
