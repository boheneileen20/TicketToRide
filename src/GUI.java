import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Class to create and access panels needed for interface
 */
public class GUI extends JPanel implements MouseListener {
    /* Create and set up the window.*/
    private static JFrame frame =  new  JFrame("Ticket To Ride NY");
    //board panel
    private static JPanel gameBoardPanel;

    /* width and height of display*/
    private int width;
    private int height;
    /* Images of the board,box cover,and back of the transport card*/
    private Image coverImage;
    private Image destinationCardBack;
    /* Toolkit used for grabbing Images*/
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();;
    private static TTRDriver driver;
    //private static Image boardImage;

    //center board panel
    static JPanel game;
    //left side panel
    static JPanel left;
    //top panel
    static JPanel top;
    //bottom panel
    static JPanel bottom;
    //right panel
    static JPanel right;

    public GUI(){

        //set up players first
        int numPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
        driver = new TTRDriver(numPlayers);


        //call makePlayer for each player
        for(int i = 1; i<=numPlayers; i++){
            String name = JOptionPane.showInputDialog("Enter player " + i + "'s name.");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter player " + i + "'s age."));
            driver.makePlayer(name, age);
        }

        //deal initial trans cards
        driver.dealInitialTransCards();


        /* sets size of window*/
        frame.setPreferredSize( new  Dimension(1000, 800));

        frame.setBackground(Color.WHITE);
        /* adds functionality of mouse*/
        addMouseListener(this);

        //get board panel
        gameBoardPanel = boardPanel();

        //

    }
    public void paintComponent(Graphics g) {
       // super.paintComponent(g);
        //center board panel
        game = boardPanel();
        //left side panel
        left = leftPanel();
        //top panel
        top = topPanel();
        //bottom panel
        bottom = bottomPanel();
        //right panel
        right = rightPanel();
        super.paintComponent(g);

    }

    /**
     * Creates the window and GUI with a label
     */
    static public void createAndShowGUI()
    {
        GUI thegui = new GUI();
        JFrame frame = new JFrame("GUITest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //background panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(1000, 800));
        panel.setLayout(new BorderLayout());

        //center board panel
        game = boardPanel();
        //left side panel
         left = leftPanel();
        //top panel
         top = topPanel();
        //bottom panel
         bottom = bottomPanel();
        //right panel
         right = rightPanel();

        panel.add(game, BorderLayout.CENTER);
        panel.add(right, BorderLayout.EAST);
        panel.add(bottom, BorderLayout.SOUTH);
        panel.add(top, BorderLayout.NORTH);
        panel.add(left, BorderLayout.WEST);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        //deal dest cards
        for(Player p: driver.getPlayers()){
            ArrayList<DestinationCard> choices = driver.drawTwoDest();
            String playerChoice = JOptionPane.showInputDialog(p.getName() + ", you have drawn these cards: "+ choices.get(0).toString() + " and " +
                    choices.get(1) + " \n" +
                    "Enter \"both\" to take both, \"1\" for the first card, and \"2\" for the second");
            driver.dealInitialDestCardsGUI(playerChoice, choices, p);
        }

        //loop through turns and remake panes each time
        for(int i = 0; i<10; i++){
            Player p = driver.getPlayers().get(driver.getPlayerTurn());
            JOptionPane.showMessageDialog(frame, p.getName() + "'s turn");

            //center board panel
            game = boardPanel();
            //left side panel
            left = leftPanel();
            //top panel
            top = topPanel();
            //bottom panel
            bottom = bottomPanel();
            //right panel
            right = rightPanel();

            panel.add(game, BorderLayout.CENTER);
            panel.add(right, BorderLayout.EAST);
            panel.add(bottom, BorderLayout.SOUTH);
            panel.add(top, BorderLayout.NORTH);
            panel.add(left, BorderLayout.WEST);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);

            //move to next players turn
            driver.nextPlayersTurn();

        }



    }



