
public class TesteThread {

	public static void main(String[] args) {
		
		// Thread é uma linha de execução
		Thread t = new Thread(() ->  System.out.println("Rodando..."));
		
		t.setPriority(Thread.MAX_PRIORITY);
		t.start(); // Rodando...

		System.out.println(Thread.MAX_PRIORITY);	// 10
		System.out.println(Thread.MIN_PRIORITY);	// 1
		System.out.println(Thread.NORM_PRIORITY);	// 5
	}

}
