package week3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Tail
{
	 static long sleepTime = 1000;
    public static void main(String args[]) throws IOException
        {
          String size="";
            String fileName="";
            String options="";
            String optionsAllowed="-f-n";//Options allowed in the input
            if (args.length==2)
            {
                options=args[0];
                fileName=args[1];
            }
            else if(args.length==3)
            {
                options=args[0];
                size=args[1];
                fileName=args[2];
            }
            else
            {
                exit();
            }

            if (args.length > 2){
                sleepTime = Long.parseLong(args[1]) * 1000;
            }
            if(options.length()>2 )   // length  of options may not be more than 4 chars.
                {
                    exit();
                }

                char OA[]=options.toCharArray(); //Options converted to char array

            for (int i=0 ; i<OA.length;i++)
                if( optionsAllowed.indexOf(OA[i])==-1)  //if options contains other than vnci, it exits
                {
                    System.out.println("Invalid options");
                    exit();
                }
if(args.length==2){
tail(options,fileName);
}
else
{
            tail(options,Integer.parseInt(size),fileName);  // calling grep method to search lines
        }
        }
// grep method starts
        public static void tail(String options, String fileName) throws IOException	//output appended data as the file grows
            {
                // open the file
        	if(options.contains("-f")){
                	BufferedReader input = new BufferedReader(new FileReader(fileName));
        			String currentLine = null;
        		      while (true) {

        		        if ((currentLine = input.readLine()) != null) {
        		          System.out.println(currentLine);
        		          continue;
        		        }

        		        try {
        		          Thread.sleep(sleepTime);
        		        } catch (InterruptedException e) {
        		          Thread.currentThread().interrupt();
        		          break;
        		        }

        		      }
        		      input.close();
                     
                }
            }
            public static void tail(String options,int tailSize,String fileName){
        if(options.contains("-n")){
        	String thisLine="";
        	List<String> array = new ArrayList<>();
        		try{
        			FileReader filereader = new FileReader( fileName );
        			BufferedReader br = new BufferedReader( filereader );
        	//  output the last NUM lines, instead of the last 10 
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
        				
        		}catch(Exception e){
        			System.out.println("error");
        	}
        	}
        				
        	
        		}
        		
        public static void exit()
        {
                System.out.println("Syntax : java Tail [options] regular_expression/word file_name "  );
                System.out.println("Options Allowed : -f or -n "  );
                System.exit(0);
        }
}

