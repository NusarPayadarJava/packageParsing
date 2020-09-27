package packageParsing;

	import java.io.*;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.*;

	public class ParsingMain {

		
		 

		   static int antalA=0;
		   static int antalAndroid=0;
		   
		   static char ch;
		   static char ch2;

		   	 
		   public static String COMMA_DELIMITER = ",";
				   
		 	public static void main(String[] args) {
		 			
			List<List<String>> records = new ArrayList<>();
			try (Scanner scanner = new Scanner(new File("C:\\sample.csv"), "UTF-8")) {
					while (scanner.hasNextLine()) {

					  records.add(recordLine(scanner.nextLine()));
						//System.out.println(records);
					}
			} 
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//----------------------------tidstamp------------------------------------		
			ArrayList<String> tidstamp = new ArrayList<>( ); 

	        Set <String> temp_file = new HashSet<>();


			for(List<String> s:records){ 
				//System.out.println(s.get(2)); 
				tidstamp.add(s.get(0));

			}
			 				
	 						int index=0;
	 						System.out.println("personer som har samma tidstample: ");
	 						System.out.println("----------------------------------- ");


			 					for  (String st: tidstamp) {
				        	     if (temp_file.add(st) == false) {
					        	     System.out.println("found dublicate: "+st); 
					        	     PrintLine.printLine(index);


				        	     }
					        	 	index++;

				            }

				            
	//------------------------------------------------------
	System.out.println("--------------------------------");


	System.out.println("totalt personer som arbetar med Android: "+antalAndroid);
	System.out.println("--------------------------------");

	System.out.println("antal personer med bokstaven [A]: "+ antalA); 
	System.out.println("--------------------------------");

		        
		        //-------------

	} //main	
		//***************************************************
		 	static List<String> recordLine(String line) {
		 		ArrayList<String> arrayG1 = new ArrayList<String>();
			     ArrayList<String> arrayG2 = new ArrayList<String>();

			
			 List<String> Value = new ArrayList<String>();
			
			 try (Scanner sc = new Scanner(line)) {
				sc.useDelimiter(COMMA_DELIMITER);
				 
				while (sc.hasNext()) {	

					Value.add(sc.next());
					
				}
			
			 //Name group member G1 & G2------	
		    
		     arrayG1.add (Value.get(1)); //System.out.println( arrayG1);
		     arrayG2.add (Value.get(2)); //System.out.println(arrayG2);	
		     
		    
		        
		        for (int i=0; i < arrayG1.get(0).length(); i++) {
		            ch =arrayG1.get(0).charAt(0);
		            ch2 =arrayG2.get(0).charAt(0);
		        }//for loop
		        
		        		if (  ch == 'A' ){
		        			antalA++;
		        			//System.out.println(arrayG1+" is in the list");
		        		} 
		        		else if (  ch2 == 'A'  ) {
		        			antalA++;

		        		    //System.out.println(arrayG2+" is in the list");
		        	    }
		       
				
				
				 //android work lista -------------------
					 
						if (Value.get(6).equals("Android App") ) {
							antalAndroid++;
							//System.out.println(Value.get(6)); 
						}
					
				// *******************************************
					
							

			}// ------- try ----- 	

			return Value;
			
		}

	}


	