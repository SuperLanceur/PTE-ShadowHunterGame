package database;

public class Record {

	private int id;
	private String nom;
	private byte[] img;
	
	public Record() {
		this(0, null, null);
	}
	
	public Record(String n, byte[] b) {
		this(0, n, b);
	}
	
	public Record(String number, String n, byte[] b) {
		this(Integer.parseInt(number), n, b);
	}
	
	public Record(int i, String n, byte[] b) {
		this.id = i;
		this.nom = n;
		this.img = b;
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

	
}
