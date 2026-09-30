package com.slotmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerPlayerTest {

	@ParameterizedTest(name = "난수 {0} → {1}")
	@CsvSource({
			"0, ROCK",
			"1, PAPER",
			"2, SCISSORS"
	})
	void 난수_값에_해당하는_손을_고른다(int fixedNumber, Hand expected) {
		Random fixedRandom = new Random() {
			@Override
			public int nextInt(int bound) {
				return fixedNumber;
			}
		};
		ComputerPlayer computer = new ComputerPlayer(fixedRandom);

		assertEquals(expected, computer.choose());
	}

	@Test
	void 여러_번_고르면_세_가지_손이_모두_나온다() {
		ComputerPlayer computer = new ComputerPlayer(new Random(42));
		Set<Hand> chosen = EnumSet.noneOf(Hand.class);

		for (int i = 0; i < 100; i++) {
			chosen.add(computer.choose());
		}

		assertEquals(EnumSet.allOf(Hand.class), chosen);
	}
}
