package similiarity;

import info.debatty.java.stringsimilarity.Damerau;

public class TestingSimiliarity {

	public static void main(String[] args) {

		// produces 0.416666
		// NGram twogram = new NGram(2);
		// System.out.println(twogram.distance("ABCD", "ABTUIO"));

		// produces 0.97222
		// String s1 = "THE Hotel Aryaduta  Semanggi".toUpperCase();
		// String s2 = "THE ARYADUTA SUITE SEMANGGI";
		// NGram ngram = new NGram(4);
		// System.out.println(ngram.distance(s1, s2));

		Damerau l = new Damerau();
		String s1 = "THE Hotel NUSA DUA BEACH".toUpperCase();
		String s2 = "THE ARYADUTA SUITE SEMANGGI";
		System.out.println(l.distance(s1, s2));

		s1 = "THE Hotel Semanggi".toUpperCase();
		s2 = "THE ARYADUTA SUITE SEMANGGI";
		System.out.println(l.distance(s1, s2));

		s1 = "THE Aryaduta Semanggi".toUpperCase();
		s2 = "THE ARYADUTA SUITE SEMANGGI";
		System.out.println(l.distance(s1, s2));

	}

}
