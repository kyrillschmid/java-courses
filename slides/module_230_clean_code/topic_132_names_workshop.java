// j2 from 'macros.j2' import header
// {{ header("Workshop: Namen", "Workshop: Names") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop: Namen
//
// Das folgende Programm verwendet sehr schlechte Namen. Ändern Sie die Namen
// so, dass sie den Regeln für gute Namen folgen.

// %% [markdown] lang="en" tags=["slide"]
// ## Mini workshop: Names
//
// The following program uses very bad names. Change the names so that they
// follow the rules for good names.


// %% tags=["keep"]
// Class representing Line Items:
public class LI {
    
    //number of items
    int X;
    // description of the items
    String ChrLst;
    // price per item
    double Y;
    
    
    public LI(int X, String ChrLst, double Y){
        this.X = X;
        this.ChrLst = ChrLst;
        this.Y = Y;
    }
    
    // compute the total price
    public double foo(){
        return this.X * this.Y;
    }
}


// %% tags=["subslide", "keep"]
// Class representing an Order
public class LIManager{
    // a list of line items
    ArrayList<LI> LIVec = new ArrayList<LI>();
    
    // compute the total price
    public double myResult(){
        double result = 0.0;
        for(LI li : LIVec){
            result += li.foo();
        }
        return result;
    }
}


// %% tags=["keep"]
// Prepare an order
LIManager myOrder = new LIManager();
LI l1 = new LI(2, "Tea", 0.99);
LI l2 = new LI(3, "Coffee", 0.89);
myOrder.LIVec.add(l1);
myOrder.LIVec.add(l2);
System.out.println(myOrder.myResult())


// %% tags=["subslide"]
public class LineItem {
    
    int numItems;
    String description;
    double pricePerItem;
    
    public LineItem(int numItems, String description, double pricePerItem){
        this.numItems = numItems;
        this.description = description;
        this.pricePerItem = pricePerItem;
    }
    
    public double computeTotalPrice(){
        return this.numItems * this.pricePerItem;
    }
}


// %% tags=["subslide"]
public class Order{

    ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    
    public double totalPrice(){
        double result = 0.0;
        for(LineItem item : lineItems){
            result += item.computeTotalPrice();
        }
        return result;
    }
}

