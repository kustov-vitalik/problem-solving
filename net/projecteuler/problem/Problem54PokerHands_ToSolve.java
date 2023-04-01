package net.projecteuler.problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Problem54PokerHands_ToSolve {

  public static void main(String[] args) throws IOException {

    List<String> lines = Files.readAllLines(
        Path.of("net/projecteuler/problem/Problem54pokerData.txt"));

    System.out.println("Lines: " + lines.size());

    int winFirstCounter = 0;

    for (String line : lines) {
      if (firstPlayerWins(line)) {
        winFirstCounter++;
      }
    }

    System.out.println("Result: " + winFirstCounter);

  }

  private static boolean firstPlayerWins(String line) {

    String[] cards = line.split(" ");

    List<Card> cards1 = new ArrayList<>(5);
    for (int i = 0; i < 5; i++) {
      cards1.add(new Card(cards[i]));
    }

    List<Card> cards2 = new ArrayList<>(5);
    for (int i = 5; i < 10; i++) {
      cards2.add(new Card(cards[i]));
    }

    var player1 = new Player(cards1);
    var player2 = new Player(cards2);

    return player1.wins(player2);
  }

  static class Player {

    TreeSet<Card> cards;

    public Player(List<Card> cards) {
      this.cards = new TreeSet<>(cards);
    }

    public TreeSet<Card> getCards() {
      return cards;
    }

    @Override
    public String toString() {
      return "Player{" +
          "cards=" + cards +
          '}';
    }

    public boolean wins(Player player) {
      return false;
    }
  }


  static class Card implements Comparable<Card> {

    String suit;
    Integer rank;

    public Card(String card) {
      this.suit = card.substring(1);

      String rank = card.substring(0, 1);

      try {
        this.rank = Integer.parseInt(rank);
      } catch (NumberFormatException e) {
        if ("J".equalsIgnoreCase(rank)) {
          this.rank = 11;
        } else if ("Q".equalsIgnoreCase(rank)) {
          this.rank = 12;
        } else if ("K".equalsIgnoreCase(rank)) {
          this.rank = 13;
        } else if ("A".equalsIgnoreCase(rank)) {
          this.rank = 14;
        } else if ("T".equalsIgnoreCase(rank)) {
          this.rank = 10;
        } else {
          throw new RuntimeException(String.format("Unexpected card: %s", card));
        }
      }
    }

    public boolean sameSuit(Card card) {
      return Objects.equals(suit, card.suit);
    }

    public boolean sameRank(Card card) {
      return Objects.equals(rank, card.rank);
    }

    public Integer getRank() {
      return rank;
    }

    public String getSuit() {
      return suit;
    }

    @Override
    public String toString() {
      return "Card{" +
          "suit='" + suit + '\'' +
          ", rank=" + rank +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Card card = (Card) o;

      if (!suit.equals(card.suit)) {
        return false;
      }
      return rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
      int result = suit.hashCode();
      result = 31 * result + rank.hashCode();
      return result;
    }

    @Override
    public int compareTo(Card o) {
      return Comparator.comparingInt(Card::getRank)
          .thenComparing(Card::getSuit)
          .compare(o, this);
    }
  }

}
