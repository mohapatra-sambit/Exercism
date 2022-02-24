public class Blackjack{

    public int parseCard(String card) {
        if ("ace".equals(card)) {
        	return 11;
        }
        if ("two".equals(card)) {
        	return 2;
        }
        if ("three".equals(card)) {
        	return 3;
        }
        if ("four".equals(card)) {
        	return 4;
        }
        if ("five".equals(card)) {
        	return 5;
        }
        if ("six".equals(card)) {
        	return 6;
        }
        if ("seven".equals(card)) {
        	return 7;
        }
        if ("eight".equals(card)) {
        	return 8;
        }
        if ("nine".equals(card)) {
        	return 9;
        }
        if ("ten".equals(card) || "jack".equals(card) || "queen".equals(card) || "king".equals(card)) {
        	return 10;
        }
       	return 0;
    }

    public boolean isBlackjack(String card1, String card2) {
    	return (parseCard(card1) + parseCard(card2)) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) {
        	return "P";
        } else if (dealerScore < 10) {
        	return "W";
        } else {
        	return "S";
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore <= 11) {
        	return "H";
        } else if (handScore > 11 && handScore < 17) {
        	return dealerScore >= 7 ? "H" : "S";
        } else {
        	return "S";
        }
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) 
            return largeHand(isBlackjack(card1, card2), dealerScore);
        
        else
            return smallHand(handScore, dealerScore);
    }
}
