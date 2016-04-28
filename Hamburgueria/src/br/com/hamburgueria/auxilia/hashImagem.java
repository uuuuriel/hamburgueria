package br.com.hamburgueria.auxilia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

import br.com.hamburgueria.exception.CripException;

public class hashImagem {

    public String cripto(String caminho) throws  CripException {
    	try{
    		Date data = new Date();
    		String caminhoC = caminho+data.getTime();
    		MessageDigest md = MessageDigest.getInstance("MD5");
	        BigInteger hash = new BigInteger(1, md.digest(caminhoC.getBytes()));
	 
	        return String.format("%32x", hash);
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new CripException(e);
    	}
    }
}
