package database;

public class Record {

	private int id;
	private String nom;
	private byte[] img;
	private byte[] objetJava;
	
	public Record() {
		this(0, null, null, null);
	}
	
	public Record(String n, byte[] b) {
		this(0, n, b);
	}
	
	public Record(String number, String n, byte[] b) {
		this(Integer.parseInt(number), n, b);
	}
	
	public Record(String number, String n, byte[] b, byte[] o) {
		this(Integer.parseInt(number), n, b, o);
	}
	
	public Record(int i, String n, byte[] b) {
		this(i, n, b, null);
	}
	
	public Record(int i, String n, byte[] b, byte[] o) {
		this.id = i;
		this.nom = n;
		this.img = b;
		this.objetJava = o;
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public byte[] getImg() {
		return img;
	}
	
	public byte[] getObjetJava() {
		return objetJava;
	}

	@Override
	public String toString() {
		return String.format("%-20.30s  %-30.30s  %-20.30s  %-20.30s%n", this.getId(), this.getNom(), this.getImg(), this.getObjetJava());
	}
	
}
