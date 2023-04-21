package Tp1.ej8;

public class ListaDoblementeVinculada<T>{
	public Node<T> first,last;
	public int size;

	public ListaDoblementeVinculada() {
		this.first = null;
		this.last =null;
		this.size = 0;
	}

  public void insertLast( T info) {
      Node <T> nuevo = new Node <T>(info,null, null);
      if(this.first == null) {
    	  this.insertFront(info);
      }else {	
    	  last.setNext(nuevo);
    	  nuevo.setPrev(last);
    	  last = nuevo;
      }     
      size++;
  }
	
	public void insertFront(T info) { 	
		Node<T> nuevo = new Node<T>(info, null, null);	
		if(this.first == null){
			first = nuevo;
			last = first;
		}else {
			first.setPrev(nuevo);
			first.prev.setNext(first);
			first = nuevo;
		}	
		size++;
	}

	public <T> T extractFront() {
		if (this.first != null) {
			T info = (T) this.first.getInfo();
			this.first = this.first.getNext();
			size--;
			return info;
		} else {
			return null;
		}
	}
	
	public <T> T extractLast() {
		if(this.last != null) {
			this.last = this.last.getPrev();
			this.last.setNext(null);
			size--;
			return (T) this.last.getInfo();
		}else {
			return null;			
		}	
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}

	public int getSize() {
		return size;
	}

	public T get(int i) {
		Node aux = this.first;
		int cont = 0;
		
		while(aux != null && cont < i) {
			aux = aux.getNext();
			cont++;
		}
		
		return (T)aux.getInfo();
	}
	
	public int indexOF(T o) {
		int i = 0;
		Node aux = first;
		while(aux != null && aux.getInfo() != o) {
			i++;
			aux = aux.getNext();
		}
		
		if(aux == null) {
			return -1;
		}
		return i;			
	}

	@Override
	public String toString() {
		String r = "";
		Node aux = first;
		
		while(aux != null) {
			r += " - " + aux.getInfo() + " - \n";
			aux = aux.getNext();
		}
		
		return  r;
	}
}
