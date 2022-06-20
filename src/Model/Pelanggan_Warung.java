package Model;

public class Pelanggan_Warung {
	
	private String id_pelanggan, nama_pelanggan;

	public Pelanggan_Warung() {
		// TODO Auto-generated constructor stub
	}

	public Pelanggan_Warung(String id_pelanggan, String nama_pelanggan) {
		super();
		this.id_pelanggan = id_pelanggan;
		this.nama_pelanggan = nama_pelanggan;
	}

	public String getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public String getNama_pelanggan() {
		return nama_pelanggan;
	}

	public void setNama_pelanggan(String nama_pelanggan) {
		this.nama_pelanggan = nama_pelanggan;
	}
	
}
