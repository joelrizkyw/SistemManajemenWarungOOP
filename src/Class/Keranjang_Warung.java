package Class;

public class Keranjang_Warung {
	
	private int id_produk, jumlah_produk;

	public Keranjang_Warung() {
		// TODO Auto-generated constructor stub
	}

	public Keranjang_Warung(int id_produk, int jumlah_produk) {
		super();
		this.id_produk = id_produk;
		this.jumlah_produk = jumlah_produk;
	}

	public int getId_produk() {
		return id_produk;
	}

	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}

	public int getJumlah_produk() {
		return jumlah_produk;
	}

	public void setJumlah_produk(int jumlah_produk) {
		this.jumlah_produk = jumlah_produk;
	}
}
