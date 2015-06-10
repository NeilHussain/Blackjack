import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cards {

	String FrontImage, BackImage, Name;
	int Number, Value1, Suit;
	Boolean turnedOver, isFace, is11;
	int x, y, w, h;

	public Cards(String img1, String img2, int num, int suit, Boolean side,
			Boolean is11, int x, int y, int w, int h, String name) {

		this.FrontImage = img1;
		this.BackImage = img2;
		this.Number = num;
		this.Suit = suit;
		this.turnedOver = side;
		this.is11 = is11;
		// this.isFace = face;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Name = name;

	}

	public Boolean getIs11() {
		return is11;
	}

	public void setIs11(Boolean is11) {
		this.is11 = is11;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Rectangle getBounds() {
		return (new Rectangle(x, y, w, h));

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Image getFrontImage() {
		Image front = null;

		try {
			front = ImageIO.read(new File(FrontImage));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return front;

	}

	public void setFrontImage(String image) {
		FrontImage = image;
	}

	public Image getBackImage() {
		Image back = null;

		try {
			back = ImageIO.read(new File("CardBack_1.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return back;

	}

	public void setBackImage(String image) {
		BackImage = image;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getValue1() {

		if (Number <= 10) {
			return Number;

		} else if (Number > 10) {
			return 10;

		}
		return -1;
	}

	public void setValue1(int value1) {
		Value1 = value1;
	}

	public int getSuit() {
		return Suit;
	}

	public void setSuit(int suit) {
		Suit = suit;
	}

	public Boolean getTurnedOver() {
		return turnedOver;
	}

	public void setTurnedOver(Boolean turnedOver) {
		this.turnedOver = turnedOver;
	}

	public Boolean getIsFace() {
		if (Number == 1 || Number >= 11) {

			return true;

		} else {
			return false;
		}

	}

	public void setIsFace(Boolean isFace) {
		this.isFace = isFace;
	}

}
