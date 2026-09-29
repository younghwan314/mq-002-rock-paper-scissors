package com.slotmaster;

public class Referee {

	public Result judge(Hand user, Hand computer) {
		if (user == computer) {
			return Result.DRAW;
		}
		return beats(user, computer) ? Result.WIN : Result.LOSE;
	}

	private boolean beats(Hand attacker, Hand defender) {
		return switch (attacker) {
			case ROCK -> defender == Hand.SCISSORS;
			case PAPER -> defender == Hand.ROCK;
			case SCISSORS -> defender == Hand.PAPER;
		};
	}
}
