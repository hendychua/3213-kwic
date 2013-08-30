import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input {
	public final String INPUT_MOVIE_FILE = "movie.txt";
	public final String INPUT_FORBIDDEN_FILE = "forbidden.txt";

	public Input() {
	}

	public LineStorage parseLines() {
		// returns the data structure LineStorage which contains lines entered
		// by user

		LineStorage lines = null;
		System.out.println("Enter the mode of input for movie titles: ");
		System.out.println("0. Read from " + INPUT_MOVIE_FILE);
		System.out.println("1. Enter the input in the terminal window.");

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		while (!line.equals("0") && !line.equals("1")) {
			System.out.println("Please enter 0 or 1:");
			line = sc.nextLine();
		}

		if (line.equals("0")) {
			lines = readMovieTitlesFromFile();
		} else if (line.equals("1")) {
			lines = readMovieTitlesFromTerminal();
		}
		return lines;
	}

	private LineStorage readMovieTitlesFromFile() {
		LineStorage lines = new LineStorage();
		String line = new String();
		System.out.println("Reading movie titles from file");
		File inputFile = new File(INPUT_MOVIE_FILE);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			line = reader.readLine();
			while (line != null) {
				lines.addLine(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There was an error reading from the file: "
					+ e.getMessage());
		}
		return lines;
	}

	private LineStorage readMovieTitlesFromTerminal() {
		LineStorage lines = new LineStorage();
		System.out.println("Enter movie titles. Enter 0 to end input.");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		while (!line.equals("0")) {
			lines.addLine(line);
			line = sc.nextLine();
		}
		return lines;
	}

	public ForbiddenWords parseWords() {
		// returns the data structure ForbiddenWords which contains words to
		// ignore entered by user
		ForbiddenWords forbiddenWords = new ForbiddenWords();
		System.out.println("Enter the mode of input for the forbidden words: ");
		System.out.println("0. Read from " + INPUT_FORBIDDEN_FILE);
		System.out.println("1. Enter the input in the terminal window.");

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		while (!line.equals("0") && !line.equals("1")) {
			System.out.println("Please enter 0 or 1:");
			line = sc.nextLine();
		}

		if (line.equals("0")) {
			forbiddenWords = readForbiddenWordsFromFile();
		} else if (line.equals("1")) {
			forbiddenWords = readForbiddenWordsFromTerminal();
		}
		return forbiddenWords;

	}

	private ForbiddenWords readForbiddenWordsFromTerminal() {
		ForbiddenWords forbiddenWords = new ForbiddenWords();
		System.out.println("Enter the forbidden words. Enter 0 to end input.");
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		while (!word.equals("0")) {
			forbiddenWords.add(word);
			word = sc.next();
		}
		return forbiddenWords;
	}

	private ForbiddenWords readForbiddenWordsFromFile() {
		ForbiddenWords forbiddenWords = new ForbiddenWords();
		String line = new String();
		System.out.println("Reading from forbidden words from file");
		File inputFile = new File(INPUT_FORBIDDEN_FILE);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			line = reader.readLine();
			while (line != null) {
				forbiddenWords.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There was an error reading from the file: "
					+ e.getMessage());
		}
		return forbiddenWords;
	}

}
