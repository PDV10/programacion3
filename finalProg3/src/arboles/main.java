package arboles;

public class main {
	public static void main(String[] args) {
		ArbolConNodo arbol = new ArbolConNodo();
		
		arbol.add(10);
		arbol.add(60);
		arbol.add(30);
		arbol.add(5);
		arbol.add(25);
		arbol.add(100);
		
		
//		arbol.printInOrden();
//		System.out.println("\n");
//		arbol.printPreOrden();
//		System.out.println("\n");
//		arbol.printPostOrden();
		
		
//		System.out.println(arbol.hasElem(10));
//		System.out.println(arbol.isEmpty());
		
//		System.out.println(arbol.getHeight());
		
//		System.out.println(arbol.getLongestBranch());
		
//		System.out.println(arbol.getFrontera());
		
//		System.out.println(arbol.getMaxElem());
		
//		System.out.println(arbol.elemsAtLevel(2));
		System.out.println(arbol.suma());
		System.out.println(arbol.HojasMayores(2));
		System.out.println(arbol.superaK(20));
	}
}
