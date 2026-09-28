package com.slotmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test
	void 각_손은_한글_이름을_가진다() {
		assertEquals("바위", Hand.ROCK.getKoreanName());
		assertEquals("보", Hand.PAPER.getKoreanName());
		assertEquals("가위", Hand.SCISSORS.getKoreanName());
	}

	@Test
	void 손은_세_가지뿐이다() {
		assertEquals(3, Hand.values().length);
	}
}
