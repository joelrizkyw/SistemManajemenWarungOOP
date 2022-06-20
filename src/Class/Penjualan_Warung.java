package Class;

public class Penjualan_Warung {
	
	private String id_produk, id_pelanggan, tgl_pembelian;
	private int jumlah;

	public Penjualan_Warung() {
		
	}

	public Penjualan_Warung(String id_produk, String id_pelanggan, String tgl_pembelian, int jumlah) {
		super();
		this.id_produk = id_produk;
		this.id_pelanggan = id_pelanggan;
		this.tgl_pembelian = tgl_pembelian;
		this.jumlah = jumlah;
	}

	public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public String getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public String getTgl_pembelian() {
		return tgl_pembelian;
	}

	public void setTgl_pembelian(String tgl_pembelian) {
		this.tgl_pembelian = tgl_pembelian;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	
	

}
