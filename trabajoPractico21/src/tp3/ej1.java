package tp3;

import java.util.ArrayList;

public class ej1 {
	public static void main(String[] args) {
		ArbolConNodos arbol = new ArbolConNodos();
//		Nodo n1 = new Nodo(8);
//		Nodo n2 = new Nodo(5);
//		Nodo n3 = new Nodo(7);
//		Nodo n4 = new Nodo(9);
//		Nodo n5 = new Nodo(20);
//		Nodo n6 = new Nodo(14);
//		Nodo n7 = new Nodo(34);
		
//		arbol.addNodo(n1.getValor());	
//		arbol.addNodo(n2.getValor());	
//		arbol.addNodo(n3.getValor());	
//		arbol.addNodo(n4.getValor());	
//		arbol.addNodo(n5.getValor());	
//		arbol.addNodo(n6.getValor());	
//		arbol.addNodo(n7.getValor());
	
		arbol.addNodo(35);
		arbol.addNodo(34);
		arbol.addNodo(350);
		arbol.addNodo(50);
		arbol.addNodo(100);
		arbol.addNodo(400);
		arbol.addNodo(401);
		arbol.addNodo(15);
		arbol.addNodo(16);
		arbol.addNodo(6);
		arbol.addNodo(5);
		
		
		
		
//		System.out.println(arbol.getRaiz().getValor());
//		Nodo raiz = arbol.getRoot();
//		System.out.println("el mayor elemento es: " + arbol.getMaxElement());
//		System.out.println("la rama mas larga es: " + arbol.getLongestBranch());
//		System.out.println(" ");
//		System.out.println("la altura del arbol es de : " + arbol.getHeight()+ " niveles" );
//		System.out.println(arbol.getElementAtLevel(2));

		arbol.printInOrder();
		System.out.println("");
		arbol.delete(50);
		arbol.printInOrder();
//		System.out.println(" ");
//		arbol.printPreOrder();
//		System.out.println(" ");
//		System.out.println(" ");
		

//		System.out.println(arbol.getFrontera());
//		arbol.printPostOrder();
//		System.out.println(raiz.getValor());
//		System.out.println(arbol.hasElem(490));
//		System.out.println(arbol.getRaiz().getValor());
//		System.out.println(arbol.getRaiz().getNodoIzquierdo().getValor());
//		System.out.println(arbol.getRaiz().getNodoIzquierdo().getNodoDerecho().getValor());
//		System.out.println(arbol.getRaiz().getNodoDerecho().getValor());
	}
}
