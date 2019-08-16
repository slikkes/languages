package bibleshow;


public class Bibleshow {
	public static void main(String[] args) {

		
		FileIOService service = new FileIOService();
		
		String path = "/home/slikk/Dokumentumok/bibleshow/BibleShow.lng";
		
		service.read(path);
		String engLines = service.getLines("English");
		
		System.out.println(engLines);


	}
}
