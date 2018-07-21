package utilities;
import java.security.MessageDigest;
 
public class MD5Hashing 
{
    public static void main(String[] args)throws Exception
    {
    	System.out.println(getMd5Hashing("123456"));
    }
    public static String getMd5Hashing(String value){
    	String md5Val="";
    	try{
    	   	 
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
 
        byte byteData[] = md.digest();
 
    
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	md5Val=hexString.toString();
    	System.out.println("Digest(in hex format):: " + hexString.toString());
    	}catch(Exception e){
    		
    	}
		return md5Val;
    }
}