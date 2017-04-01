package com.two.armies;

import org.immutables.value.Value;

/**
 * Group of same type troops, like Elf Archers, for example, in can have certain divergence inside it.
 *
 * For example, there can be a sergent, which has separate set of stats.
 *
 * Or with a squad can be found a group of mages.
 *
 * @author BlindButcher on 1/30/17.
 */
@Value.Immutable
public interface Squad {
    String name();
    int size();
}
