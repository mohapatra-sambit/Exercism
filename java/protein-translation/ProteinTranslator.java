import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProteinTranslator {

	private boolean flag = true;

	List<String> translate(String rnaSequence) {
		return Arrays.stream(rnaSequence.split("(?<=\\G.{3})")).filter(codon -> isStop(codon)).map(codon -> {
			return determineProtein(codon);
		}).collect(Collectors.toList());
	}

	private boolean isStop(String codon) {
		if (flag && (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA"))) {
			flag = false;
		}
		return flag;
	}

	private String determineProtein(String codon) {
		switch (codon) {
		case "AUG":
			return "Methionine";
		case "UUU":
		case "UUC":
			return "Phenylalanine";
		case "UUA":
		case "UUG":
			return "Leucine";
		case "UCU":
		case "UCC":
		case "UCA":
		case "UCG":
			return "Serine";
		case "UAU":
		case "UAC":
			return "Tyrosine";
		case "UGU":
		case "UGC":
			return "Cysteine";
		case "UGG":
			return "Tryptophan";
		}
		return "";
	}

}

