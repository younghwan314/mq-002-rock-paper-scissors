import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		// 게임 작동 변수
		boolean isRunning = true;

		// Random 클래스 객체 생성
		Random random = new Random();

		// 사용자 입력 받기 위한 객체 생성
		Scanner scanner = new Scanner(System.in);

		// 가위/바위/보 배열 선언
		String[] rps = {"가위", "바위", "보"};

		// 승점 선언
		int winningScore = 2;

		// 게임 시작(재시작 포함)
		while (isRunning) {
			System.out.println("가위바위보 게임 시작!");

			// 점수 변수 선언 및 초기화
			int userScore = 0;
			int computerScore = 0;

			// 목표 승점을 먼저 얻을 때까지 반복
			while (userScore < winningScore && computerScore < winningScore) {
				// 가위/바위/보 랜덤 선택
				int randomIndex = random.nextInt(rps.length);

				// 랜덤 정수를 가위/바위/보로 변환
				String computerChoice = rps[randomIndex];

				// 사용자 입력 받기
				System.out.print("가위/바위/보 중 하나를 입력하세요: ");
				String userChoice = scanner.nextLine();

				// 무승패 판정
				if (userChoice.equals(computerChoice)) {
					System.out.println("무승부입니다.");

				} else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
					(userChoice.equals("바위") && computerChoice.equals("가위")) ||
					(userChoice.equals("보") && computerChoice.equals("바위"))) {
					System.out.println("승리입니다.");
					userScore++;

				} else {
					System.out.println("패배입니다.");
					computerScore++;
				}

				System.out.println("------------------------------");

				// 결과 출력
				System.out.println("컴퓨터: " + computerChoice);
				System.out.println("유저: " + userChoice);

				System.out.println("------------------------------");

				// 스코어 출력
				System.out.println("유저 점수: " + userScore);
				System.out.println("컴퓨터 점수: " + computerScore);

				System.out.println("------------------------------");
			}

			// 최종 승자 출력
			System.out.println("============ 최종 결과 ============");
			System.out.println("유저 점수: " + userScore);
			System.out.println("컴퓨터 점수: " + computerScore);
			System.out.println();

			if (userScore == winningScore) {
				System.out.println("유저가 최종 승리했습니다.");
			} else {
				System.out.println("컴퓨터가 최종 승리했습니다.");
			}

			System.out.println("=================================");

			System.out.print("게임을 다시 하시겠습니까? (y/n): ");
			String restartChoice = scanner.nextLine();

			if (restartChoice.equals("n")) {
				isRunning = false;
			}
		}
		scanner.close();
	}
}
