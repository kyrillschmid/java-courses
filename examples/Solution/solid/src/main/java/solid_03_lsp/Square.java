package solid_03_lsp;

public class Square extends Rectangle {

    public Square(double length, double width) {
        super(length, length);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public void setLength(double newLength) {
        super.setLength(newLength);
        super.setWidth(newLength);
    }

    @Override
    public double getWidth() {
        return super.getLength();
    }

    @Override
    public void setWidth(double newWidth) {
        super.setLength(newWidth);
        super.setWidth(newWidth);
    }
    
    @Override
    public String toString() {
        return "Square [length=" + getLength() + ", width=" + getWidth() + "]";
    }

    
}

