package com.slotmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

	private final Referee referee = new Referee();

	@ParameterizedTest(name = "사용자 {0} vs 컴퓨터 {1} → {2}")
	@CsvSource({
			"ROCK,     SCISSORS, WIN",
			"PAPER,    ROCK,     WIN",
			"SCISSORS, PAPER,    WIN",
			"ROCK,     PAPER,    LOSE",
			"PAPER,    SCISSORS, LOSE",
			"SCISSORS, ROCK,     LOSE",
			"ROCK,     ROCK,     DRAW",
			"PAPER,    PAPER,    DRAW",
			"SCISSORS, SCISSORS, DRAW"
	})
	void 가능한_9가지_조합을_판정한다(Hand user, Hand computer, Result expected) {
		assertEquals(expected, referee.judge(user, computer));
	}
}
