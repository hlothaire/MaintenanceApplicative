package trivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game implements IGame {
   private final List<Player> players = new ArrayList<>();
   private final LinkedList<String> popQuestions = new LinkedList<>();
   private final LinkedList<String> scienceQuestions = new LinkedList<>();
   private final LinkedList<String> sportsQuestions = new LinkedList<>();
   private final LinkedList<String> rockQuestions = new LinkedList<>();

   private int currentPlayerIndex = 0;
   private boolean isGettingOutOfPenaltyBox;

   public Game() {
      for (int i = 0; i < 50; i++) {
         popQuestions.add("Pop Question " + i);
         scienceQuestions.add("Science Question " + i);
         sportsQuestions.add("Sports Question " + i);
         rockQuestions.add(createRockQuestion(i));
      }
   }

   private String createRockQuestion(int index) {
      return "Rock Question " + index;
   }

   public boolean isPlayable() {
      return players.size() >= 2;
   }

   public boolean add(String playerName) {
      Player player = new Player(playerName);
      players.add(player);
      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public int howManyPlayers() {
      return players.size();
   }

   public void roll(int roll) {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println(currentPlayer.getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (currentPlayer.isInPenaltyBox()) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
            currentPlayer.move(roll);
            System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPlace());
            Categories category = currentCategory(currentPlayer.getPlace());
            System.out.println("The category is " + category);
            askQuestion(category);
         } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }
      } else {
         currentPlayer.move(roll);
         System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPlace());
         Categories category = currentCategory(currentPlayer.getPlace());
         System.out.println("The category is " + category);
         askQuestion(category);
      }
   }

   private void askQuestion(Categories category) {
      switch (category) {
         case POP:
            System.out.println(popQuestions.removeFirst());
            break;
         case SCIENCE:
            System.out.println(scienceQuestions.removeFirst());
            break;
         case SPORTS:
            System.out.println(sportsQuestions.removeFirst());
            break;
         case ROCK:
            System.out.println(rockQuestions.removeFirst());
            break;
         default:
            break;
      }
   }

   private Categories currentCategory(int place) {
      int categoryIndex = (place - 1) % 4;
      switch (categoryIndex) {
         case 0:
            return Categories.POP;
         case 1:
            return Categories.SCIENCE;
         case 2:
            return Categories.SPORTS;
         default:
            return Categories.ROCK;
      }
   }

   public boolean handleCorrectAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      if (currentPlayer.isInPenaltyBox()) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            currentPlayer.addCoin();
            System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurse() + " Gold Coins.");
            boolean winner = !hasPlayerWon(currentPlayer);
            moveToNextPlayer();
            return winner;
         } else {
            moveToNextPlayer();
            return true;
         }
      } else {
         System.out.println("Answer was correct!!!!");
         currentPlayer.addCoin();
         System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurse() + " Gold Coins.");
         boolean winner = !hasPlayerWon(currentPlayer);
         moveToNextPlayer();
         return winner;
      }
   }

   public boolean wrongAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer.getName() + " was sent to the penalty box");
      currentPlayer.setInPenaltyBox(true);
      moveToNextPlayer();
      return true;
   }

   private boolean hasPlayerWon(Player player) {
      return player.getPurse() == 6;
   }

   private void moveToNextPlayer() {
      currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
   }
}
