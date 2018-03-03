/*
 * Ajay Kc
Black Jack
CECS 174
 */
package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ajay
 */
public class Frames extends JFrame {

    JFrame frame;
    JPanel panel;
    Deck deck;
    Hand[] hand;
    public int player_money = 10;
    public int comp_money = 10000;

    public void Welcome() {

        frame = new JFrame();
        frame.setLocation(480, 300);
        frame.setSize(450, 180);
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);

        frame.add(panel);

        JLabel welcome_label = new JLabel("Welcome ");
        welcome_label.setFont(new Font("Serif", Font.PLAIN, 34));
        welcome_label.setSize(200, 30);
        welcome_label.setLocation(150, 10);
        panel.add(welcome_label);

        JLabel blackjack_label = new JLabel("to Black Jack ");
        blackjack_label.setFont(new Font("Serif", Font.PLAIN, 34));
        blackjack_label.setSize(250, 80);
        blackjack_label.setLocation(110, 30);
        panel.add(blackjack_label);

        JButton start_button = new JButton("PLAY");
        start_button.setBounds(200, 100, 80, 50);
        panel.add(start_button);

        start_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenu();
            }
        });
    }

    public void MainMenu() {

        frame = new JFrame();
        frame.setLocation(500, 250);
        frame.setSize(300, 330);
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel MainMenu_label = new JLabel("Main Menu");
        MainMenu_label.setFont(new Font("Serif", Font.PLAIN, 14));
        MainMenu_label.setSize(100, 30);
        MainMenu_label.setLocation(20, 10);
        panel.add(MainMenu_label);

        JButton newdeck_button = new JButton("New Deck");
        newdeck_button.setBounds(5, 50, 140, 30);
        panel.add(newdeck_button);

        JButton shuffle_button = new JButton("Shuffle");
        shuffle_button.setBounds(5, 100, 140, 30);
        panel.add(shuffle_button);

        JButton display_button = new JButton("Display Deck");
        display_button.setBounds(5, 150, 140, 30);
        panel.add(display_button);

        JButton play_button = new JButton("Play Black Jack");
        play_button.setBounds(5, 200, 140, 30);
        panel.add(play_button);

        JButton exit_button = new JButton("Exit");
        exit_button.setBounds(5, 250, 140, 30);
        panel.add(exit_button);

        newdeck_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deck = new Deck();
                JOptionPane.showMessageDialog(null, "A New Deck has been created", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exit_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Thank you", "Message", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });

        shuffle_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    deck.Shuffle();
                    JOptionPane.showMessageDialog(null, "The Deck has been shuffled", "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (NullPointerException error) {
                    JOptionPane.showMessageDialog(null, "A deck has not been created", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        display_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    deck.displayDec();
                    frame.setLocation(50, 250);
                    frame.setVisible(true);
                } catch (NullPointerException error) {
                    JOptionPane.showMessageDialog(null, "A deck has not been created", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        play_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (deck == null) {
                    JOptionPane.showMessageDialog(null, "A deck has not been created", "Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (player_money < 2) {
                        JOptionPane.showMessageDialog(null, "You do not have sufficient money", "Message", JOptionPane.ERROR_MESSAGE);
                    } else if (deck.cardLeft() <= 12) {
                        JOptionPane.showMessageDialog(null, "There are not enough card in the deck", "Message", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            frame.dispose();
                            Game();
                        } catch (NullPointerException error) {
                            JOptionPane.showMessageDialog(null, "A deck has not been created", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        );
    }

    public void Game() {

        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Black Jack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        JOptionPane.showMessageDialog(null, "Press Ok to Start", "Message", JOptionPane.PLAIN_MESSAGE);

        JLabel blackjack_label = new JLabel("Black Jack");
        blackjack_label.setFont(new Font("Verdana", Font.PLAIN, 34));
        blackjack_label.setSize(200, 50);
        blackjack_label.setLocation(600, 10);
        panel.add(blackjack_label);

        JLabel CPU_label = new JLabel("CPU");
        CPU_label.setFont(new Font("Serif", Font.PLAIN, 14));
        CPU_label.setSize(100, 30);
        CPU_label.setLocation(20, 50);
        panel.add(CPU_label);

        JLabel Player_label = new JLabel("Player");
        Player_label.setFont(new Font("Serif", Font.PLAIN, 14));
        Player_label.setSize(100, 30);
        Player_label.setLocation(20, 400);
        panel.add(Player_label);

        JButton wallet_button = new JButton("$$ Wallet");
        wallet_button.setBackground(Color.GREEN);
        wallet_button.setBounds(1200, 430, 140, 30);
        panel.add(wallet_button);

        JButton new_button = new JButton("New Game");
        new_button.setBounds(1200, 20, 140, 30);
        panel.add(new_button);

        JButton back_button = new JButton("Back");
        back_button.setBounds(20, 20, 140, 30);
        panel.add(back_button);

        JButton exit_button = new JButton("Exit");
        exit_button.setBounds(1200, 530, 140, 30);
        panel.add(exit_button);

        frame.add(panel);
        frame.setVisible(true);

        BufferedImage blank_image = null;
        JLabel blank_card = new JLabel();

        try {
            String file = (getClass().getResource("").getPath().toString());
            blank_image = ImageIO.read(new File(file + "blank_card.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon imageicon = new ImageIcon(blank_image);
        blank_card = new JLabel(imageicon);
        blank_card.setSize(200, 200);
        blank_card.setLocation(0, 50);

        frame.setVisible(false);
        frame.dispose();
        panel.add(blank_card);
        frame.add(panel);
        frame.setVisible(true);

        hand = new Hand[2];
        hand[0] = new Hand(0);
        hand[1] = new Hand(1);
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 1:
                    hand[0].takeHand(deck.deal());
                    deck.DeckAfterDeal();
                    break;
                case 2:
                    hand[1].takeHand(deck.deal());
                    deck.DeckAfterDeal();
                    break;
                case 3:
                    hand[0].takeHand(deck.deal());
                    deck.DeckAfterDeal();
                    break;
                default:
                    hand[1].takeHand(deck.deal());
                    deck.DeckAfterDeal();
                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            frame.add(hand[i].displayHand(panel));
            frame.setVisible(true);
        }

        Boolean player_choice = false;
        Boolean comp_choice = false;
        while (player_choice == false) {
            int option = JOptionPane.showConfirmDialog(null, "HIT??", "Message", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                hand[1].takeHand(deck.deal());
                deck.DeckAfterDeal();
                frame.setVisible(false);
                frame.dispose();
                frame.add(hand[1].displayHand(panel));
                frame.setVisible(true);

            } else {
                player_choice = true;
            }
        }

        while (comp_choice == false) {
            if ((hand[0].total_value() <= 17) && (hand[0].total_value() <= hand[1].total_value())) {
                hand[0].takeHand(deck.deal());
                deck.DeckAfterDeal();
                frame.setVisible(false);
                frame.dispose();
                frame.add(hand[0].displayHand(panel));
                frame.setVisible(true);
            } else {
                comp_choice = true;
                panel.remove(blank_card);
                panel.revalidate();
                panel.repaint();
            }
        }

        if ((hand[0].total_value() > 21) && (hand[1].total_value() > 21)) {
            JOptionPane.showMessageDialog(null, "Its a tie", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if ((hand[0].total_value() <= 21) && (hand[1].total_value() <= 21)) {
            if (hand[0].total_value() > hand[1].total_value()) {
                lose();
                comp_money = comp_money + 2;
                player_money = player_money - 2;
            } else if ((hand[0].total_value() < hand[1].total_value()) || (hand[1].total_value() == 21)) {
                win();
                comp_money = comp_money - 2;
                player_money = player_money + 2;
            } else {
                JOptionPane.showMessageDialog(null, "Its a tie", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if ((hand[0].total_value() <= 21) && ((hand[1].total_value() > 21))) {
            lose();
            comp_money = comp_money + 2;
            player_money = player_money - 2;
        } else {
            win();
            comp_money = comp_money - 2;
            player_money = player_money + 2;
        }

        wallet_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You have $" + player_money, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        back_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Message", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    player_money = player_money - 2;
                    comp_money = comp_money + 2;
                    frame.dispose();
                    MainMenu();
                }
            }
        });

        new_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (player_money < 2) {
                    JOptionPane.showMessageDialog(null, "You do not have sufficient money", "Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    frame.dispose();
                    deck = new Deck();
                    deck.Shuffle();
                    Game();
                }
            }
        });

        exit_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you", "Message", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();

            }
        });
    }

    public void lose() {

        frame = new JFrame();
        frame.setTitle("You lose");
        frame.setLocation(560, 150);
        frame.setSize(250, 540);
        panel = new JPanel();
        panel.setLayout(null);

        BufferedImage lose_image = null;
        JLabel lose_label = new JLabel();

        try {
            String file = (getClass().getResource("").getPath().toString());
            lose_image = ImageIO.read(new File(file + "lose.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon lose_icon = new ImageIcon(lose_image);

        lose_label = new JLabel(lose_icon);
        lose_label.setSize(250, 600);
        lose_label.setLocation(0, 0);
        panel.add(lose_label);

        frame.add(panel);
        frame.setVisible(true);

        JButton lose_button = new JButton("You lose");
        lose_button.setBounds(80, 30, 100, 50);
        panel.add(lose_button);

        lose_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void win() {

        frame = new JFrame();
        frame.setTitle("You win");
        frame.setLocation(560, 150);
        frame.setSize(250, 540);
        panel = new JPanel();
        panel.setLayout(null);

        BufferedImage win_image = null;
        JLabel win_label = new JLabel();

        try {
            String file = (getClass().getResource("").getPath().toString());
            win_image = ImageIO.read(new File(file + "win.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon win_icon = new ImageIcon(win_image);

        win_label = new JLabel(win_icon);
        win_label.setSize(250, 600);
        win_label.setLocation(0, 0);
        panel.add(win_label);

        frame.add(panel);
        frame.setVisible(true);

        JButton win_button = new JButton("You win");
        win_button.setBounds(80, 30, 100, 50);
        panel.add(win_button);

        win_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
