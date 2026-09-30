package com.slotmaster;

import java.util.Random;

public class ComputerPlayer {

	private final Random random;

	public ComputerPlayer(Random random) {
		this.random = random;
	}

	public Hand choose() {
		Hand[] hands = Hand.values();
		return hands[random.nextInt(hands.length)];
	}
}
