/**
 * 
 */
package ttool;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author VinojanV
 *
 */
public class TextTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strURL, content, keyword;
		strURL = "YOUR URL"; //user enters url or webpage to count words from
		content = readURL(strURL);
		keyword = "YOUR KEYWORD"; //user enters the word they want to count	
		
		System.out.println(search(keyword,content));

	}
	
	public static String readURL(String url) {
		
		String strCombinedText = "", strLine = "";
		
		try {
			
			URL urlReader = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(urlReader.openStream()));
			
			while((strLine = br.readLine()) != null) {
				
				strCombinedText = strCombinedText + strLine;
				
			}
			
		} catch(IOException e) {
			
			System.out.println("ERROR");
			
		}
		
		return strCombinedText;
				
	}
	
	public static int search(String key, String text) {
		
		int intOccurances = 0;
		int index;
		for (int x = 0; x < text.length(); x++) {
			
			index = text.indexOf(key, x);
			
			if(index != -1) {
				
				intOccurances++;
				x = index;
				
			} else {
				
				break;
				
			}
		}
		
		return intOccurances;
	}
	
	public static void orderByAlpha(String text, String fileName) {
		
		String[] strText = text.split(" ");
		
		Arrays.sort(strText);
		
		try {
			
			FileWriter fr = new FileWriter(fileName);
			PrintWriter pr = new PrintWriter(fr);
			
			pr.println(Arrays.toString(strText) );
		} catch(IOException e) {
			
			System.out.println("ERROR");
			
		}
		
	}

	public static void orderByLength (String text, String fileName) {
		 
		String[] strText = text.split(" ");
		
		Arrays.sort (strText, Comparator.comparingInt(String::length));
		
		try {
			
			FileWriter fr = new FileWriter(fileName);
			PrintWriter pr = new PrintWriter(fr);
			
			pr.println(Arrays.toString(strText) );
		} catch(IOException e) {
			
			System.out.println("ERROR");
			
		}
		
	}
}
