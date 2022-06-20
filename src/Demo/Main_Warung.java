package Demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Database.Connect;
import Model.Penjual_Warung;
import Model.Penjualan_Warung;
import Model.Produk_Warung;

public class Main_Warung {
 
    Scanner scan = new Scanner(System.in);
    

	public void showMenuUtama() {

        System.out.println("Menu Manajemen Warung");
        System.out.println("===========================");
        System.out.println("1. Login Penjual");
        System.out.println("2. Login Pembeli");
        System.out.println("3. Exit");
        System.out.print(">> ");
    }

    public void showMenuPenjual() {

        System.out.println("Menu Penjual (Status: Logged In)");
        System.out.println("===========================");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Edit Produk");
        System.out.println("3. Hapus Produk");
        System.out.println("4. Lihat Produk");
        System.out.println("5. Lihat Penjualan");
        System.out.println("6. Log Out Penjual");
        System.out.print(">> ");
    }

    public void loginPenjual() {

        String userInput = "";
        String passInput = "";
        int input = 0;
    	
    	String username = "";
    	String password = "";
    	
    	Penjual_Warung penjual = new Penjual_Warung();
    	Produk_Warung produk = new Produk_Warung();
    	
    	penjual.setDataPenjual();
    	
    	username = penjual.getDataPenjual().get(0).getUsername();
    	password = penjual.getDataPenjual().get(0).getPassword();
    	
    	System.out.println("Login Penjual");
        System.out.println("===========================");
    	
    	do {

            System.out.print("Input username [ admin ]: ");

            userInput = scan.nextLine();

        } while(!userInput.equals(username));

        do {

            System.out.print("Input password [ admin1234 ]: ");

            passInput = scan.nextLine();

        } while(!passInput.equals(password));
        
        System.out.println("Login Sukses !");
        System.out.println();
        
        do {
        	
        	showMenuPenjual();
        	
        	input = scan.nextInt();
        	scan.nextLine();
        	
        	switch(input) {
        	
	        	case 1:
	        		
	        		System.out.println();
	        		produk.tambah_produk();
	        		break;
	        	case 2:
	        		
	        		break;
	        	case 3:
	        		
	        		break;
	        	case 4:
	        		
	        		System.out.println();
	        		produk.lihat_produk();
	        		break;
	        	case 5:
	        		
	        		
	        		break;
        	}
        	
        	System.out.println();
        	
        } while(input != 6);
        
        System.out.println("Log out penjual sukses !");
        System.out.println();
    }

    public void showPembeliMenu() {

    }
	
    public Main_Warung() {

        int input = 0;

    	do {
            
			showMenuUtama();

            input = scan.nextInt();
            scan.nextLine();

            switch(input) {

                case 1:
                    
                    System.out.println();
                    loginPenjual();
                    break;
                case 2:
    
                    //loginPembeli();
                    break;
            }
            
            System.out.println();

		} while (input != 3);
        
        scan.close();
    }
    
    //Lihat transaksi penjualan
    public ArrayList<Penjualan_Warung> getPenjualan(){
    	ArrayList<Penjualan_Warung> penjualan = new ArrayList<>();
    	try {
			String query = "SELECT `id_pelanggan`, `id_produk`, `jumlah_produk`, `tanggal_pembelian`"
					+ "FROM `Penjualan`";
			ResultSet res = Connect.getConnection().executeQuery(query);
			String id_pelanggan, id_produk, tanggal_pembelian;
			Integer jumlah_produk;
			while(res.next()) {
				id_pelanggan = res.getString("id_pelanggan");
				id_produk = res.getString("id_produk");
				jumlah_produk = res.getInt("jumlah_produk");
				tanggal_pembelian = res.getString("tanggal_pembelian");
				penjualan.add(new Penjualan_Warung(id_pelanggan, id_produk, jumlah_produk, tanggal_pembelian));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return penjualan;
    }
    
    

    public static void main(String[] args) {
    	
    	// Test komentar buat github
        new Main_Warung();
    }
}
