package tp2;
public class ej5 {

    /*
     * Ejercicio 5. Dado un arreglo ordenado de números distintos A se desea
     * construir un algoritmo que determine si alguno de los elementos de dicho
     * arreglo contiene un valor igual a la posición en la cuál se encuentra, es
     * decir, A[i] = i.
     * 
     * 1)Construir un algoritmo recursivo que responda a dicha verificación.
     * 
     * 2) Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2,
     * 4, 6, 10])
     */
    public static void main(String[] args) {

        int[] arreglo = { 1, 6, 3, 4, 4, 6, 7, 8, 9, 10 };

        System.out.println(esIgualLaPos2(arreglo, 0));

    }
    
    private static boolean esIgualLaPos2(int[] array, int i) {
        if (i <= array.length - 1) {
            if (array[i] == i) {
                return true;
            } else {
                return esIgualLaPos2(array, i + 1);
            }
        }
        return false;
    }

    public static boolean esIgualLaPos(int[] A,int cursor) {
    	if(A.length - 1 == cursor && A[cursor] != cursor) {
            return false;
        }else if(A[cursor] == cursor) {
        	return true;
        }
    	cursor++; 
    	return  esIgualLaPos(A,cursor);
   	}
}