package me.char321.nexcavate.items.machines;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartExtractorTest {

    /** Verifies empty stale inputs never create Bukkit's invalid zero-sized stack. */
    @Test
    void doesNotRefundWhenNoItemWasConsumed() {
        assertEquals(0, PartExtractor.getRefundAmount(1, 1));
        assertEquals(0, PartExtractor.getRefundAmount(1, 2));
    }

    /** Preserves the intended refund for a genuine partial consumption. */
    @Test
    void refundsOnlyTheAmountActuallyConsumed() {
        assertEquals(2, PartExtractor.getRefundAmount(3, 1));
        assertEquals(3, PartExtractor.getRefundAmount(3, 0));
    }
}
