package tp3;

import java.util.ArrayList;

public class ej1 {
	public static void main(String[] args) {
		ArbolConNodos arbol = new ArbolConNodos();
		Nodo n1 = new Nodo(8);
		Nodo n2 = new Nodo(5);
		Nodo n3 = new Nodo(7);
		Nodo n4 = new Nodo(9);
		Nodo n5 = new Nodo(20);
		Nodo n6 = new Nodo(14);
		Nodo n7 = new Nodo(34);
		
//		arbol.setRaiz(n1);
//		
		
//		arbol.addNodo(n1.getValor());	
//		arbol.addNodo(n2.getValor());	
//		arbol.addNodo(n3.getValor());	
//		arbol.addNodo(n4.getValor());	
//		arbol.addNodo(n5.getValor());	
//		arbol.addNodo(n6.getValor());	
//		arbol.addNodo(n7.getValor());	
//		arbol.addNodo(35);	
//		arbol.addNodo(15);	
//		arbol.addNodo(16);	
//		arbol.addNodo(17);	
		
		arbol.addNodo(10);	
		arbol.addNodo(50);	
		arbol.addNodo(5);	
		arbol.addNodo(7);	
		arbol.addNodo(6);	
		arbol.addNodo(8);	
		arbol.addNodo(9);	
		arbol.addNodo(51);	
		arbol.addNodo(62);	
		arbol.addNodo(73);	
		arbol.addNodo(100);
		arbol.addNodo(1000);
		//System.out.println(arbol.getRaiz().getValor());
		System.out.println(arbol.getLongestBranch());
		//Nodo raiz = arbol.getRoot();
		
		//arbol.printInOrder();
//		System.out.println(" ");
//		System.out.println(" ");
//		arbol.printPreOrder();
//		System.out.println(" ");
//		System.out.println(" ");
		
		//ArrayList<Integer> hojas =  arbol.getFrontera();
		
//		for (int i = 0; i < hojas.size(); i++) {
//			System.out.print(hojas.get(i) + " - ");
//		}
		
		//arbol.printPostOrder();
		//System.out.println(raiz.getValor());
		//System.out.println(arbol.hasElem(490));
//		System.out.println(arbol.getRaiz().getValor());
//		System.out.println(arbol.getRaiz().getNodoIzquierdo().getValor());
//		System.out.println(arbol.getRaiz().getNodoIzquierdo().getNodoDerecho().getValor());
//		System.out.println(arbol.getRaiz().getNodoDerecho().getValor());
		
	}
}
