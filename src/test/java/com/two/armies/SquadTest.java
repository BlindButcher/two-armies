package com.two.armies;

import org.junit.Test;

/**
 * Test SquadCombatResolver class.
 *
 * @author BlindButcher
 * @since 2/5/17
 */
public class SquadTest {

    @Test
    public void testSquad() {
        SquadCombatResolver resolver = new SquadCombatResolver();

        Squad squad1 = ImmutableSquad.builder().name("Human Infantry")
                .size(100).build();
        Squad squad2 = ImmutableSquad.builder().name("Orc Infantry")
                .size(100).build();

        SquadCombatResult result = resolver.apply(squad1, squad2);
        System.out.println(result.first());
        System.out.println(result.second());
    }
}