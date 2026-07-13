import java.util.Random;
import java.util.Scanner;

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

		// 사용자 입력 받기 위한 객체 생성
		Scanner scanner = new Scanner(System.in);
		// 사용자 입력 받기
		System.out.print("가위/바위/보 중 하나를 입력하세요: ");
		String userChoice = scanner.nextLine();
		scanner.close();

		// 무승패 판정
		if (userChoice.equals(computerChoice)) {
			System.out.println("무승부입니다.");

		} else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
			       (userChoice.equals("바위") && computerChoice.equals("가위")) ||
			       (userChoice.equals("보") && computerChoice.equals("바위"))) {
			System.out.println("승리입니다.");

		} else {
			System.out.println("패배입니다.");
		}
		// 결과 출력
		System.out.println("컴퓨터: " + computerChoice);
		System.out.println("유저: " + userChoice);
	}
}
