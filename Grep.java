package week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
public class Grep
{
	public static void main(String args[])
	{ 
		String matchWord="";
		String fileName="";
		String options="";
		String optionsAllowed="-i –e –v –w –c -n";//grep options
		if (args.length==2)
		{
			matchWord=args[0];
			fileName=args[1];
		}
		else if (args.length==3)
		{
			options=args[0];    //options may contain  -i –e –v –w –c -n.
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
			if( optionsAllowed.indexOf(OA[i])==-1)  //if options contains other than -i –e –v –w –c -n, it exits
			{
				System.out.println("Invalid options");
				exit();
			}
		try
		{
			grep(options, matchWord, fileName);  // calling grep method to search lines
		}
		catch(IOException io)  { System.out.println("IOerror");  }
	}


	// grep method starts
	public static void grep(String options, String exp, String fileName) throws IOException
	{

		int count = 0;
		int lineNo=0;
		int countNM=0;

		String inputLine = null;
		Pattern pattern=null;
		try {
			FileReader filereader = new FileReader( fileName );
			BufferedReader br = new BufferedReader( filereader );
			while( true ) {// open the file
				switch (options) {
				case "-i":// for case insensitive

					while( (inputLine = br.readLine( )) != null) // reading  each line
					{
						pattern=Pattern.compile(exp, Pattern.CASE_INSENSITIVE);// to mention case insensitive
						Matcher matcher = pattern.matcher(inputLine);
						if (matcher.find())
						{
							count++;    //counting matching lines
							//printing only matching lines

							System.out.println(inputLine);

						}
					}
					break;
				case "-v":// select non-matching lines
					while( (inputLine = br.readLine( )) != null)
					{

						pattern=Pattern.compile(exp);
						Matcher matcher = pattern.matcher(inputLine);
						if (matcher.find()){}
						else{
							System.out.println(inputLine);
						}
					}

					break;

				case "-n":// print line number with output lines
					while( (inputLine = br.readLine( )) != null)
					{
						lineNo++;
						pattern=Pattern.compile(exp);

						Matcher matcher = pattern.matcher(inputLine);
						if (matcher.find())
						{

							System.out.println(lineNo + " : " + inputLine);
						}

					}
					break;
				case "-c":// print NUM lines of output context

					while( (inputLine = br.readLine( )) != null)
					{
						pattern = Pattern.compile(exp); 
						Matcher matcher = pattern.matcher(inputLine);
						if (matcher.find())
						{
							count++;    //counting matching lines
							//printing only matching lines
						}else 
						{
							countNM++;  // counting not matching lines
							//printing not matching lines
						}
					}
					System.out.println("\n Word / Exp : " + exp );
					System.out.println(count + " line(s) matched.");
					System.out.println(countNM + " line(s) not matched.");
					break;
				case "-e"://use regex PATTERN for matching
					while( ( inputLine = br.readLine() ) != null ) {
						pattern = Pattern.compile(exp); 
						Matcher matcher = pattern.matcher(inputLine);
						if (matcher.lookingAt()) {
							if (fileName != null) {

							}
							System.out.println(inputLine);
						}
					}
					break;
				case "-w"://force PATTERN to match only whole words
					while( (inputLine = br.readLine( )) != null) // reading  each line
					{
						pattern=Pattern.compile(exp);
						Matcher matcher = pattern.matcher(inputLine);


						if (matcher.find())
						{
							if(inputLine.equals(exp)){

								System.out.println(inputLine);
							}
						}
					}
					break;
				default:
					exit();
				}

				br.close();
			}
	} catch (Exception e) { System.out.println(""); }
	}
	public static void exit()
	{
		System.out.println("Syntax : java JavaGrep [options] regular_expression/word file_name "  );
		System.out.println("Options Allowed : -i –e –v –w –c -n "  );
		System.exit(0);
	}
}  
