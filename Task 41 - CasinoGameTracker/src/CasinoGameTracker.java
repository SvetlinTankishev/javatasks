import java.util.Scanner;

public class CasinoGameTracker {
    protected static final int REQUIRED_UNIQUE_GAME_COUNT = 5;
    protected static final int REWARD_GAME_COUNT = 5;

    public static void main(String[] args) {
        GameTracker gameTracker = new GameTracker();

        Scanner scanner = new Scanner(System.in);

        while (!gameTracker.hasCompletedAllGameTypes()) {
            System.out.print("Enter the name of the game played: ");
            String game = scanner.nextLine();

            if (gameTracker.isValidGame(game)) {
                gameTracker.addPlayedGame(game);
            }
        }

        System.out.println("Congratulations! You have played " + REQUIRED_UNIQUE_GAME_COUNT + " different game types.");

        if (gameTracker.hasEarnedReward()) {
            System.out.println("Congratulations! You have earned " + REWARD_GAME_COUNT + " free games for playing " + REQUIRED_UNIQUE_GAME_COUNT + " different game types.");
        } else {
            System.out.println("Keep playing to earn " + REWARD_GAME_COUNT + " free games for playing " + REQUIRED_UNIQUE_GAME_COUNT + " different game types.");
        }

        System.out.println("Game types played:");
        gameTracker.printPlayedGameTypes();

        scanner.close();
    }
}
