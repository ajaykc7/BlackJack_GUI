/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author ajay
 */
public class Card {

    char suit;
    int rank;

    public Card(char s, int r) {
        suit = s;
        rank = r;
    }

    public String displayCard() {
        String card_name = "";
        String card_rank;
        switch (rank) {
            case 1:
                card_rank = "ace";
                break;
            case 2:
                card_rank = "two";
                break;
            case 3:
                card_rank = "three";
                break;
            case 4:
                card_rank = "four";
                break;
            case 5:
                card_rank = "five";
                break;
            case 6:
                card_rank = "six";
                break;
            case 7:
                card_rank = "seven";
                break;
            case 8:
                card_rank = "eight";
                break;
            case 9:
                card_rank = "nine";
                break;
            case 10:
                card_rank = "ten";
                break;
            case 11:
                card_rank = "jack";
                break;
            case 12:
                card_rank = "queen";
                break;
            default:
                card_rank = "king";
                break;
        }
        if (suit == 'C') {
            card_name = card_rank + "_of_club.jpg";
        } else if (suit == 'H') {
            card_name = card_rank + "_of_heart.jpg";
        } else if (suit == 'S') {
            card_name = card_rank + "_of_spade.jpg";
        } else {
            card_name = card_rank + "_of_diamond.jpg";
        }
        return card_name;
    }

    public int getValue() {
        if (rank == 1) {
            return 11;
        } else if ((rank >= 2) && (rank <= 10)) {
            return rank;
        } else {
            return 10;
        }
    }
}
