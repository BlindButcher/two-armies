package com.two.armies;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Range;

public class PartitionCreatorTest
{

    @Test
    public void attackPartition() throws Exception
    {
        PartitionCreator partitionCreator = new PartitionCreator((Range<Integer> integerRange) -> {
            assertEquals((int) integerRange.upperEndpoint(), 60);
            return 50;
        });

        Squad squad = ImmutableSquad.builder().name("Human Infantry")
                .race(ImmutableRace.builder().name("Human").discipline(10).build())
                .size(100).build();

        assertEquals(50, partitionCreator.attackPartition(squad).count());
    }

}