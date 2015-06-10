import java.awt.Image;
import java.awt.Rectangle;

public class Buttons {

	int x, y, w, h;
	Boolean isSelected, isHovered;
	Image hovered, selected;

	public Buttons(int x, int y, int w, int h, Boolean isSelected,
			Boolean isHovered, Image hovered, Image selected) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.isSelected = isSelected;
		this.isHovered = isHovered;
		this.hovered = hovered;
		this.selected = selected;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
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

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Boolean getIsHovered() {
		return isHovered;
	}

	public void setIsHovered(Boolean isHovered) {
		this.isHovered = isHovered;
	}

	public Image getHovered() {
		return hovered;
	}

	public void setHovered(Image hovered) {
		this.hovered = hovered;
	}

	public Image getSelected() {
		return selected;
	}

	public void setSelected(Image selected) {
		this.selected = selected;
	}

	public Buttons() {
	}
}
