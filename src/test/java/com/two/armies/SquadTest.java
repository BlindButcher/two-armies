package com.two.armies;

import java.util.stream.Collectors;

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
        SquadCombatResolver resolver = new SquadCombatResolver(new PartitionCreator(RandFunctions::randomInRange));

        Squad squad1 = ImmutableSquad.builder().name("Human Infantry")
                .race(ImmutableRace.builder().name("Human").discipline(10).build())
                .size(100).build();
        Squad squad2 = ImmutableSquad.builder().name("Orc Infantry")
                .race(ImmutableRace.builder().name("Human").discipline(0).build())
                .size(100).build();

        SquadCombatResult result = resolver.apply(squad1, squad2);
        System.out.println(result.first());
        System.out.println(result.second());

        System.out.println(result.messages().values().stream().collect(Collectors.joining(System.lineSeparator())));
    }
}