package com.slotmaster;

public enum Hand {
	ROCK("바위"),
	PAPER("보"),
	SCISSORS("가위");

	private final String koreanName;

	Hand(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getKoreanName() {
		return koreanName;
	}
}
