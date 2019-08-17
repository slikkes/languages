package bibleshow;

public class Translation {

	public String key;
	public String translation;
	
	public Translation(String key, String translation) {
		this.key = key;
		this.translation =  translation;
	}
	
	
	public String getOriginal() {
		return this.key + "=" + this.translation;
	}
	
	public String getSeparatedWithTab() {
		return this.key + "\t" + this.translation;
	}
	
	
}
