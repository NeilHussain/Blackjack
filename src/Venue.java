public class Venue {
	String name, tablePic, floorPic, cardBackPic, previewPic;


	int number;

	public Venue(String name, String tablePic, String floorPic, String preview,
			String cardBackPic, int number) {
		super();
		this.name = name;
		this.tablePic = tablePic;
		this.floorPic = floorPic;
		this.cardBackPic = cardBackPic;
		this.number = number;
		this.previewPic = preview;
	}


	public String getPreviewPic() {
		return previewPic;
	}

	public void setPreviewPic(String previewPic) {
		this.previewPic = previewPic;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTablePic() {
		return tablePic;
	}

	public void setTablePic(String tablePic) {
		this.tablePic = tablePic;
	}

	public String getFloorPic() {
		return floorPic;
	}

	public void setFloorPic(String floorPic) {
		this.floorPic = floorPic;
	}

	public String getCardBackPic() {
		return cardBackPic;
	}

	public void setCardBackPic(String cardBackPic) {
		this.cardBackPic = cardBackPic;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


}
