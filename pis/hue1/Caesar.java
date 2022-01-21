package pis.hue1;


public class Caesar implements Codec {

      
		
		private String schluessel ;
		
		/**
		 * kodiere jeder eingetragene Klartext
		 * @return verschluesselte Klartext
		 */
		
		
	public String kodiere(String klartext) {
		char [] text2 = new char[klartext.length()];
		char [] klartext1 = klartext.toCharArray();
		char tony ;
		for(int i=0; i<klartext1.length; i++) {
			if(Character.isLetter(klartext.charAt(i)) != true ) {
				text2[i] = klartext.charAt(i);
			}
			else if(klartext.charAt(i) >= 'a' || klartext.charAt(i) >= 'A' && klartext.charAt(i) <= 'z' || klartext.charAt(i) <= 'Z'){
			
				tony = (char) (klartext.charAt(i) + schluessel.length()) ;
				while(tony > 'z' ) {
					tony = (char) (tony - 26) ;
				}
				while(tony > 'Z' && tony < 'a') {
					tony = (char)(tony - 26);
				}
				text2[i] = (char)(tony) ;
			} 
			
		}
		
		return String.valueOf(text2);
		}
	
	
	/**
	 * dekodiere der eingetragene Geheimtext
	 * @return der Klartext
	 * 
	 */
	
	
	public String dekodiere(String geheimtext) {
		char[] text2 = new char[geheimtext.length()];
		char [] geheimtext1 = geheimtext.toCharArray();
		char tony;
		for(int i=0; i<geheimtext.length(); i++) {
			if(Character.isLetter(geheimtext.charAt(i)) != true) {
				text2[i] = geheimtext.charAt(i);
			}else if(geheimtext.charAt(i) >= 'a' || geheimtext.charAt(i) >='A' && geheimtext.charAt(i) <='z' || geheimtext.charAt(i) <= 'Z') {
				tony = (char)(geheimtext.charAt(i) + (26 - schluessel.length() ));
				while(tony > 'z') {
					tony = (char)(tony - 26);
				}
				while(tony > 'Z' && tony < 'a') {
					tony = (char)(tony - 26);
				}
				text2[i] = (char)(tony);
			}
		}
		
		return String.valueOf(text2);
	}
	
	
	
	
	
	public String gibLosung() {
		return this.schluessel ;
		
	}
	
	
	


	@Override
	public void setzeLosung(String schluessel) throws IllegalArgumentException {
	
		this.schluessel = schluessel ;
	
	 }
}
