import java.util.HashMap;
import java.util.Map;

class GameTracker {
    private static final String[] GAME_NAMES = {
            "Baccarat", "Blackjack", "Craps", "Roulette", "Poker Texas hold'em",
            "Poker Five-card draw", "Poker Omaha hold'em", "Big Six wheel", "Pool",
            "Pachinko", "Slot machine", "Video lottery terminal", "Video poker",
            "Bingo", "Keno"
    };

    private Map<String, Integer> playedGameTypes;
    private int uniqueGameCount;

    public GameTracker() {
        playedGameTypes = new HashMap<>();
        uniqueGameCount = 0;
    }

    public boolean isValidGame(String game) {
        for (String name : GAME_NAMES) {
            if (name.equalsIgnoreCase(game)) {
                return true;
            }
        }
        return false;
    }

    public void addPlayedGame(String game) {
        if (!playedGameTypes.containsKey(game)) {
            playedGameTypes.put(game, 1);
            uniqueGameCount++;
        } else if (playedGameTypes.get(game) < CasinoGameTracker.REWARD_GAME_COUNT) {
            playedGameTypes.put(game, playedGameTypes.get(game) + 1);
        }
    }

    public boolean hasCompletedAllGameTypes() {
        return uniqueGameCount >= CasinoGameTracker.REQUIRED_UNIQUE_GAME_COUNT;
    }

    public boolean hasEarnedReward() {
        for (int count : playedGameTypes.values()) {
            if (count < CasinoGameTracker.REQUIRED_UNIQUE_GAME_COUNT) {
                return false;
            }
        }
        return true;
    }

    public void printPlayedGameTypes() {
        for (String gameType : playedGameTypes.keySet()) {
            System.out.println(gameType);
        }
    }
}