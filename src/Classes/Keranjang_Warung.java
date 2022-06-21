package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Database.Connect;
import Model.Produk_Warung;

public class Keranjang_Warung {
	
	private String id_pelanggan, id_produk;
	private int jumlah_produk;
	
	ArrayList<Keranjang_Warung> listKeranjang = new ArrayList<>();

	public Keranjang_Warung() {
		// TODO Auto-generated constructor stub
	}

	public Keranjang_Warung(String id_pelanggan, String id_produk, int jumlah_produk) {
		super();
		this.id_pelanggan = id_pelanggan;
		this.id_produk = id_produk;
		this.jumlah_produk = jumlah_produk;
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

	public void tambahKeranjang() {
		
		listKeranjang.add(new Keranjang_Warung(getId_pelanggan(), getId_produk(), getJumlah_produk()));
	}
	
	public void hapusKeranjang(int index) {
		
		listKeranjang.remove(index);
	}
	
	public void ubahKeranjang(int index, String idProduk, String idPelanggan, int jumlahProduk) {
		
		Keranjang_Warung choosenData = listKeranjang.get(index);
		
		choosenData.setId_produk(idProduk);
		choosenData.setId_pelanggan(idPelanggan);
		choosenData.setJumlah_produk(jumlahProduk);
	}
	
	public void tampilKeranjang() {
		
		Produk_Warung produk = null;
		
		System.out.println("Keranjang " + id_pelanggan);
		System.out.println("==============");
		System.out.println("| No | Nama Produk | Jumlah | Harga |");
		
		for(int i = 0; i < listKeranjang.size(); i++) {
			
			produk = Produk_Warung.getDataProduk(getId_produk());
			 
			System.out.printf("| %d | %s | %d | %s |\n", i + 1, produk.getNama_produk(), getJumlah_produk(), "Rp. " +  produk.getHarga_produk());
		}
	}
	
}
