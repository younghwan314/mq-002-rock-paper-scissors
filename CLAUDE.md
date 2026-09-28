# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

A console rock-paper-scissors game written as a Java learning exercise. The package root is `com.slotmaster`. `Main.java` still holds IntelliJ placeholder code that the game logic will replace.

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
- Tests go under `src/test/java/com/slotmaster/`.
- The feature plan and progress order live in `docs/plan.md`.

작업, Git, 노션 기록 규칙은 상위 폴더의 `../CLAUDE.md`에 있다.
