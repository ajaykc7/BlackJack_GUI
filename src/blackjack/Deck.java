/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ajay
 */
public class Deck extends JFrame {

    Card[] card_deck;
    Card[] temp_deck;

    public Deck() {
        card_deck = new Card[52];
        temp_deck = new Card[52];
        for (int i = 0; i < 52; i++) {
            if ((i >= 0) && (i <= 12)) {
                card_deck[i] = new Card('C', (i + 1) % 13);
            } else if ((i >= 13) && (i <= 25)) {
                card_deck[i] = new Card('D', (i + 1) % 13);
            } else if ((i >= 26) && (i <= 38)) {
                card_deck[i] = new Card('S', (i + 1) % 13);
            } else {
                card_deck[i] = new Card('H', (i + 1) % 13);
            }
        }
        temp_deck = card_deck;

    }

    public Card deal() {
        return card_deck[0];
    }

    public void DeckAfterDeal() {
        card_deck = new Card[temp_deck.length - 1];
        for (int i = 0; i < card_deck.length; i++) {
            card_deck[i] = temp_deck[i + 1];
        }
        temp_deck = new Card[card_deck.length];
        temp_deck = card_deck;
    }

    public int cardLeft() {
        return card_deck.length;
    }

    public void Shuffle() {
        int index;
        Card temp;
        Random random = new Random();
        for (int i = card_deck.length - 1; i > 0; i--) {

            index = random.nextInt(i + 1);
            temp = card_deck[index];
            card_deck[index] = card_deck[i];
            card_deck[i] = temp;
        }
        temp_deck = card_deck;
    }

    public void displayDec() {

        if (card_deck.length == 0) {
            JOptionPane.showMessageDialog(null, "The deck is empty", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            BufferedImage image = null;

            JFrame frame = new JFrame();
            frame.setTitle("Deck");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);

            JPanel panel = new JPanel();

            String card_location;
            JLabel label;

            for (int i = 0; i < card_deck.length; i++) {
                card_location = card_deck[i].displayCard();
                String file = (getClass().getResource("").getPath().toString());
                card_location = file + card_location;
                try {
                    image = ImageIO.read(new File(card_location));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                ImageIcon imageicon = new ImageIcon(image);

                label = new JLabel(imageicon);
                panel.add(label);
            }
            frame.add(panel);
        }
    }
}
