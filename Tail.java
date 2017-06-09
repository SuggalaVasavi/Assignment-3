package week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class Tail
{
	public static void main(String args[])
	{ 
		String matchWord="";
		String fileName="";
		String options="";
		String optionsAllowed="–f -n";//tail options
		if (args.length==2)
		{
			options=args[0];
			fileName=args[1];
		}
		else if (args.length==3)
		{
			options=args[0];    //options may contain   –f -n.
			matchWord=args[1];
			fileName=args[2];
		}
		else
		{
			exit();
		}


		if(options.length()>2)   // length  of options may not be more than 2 chars.
		{
			exit();
		}

		char OA[]=options.toCharArray(); //Options converted to char array

		for (int i=0 ; i<OA.length;i++)
			if( optionsAllowed.indexOf(OA[i])==-1)  //if options contains other than –f -n, it exits
			{
				System.out.println("Invalid options");
				exit();
			}
		try
		{
			tail(options, Integer.parseInt(matchWord), fileName);  // calling grep method to search lines
		}
		catch(Exception io)  { System.out.println("IOerror");  }
	}

	public static void tail(String options,int tailSize,String fileName){
		String thisLine="";

		List<String> array = new ArrayList<>();
		long sleepTime = 10000;
		try{
			FileReader filereader = new FileReader( fileName );
			BufferedReader br = new BufferedReader( filereader );
			while( true ) {// open the file
				switch (options) {
				case "-n"://  output the last NUM lines, instead of the last 10 
					while( (thisLine = br.readLine( )) != null){
						array.add(thisLine);
					}
					int end= array.size();

					int start = end - tailSize;
					if(start<0)
					{
						start =0;
						tailSize= end;
					}

					for(int i=start; i <end; i++)
					{
						System.out.println(array.get(i));
					}
					break;
				case "-f"://output appended data as the file grows;

					while ((thisLine = br.readLine()) != null) {
						System.out.println(thisLine);
						continue;
					}
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}

					break;
				default:
					exit();
				}
				br.close();
			} // end try

		}
		catch( Exception e )
		{
			System.out.println( "Error reading file: " + e );
		}
	}
	public static void exit()
	{
		System.out.println("Syntax : java Tail [options] regular_expression/word file_name "  );
		System.out.println("Options Allowed : -f -n "  );
		System.exit(0);
	}
}

