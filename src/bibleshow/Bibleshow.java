package bibleshow;

import java.util.ArrayList;
import java.util.List;

public class Bibleshow {
	public static void main(String[] args) {

		
		FileIOService fileService = new FileIOService();
		
		String path = "/home/slikk/Dokumentumok/bibleshow/BibleShow.lng";		
		fileService.read(path);
		String engLines = fileService.getLines("English");
		
		path = "/home/slikk/Dokumentumok/bibleshow/BibleShowOld.lng";
		fileService.read(path);
		String hunLines = fileService.getLines("Magyar");
		
		TranslationComparatorService compService = new TranslationComparatorService();
		
		List<String> diffs = new ArrayList<String>(compService.getDifferences(engLines, hunLines));
		
		System.out.print(diffs.size());
		
	}
}
