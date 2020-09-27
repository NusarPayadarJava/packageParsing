package packageParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintLine {
	
	static void printLine(int line_nr){

		ArrayList<String> line = new ArrayList<>( );

		try (Scanner read_all = new Scanner(new File("C:\\sample.csv"), "UTF-8")){		

			while ( read_all.hasNextLine() ) {

						line.add(read_all.nextLine() );	

				}
			
			System.out.println(line.get(line_nr));


		}
		catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
	}		

}
