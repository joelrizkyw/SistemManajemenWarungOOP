package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Database.Connect;


public class Produk_Warung {

	ArrayList<Produk_Warung> produkList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	Connect con = Connect.getConnection();

	private String id_produk;
	private String nama_produk;
	private int stok_produk;
	private float harga_produk;
	private String tanggal_expired;
  
	
	



	public Produk_Warung(String id_produk, String nama_produk, int stok_produk, float harga_produk,
			String tanggal_expired) {
		super();
		this.id_produk = id_produk;
		this.nama_produk = nama_produk;
		this.stok_produk = stok_produk;
		this.harga_produk = harga_produk;
		this.tanggal_expired = tanggal_expired;
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

	public float getHarga_produk() {
		return harga_produk;
	}

	public void setHarga_produk(float harga_produk) {
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
	   
	   
	   Produk_Warung produk = new Produk_Warung(generateId(), nama_produk, stok_produk, harga_produk, tanggal_expired);
	   
	   
	   System.out.println();
	   
	   if(produkList.add(this)) {
		   System.out.print("Produk Berhasil Ditambahkan");
	   }
	   
	   Produk_Warung produk_Warung = new Produk_Warung(id_produk, nama_produk, stok_produk, harga_produk, tanggal_expired);
	   produk_Warung.insert();
	   System.out.println();
	}
	
	public void insert() {
		Connect con = Connect.getConnection();
		
		String query  = String.format(" INSERT INTO produk VALUES ('%s', '%s', '%d' , '%f', '%s' )", id_produk, nama_produk, stok_produk, harga_produk, tanggal_expired);
		con.executeUpdate(query);
	}
	
	public void edit_produk() {
		String id_produk;
		String nama_produk = null;
		int stok_produk = 0;
		float harga_produk = 0;
		String tanggal_expired = null;
		
		setStok_produk(stok_produk);
		setHarga_produk(harga_produk);
		
		System.out.println("Input ID produk yang diubah");
		id_produk = scan.nextLine();
		
		System.out.println("Input nama produk yang diubah");
		nama_produk = scan.nextLine();
		
		System.out.println("Input stok produk yang diubah");
		stok_produk = scan.nextInt();
		
		System.out.println("Input harga produk yang diubah");
		harga_produk = scan.nextFloat();
		
		System.out.println("Input tanggal expired produk yang diubah");
		tanggal_expired = scan.nextLine();
		
		String query = String.format("UPDATE produk '%s', '%s', '%d', '%f', '%s' WHERE id produk = '%s'", id_produk, nama_produk, stok_produk, harga_produk, tanggal_expired, id_produk);
	}
	
	public void hapus_produk() {
		String id_produk;
		System.out.println("Input Id Produk: ");
		id_produk = scan.nextLine();
		
		Connect con = Connect.getConnection();
		String query = String.format("DELETE FROM produk WHERE id_produk = '%s'", id_produk);
		con.executeUpdate(query);
		
		System.out.println("Produk berhasil dihapus");
		
	}
	
	public void load_produk()
	{
		String id_produk;
		String nama_produk;
		int stok_produk;
		float harga_produk;
		String tanggal_expired; 
		
		String query = "SELECT * FROM produk";
		
		Connect con = Connect.getConnection();
    	ResultSet rs = con.executeQuery(query);
    	
    	try {
    		while(rs.next()) {
    			id_produk = rs.getString("id_produk");
    		    nama_produk = rs.getString("nama_produk");
    		    stok_produk = rs.getInt("stok_produk");
    		    harga_produk = rs.getFloat("harga_produk");
    		    tanggal_expired = rs.getString("tanggal_expired");
    		    
    		    produkList.add(new Produk_Warung( id_produk, nama_produk, stok_produk, harga_produk, tanggal_expired));
    		}
    		}catch (SQLException e) {
    	    	e.printStackTrace();
    	}
	}
	
	public void lihat_produk()
	{
		
		load_produk();
		
		System.out.println("Lihat Produk");
	    System.out.println("=================================================================================");
	    System.out.println("| No | ID produk | Nama Produk | Stok Produk | Harga Produk | Tanggal Expired |");
		
		if(produkList.isEmpty())
		{
			System.out.println("List Produk Kosong");
			System.out.println("Tekan enter untuk lanjut..."); 
			scan.nextLine();
		}
		
		else
		{
			int i = 0;
			for(Produk_Warung  produk : produkList)
			{
				System.out.printf("| %d | %s | %s | %d | %.2f | %s | \n", i+1, produk.getId_produk(), produk.getNama_produk(), produk.getStok_produk(), produk.getHarga_produk(), produk.getTanggal_expired());
				i++;
			}
		}
	}	
	
	
	public void cari_produk()
	{
		String nama_produk;
		System.out.println("Ketik nama produk yang Ingin dicari");
	    nama_produk = scan.nextLine();
		
	    String query = String.format("SELECT * FROM produk WHERE nama_produk = '%s'", nama_produk);
	    
	    if(query.contains(nama_produk)) {
	    	System.out.println("Produk Tersedia");
	    }else {
	    	System.out.println("Produk Tidak Tersedia");
	    }
	}
}
