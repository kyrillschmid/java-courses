package solid_03_lsp;

public class Main {
	
    public static void main(String[] args) {
    	
    	Rectangle rect = new Square(5, 5);
		rect.setWidth(10);
		System.out.println(rect);
        
    }
}

