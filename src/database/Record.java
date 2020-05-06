package database;

public class Record {

	private String id;
	private String nom;
	private byte[] img;
	private byte[] obj;
	
	public Record() {
		this("0", "", null);
	}
	
	public Record(String n, byte[] b) {
		this.nom = n;
		this.img = b;
	}
	
	public Record(String number, String n, byte[] b) {
		this.id = number;
		this.nom = n;
		this.img = b;
	}
	
	public Record(String i, String n, byte[] b, byte[] obj) {
		this.id = i;
		this.nom = n;
		this.img = b;
		this.obj = obj;
	}
	
	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public byte[] getImg() {
		return img;
	}
	
	public String toString() {
		return String.format("%-20.30s  %-30.30s  %-20.30s%n", this.getId(), this.getNom(), this.getImg());
	}

	public byte[] getObjet() {
		return this.obj;
	}
	
}
