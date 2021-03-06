package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.CpfInvalidoException;

public class ValidaCpf {
	
	public void validarCpf (String cpf) throws CpfInvalidoException{
		
		if (!cpf.equals("")) {
			boolean isCpf = CPF(cpf);
			if ((isCpf == false) || cpf.matches("^(0{11}|1{11}|2{11}|3{11}|4{11}|5{11}|6{11}|7{11}|9{11}|9{11})$")){
				throw new CpfInvalidoException();
			}
		}
	}
	
	public static boolean  CPF(String cpf) {
			String strCpf = cpf; 
	        int d1, d2;
	        int digito1, digito2, resto;
	        int digitoCPF;
	        String nDigResult;
	        d1 = d2 = 0;
	        digito1 = digito2 = resto = 0;
	        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
	        	 digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();
	            d1 = d1 + (11 - nCount) * digitoCPF;
	            d2 = d2 + (12 - nCount) * digitoCPF;
	        } 
	        resto = (d1 % 11); 
	        if (resto < 2) {
	            digito1 = 0;
	        } else {
	            digito1 = 11 - resto;
	        }
	        d2 += 2 * digito1;  
	        resto = (d2 % 11);  
	        if (resto < 2) {
	            digito2 = 0;
	        } else {
	            digito2 = 11 - resto;
	        }  
	        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());  
	        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
	        System.out.println(strCpf);
	        System.out.println(nDigResult);
	        return nDigVerific.equals(nDigResult);
	    }
}