package bibleshow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIOService {

	public String fileContent;
	public List<String> languages = new ArrayList<String>();

	public void read(String path) {

		try {

			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));

			this.fileContent = "";
			String line;
			while ((line = br.readLine()) != null) {

				this.fileContent += line;
				this.fileContent += "\n";

			}

			br.close();
			this.fileContent = this.fileContent.replaceAll("(?m)^\\s", "");

			this.extractLanguages();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getLines(String lang) {
		
		//TODO if language doesn't included throw exception

		
		int start = this.fileContent.indexOf("[" + lang + "]") + lang.length() + 2;
		int end = this.fileContent.indexOf("[" + this.getNextLang(lang) + "]", start);
		
		return this.fileContent.substring(start, end);
	}

	private void extractLanguages() {

		int langStart = this.fileContent.indexOf("[Languages]") + 12;

		List<String> langs = new ArrayList<String>(Arrays
				.asList(this.fileContent.substring(langStart, this.fileContent.indexOf("[", langStart)).split("\n")));

		langs.forEach(line -> this.languages.add(line.split("=")[1]));

	}

	private String getNextLang(String lang) {
		
		//the language list order needs to be the same with the translations order in the file
		
		return this.languages.get(this.languages.indexOf(lang) + 1);
	}

}
