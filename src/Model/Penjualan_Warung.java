package Model;


public class Penjualan_Warung {
	
	private String id_pelanggan, id_produk, tgl_pembelian;
	private int jumlah_produk;
	
    public Penjualan_Warung() {
		
	}

	public Penjualan_Warung(String id_pelanggan, String id_produk, int jumlah_produk, String tgl_pembelian) {
		super();
		this.id_pelanggan = id_pelanggan;
		this.id_produk = id_produk;
		this.jumlah_produk = jumlah_produk;
		this.tgl_pembelian = tgl_pembelian;
	}

	public String getId_pelanggan() {
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) {
		this.id_pelanggan = id_pelanggan;
	}

	public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public int getJumlah_produk() {
		return jumlah_produk;
	}

	public void setJumlah_produk(int jumlah_produk) {
		this.jumlah_produk = jumlah_produk;
	}

	public String getTgl_pembelian() {
		return tgl_pembelian;
	}

	public void setTgl_pembelian(String tgl_pembelian) {
		this.tgl_pembelian = tgl_pembelian;
	}
	
	

}
