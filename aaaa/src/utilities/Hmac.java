package utilities;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Hmac {

  public static void main(String[] args) throws Exception {
  // //System.out.println("MD5 "+getHmacDigest("d12121c70dda5edfgd1df6633fdb36c71791691429510858", "e10adc3949ba59abbe56e057f20f883e", "HmacMD5"));
   ////System.out.println("SHA1 "+getHmacDigest("d12121c70dda5edfgd1df6633fdb36c71791691429510858", "e10adc3949ba59abbe56e057f20f883e", "HmacSHA1"));
   //System.out.println("SHA256 "+getHmacDigest("d12121c70dda5edfgd1df6633fdb36c071791691429696306", "e10adc3949ba59abbe56e057f20f883e", "HmacSHA256"));
   //getHmacNew();
  }

  public static String getHmacDigest(String msg, String keyString, String algo) {
    String digest = null;
    try {
      SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
      Mac mac = Mac.getInstance(algo);
      mac.init(key);

      byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

      StringBuffer hash = new StringBuffer();
      for (int i = 0; i < bytes.length; i++) {
        String hex = Integer.toHexString(0xFF & bytes[i]);
        if (hex.length() == 1) {
          hash.append('0');
        }
        hash.append(hex);
      }
      digest = hash.toString();
    } catch (UnsupportedEncodingException e) {
    } catch (InvalidKeyException e) {
    } catch (NoSuchAlgorithmException e) {
    }
    return digest;
  }
 public static String getHmacNew(){
	 String result="";

	 try {
		 String algorithm = "HmacSHA256";

		//hex encoded 256 bit key
		String encryptionKey = "e10adc3949ba59abbe56e057f20f883e";
		String message = "d12121c70dda5edfgd1df6633fdb36c071791691429510858";

		byte[] keyBytes = Hex.decodeHex(encryptionKey.toCharArray());
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, algorithm);

		Mac mac = Mac.getInstance(algorithm);
		mac.init(secretKeySpec);
		byte[] macBytes = mac.doFinal(message.getBytes());

		String hexBytes = new String(Hex.encodeHex(macBytes));
		System.out.println(hexBytes);        

	 }
	 catch (Exception e) {

	 }
	 return result;
 }
}