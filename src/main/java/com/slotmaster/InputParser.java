package com.slotmaster;

import java.util.Optional;

public class InputParser {

	public Optional<Hand> parse(String input) {
		if (input == null) {
			return Optional.empty();
		}
		String trimmed = input.strip();
		for (Hand hand : Hand.values()) {
			if (hand.getKoreanName().equals(trimmed)) {
				return Optional.of(hand);
			}
		}
		return Optional.empty();
	}
}
