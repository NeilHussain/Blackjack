import java.util.Random;

public class DeckOps {

	public static Cards[][] shuffle(int cardsPerDeck, Cards[][] deck, int cards) {
		Random rnd = new Random();

		Cards temp = null;

		for (int i = 1; i <= cards; i++) {

			int ranSpot = rnd.nextInt(51) + 1;

			// temp = deck[1][ranSpot];

			while (deck[1][ranSpot] == deck[1][i]) {
				ranSpot = rnd.nextInt(51) + 1;

			}
			// System.out.println(ranSpot);
			temp = deck[1][ranSpot];

			// temp = deck[1][i];

			deck[1][ranSpot] = deck[1][i];

			deck[1][i] = temp;

			// System.out.println(i + " " + deck[1][i]);

		}

		return deck;

	}

	public void Deal() {

	}

}