    //creates right panel, hold face up transport cards and blind draw pile.
    public static JPanel rightPanel(){
        JPanel p = new JPanel();
        p.setSize(new Dimension(100, 800));
        p.setBackground(Color.BLUE);
        p.setLayout(new GridLayout(6,1));

        Image tCard = driver.getDisplayTransCards().get(0).getPicture();
        tCard = tCard.getScaledInstance(200,125, 0);
        JLabel picLabel = new JLabel(new ImageIcon(tCard));

        Image tCard2= driver.getDisplayTransCards().get(1).getPicture();
        tCard2 = tCard2.getScaledInstance(200,125, 0);
        JLabel picLabel2 = new JLabel(new ImageIcon(tCard2));

        Image tCard3= driver.getDisplayTransCards().get(2).getPicture();
        tCard3 = tCard3.getScaledInstance(200,125, 0);
        JLabel picLabel3 = new JLabel(new ImageIcon(tCard3));

        Image tCard4= driver.getDisplayTransCards().get(3).getPicture();
        tCard4 = tCard4.getScaledInstance(200,125, 0);
        JLabel picLabel4 = new JLabel(new ImageIcon(tCard4));

        Image tCard5= driver.getDisplayTransCards().get(4).getPicture();
        tCard5 = tCard5.getScaledInstance(200,125, 0);
        JLabel picLabel5 = new JLabel(new ImageIcon(tCard5));


        Image blindPile = toolkit.getImage("C:/Users/patri/Documents/eileen/ttrrestored/src/fwdpieces/transportation_back.jpg");
        blindPile = blindPile.getScaledInstance(200,125, 0);
        JLabel blindPileLabel = new JLabel(new ImageIcon(blindPile));

        p.add(picLabel);
        p.add(picLabel2);
        p.add(picLabel3);
        p.add(picLabel4);
        p.add(picLabel5);
        p.add(blindPileLabel);

        return p;
    }
    //creates bottom panel
    public static JPanel bottomPanel(){
        JPanel p = new JPanel();
        p.setSize(new Dimension(1000, 100));
        p.setBackground(Color.RED);
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel("This will give show score components (taxis, routes claimed)");
        jLabel.setFont(new Font("Calibri",1, 15));
        panel.add(jLabel);
        panel.setBorder(new LineBorder(Color.BLACK));

        p.add(panel);
        return p;
    }

