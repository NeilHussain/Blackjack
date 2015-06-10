public class Players {
	String name, facePic;
	Cards[] hand;
	int difficulty, coins, bet, cardsValue;
	Boolean willHit, Bust, Stay, isPlaying, isTurn, isCPU;
	int x, y, w, h, numCards;

	public Players(String name, String facePic, Cards[] hand, int difficulty,
			int coins, int bet, int cardsValue, Boolean willHit, Boolean bust, Boolean stay,
			Boolean isPlaying, Boolean isTurn, int x, int y, int w, int h, int numCards, boolean isCPU) {
		super();
	
		this.isTurn = isTurn;
		this.name = name;
		this.facePic = facePic;
		this.hand = hand;
		this.difficulty = difficulty;
		this.coins = coins;
		this.bet = bet;
		this.cardsValue = cardsValue;
		this.willHit = willHit;
		this.Bust = bust;
		this.Stay = stay;
		this.isPlaying = isPlaying;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.numCards = numCards;
		this.isCPU = isCPU;

	}
	public Boolean getStay() {
		return Stay;
	}
	public void setStay(Boolean stay) {
		Stay = stay;
	}
	public void addCard(Cards toAdd){
		
	
		
		
	}

	public Boolean getIsCPU() {
		return isCPU;
	}

	public void setIsCPU(Boolean isCPU) {
		this.isCPU = isCPU;
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}

	public Boolean getIsTurn() {
		return isTurn;
	}

	public void setIsTurn(Boolean isTurn) {
		this.isTurn = isTurn;
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

	public Boolean getIsPlaying() {
		return isPlaying;
	}

	public void setIsPlaying(Boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacePic() {
		return facePic;
	}

	public void setFacePic(String facePic) {
		this.facePic = facePic;
	}

	public Cards[] getHand() {
		return hand;
	}

	public void setHand(Cards[] hand) {
		this.hand = hand;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public int getCardsValue() {
		return cardsValue;
	}

	public void setCardsValue(int cardsValue) {
		this.cardsValue = cardsValue;
	}

	public Boolean getWillHit() {
		return willHit;
	}

	public void setWillHit(Boolean willHit) {
		this.willHit = willHit;
	}

	public Boolean getBust() {
		return Bust;
	}

	public void setBust(Boolean bust) {
		Bust = bust;
	}

}
