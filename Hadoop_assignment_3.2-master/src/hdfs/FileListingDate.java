package hdfs;
import java.io.File;
import java.util.Date;



public class FileListingDate {

    public void listing( String path, Date start, Date end ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                listing( f.getAbsolutePath(), start, end );
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {

                Date fileModified = new Date(f.lastModified());

                if(fileModified.compareTo(start) >= 0 && fileModified.compareTo(end) <= 0)
                        System.out.println( "File:" + f.getAbsoluteFile() );
            }
        }
    }

    public static void main(String[] args) {
        FileListingDate fw = new FileListingDate();

       
       if (args.length == 0 || args.length > 3) {
			System.out.println("Pass 3 arguments");
			System.exit(1);
		}
       

       long start_ts = 0;
       long end_ts = 1493577000000L;
       String path = new String(args[0]);
		
       if (args.length == 2 || args.length == 3){
        	   start_ts = Long.parseLong(new String(args[1]));
           }

       if (args.length == 3){
    	   end_ts = Long.parseLong(new String(args[2]));
		}
	       
	        
	        Date startDate = new Date(start_ts);
	        Date endDate = new Date(end_ts);
			fw.listing(path,startDate,endDate);
    }

}