    //creates top panel
    public static JPanel topPanel(){
        JPanel p = new JPanel();
        p.setSize(new Dimension(1000, 100));
        p.setBackground(Color.RED);
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel("This will give some instruction on who's turn it is");
        jLabel.setFont(new Font("Calibri",1, 15));
        panel.add(jLabel);
        panel.setBorder(new LineBorder(Color.BLACK));

        p.add(panel);
        return p;
    }
    /*creates left side panel for player info,
            1)num taxis
            2)transportation hand
            3)destination hand
        also pile of destination cards
     */
    public static JPanel leftPanel(){
        JPanel p = new JPanel();
        p.setSize(new Dimension(200, 800));
        p.setBackground(Color.BLUE);
        p.setLayout(new GridLayout(5,1));

        JPanel transCardHandPanel = new JPanel();
        transCardHandPanel.setSize(new Dimension(200, 500));
        transCardHandPanel.setBackground(Color.WHITE);
        transCardHandPanel.setLayout(new GridLayout(8,2));

        //label for name
        JLabel nameLabel = new JLabel(driver.getPlayers().get(driver.getPlayerTurn()).getName() + "'s");
        nameLabel.setFont(new Font("Calibri",1, 15));

        Image blue = driver.getUprightTrans().get(0).getPicture();
        blue = blue.getScaledInstance(100,100, 0);
        JLabel bluePile = new JLabel(new ImageIcon(blue));

        //blank space
        JLabel blankLabel = new JLabel("cards");
        blankLabel.setFont(new Font("Calibri",1, 15));

        //label for num blue cards
        JLabel blueLabel = new JLabel("Blues: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("blue"));
        blueLabel.setFont(new Font("Calibri",1, 15));


        Image gray = driver.getUprightTrans().get(1).getPicture();
        gray = gray.getScaledInstance(100,100, 0);
        JLabel grayPile = new JLabel(new ImageIcon(gray));

        //label for num gray cards
        JLabel grayLabel = new JLabel("Grays: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("gray"));
        grayLabel.setFont(new Font("Calibri",1, 15));

        Image green = driver.getUprightTrans().get(2).getPicture();
        green = green.getScaledInstance(100,100, 0);
        JLabel greenPile = new JLabel(new ImageIcon(green));

        //label for num green cards
        JLabel greenLabel = new JLabel("Greens: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("green"));
        greenLabel.setFont(new Font("Calibri",1, 15));

        Image orange = driver.getUprightTrans().get(3).getPicture();
        orange = orange.getScaledInstance(100,100, 0);
        JLabel orangePile = new JLabel(new ImageIcon(orange));

        //label for num orange cards
        JLabel orangeLabel = new JLabel("Oranges: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("orange"));
        orangeLabel.setFont(new Font("Calibri",1, 15));

        Image pink = driver.getUprightTrans().get(4).getPicture();
        pink = pink.getScaledInstance(100,100, 0);
        JLabel pinkPile = new JLabel(new ImageIcon(pink));

        //label for num pink cards
        JLabel pinkLabel = new JLabel("Pinks: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("pink"));
        pinkLabel.setFont(new Font("Calibri",1, 15));

        Image red = driver.getUprightTrans().get(5).getPicture();
        red = red.getScaledInstance(100,100, 0);
        JLabel redPile = new JLabel(new ImageIcon(red));

        //label for num red cards
        JLabel redLabel = new JLabel("Reds: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("red"));
        redLabel.setFont(new Font("Calibri",1, 15));

        Image rainbow = driver.getUprightTrans().get(6).getPicture();
        rainbow = rainbow.getScaledInstance(100,100, 0);
        JLabel rainbowPile = new JLabel(new ImageIcon(rainbow));

        //label for num rainbow cards
        JLabel rainbowLabel = new JLabel("Rainbows: " + driver.getPlayers().get(driver.getPlayerTurn()).getNumColor("Rainbow"));
        rainbowLabel.setFont(new Font("Calibri",1, 15));

        Image destDraw = toolkit.getImage("C:/Users/patri/Documents/eileen/ttrrestored/src/fwdboardandtransport/destination_card_back.jpg");
        destDraw = destDraw.getScaledInstance(200,100, 0);
        JLabel destDrawPile = new JLabel(new ImageIcon(destDraw));

        //score panel
        JPanel scorePanel = new JPanel();
        scorePanel.setSize(new Dimension(200, 100));
        scorePanel.setBackground(Color.WHITE);
        scorePanel.setLayout(new GridLayout(3,1));

        JLabel taxiLabel = new JLabel("Taxis: " + driver.getPlayers().get(driver.getPlayerTurn()).getTaxis());
        taxiLabel.setFont(new Font("Calibri",1, 15));
        scorePanel.add(taxiLabel);
        scorePanel.setBorder(new LineBorder(Color.BLACK));

        JButton seeDestButton = new JButton("See destination cards");
        scorePanel.add(seeDestButton);

        seeDestButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String message = "You have these cards:";
                for(DestinationCard d: driver.getPlayers().get(driver.getPlayerTurn()).getDestHand()){
                    message = message + " " + d.toString();
                }
                JOptionPane.showMessageDialog(frame, message);
            }
        });



        JLabel touristLabel = new JLabel("Tourist Attractions: ");
        touristLabel.setFont(new Font("Calibri",1, 15));
        scorePanel.add(touristLabel);
        scorePanel.setBorder(new LineBorder(Color.BLACK));


        transCardHandPanel.add(nameLabel);
        transCardHandPanel.add(bluePile);
        transCardHandPanel.add(blankLabel);
        transCardHandPanel.add(blueLabel);
        transCardHandPanel.add(grayPile);
        transCardHandPanel.add(greenPile);
        transCardHandPanel.add(grayLabel);
        transCardHandPanel.add(greenLabel);
        transCardHandPanel.add(orangePile);
        transCardHandPanel.add(pinkPile);
        transCardHandPanel.add(orangeLabel);
        transCardHandPanel.add(pinkLabel);

        transCardHandPanel.add(redPile);
        transCardHandPanel.add(rainbowPile);
        transCardHandPanel.add(redLabel);
        transCardHandPanel.add(rainbowLabel);
        p.add(transCardHandPanel);
        p.add(scorePanel);
        p.add(destDrawPile);


        return p;
    }



    /*creates panel in center for board*/
    public static JPanel boardPanel(){

        JPanel p = new JPanel();
        p.setSize(new Dimension(600,600));
        p.setBackground(Color.GRAY);
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see

        //add the board image to the panel
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image boardImage = toolkit.getImage("C:/Users/patri/Documents/eileen/ttrrestored/src/fwdboardandtransport/game_board.jpg");

        boardImage = boardImage.getScaledInstance(650,700, 0);
        JLabel picLabel = new JLabel(new ImageIcon(boardImage));
        panel.add(picLabel);
        panel.repaint();

        p.add(panel);
        return p;
    }
    /**
     * This method makes sure the mouse does nothing when the mouse enters the panel.
     * @param e   the event the mouse triggers
     */
    public void mouseEntered(MouseEvent e)
    {
    }

    /**
     * This method makes sure the mouse does nothing when the mouse exits the panel.
     * @param e   the event the mouse triggers
     */
    public void mouseExited(MouseEvent e)
    {
    }

    /**
     * This method makes sure the mouse does nothing when the mouse is pressed down.
     * @param e   the event the mouse triggers
     */
    public void mousePressed(MouseEvent e)
    {
    }

    /**
     * This method makes sure the mouse does nothing when the mouse button is released.
     * @param e   the event the mouse triggers
     */
    public void mouseReleased(MouseEvent e)
    {
    }

    /**
     * This method makes sure the mouse does nothing when the mouse is moved.
     * @param e   the event the mouse triggers
     */
    public void mouseWheelMoved(MouseWheelEvent e)
    {
    }

    /**
     * This method handles mouse clicking events. This includes clicking "play game" to start the game, and the functionality to interact with the board.
     * @param e   the event the mouse triggers
     */
    public void mouseClicked(MouseEvent e)
    {

    }

    /**
     * Main method to run program
     * @param args command line arguments.
     */
    static public void main(String[] args)
    {
        /* Schedule a job for the event-dispatching thread: creating and showing this application's GUI. Unsupported feature in Stride : anonymous class*/
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
