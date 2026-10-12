package com.slotmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

	private final InputParser parser = new InputParser();

	@ParameterizedTest(name = "{0} → {1}")
	@CsvSource({
			"가위, SCISSORS",
			"바위, ROCK",
			"보, PAPER",
			"'  가위  ', SCISSORS",
			"'\t보\t', PAPER"
	})
	void 한글_입력을_손으로_바꾼다(String input, Hand expected) {
		assertEquals(Optional.of(expected), parser.parse(input));
	}

	@ParameterizedTest(name = "{0} → 잘못된 입력")
	@NullAndEmptySource
	@ValueSource(strings = {"   ", "가우", "rock", "ROCK", "1", "가 위", "가위바위"})
	void 잘못된_입력은_빈_값을_돌려준다(String input) {
		assertTrue(parser.parse(input).isEmpty());
	}
}
