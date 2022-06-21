package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Database.Connect;

public class Produk_Warung {

	ArrayList<Produk_Warung> produkList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	private String id_produk;
	private String nama_produk;
	private int stok_produk;
	private double harga_produk;
	private String tanggal_expired;

	public ArrayList<Produk_Warung> getProdukList() {
		return produkList;
	}

	public void setProdukList(ArrayList<Produk_Warung> produkList) {
		this.produkList = produkList;
	}

	public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public String getNama_produk() {
		return nama_produk;
	}

	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}

	public int getStok_produk() {
		return stok_produk;
	}

	public void setStok_produk(int stok_produk) {
		this.stok_produk = stok_produk;
	}

	public double getHarga_produk() {
		return harga_produk;
	}

	public void setHarga_produk(double harga_produk) {
		this.harga_produk = harga_produk;
	}

	public String getTanggal_expired() {
		return tanggal_expired;
	}

	public void setTanggal_expired(String tanggal_expired) {
		this.tanggal_expired = tanggal_expired;
	}
	
	public String generateId() {
		
		String id = "P";
		int min = 0;
		int max = 9;
		
		Random random = new Random();
		
		int num1 = random.nextInt((max - min) + 1) + min;
		int num2 = random.nextInt((max - min) + 1) + min;
		int num3 = random.nextInt((max - min) + 1) + min;
		
		// P098
		id = id + num1 + num2 + num3;
		
		return id;
	}
    
	public void tambah_produk(){
		
	   String nama_produk;
	   int stok_produk;
	   float harga_produk;
	   String tanggal_expired;
	   
	   String tanggalPattern = "^\\d{2}/\\d{2}/\\d{4}$";
	   
	   System.out.println("Tambah Produk");
       System.out.println("===========================");
	   	   
	   do{
		   System.out.print("Masukkan Nama Produk: ");
		   nama_produk = scan.nextLine();
		   
	   } while(nama_produk.length() <= 0 );

	   do{
		   System.out.print("Masukkan Stok Produk: ");
		   stok_produk = scan.nextInt();
		   scan.nextLine();
		   
	   } while(stok_produk <= 0);

	   do{
		   System.out.print("Masukkan Harga Produk: ");
		   harga_produk = scan.nextFloat();
		   scan.nextLine();
		   
	   } while(harga_produk <= 0);

	   do{
		   System.out.print("Masukkan Tanggal Expired Produk [ - | dd/mm/yyyy ]: ");
		   tanggal_expired = scan.nextLine();
		   
	   } while(!tanggal_expired.equals("-") && !tanggal_expired.matches(tanggalPattern));
       
	   setId_produk(generateId());
	   setNama_produk(nama_produk);
	   setStok_produk(stok_produk);
	   setHarga_produk(harga_produk);
	   setTanggal_expired(tanggal_expired);
	   
	   System.out.println();
	   
	   if(produkList.add(this)) {
		   
		   System.out.print("Produk Berhasil Ditambahkan");
	   }
	   
	   System.out.println();
	}
	
	public void lihat_produk()
	{
		
		System.out.println("Lihat Produk");
	    System.out.println("===========================");
		
		if(produkList.isEmpty())
		{
			System.out.println("List Produk Kosong");
			System.out.println("Tekan enter untuk lanjut..."); 
			scan.nextLine();
		}
		
		else
		{
			
			for(int i=0; i < produkList.size(); i++)
			{
				System.out.println("ID Produk: " + produkList.get(i).getId_produk());
				System.out.println("Nama Produk: " + produkList.get(i).getNama_produk());
				System.out.println("Stok Produk: " + produkList.get(i).getStok_produk());
				System.out.println("Harga Produk: " + produkList.get(i).getHarga_produk());
				System.out.println("Tanggal Expired: " + produkList.get(i).getTanggal_expired());
				System.out.println();
			}
		}
	}

	public static Produk_Warung getDataProduk(String id_produk) {
		// TODO Auto-generated method stub
		
		Produk_Warung produk = new Produk_Warung();
		
		Connect con = Connect.getConnection();
		String query = String.format("SELECT * FROM produk WHERE id_produk = '?'", id_produk);
		ResultSet rs = con.executeQuery(query);
		
		try {
			
			while(rs.next()) {
				
				produk.setId_produk(rs.getString("id_produk"));
				produk.setNama_produk(rs.getString("nama_produk"));
				produk.setStok_produk(rs.getInt("stok_produk"));
				produk.setHarga_produk(rs.getDouble("harga_produk"));
				produk.setTanggal_expired(rs.getString("tanggal_expired"));
				
			}
			
			return produk;
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}	
}
