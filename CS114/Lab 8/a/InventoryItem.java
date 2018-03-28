package a;

public class InventoryItem implements Comparable<InventoryItem>{
	private String partNo;
	private String model;
	private String description;
	private double listPrice;

	public InventoryItem(String partNumber, String model, String part, double cost){
		this.partNo = partNumber;
		this.model = model;
		this.description = part;
		this.listPrice = cost;
	}

	public String PartNumber(){
		return partNo;
	}

	public String Model(){
		return model;
	}

	public String Part(){
		return description;
	}

	public Double Cost(){
		return listPrice;
	}

	public String toString(){
		return "Part Number: " + partNo + "\nModel: " + model + "\nDescription: " + description + "\nCost: " + listPrice
				+ "\n";
	}

	@Override
	public int compareTo(InventoryItem o){
		return partNo.compareTo(o.PartNumber()) + model.compareTo(o.Model()) + model.compareTo(o.Part());
	}

}
