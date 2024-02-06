package project;

public class Project {
    public final String name;
    public final double assets;

	public Project(String name, double assets) {
        this.name = name;
        this.assets = assets;
 
	}
	
    public String getName() {
		return name;
	}

	public double getAssets() {
		return assets;
	}
}
