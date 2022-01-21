package pis.hue1;

//import java.util.Scanner;
//import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.* ;

public class Wuerfel implements Codec{
	
	
	private String schluessel ;

	public Wuerfel(String schluessel){
		setzeLosung(schluessel);
	};
	
	public Wuerfel() {
		
	}
	
	/**
	 * kodiere der eingetragene Klartext
	 * @param klartext 
	 * @return verschluesselte Klartext
	 */
	public String kodiere(String klartext) {
		schluessel = schluessel.toLowerCase();
		char [] losungswort1array = schluessel.toCharArray();                                     //etant donne que le losungswort est un string de caractere, la on vas juste transformer cela en array pour pouvoir bien sortieren
		Arrays.sort(losungswort1array);                                                           //ici le array a ete sortieren
		//System.out.println("le Losungswort 1 sortieren est :"+String.valueOf(losungswort1array) );
		int[] place1 = new int[schluessel.length()] ; 
		
		for( int i=0; i<schluessel.length(); i++) {
			for(int j=0; j<schluessel.length(); j++) {
				if(schluessel.charAt(i) == losungswort1array[j]) {
					place1[i] = j ;                                                               //avec ces instructions on a durchnummerieren also on a obtenu le Zahlenlosung
					break;
					
				}
			}
			
		}
		char[] tony = new char[klartext.length()];
		int x = 0;
		int y = 0;
		for(int k=0; k<schluessel.length(); k++) {
			for(int j=0; j<schluessel.length(); j++) {
				if(place1[j] == k) {
					x = j ;
					for(int i=0; i<klartext.length(); i++) {
						if(x < klartext.length()) {
							tony[y] = klartext.charAt(x);
							x = x + schluessel.length();
							y++;
						}
					}
				}
			}
		}
		
		
		
		return String.valueOf(tony);
	}

	/**
	 * dekodiere eingetragene Geheimtext
	 * @param geheimtext
	 * @return klartext
	 * 
	 */
	
	@Override
	public String dekodiere(String geheimtext) {
		// TODO Auto-generated method stub
		char [] resultat1 = new char[geheimtext.length()];
		int x = 0;
		    schluessel = schluessel.toLowerCase();
			char [] losungswort1array = schluessel.toCharArray();                                     //etant donne que le losungswort est un string de caractere, la on vas juste transformer cela en array pour pouvoir bien sortieren
			Arrays.sort(losungswort1array);                                                           //ici le array a ete sortieren
			//System.out.println("le Losungswort 1 sortieren est :"+String.valueOf(losungswort1array) );
			int[] place1 = new int[schluessel.length()] ; 
			
			for( int i=0; i<schluessel.length(); i++) {
				for(int j=0; j<schluessel.length(); j++) {
					if(schluessel.charAt(i) == losungswort1array[j]) {
						place1[i] = j ;                                                               //avec ces instructions on a durchnummerieren also on a obtenu le Zahlenlosung
						break;
						
					}
				}
				
			}
			
			                                                                                          //avec ces instructions on a aussi durchnummerieren le second losungswort also on a obtenu le second zahlenlosung
			//System.out.println("Le premier Zahlenlosung est: " +Arrays.toString(place1));
			//geheimtext = geheimtext.toLowerCase();
			
			
			for(int k=0; k<schluessel.length(); k++) {
				for(int j=0; j<schluessel.length(); j++) {
					if(place1[j] == k) {
						for(int i=j ; i<geheimtext.length(); i = schluessel.length()+i) {
							if(x < geheimtext.length()) {
							resultat1[i] = geheimtext.charAt(x);
							x++;
							}
							
						}
					}
				}
				
			}
			
			//System.out.println("le premier text est: "+ String.valueOf(resultat1));
			
			
			
			return String.valueOf(resultat1);
		}

	
	
	
	
	
	@Override
	public String gibLosung() {
		// TODO Auto-generated method stub
		return this.schluessel;
	}

	@Override
	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
			
		this.schluessel = schluessel ;
		
		
		
	}
	
	
}
	

		

	


