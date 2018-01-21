package com.cloning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class TestFileSystem {

	public static void main(String args[]) {
		File currFile = new File( "C:\\Shruti\\enc" + File.separator + "tmp.ber" );

		/*
		 * Check for the compatibility between file systems. If the source and target directories are on different file systems, perform a
		 * copy and delete of files rather than using the renameTo() method which works works for same file systems
		 */
		try {
			copy( currFile, new File( "C:\\data\\DCF\\output\\scscf" + File.separator + currFile.getName() ) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* boolean checkFileSystem = true;
		if( checkFileSystem )
		{
			checkFileSystem = currFile.renameTo( new File( "Z:\\CoE-CB&Mediation\\tmp" + File.separator + "tmp.ber" ) );
			System.out.println("checkFileSystem : "+checkFileSystem);
			if( !checkFileSystem )
			{
				System.out.println("before move");
				TestFileSystem.move( currFile, "Z:\\CoE-CB&Mediation\\tmp" );
				checkFileSystem = false;
			}
		}*/
	}
	
	/*public static void move(File srcFile, String destDir) throws IOException
	{
		try
		{
			copy( srcFile, new File( destDir + File.separator + srcFile.getName() ) );
			srcFile.delete();
		}
		catch( IOException io )
		{
			
			 * In case of Move error lets throw the Exception for the distribute() method to handle
			 
			throw new IOException( "Failed in moving file " + srcFile.getName() + " from directory " + srcFile.getAbsolutePath() + " to "
					+ destDir );
		}

	}*/

	public static void copy(File src, File dst) throws IOException
	{
		System.out.println("copy called");
		InputStream in = new FileInputStream( src );
		OutputStream out = new FileOutputStream( dst );

		// Transfer bytes from in to out
		byte[] buf = new byte[4096];
		int len;
		while( ( len = in.read( buf ) ) > 0 )
		{
			out.write( buf, 0, len );
		}
		in.close();
		out.close();
	}
	
}
