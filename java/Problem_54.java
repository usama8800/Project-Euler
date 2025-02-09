import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_54 {
	/* In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in
	 * the following way:
	 * 
	 * -High Card: Highest value card.
	 * -One Pair: Two cards of the same value.
	 * -Two Pairs: Two different pairs.
	 * -Three of a Kind: Three cards of the same value.
	 * -Straight: All cards are consecutive values.
	 * -Flush: All cards of the same suit.
	 * -Full House: Three of a kind and a pair.
	 * -Four of a Kind: Four cards of the same value.
	 * -Straight Flush: All cards are consecutive values of same suit.
	 * -Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
	 * 
	 * The cards are valued in the order:
	 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
	 * 
	 * If two players have the same ranked hands then the rank made up of the highest value wins; for
	 * example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for
	 * example, both players have a pair of queens, then highest cards in each hand are compared (see
	 * example 4 below); if the highest cards tie then the next highest cards are compared, and so on.
	 * 
	 * Consider the following five hands dealt to two players:						@formatter:off	 
	 * 
	 * Hand	Player 1			Player 2			Winner
	 * 
	 * 1	5H 5C 6S 7S KD		2C 3S 8S 8D TD		Player 2
	 * 		Pair of Fives		Pair of Eights
	 * 
	 * 2 	5D 8C 9S JS AC		2C 5C 7D 8S QH		Player 1
	 * 		Highest card Ace	Highest card Queen
	 * 
	 * 3 	2D 9C AS AH AC		3D 6D 7D TD QD		Player 2
	 * 		Three Aces			Flush with Diamonds
	 * 
	 * 4 	4D 6S 9H QH QC		3D 6D 7H QD QS		Player 1
	 * 		Pair of Queens		Pair of Queens
	 * 		Highest card Nine	Highest card Seven
	 * 
	 * 5 	2H 2D 4C 4D 4S		3C 3D 3S 9S 9D		Player 1
	 * 		Full House			Full House
	 * 		With Three Fours	with Three Threes	*/					
	 /* 																			@formatter:on
	 * The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the
	 * file contains ten cards (separated by a single space): the first five are Player 1's cards and the
	 * last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or
	 * repeated cards), each player's hand is in no specific order, and in each hand there is a clear
	 * winner.
	 * 
	 * How many hands does Player 1 win? */
	public static void main(String[] args) {
		try {
			File file = new File("Problem_54_Data.txt");
			Scanner sc = new Scanner(file).useDelimiter("\n");
			int answer = 0;
			while (sc.hasNext()) {
				String allCards = sc.next();
				String[] p1Cards = allCards.substring(0, 14).split(" ");
				String[] p2Cards = allCards.substring(15).split(" ");
				if (whoWins(p1Cards, p2Cards) == 1) answer++;
			}
			sc.close();
			System.out.println(answer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static int whoWins(String[] p1Cards, String[] p2Cards) {
		if (isRoyalFlush(p1Cards) && !isRoyalFlush(p2Cards)) return 1;
		if (isRoyalFlush(p2Cards) && !isRoyalFlush(p1Cards)) return 2;
		if (isStraightFlush(p1Cards) > isStraightFlush(p2Cards)) return 1;
		if (isStraightFlush(p2Cards) > isStraightFlush(p1Cards)) return 2;
		if (isFourOfAKind(p1Cards) > isFourOfAKind(p2Cards)) return 1;
		if (isFourOfAKind(p2Cards) > isFourOfAKind(p1Cards)) return 2;
		if (isFullHouse(p1Cards) > isFullHouse(p2Cards)) return 1;
		if (isFullHouse(p2Cards) > isFullHouse(p1Cards)) return 2;
		if (isFlush(p1Cards) && !isFlush(p2Cards)) return 1;
		if (isFlush(p2Cards) && !isFlush(p1Cards)) return 2;
		if (isStraight(p1Cards) > isStraight(p2Cards)) return 1;
		if (isStraight(p2Cards) > isStraight(p1Cards)) return 2;
		if (isThreeOfAKind(p1Cards) > isThreeOfAKind(p2Cards)) return 1;
		if (isThreeOfAKind(p2Cards) > isThreeOfAKind(p1Cards)) return 2;
		String isPairp1 = isPair(p1Cards);
		String isPairp2 = isPair(p2Cards);
		if (isPairp1.contains(",") && isPairp2.contains(",")) {
			if (Integer.parseInt(isPairp1.substring(isPairp1.length() - 1)) > Integer.parseInt(isPairp2.substring(isPairp2.length() - 1))) return 1;
			else return 2;
		}
		if (isPairp1.contains(",") && !isPairp2.contains(",")) return 1;
		if (isPairp2.contains(",") && !isPairp1.contains(",")) return 2;
		if (!isPairp1.equals("") && !isPairp2.equals("")) {
			if (Integer.parseInt(isPairp1) > Integer.parseInt(isPairp2)) return 1;
			else return 2;
		}
		if (!isPairp1.equals("") && isPairp2.equals("")) return 1;
		if (!isPairp2.equals("") && isPairp1.equals("")) return 2;
		if (highestCard(p1Cards) > highestCard(p2Cards)) return 1;
		else return 2;
	}
	
	public static int highestCard(String[] cards) {
		int highest = 0;
		for (String card : cards)
			if (getCardValue(card) > highest) highest = getCardValue(card);
		return highest;
	}
	
	public static int isFullHouse(String[] cards) {
		int tok = isThreeOfAKind(cards);
		if (tok != 0 && !isPair(cards).equals("")) return tok;
		else return 0;
	}
	
	public static String isPair(String[] cards) {
		String repeater = "";
		for (int i = 2; i < 15; i++) {
			int repeats = 0;
			for (String card : cards)
				if (getCardValue(card) == i) repeats++;
			if (repeats == 2) repeater += (repeater.equals("") ? "" : ",") + String.valueOf(i);
		}
		return repeater;
	}
	
	public static int isThreeOfAKind(String[] cards) {
		int repeater = 0;
		for (int i = 2; i < 15; i++) {
			int repeats = 0;
			for (String card : cards)
				if (getCardValue(card) == i) repeats++;
			if (repeats == 3) repeater = i;
		}
		return repeater;
	}
	
	public static int isFourOfAKind(String[] cards) {
		int repeater = 0;
		for (int i = 2; i < 15; i++) {
			int repeats = 0;
			for (String card : cards)
				if (getCardValue(card) == i) repeats++;
			if (repeats == 4) repeater = i;
		}
		return repeater;
	}
	
	public static boolean isRoyalFlush(String[] cards) {
		String suit = getCardSuit(cards[0]);
		int sum = getCardValue(cards[0]);
		for (int i = 1; i < cards.length; i++) {
			if (!getCardSuit(cards[i]).equals(suit)) return false;
			int cardValue = getCardValue(cards[i]);
			if (cardValue < 10) return false;
			sum += cardValue;
		}
		if (sum == (10 + 11 + 12 + 13 + 14)) return true;
		else return false;
	}
	
	public static int isStraightFlush(String[] cards) {
		String suit = getCardSuit(cards[0]);
		int[] cardsValues = new int[5];
		for (int i = 0; i < cards.length; i++) {
			if (!getCardSuit(cards[i]).equals(suit)) return 0;
			cardsValues[i] = getCardValue(cards[i]);
		}
		Arrays.sort(cardsValues);
		for (int i = 0; i < cardsValues.length - 1; i++)
			if (cardsValues[i + 1] - cardsValues[i] != 1) return 0;
		return cardsValues[0];
	}
	
	public static boolean isFlush(String[] cards) {
		String suit = getCardSuit(cards[0]);
		for (int i = 0; i < cards.length; i++)
			if (!getCardSuit(cards[i]).equals(suit)) return false;
		return true;
	}
	
	public static int isStraight(String[] cards) {
		int[] cardsValues = new int[5];
		for (int i = 0; i < cards.length; i++)
			cardsValues[i] = getCardValue(cards[i]);
		Arrays.sort(cardsValues);
		for (int i = 0; i < cardsValues.length - 1; i++)
			if (cardsValues[i + 1] - cardsValues[i] != 1) return 0;
		return cardsValues[0];
	}
	
	public static int getCardValue(String card) {
		String cardValue = card.substring(0, 1);
		try {
			return Integer.parseInt(cardValue);
		} catch (NumberFormatException e) {
			switch (cardValue) {
				case "T":
					return 10;
				case "J":
					return 11;
				case "Q":
					return 12;
				case "K":
					return 13;
				case "A":
					return 14;
			}
		}
		return 0;
	}
	
	public static String getCardSuit(String card) {
		return card.substring(1);
	}
}
