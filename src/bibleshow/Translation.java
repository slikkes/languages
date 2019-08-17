package bibleshow;

public class Translation {

	public String key;
	public String translation;
	
	public Translation(String key, String translation) {
		this.key = key;
		this.translation =  translation;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		
//		 if (o == this) { 
//	            return true; 
//	        } 
//	  
//	        if (!(o instanceof Translation)) { 
//	            return false; 
//	        } 
//	          
//	        Translation c = (Translation) o; 
//	        
//
//
//		return this.key == c.key;
//	}
	
	public String getOriginal() {
		return this.key + "=" + this.translation;
	}
}
