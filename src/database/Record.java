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
	
	protected String getId() {
		return id;
	}

	protected String getNom() {
		return nom;
	}

	protected byte[] getImg() {
		return img;
	}

	@Override
	public String toString() {
		return String.format("%-20.30s  %-30.30s  %-20.30s  %-20.30s%n", this.getId(), this.getNom(), this.getImg(), this.getObjet());
	}

	protected byte[] getObjet() {
		return this.obj;
	}
	
}
