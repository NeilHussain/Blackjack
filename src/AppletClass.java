import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class AppletClass extends Applet implements KeyListener, Runnable,
		ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	/*
	 * TO DO: Fix Card Images
	 */

	/********* Applet Things ************/
	int width = 1280;
	int height = 720;
	int update = 10;

	/********* Game Things ************/
	int numberOfDecks = 1;
	int numberCardsPerDeck = 52;
	int numberOfSuits = 4;
	int counter = 1;
	int numberOfPlayers = 0;
	int Difficulty = 0;
	int Venue = 0;
	double titleY = 0;
	int numPlayers = 1;

	double pressScale = 0;
	int pot;
	int isTurn = 0;
	int cardsNotDealt = 52;

	int stage = 0;
	int chipRot;

	int playMenuX = 975;
	int playMenuY = 425;

	int bet;
	int minusYPos = 400;

	/********* Menu Things ************/

	int difficulty = 0;
	int human = -1;
	int cpu = -1;
	int venue = 0;

	int difMult = 75;
	int venMult = 75;
	int menuButLeng = 150;
	int bettingMenuLength = 400;
	int bettingMenuSpeed = 15;

	int bettingScreenLength = 0;

	/********* Arrays ************/

	public Cards[][] deck = new Cards[numberOfDecks + 1][numberCardsPerDeck + 1];
	Players[] players;
	Players dealer;
	String[] names = { "Donny", "Sam", "Jack", "Phil", "Sara", "Lauren",
			"Sammy", "Nick", "Ryan", "Mike", "Joe", "Heather", "Matt", "Dhara",
			"Autumn", "Ashley", "Andy", "Austin", "Rob", "Ron", "Paulina",
			"Michelle", "Chelsea", "Alex" };
	char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };

	int[] chipVal = { 1, 5, 10, 50, 100 };

	/********* Booleans ************/
	Boolean gamePlay = true;
	Boolean keyPressed = false;

	Boolean betting = true;
	Boolean dealing = false;

	Boolean bettingScreen = false;

	String initBg = "VenueBG_1.png";
	String[] buttNames = { "Deal.png", "Bet.png", "X.png", "Hit.png",
			"Stay.png", "Double.png" };
	
	Boolean allOut = false;

	Random rnd = new Random();

	BufferedImage backBuffer; // don't mess
	AffineTransform identity;// with this
	Graphics2D g2d; // stuff
	Thread me; // here

	String nameImgPrefix = "PlayingCard";

	/********* Images ************/
	Image Background;
	Image BigChip;
	Image TitleBG;
	Image Venue1;
	Image CardBack_1;
	// Image CardFront_1;
	Image[] Player;
	Image Table_1;
	Image pressSpace;
	Image sideBar;
	Image selected;
	Image[][] cardPics = new Image[5][14];

	Image[] chips = new Image[5];

	Image[] difficulties = new Image[6];
	Image[] Venues = new Image[6];
	Image[] humanButt = new Image[5];
	Image[] cpuButt = new Image[5];
	Image[] Start = new Image[2];
	Image menuBot;
	Image[] menuText = new Image[10];
	Image[] Dot = new Image[2];

	Image buttBG;
	Image[] playButtons = new Image[6];

	/*********** Buttons ****************/

	Buttons[] diff = new Buttons[3];
	Buttons[] ven = new Buttons[3];
	Buttons startButt;
	Buttons[] humanButts = new Buttons[5];
	Buttons[] CPUButts = new Buttons[5];
	Buttons[] playButts = new Buttons[6];
	Buttons[] betButts = new Buttons[6];
	Buttons placeBet;

	// Player players = new Players[6];

	public void init() {

		this.setLayout(null);
		setSize(width, height);
		setBackground(Color.BLACK); // change here the applet window color
		this.addKeyListener(this);
		this.addMouseListener(this);

		identity = new AffineTransform();
		backBuffer = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		g2d = backBuffer.createGraphics();

		makeObjects();
		initializeObjects();
		getImages();
		getSounds();
		g2d.setFont(new Font("Ariel", Font.BOLD, 18));

		/*
		 * for (int i = 1; i < 52; i++) {
		 * 
		 * System.out.println(deck[1][52].getName());
		 * 
		 * }
		 */

	}

	private void initializeObjects() {

		// String deck[][] = new String[0][6];
	}

	private void makeObjects() {
		// String[] cardNames = { "Ace", "Two", "Three", "Four", "Five", "Six",
		// "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

		for (int i = 1; i <= numberOfDecks; i++) {

			// int i = 1;
			for (int g = 1; g <= 4; g++) {

				for (int y = 1; y <= numberCardsPerDeck / numberOfSuits; y++) {

					// System.out.println(nameImgPrefix + "_" + g + "_" + y);

					deck[1][counter] = new Cards(
							"Card_" + g + "_" + y + ".png", "CardBack_1.png",
							y, g, false, false, 0, 0, 50, 100, "");

					try {
						cardPics[g][y] = ImageIO.read(new File("Card_" + g
								+ "_" + y + ".png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// System.out.println(deck[1][counter].getSuit() + " " + g);

					// System.out.println(cardNames[deck[i][counter].getSuit()]);

					// deck[i][counter].setName(cardNames[deck[i][counter].getSuit()-1]
					// + " of ");

					/*
					 * switch (g) { case (1):
					 * deck[i][counter].setName(deck[i][counter].getName()
					 * +"Spades"); break; case (2):
					 * deck[i][counter].setName(deck[i][counter].getName()
					 * +"Clubs"); break; case (3):
					 * deck[i][counter].setName(deck[i][counter].getName()
					 * +"Hearts"); break; case (4):
					 * deck[i][counter].setName(deck[i][counter].getName()
					 * +"Diamonds"); break; }
					 */

					// nameImgPrefix + "_" + g + "_"+ y

					counter++;

					// System.out.println(deck[0][counter - 1].getImage());

				}

			}
			counter = 1;
		}

		Player = new Image[6];

		for (int i = 0; i < diff.length; i++) {
			ven[i] = new Buttons(700 + i * 2 * venMult, 250, menuButLeng, 50,
					false, false, null, null);
			diff[i] = new Buttons(700 + i * 2 * difMult, 400, menuButLeng, 50,
					false, false, null, null);

		}

		for (int i = 0; i < 5; i++) {
			humanButts[i] = new Buttons(825 + (i * 25), 107, 12, 12, false,
					false, null, null);
			CPUButts[i] = new Buttons(825 + (i * 25), 155, 12, 12, false,
					false, null, null);

			// g2d.drawImage(Dot[0], 825 + (i *25),107,this);

			// g2d.drawImage(Dot[0], 825 + (i *25),155,this);

		}
		startButt = new Buttons(950, 600, 250, 100, false, false, null, null);

		playButts[0] = new Buttons(playMenuX + 25, playMenuY + 75, 150, 150,
				false, false, null, null);
		playButts[1] = new Buttons(playMenuX + 200, playMenuY + 35, 150, 150,
				false, false, null, null);
		playButts[2] = new Buttons(playMenuX + 200, playMenuY + 155, 150, 150,
				false, false, null, null);

		playButts[3] = new Buttons(playMenuX + 25, playMenuY + 75, 150, 150,
				false, false, null, null);
		playButts[4] = new Buttons(playMenuX + 200, playMenuY + 35, 150, 150,
				false, false, null, null);
		playButts[5] = new Buttons(playMenuX + 200, playMenuY + 155, 150, 150,
				false, false, null, null);

		for (int i = 0; i < betButts.length; i++) {
			betButts[i] = new Buttons((width / 2 - bettingMenuLength + 30) + i
					* 150, 400, 150, 50, false, false, null, null);

		}

		placeBet = new Buttons(width / 2 - bettingMenuLength, 500,
				bettingMenuLength * 2, 50, false, false, null, null);
	}

	private void getSounds() {
	}

	private void getImages() {
		try {
			Background = ImageIO.read(new File("MenuBG.png"));

			BigChip = ImageIO.read(new File("BigChip.png"));

			TitleBG = ImageIO.read(new File("TitleBJ.png"));

			Player[1] = ImageIO.read(new File("player_1.png"));

			Venue1 = ImageIO.read(new File("VenueBG_1.png"));

			Table_1 = ImageIO.read(new File("VenueTable_1.png"));

			pressSpace = ImageIO.read(new File("PressSpace.png"));

			sideBar = ImageIO.read(new File("SideBar.png"));

			selected = ImageIO.read(new File("Selected.png"));

			CardBack_1 = ImageIO.read(new File("CardBack_1.png"));

			for (int i = 1; i <= numberOfSuits; i++) {
				for (int g = 1; g <= 13; g++) {

					cardPics[i][g] = ImageIO.read(new File("Card_" + i + "_"
							+ g + ".png"));

				}

			}
			for (int i = 0; i < 2; i++) {
				Start[i] = ImageIO.read(new File("Start_" + i + ".png"));

			}

			menuBot = ImageIO.read(new File("Menu2BG.png"));

			menuText[0] = ImageIO.read(new File("MenuWords.png"));
			menuText[1] = ImageIO.read(new File("HumanCPU.png"));

			for (int i = 1; i <= Venues.length; i++) {
				Venues[i - 1] = ImageIO
						.read(new File("VenueWord_" + i + ".png"));
				difficulties[i - 1] = ImageIO.read(new File("diff_" + i
						+ ".png"));

			}
			Dot[0] = ImageIO.read(new File("Dot_0.png"));
			Dot[1] = ImageIO.read(new File("Dot_1.png"));

			buttBG = ImageIO.read(new File("ButtonBG.png"));

			for (int i = 0; i < playButtons.length; i++) {
				playButtons[i] = ImageIO.read(new File(buttNames[i]));
			}

			for (int i = 0; i < chips.length; i++) {
				chips[i] = ImageIO.read(new File("Chips_" + i + ".png"));

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void start() {

		me = new Thread(this);
		me.start();
	}

	public void stop() {
		me = null;
		//System.out.println("Hit");
	}

	public void update(Graphics g) {
		requestFocus();
		g2d.setTransform(identity);
		// g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (gamePlay == true) {
			gamePlayStuff();
		}

		paint(g);

	}

	private void gamePlayStuff() {
		g2d.setTransform(identity);

		if (stage == 0) {

			menuThings();
		} else if (stage == 1) {

			GameSetup();

		} else if (stage == 2) {

			gameGraphics();
			gameThings();
			
			gameCards();
			gameCoins();
			g2d.scale(2.00,2.00);
			gameUI();

		}

		// g2d.drawImage(Background, 0, 0, this);

		g2d.setTransform(identity);
	}

	private void gameCoins() {

		g2d.scale(.5, .5);

		for (int i = 0; i < pot / 10; i++) {

			g2d.drawImage(chips[4], 1400 + ((i * 1) / 2), 600 - (i * 2), this);

		}
		
		
	}

	private void gameCards() {
		// System.out.println("gameCards");

		g2d.scale(.25, .25);
		for (int i = 0; i < numPlayers; i++) {
			// System.out.println(i);
			if (players[i].getNumCards() > 0) {
				g2d.scale(4.00, 4.00);
				g2d.setColor(Color.white);
				g2d.drawString(players[0].name, 325, 240);
				g2d.drawString(players[i].getName(), 375 + (i * 125), 360);
				g2d.drawString(players[numPlayers - 1].name, 1025, 240);

				g2d.scale(.25, .25);
			}

			for (int g = 0; g < players[i].getNumCards(); g++) {

				if (g == 0) {
					if (i == 0) {
						g2d.drawImage(CardBack_1, 1300 + g * 50, 1000, this);
					}
					if (i > 0 && i < numPlayers - 1) {
						g2d.drawImage(CardBack_1, (i * 500) + (1500 + g * 50),
								1500, this);
					}

					g2d.drawImage(CardBack_1, 4100 + g * 50, 1000, this);

					// System.out.println(i + " " + g);
				}

				if (g > 0) {

					if (players[0].getNumCards() > 0) {
						if (i == 0) {
							g2d.drawImage(
									cardPics[players[0].getHand()[g].Suit][players[0]
											.getHand()[g].Number],
									1300 + g * 50, 1000, this);
						}

						if ((i > 0 && i < numPlayers - 1)) {

							// System.out.println("Drawing");
							g2d.drawImage(
									cardPics[players[i].getHand()[g].Suit][players[i]
											.getHand()[g].Number], (i * 500)
											+ (1500 + g * 50), 1500, this);
						}

						// System.out.println(i + " " + g);
						if (i == numPlayers - 1) {
							g2d.drawImage(cardPics[players[numPlayers - 1]
									.getHand()[g].Suit][players[numPlayers - 1]
									.getHand()[g].Number], 4100 + g * 50, 1000,
									this);
						}
					}
				}
			}
		}
		if (dealer.getNumCards() > 0) {
			g2d.drawImage(CardBack_1, 2700, 600, this);
			for (int i = 1; i < dealer.getNumCards(); i++) {

				g2d.drawImage(cardPics[dealer.getHand()[i].getSuit()][dealer
						.getHand()[i].getNumber()], 2700 + (i * 60), 600, this);
			}
		}
		// System.out.println(players[i].getHand()[0]);

		// g2d.dispose();

		g2d.scale(4.00, 4.00);
		// g2d.transform(identity);

		if (!players[isTurn].getIsCPU()) {

			for (int i = 0; i < players[isTurn].getNumCards(); i++) {
				g2d.drawImage(
						cardPics[players[isTurn].getHand()[i].Suit][players[isTurn]
								.getHand()[i].Number], 400 + (i * 50), 450,
						this);

			}
		}

	}

	private void GameSetup() {
		g2d.drawImage(Background, 0, 0, this);
		// g2d.set;
		// g2d.fillRect(0, 0, width, height);
		g2d.drawImage(menuBot, 0, 0, this);

		g2d.drawImage(Start[0], 950, 600, this);

		g2d.drawImage(menuText[0], 200, 100, this);
		g2d.drawImage(menuText[1], 700, 100, this);

		for (int i = 0; i < Venues.length / 2; i++) {
			g2d.drawImage(Venues[i], 700 + i * 2 * venMult, 250, this);

			g2d.drawImage(difficulties[i], 700 + i * 2 * difMult, 400, this);

		}
		for (int i = 0; i < 3; i++) {
			if (diff[i].getIsSelected() == true) {
				g2d.drawImage(difficulties[difficulty + 2], 700 + i * 2
						* difMult, 400, this);

			}
			if (ven[i].getIsSelected() == true) {
				g2d.drawImage(Venues[venue + 2], 700 + i * 2 * venMult, 250,
						this);

			}

		}

		for (int i = 0; i < 5; i++) {
			g2d.drawImage(Dot[0], 825 + (i * 25), 107, this);

			g2d.drawImage(Dot[0], 825 + (i * 25), 155, this);

		}

		// if (human > 0) {
		for (int i = 0; i <= human; i++) {
			g2d.drawImage(Dot[1], 825 + (i * 25), 107, this);

			// }
		}
		// if (cpu > 0) {
		for (int i = 0; i <= cpu; i++) {

			g2d.drawImage(Dot[1], 825 + (i * 25), 155, this);

			// }
		}

		menuButtons();
	}

	private void menuButtons() {
		for (int i = 0; i < 4; i++) {
			// if(ven[i].getBounds().intersects(ME.))

		}

	}

	private void gameUI() {
		g2d.drawImage(sideBar, 0, 0, this);

		g2d.setColor(Color.BLACK);
		for (int i = 0; i < numPlayers; i++) {

			if (players[i].isPlaying == true) {

				g2d.drawImage(Player[1], players[i].getX(), players[i].getY(),
						this);

				if (players[i].getIsTurn() == true) {
					g2d.drawImage(selected, players[i].getX() - 5,
							players[i].getY() - 5, this);

					players[i].setX((int) (28 + 5 * (Math.sin((titleY) / 20))));
				}
				g2d.setFont(new Font("Ariel", Font.BOLD, 18));
				g2d.drawString(players[i].getName(), players[i].getX(),
						players[i].getY() + 7);
				g2d.setFont(new Font("Ariel", Font.BOLD, 14));
				g2d.drawString("$" + players[i].getCoins() + "",
						players[i].getX() + 25, players[i].getY() + 95);

			}
		}

		g2d.drawImage(buttBG, playMenuX, playMenuY, this);

		g2d.scale(.5, .5);
		g2d.drawImage(TitleBG, 400 + (int) (5 * (Math.sin((titleY) / 25))),
				(int) (5 * (Math.sin((titleY++) / 20))), this);

		g2d.setTransform(identity);

		if (betting == true) {
			g2d.drawImage(playButtons[0], playMenuX + 25, playMenuY + 75, this);
			g2d.drawImage(playButtons[1], playMenuX + 200, playMenuY + 35, this);
			g2d.drawImage(playButtons[2], playMenuX + 200, playMenuY + 155,
					this);

		} else if (betting == false) {
			g2d.drawImage(playButtons[3], playMenuX + 25, playMenuY + 75, this);
			g2d.drawImage(playButtons[4], playMenuX + 200, playMenuY + 35, this);
			g2d.drawImage(playButtons[5], playMenuX + 200, playMenuY + 155,
					this);

		}

		if (bettingScreen == true) {

			g2d.setColor(Color.lightGray);
			if (bettingScreenLength < bettingMenuLength) {
				g2d.fillRect(width / 2 - bettingScreenLength, 150,
						bettingScreenLength * 2, 400);
				bettingScreenLength += bettingMenuSpeed;

				g2d.setColor(Color.gray);
				g2d.fillRect(width / 2 - bettingScreenLength, 500,
						bettingScreenLength * 2, 50);
				g2d.setColor(Color.lightGray);

			} else {
				g2d.fillRect(width / 2 - bettingMenuLength, 150,
						bettingMenuLength * 2, 400);

				g2d.setColor(Color.gray);
				g2d.fillRect(width / 2 - bettingMenuLength, 500,
						bettingMenuLength * 2, 50);
				g2d.setColor(Color.black);

				g2d.setFont(new Font("Ariel", Font.BOLD, 24));

				g2d.drawString("Place your bet", (width / 2) - 100, 535);

				g2d.setFont(new Font("Ariel", Font.BOLD, 150));
				g2d.drawString("$" + bet + "" + ".00", (width / 2) - 350, 300);

				g2d.setFont(new Font("Ariel", Font.BOLD, 48));
				for (int i = 0; i < chips.length; i++) {
					g2d.drawImage(chips[i], betButts[i].getX(),
							betButts[i].getY(), this);

					g2d.drawString(chipVal[i] + "", betButts[i].getX() + 25,
							betButts[i].getY() + 35);

				}

			}

			g2d.setColor(Color.BLACK);

		}

	}

	private void gameGraphics() {
		// System.out.println("fasdfasdfasdf");
		g2d.drawImage(Venue1, 80, 0, this);
		g2d.drawImage(Table_1, 275, 100, this);


		g2d.setTransform(identity);

	}

	private void gameThings() {

	}

	private void menuThings() {
		g2d.drawImage(Background, 0, 0, this);

		// g2d.scale(.5,.5);
		g2d.drawImage(pressSpace, 300, 500, this);
		// g2d.setTransform(identity);
		g2d.drawImage(TitleBG, 100 + (int) (5 * (Math.sin((titleY) / 25))),
				(int) (50 + 5 * (Math.sin((titleY++) / 20))), this);

		if (titleY == 361) {
			titleY = 0;
		}

		g2d.scale(1.00, .3);
		g2d.rotate(Math.toRadians(chipRot), 600 + 275, 1015 + 275);

		g2d.drawImage(BigChip, 600, 1015, this);
		// g2d.rotate(0);

		g2d.rotate(Math.toRadians(chipRot++ / 2), 600 + 275, 1000 + 275);

		g2d.drawImage(BigChip, 600, 1000, this);

		/*
		 * g2d.rotate(Math.toRadians(chipRot/2), 450+275,505+275);
		 * g2d.drawImage(BigChip, 450,505,this);
		 * 
		 * g2d.rotate(Math.toRadians(chipRot/2), 450+275,510+275);
		 * g2d.drawImage(BigChip, 450,510,this);
		 */
		g2d.scale(1.00, 1.00);

		g2d.rotate(0);
		// g2d.setTransform(identity);

	}

	public void run() {

		while (true) {

			try {
				Thread.sleep(update);
				allUpdates();

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			repaint();
		}
	}

	private void allUpdates() {
		// thread crap
	}

	public void paint(Graphics g) {

		g.drawImage(backBuffer, 0, 0, this);
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	public void keyPressed(KeyEvent ke) {
		keyPressed = true;
		int keyCode;
		keyCode = ke.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_V:

			if (stage == 2) {

				if (betting == true) {
					betting = false;
					break;
				}
				betting = true;
			}
			// System.out.println(stage);
			break;
		case KeyEvent.VK_S:
			suffle();

			for (int i = 1; i <= 52; i++) {

				// System.out.println(i + " " + deck[1][i].getSuit() + " "
				// + deck[1][i].getNumber());

			}
			break;

		case KeyEvent.VK_SPACE:
			if (stage == 0) {
				// .println("aa");
				//
				stage = 1;
			}
			break;

		case KeyEvent.VK_LEFT:

			break;
		case KeyEvent.VK_RIGHT:

			break;
		case KeyEvent.VK_UP:
			numPlayers++;
			if (numPlayers > 6) {

				numPlayers = 1;
			}

			break;
		case KeyEvent.VK_DOWN:
			players[isTurn].setIsTurn(false);

			if (isTurn == numPlayers - 1) {

				isTurn = 0;

			} else {
				isTurn++;
			}

			players[isTurn].setIsTurn(true);

			break;
		}
	}

	public void suffle() {

		deck = DeckOps.shuffle(52, deck, cardsNotDealt);

		/*
		 * Cards temp = null;
		 * 
		 * for (int i = 1; i <= numberCardsPerDeck; i++) {
		 * 
		 * int ranSpot = rnd.nextInt(51) + 1;
		 * 
		 * // temp = deck[1][ranSpot];
		 * 
		 * while (deck[1][ranSpot] == deck[1][i]) { ranSpot = rnd.nextInt(51) +
		 * 1;
		 * 
		 * } // System.out.println(ranSpot); temp = deck[1][ranSpot];
		 * 
		 * // temp = deck[1][i];
		 * 
		 * deck[1][ranSpot] = deck[1][i];
		 * 
		 * deck[1][i] = temp;
		 * 
		 * System.out.println(i + " " + deck[1][i]);
		 * 
		 * }
		 */

	}

	public void keyReleased(KeyEvent ke) {
		keyPressed = false;
	}

	public void keyTyped(KeyEvent ke) {
	}

	public void mouseClicked(MouseEvent me) {

	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {

	}

	public void mousePressed(MouseEvent me) {
		// System.out.println("Pressed");

		switch (stage) {
		case 1:
			menuThingsMouse(me);
			break;

		case 2:
			if (bettingScreen == true) {
				bettingButtons(me);
			}

			if (bettingScreen == false) {
				gameButtonsMouse(me);
			}
			break;

		}
	}

	private void bettingButtons(MouseEvent me) {

		for (int i = 0; i < betButts.length; i++) {

			if (betButts[i].getBounds().intersects(
					new Rectangle(me.getX(), me.getY(), 1, 1))) {

				if (players[isTurn].getCoins() > bet + chipVal[i]) {
					bet += chipVal[i];

				}
			}
		}

		if (placeBet.getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))) {
			if (bet > 0) {

				/*
				 * players[numPlayers - 1].setBet(bet); players[numPlayers -
				 * 1].setCoins(players[numPlayers - 1] .getCoins() - bet);
				 */

				pot = bet;
				players[isTurn].setBet(bet);
				players[isTurn].setCoins(players[isTurn].getCoins() - bet);
				bet = 0;

				NextPlayer(0);

				System.out.println(isTurn);
				bettingScreen = false;
				bettingScreenLength = 0;
				// bet = 0;
				// betting = false;

			}

		}
	}

	private void gameButtonsMouse(MouseEvent me) {

		if (playButts[3].getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))
				&& betting == false) {
			if (players[isTurn].getBust() == true) {
				if(allOut == false){
				NextPlayer(400);
				}
			} else {
				//System.out.println("Hitting Meth " + (isTurn));

				switch (players[isTurn].getNumCards()) {
				case 2:
					// System.out.println("Hitting");
					players[isTurn].setHand(new Cards[] {
							players[isTurn].getHand()[0],
							players[isTurn].getHand()[1],
							deck[1][cardsNotDealt], null, null });
					players[isTurn].setNumCards(3);
					cardsNotDealt--;
					checkCardsValue();
					if(allOut == false){
					NextPlayer(400);
					}
					break;
				case 3:
					players[isTurn].setHand(new Cards[] {
							players[isTurn].getHand()[0],
							players[isTurn].getHand()[1],
							players[isTurn].getHand()[2],
							deck[1][cardsNotDealt], null });
					players[isTurn].setNumCards(4);
					cardsNotDealt--;
					checkCardsValue();
					if(allOut == false){
					NextPlayer(400);
					}
					break;
				case 4:
					players[isTurn].setHand(new Cards[] {
							players[isTurn].getHand()[0],
							players[isTurn].getHand()[1],
							players[isTurn].getHand()[2],
							players[isTurn].getHand()[3],
							deck[1][cardsNotDealt] });
					players[isTurn].setNumCards(5);
					cardsNotDealt--;
					checkCardsValue();
					if(allOut == false){
					NextPlayer(400);
					}
					break;
				case 5:
					players[isTurn].setHand(new Cards[] {
							players[isTurn].getHand()[0],
							players[isTurn].getHand()[1],
							players[isTurn].getHand()[2],
							players[isTurn].getHand()[3],
							players[isTurn].getHand()[4],
							deck[1][cardsNotDealt] });
					players[isTurn].setNumCards(6);
					cardsNotDealt--;
					checkCardsValue();
					if(allOut == false){
					NextPlayer(400);
					}
					break;
				case 6:
					players[isTurn].setHand(new Cards[] {
							players[isTurn].getHand()[0],
							players[isTurn].getHand()[1],
							players[isTurn].getHand()[2],
							players[isTurn].getHand()[3],
							players[isTurn].getHand()[4],
							players[isTurn].getHand()[5],
							deck[1][cardsNotDealt] });
					players[isTurn].setNumCards(7);
					cardsNotDealt--;
					checkCardsValue();
					if(allOut == false){
					NextPlayer(400);
					}
					break;

				}
			}
		} else if (playButts[4].getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))
				&& betting == false) {
			
			players[isTurn].setStay(true);
			NextPlayer(0);

		}

		//System.out.println(bettingScreen);

		if (playButts[0].getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))) {

			if (dealing == true && players[numPlayers - 1].getBet() > 0) {
				deck = DeckOps.shuffle(52, deck, 52);
				// dealing = true;

				for (int i = isTurn; i < numPlayers; i++) {

					// System.out.println(bet);

					// bet = 0;

					// This code work for no human choices

					players[i].setHand(new Cards[] {
							deck[1][cardsNotDealt - (i + i)],
							deck[1][cardsNotDealt - ((i + 1) + i)], null, null,
							null });
					players[i].setNumCards(2);

					cardsNotDealt -= 2;

					/*
					 * if (!players[i].getIsCPU()) {
					 * 
					 * if (players[i].getBet() == 0) {
					 * System.out.println(players[i].getBet());
					 * 
					 * // betting =true; break; }
					 * System.out.println("Got HEre"); players[i].setHand(new
					 * Cards[] { deck[1][cardsNotDealt - (i + i)],
					 * deck[1][cardsNotDealt - ((i + 1) + i)], null, null, null
					 * }); players[i].setNumCards(2);
					 * 
					 * cardsNotDealt -= 2;
					 * System.out.println(players[isTurn].getHand()[0]
					 * .getSuit()); isTurn++; if (isTurn == numPlayers) { isTurn
					 * = 0; } // continue;
					 * 
					 * } else { players[i].setHand(new Cards[] {
					 * deck[1][cardsNotDealt - (i + i)], deck[1][cardsNotDealt -
					 * ((i + 1) + i)], null, null, null });
					 * players[i].setNumCards(2); cardsNotDealt -= 2; isTurn++;
					 * if (isTurn == numPlayers) { isTurn = 0; }
					 */
					// continue;
					// System.out.println(isTurn); }

					// betting = false;

				}

				// System.out.println("Setting dealer cards");
				dealer.setHand(new Cards[] { deck[1][cardsNotDealt],
						deck[1][cardsNotDealt - 1], null, null, null });
				cardsNotDealt -= 2;
				dealer.setNumCards(2);

				dealing = false;
				betting = false;
			}
			// System.out.println(players[numPlayers-1].getHand()[0] +
			// " " +
			// players[numPlayers-1].getHand()[1] + " "
			// +players[numPlayers-1].getHand()[2]);

		} else if (playButts[1].getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))
				&& betting == true && players[isTurn].getBet() == 0) {

			bettingScreen = true;

		} else if (playButts[2].getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))
				&& betting == true) {

			bettingScreen = false;
			bettingScreenLength = 0;

		}

	}

	private void checkCardsValue() {
		int cardVal = 0;

		for (int i = 0; i < players[isTurn].getNumCards(); i++) {
			cardVal += players[isTurn].getHand()[i].getValue1();

		}

		if (cardVal > 21) {

			System.out.println("BUSTED");
			players[isTurn].setBust(true);

		}

	}

	private void menuThingsMouse(MouseEvent me) {
		for (int i = 0; i < 3; i++) {

			if (ven[i].getBounds().intersects(
					new Rectangle(me.getX(), me.getY(), 1, 1))) {

				for (int y = 0; y < ven.length; y++) {
					ven[y].setIsSelected(false);
				}

				venue = i + 1;
				// System.out.println(venue);
				ven[i].setIsSelected(true);
			}
			if (diff[i].getBounds().intersects(
					new Rectangle(me.getX(), me.getY(), 1, 1))) {

				for (int y = 0; y < diff.length; y++) {
					diff[y].setIsSelected(false);

				}

				difficulty = i + 1;

				diff[i].setIsSelected(true);

				// System.out.println(difficulty);
			}
		}

		if (startButt.getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))) {

			startButt.setIsSelected(true);
		}

		for (int i = 0; i < 5; i++) {
			if (humanButts[i].getBounds().intersects(
					new Rectangle(me.getX(), me.getY(), 1, 1))) {

				human = i;

				if ((cpu + 1 + human + 1) >= 5) {
					cpu = 5 - (human + 2);
				}

			}
			if (CPUButts[i].getBounds().intersects(
					new Rectangle(me.getX(), me.getY(), 1, 1))) {

				cpu = i;

				if ((cpu + 1 + human + 1) >= 5) {
					human = 5 - (cpu + 2);

				}

			}

		}
		if (startButt.getBounds().intersects(
				new Rectangle(me.getX(), me.getY(), 1, 1))) {

			StartGame();
		}
	}

	private void StartGame() {
		/********** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ************/
		if (difficulty != 0 && venue != 0) {
			cpu++;
			human++;

			numPlayers = cpu + human + 1;

			players = new Players[numPlayers];
			dealer = new Players("Dealer", "Dealer.png", new Cards[10],
					difficulty, 64000, 0, 0, false, false, false, true, false,
					700, 200, 150, 150, 0, true);

			players[0] = new Players("Neil", "Player_1.png", new Cards[10],
					difficulty, 1000, 0, 0, false, false, false, true, false,
					25, (((height / numPlayers)) * 0) + 15, 150, 150, 0, false);

			for (int i = 1; i < numPlayers; i++) {
				// System.out.println(human+1+cpu);
				// System.out.println(i);

				if (i <= human) {
					players[i] = new Players(
							names[rnd.nextInt(names.length - 1)]
									+ " "
									+ alphabet[rnd.nextInt(alphabet.length - 1)]
									+ ".", "Player_1.png", new Cards[5],
							difficulty, 1000, 0, 0, false, false, false, true,
							false, 25, (((height / numPlayers)) * i) + 15, 150,
							150, 0, false);

				} else {
					// System.out.println(i);
					players[i] = new Players(
							names[rnd.nextInt(names.length - 1)]
									+ " "
									+ alphabet[rnd.nextInt(alphabet.length - 1)]
									+ ".", "Player_1.png", new Cards[5],
							Difficulty, 1000, 0, 0, false, false, false, true,
							false, 25, (((height / numPlayers)) * i) + 15, 150,
							150, 0, true);

				}
			}

			players[0].setIsTurn(true);
			stage = 2;
		}
	}

	public void mouseReleased(MouseEvent me) {

	}

	public void newRound() {

	}

	public void checkWins() {
		System.out.println("Lets see wins");
		me = null;

	}

	public void NextPlayer(int wait) {
		int time = 0;
		
		while (time < wait) {
			time++;
			// System.out.println(time);
		}

		if (allOut == false) {
			// System.out.println("Out of the loop");
			players[isTurn].setIsTurn(false);

			if (isTurn == numPlayers - 1) {

				if (betting == true && isTurn > 0) {
					System.out.println("dealing = false");
					dealing = true;
				}
				isTurn = 0;

			} else {
				isTurn++;
			}

			players[isTurn].setIsTurn(true);
			time = 0;
			allOut = true;

			for (int i = 0; i < players.length; i++) {
				if (players[i].getBust() == true
						|| players[i].getStay() == true) {

				} else {
					allOut = false;

				}
			}

			if (allOut == true) {

				checkWins();

			}
			if (players[isTurn].getBust() == true && allOut == false) {
				NextPlayer(0);

			}
		}
	}
}