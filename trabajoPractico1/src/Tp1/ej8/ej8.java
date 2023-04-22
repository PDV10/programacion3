package Tp1.ej8;


public class ej8 {
	public static void main(String[] args) {
		ListaDoblementeVinculada<Integer> lista = new ListaDoblementeVinculada<>();
		ListaDoblementeVinculada<Integer> lista2 = new ListaDoblementeVinculada<>();
		
//		lista.insertFront(4);
//		lista.insertFront(9);
//		lista.insertFront(92);
		lista.insertFront(1);
		lista.insertLast(29);
		lista.insertLast(9);
		System.out.println(lista);
			
		lista.extractFront();
		lista.extractLast();
		System.out.println(lista);
	}
}
