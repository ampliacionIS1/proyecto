package calculadora;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.*;

public class evolitivo{	
	static String cadena = null;
	public static String numeroEntero(String caden, int index){
		String temp =  caden.substring(0,1);
		int i = index;
		if (( !temp.equals("+"))&&(!temp.equals("-"))&&(!temp.equals("*"))&&(!temp.equals("/"))){
			if (cadena.length()>1){
				while(i<cadena.length()){
				String temp2 = cadena.substring(i,i+1);
				if ( (!temp2.equals("+"))&&(!temp2.equals("-"))&&(!temp2.equals("*"))&&(!temp2.equals("/"))){
							temp+=temp2;
							i++;
						}
				else break;
				}
		
			}
		}
	
			cadena = cadena.substring(i);
			return temp;
	}
	public static void operar (String op, String num, ArrayList<Double> s){
		switch (op){
			case "/":
				s.set(s.size()-1, s.get(s.size()-1)/Double.parseDouble(num));
			break;
			case "*":
				s.set(s.size()-1, s.get(s.size()-1)*Double.parseDouble(num));
			break;
			case "-":
				s.set(s.size()-1, s.get(s.size()-1)-Double.parseDouble(num));
			break;
			case "+": 
				s.set(s.size()-1, s.get(s.size()-1)+Double.parseDouble(num));
			break;
			default: 
			System.out.println("error");
		}
		System.out.println("Péinate");
		
	}
public static void main(String []agrs){
	String caden = "2/2+3*3";
	cadena= caden;
	ArrayList <Double> solucion = new ArrayList<>(0);
	while(cadena.contains("*")||cadena.contains("/")){
		for(int i = 0; i <cadena.length();i++){
			String aux = cadena.substring(i,i+1);
			if (("*".equals(aux)||("/".equals(aux)))){
				solucion.add(Double.parseDouble(cadena.substring(i-1,i)));
				operar(aux,cadena.substring(i+1, i+2),solucion);
				String r =cadena.substring(i-1, i+2);
				String auxC = cadena.substring(0, i-1);
				auxC = auxC+solucion.get(solucion.size()-1);
				auxC= auxC+cadena.substring(i+2);
				cadena = auxC;
				solucion.remove(solucion.size()-1);
			}
		}
		caden = cadena;
	}
	while (cadena.length()>0){
		String temp = numeroEntero(cadena,1);
		if (( !temp.equals("+"))&&(!temp.equals("-"))&&(!temp.equals("*"))&&(!temp.equals("/"))){
			double a = Double.parseDouble( temp);
			solucion.add(a);
		}
		else{
			caden = cadena;	
			String temp2 = numeroEntero(cadena,1);
			caden = cadena;	
			operar(temp,temp2,solucion );
			double r = solucion.get(solucion.size()-1);
			if (cadena.length()==0){
				solucion.set(0, r);
				break;
			}
			cadena = r+cadena;
			caden = cadena;	
			
		}
		caden = cadena;	
	}
	
	System.out.print("solucion : "+solucion.get(0));
	
}	
}


