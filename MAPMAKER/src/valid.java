import java.io.*;
import java.util.*;


public class valid
{
    public static void validate(String file1, String file2)throws IOException
    {

    	FileReader fr1 = new FileReader(file1);
    	FileReader fr2 = new FileReader(file2);
    	BufferedReader br1 = new BufferedReader(fr1);
    	BufferedReader br2 = new BufferedReader(fr2);
    	String line1 = br1.readLine();
    	String line2 = br2.readLine();
    	List<String> diffs=new ArrayList<String>();
    	while (line1 != null && line2 != null) {
    		if (!line1.equals(line2))
            {
    			diffs.add(line1);
    			//break;
            }
    		line1 = br1.readLine();
            line2 = br2.readLine();
            
    		if ((line1 == null && line2 != null) || (line1 != null && line2 == null))
            diffs.add("Eltero a sorok szama a fileokban!");
    	}
    	if (diffs.size()==0){
    		System.out.println("A ket file azonos!");
    	}else{
    		for (int i=0; i<diffs.size();i++){
    			System.out.println(diffs.get(i));
    		}
    	}
        br1.close();
    	br2.close();
    }
    

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ird be az elso file nevet:");
        String egy = br.readLine();
        egy = egy + ".txt";
        System.out.print("Ird be a masodik file nevet:");
        String ket = br.readLine();
        ket = ket + ".txt";
	    validate(egy,ket);
	}
}