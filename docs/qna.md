# 질문과 답변 기록

## 2026-09-28

### Q. `assertEquals`는 무엇인가?
- JUnit이 제공하는 검증 메서드. `assertEquals(기대값, 실제값)` 형태로 쓰고, 두 값이 같으면 통과, 다르면 테스트가 실패한다.
- 인자 순서가 중요하다. 첫 번째가 기대값, 두 번째가 실제값이다. 순서를 바꿔도 통과/실패는 같지만, 실패 메시지(`expected: <바위> but was: <보>`)가 거꾸로 나와 헷갈린다.
- 객체는 `==`가 아니라 `equals()`로 비교한다. 그래서 문자열도 내용이 같으면 통과한다.
- `import static ...Assertions.assertEquals`로 가져왔기 때문에 `Assertions.`를 붙이지 않고 바로 쓸 수 있다.

### Q. `손은_세_가지뿐이다` 테스트는 무엇을 검사하나?
- `Hand.values()`는 enum에 선언된 모든 상수를 선언 순서대로 담은 배열을 돌려준다. 그 길이가 3인지 확인한다.
- 목적: 누군가 실수로 손을 추가하거나 지우면 바로 알아차리게 하는 안전장치. 게임 규칙은 손이 정확히 세 개라는 전제에 기대고 있다.
- 한계: 개수만 보므로 어떤 손이 있는지는 확인하지 않는다. 그 부분은 `각_손은_한글_이름을_가진다` 테스트가 보완한다.

## 2026-09-29

### Q. switch문의 `->`는 람다식인가?
- 람다식이 아니다. Java 14에서 정식 도입된 "화살표 case 라벨"(switch rule)이다. 모양만 람다와 비슷하다.
- 예전 `case X:` 방식과 달리 해당 case만 실행하고 끝난다. `break`가 필요 없고, 다음 case로 흘러내리는(fall-through) 실수가 생기지 않는다.
- `return switch (...) { ... };`처럼 switch 전체를 값으로 쓸 수 있다(switch 식). `->` 오른쪽 식의 값이 switch의 결과가 된다. 마지막 `};`의 세미콜론은 식으로 쓴 문장을 끝내는 것이다.
- switch 식에서는 모든 경우를 다뤄야 한다. enum의 모든 상수를 다루면 `default`가 없어도 되고, 하나라도 빠지면 컴파일 오류가 난다.
- `->` 오른쪽에 여러 줄이 필요하면 `{ ... yield 값; }` 블록을 쓴다.

### Q. `case ROCK -> defender == Hand.SCISSORS`에서 비교가 참이면 결과도 참인가?
- 맞다. `defender == Hand.SCISSORS`는 `true` 또는 `false`가 되는 boolean 식이고, 그 값이 그대로 switch의 결과, 즉 `beats`의 반환값이 된다.
- 예: 바위 vs 가위 → `true`(이김), 바위 vs 보 → `false`(이기지 못함).
- `if (defender == Hand.SCISSORS) return true; else return false;`를 줄여 쓴 것과 같다.

### Q. `@ParameterizedTest`와 `@CsvSource`는 무엇인가?
- `@ParameterizedTest`: 같은 테스트 메서드를 입력값만 바꿔 여러 번 실행하게 하는 애너테이션. `@Test` 자리에 쓰고, 값을 어디서 가져올지 알려 주는 "소스" 애너테이션과 함께 써야 한다.
- `name` 속성으로 실행마다 보일 이름을 정한다. `{0}`, `{1}`은 인자 순서, `{index}`는 몇 번째 실행인지.
- `@CsvSource`: 소스 애너테이션 중 하나. 문자열 한 줄이 한 번의 실행이고, 쉼표로 나뉜 값이 메서드 인자에 순서대로 들어간다. 값 앞뒤 공백은 무시한다.
- 문자열 값은 인자 타입(int, enum 등)으로 자동 변환된다. 쉼표가 들어간 값은 작은따옴표로 감싼다(`'가위, 바위'`), `''`는 빈 문자열이다.
- 다른 소스: `@ValueSource`(인자 하나짜리 값 목록), `@EnumSource`(enum 상수 전체), `@MethodSource`(메서드가 만든 값), `@CsvFileSource`(CSV 파일).
- `junit-jupiter-params` 모듈에 들어 있고, build.gradle의 `junit-jupiter`에 포함돼 있어 따로 추가할 필요가 없다.
