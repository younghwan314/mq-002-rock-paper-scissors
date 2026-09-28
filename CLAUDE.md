# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

A console rock-paper-scissors game written as a Java learning exercise. It is currently an IntelliJ-generated skeleton: `src/main/java/com/slotmaster/Main.java` holds placeholder "Hello and welcome!" code that the game logic will replace. The package root is `com.slotmaster`.

## Build & test

The project uses the Gradle wrapper (Gradle 9.3) with JUnit Jupiter (JUnit BOM 6.0.0) on the JUnit Platform.

```bash
./gradlew build                                   # compile + test
./gradlew test                                    # run all tests
./gradlew test --tests 'com.slotmaster.SomeTest'  # single test class
./gradlew test --tests 'com.slotmaster.SomeTest.methodName'  # single test method
```

No `application` plugin is configured, so there is no `./gradlew run`. Run `Main` from the IDE, or after building:

```bash
./gradlew classes && java -cp build/classes/java/main com.slotmaster.Main
```

If the game reads console input, running it through Gradle requires adding the `application` plugin with `mainClass = 'com.slotmaster.Main'` and set `standardInput = System.in` on the `run` task.

## Conventions

- Source uses tab indentation.
- Tests go under `src/test/java/com/slotmaster/` (the directory exists but is empty).

## 작업 규칙
- 모든 설명과 대화는 한국어로 한다
- 기능은 작은 단위로 나눠서 하나씩 구현한다
- 구현 전 docs/plan.md에 계획을 먼저 정리하고 내 확인을 받는다
- 코드를 작성한 후에는 핵심 로직과 설계 이유를 설명한다
- 기능을 구현하면 테스트 코드도 함께 작성하고 실행한다

## 학습 기록
- 내가 코드에 대해 질문하면, 답변 후 질문과 핵심 답변을 docs/qna.md에 날짜와 함께 요약 기록한다

## Git 규칙
- 커밋과 푸시는 반드시 내 확인을 받은 뒤 실행한다
- 커밋 메시지는 "feat/fix/refactor/docs/test: 한국어 설명" 형식으로 작성한다
- 기능은 main에서 직접 작업하지 않는다. 기능마다 `feature/기능이름` 브랜치를 만들어 작업하고, GitHub Pull Request로 main에 머지한다
