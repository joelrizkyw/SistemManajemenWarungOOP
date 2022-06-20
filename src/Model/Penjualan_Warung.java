package Model;


public class Penjualan_Warung {
	
	private String id_penjualan, id_produk, id_pelanggan, tgl_pembelian;
	private int jumlah_produk;
	
    public Penjualan_Warung() {
		
	}
	
	public Penjualan_Warung(String id_penjualan, String id_produk, String id_pelanggan, String tgl_pembelian,
			int jumlah_produk) {
		super();
		this.id_penjualan = id_penjualan;
		this.id_produk = id_produk;
		this.id_pelanggan = id_pelanggan;
		this.tgl_pembelian = tgl_pembelian;
		this.jumlah_produk = jumlah_produk;
	}
	public String getId_penjualan() {
		return id_penjualan;
	}
	public void setId_penjualan(String id_penjualan) {
		this.id_penjualan = id_penjualan;
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
	public int getJumlah_produk() {
		return jumlah_produk;
	}
	public void setJumlah_produk(int jumlah_produk) {
		this.jumlah_produk = jumlah_produk;
	}

	

}
