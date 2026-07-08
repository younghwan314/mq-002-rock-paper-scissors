import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args) {
		System.out.println("가위바위보 게임 시작!");

		// Random 클래스 객체 생성
		Random random = new Random();

		// 가위/바위/보 랜덤 선택
		int randomIntWithin3 = random.nextInt(3);

		// 랜덤 정수를 가위/바위/보로 변환
		String[] rps = {"가위", "바위", "보"};
		String computerChoice = rps[randomIntWithin3];
		System.out.println(computerChoice);
	}
}
