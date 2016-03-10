package br.com.hamburgueria.auxilia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class Crip {
 
    public String cripto(String password) throws NoSuchAlgorithmException {
    	try{
	        MessageDigest md = MessageDigest.getInstance("MD5");
	 
	        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
	 
	        return String.format("%32x", hash);
    	}catch(Exception e){
    		throw new NoSuchAlgorithmException();
    	}
    }
 
}