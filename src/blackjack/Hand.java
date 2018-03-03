/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ajay
 */
public class Hand {

    ArrayList<Card> card_hand = new ArrayList<Card>();
    int ace_count;
    int player;

    public Hand(int p) {
        player = p;
    }

    public void takeHand(Card c) {
        card_hand.add(c);
        if (c.getValue() == 11) {
            ace_count = ace_count + 1;
            System.out.println(ace_count);
        }
    }

    public JPanel displayHand(JPanel panel) {

        BufferedImage image = null;

        String card_location;
        JLabel label;

        //System.out.println(card_hand.size());
        for (int i = 0; i < card_hand.size(); i++) {
            card_location = card_hand.get(i).displayCard();
            String file = (getClass().getResource("").getPath().toString());
            card_location = file + card_location;
            try {

                image = ImageIO.read(new File(card_location));

            } catch (Exception e) {
                e.printStackTrace();
            }

            ImageIcon imageicon = new ImageIcon(image);
            label = new JLabel(imageicon);
            label.setSize(200, 200);
            if (player == 0) {
                label.setLocation(i * 105, 50);
            } else {
                label.setLocation(i * 105, 450);
            }

            panel.add(label);
        }
        return panel;
    }

    public int total_value() {
        int total = 0;
        for (int i = 0; i < card_hand.size(); i++) {
            total = total + card_hand.get(i).getValue();
        }
        while (ace_count != 0) {
            if (total > 21) {
                total = total - 10;
            }
            ace_count--;
        }
        return total;
    }

    public int changeWallet(int money, char result) {
        if (result == 'W') {
            money = money + 2;
        } else {
            money = money - 2;
        }

        return money;
    }
}
