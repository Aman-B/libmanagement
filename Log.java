package libmangaement;

import java.util.Scanner;
import java.io.*;

public class Log {

	 void Logit()
	 throws IOException {

		// variables
		String uname = null, pwd = null;
		char newusr;

		// scanners
		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);

		System.out.println(" New user or not? y/n");
		newusr = in2.next().charAt(0);

		if (newusr == 'n') 
		{
			System.out.print(" Username :");
			uname = in1.next();

			System.out.println("");

			System.out.print(" Passowrd :");
			pwd = in1.next();
			System.out.println("");
			// System.out.println(" Done !");

			verify(uname, pwd);

			if (verify(uname, pwd)) {
				System.out.println(" Login successful! ");
			}

			else {
				System.out.println(" Wrong username or passowrd!");
			}

		}// outer if ends here
		
		else
		{
			System.out.print(" Username :");
			uname = in1.next();

			System.out.println("");

			System.out.print(" Passowrd :");
			pwd = in1.next();
			newusr(uname,pwd);
		}

	}

	public  boolean newusr(String uname, String pwd) throws IOException {
		// TODO Auto-generated method stub
		
		 FileOutputStream fout = null ;  
	        try {  
	            fout = new FileOutputStream("F:\\Sem-4\\SE pro\\Data.txt",true);  
	           
	            String fdata ="\t"+uname + ":" + pwd;  
	            byte[] byt = fdata.getBytes();
	           
	            fout.write(byt);
	            fout.flush();
	            fout.close();
	            
	        }catch(Exception ex){  
	            ex.printStackTrace();  
	        }finally {  
	            if(fout != null){  
	                fout.close();  
	            }  
	        }  
	        System.out.format("\n");
	        System.out.format("%s's credentials stored !!" , uname);
			return true;  
	    }  
      
		
		
		
		
	

	public  boolean verify(String uname, String pwd) throws IOException {
		// TODO Auto-generated method stub
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\MAHE\\Documents\\NetBeansProjects\\Libmanaegment\\src\\libmangaement\\Data.txt"));
			while ((line = br.readLine()) != null) {
				if (line.contains(uname)) {
					String[] data = line.split(":");

					return pwd.equals(data[1]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return false;
	}

}
