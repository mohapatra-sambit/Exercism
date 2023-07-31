import java.util.ArrayList;
import java.util.List;

class House {

	private static final String THE = " the ";
	private static final String THAT = "that ";
	private static final String THIS = "This is the ";

	private List<Rhyme> rhymeList = new ArrayList<House.Rhyme>();

	{
		rhymeList.add(new Rhyme("lay in", "house that Jack built."));
		rhymeList.add(new Rhyme("ate", "malt"));
		rhymeList.add(new Rhyme("killed", "rat"));
		rhymeList.add(new Rhyme("worried", "cat"));
		rhymeList.add(new Rhyme("tossed", "dog"));
		rhymeList.add(new Rhyme("milked", "cow with the crumpled horn"));
		rhymeList.add(new Rhyme("kissed", "maiden all forlorn"));
		rhymeList.add(new Rhyme("married", "man all tattered and torn"));
		rhymeList.add(new Rhyme("woke", "priest all shaven and shorn"));
		rhymeList.add(new Rhyme("kept", "rooster that crowed in the morn"));
		rhymeList.add(new Rhyme("belonged to", "farmer sowing his corn"));
		rhymeList.add(new Rhyme("", "horse and the hound and the horn"));
	}

	public String verse(int n) {
		--n;
		StringBuilder buff = new StringBuilder();
		if (n == 0) {
			buff.append(THIS).append(rhymeList.get(0).post);
		} else {
			for (int i = n; i >= 0; i--) {
				if (i == n) {
					buff.append(THIS).append(rhymeList.get(i).post);
				} else {
					buff.append(THAT).append(rhymeList.get(i).pre).append(THE).append(rhymeList.get(i).post);
				}
				if (i > 0) {
					buff.append(" ");
				}
			}
		}
		return buff.toString();
	}

	public String verses(int startVerse, int endVerse) {
		StringBuffer buff = new StringBuffer();
		for (int i = startVerse; i <= endVerse; i++) {
			buff.append(verse(i));
			if (i < endVerse) {
				buff.append("\n");
			}
		}
		return buff.toString();
	}

	public String sing() {
		return verses(1, 12);
	}

	class Rhyme {

		String pre;

		String post;

		public Rhyme(String pre, String post) {
			super();
			this.pre = pre;
			this.post = post;
		}

	}

}
