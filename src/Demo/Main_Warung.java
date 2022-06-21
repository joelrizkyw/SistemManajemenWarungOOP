package Demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Database.Connect;
import Model.Pelanggan_Warung;
import Model.Penjual_Warung;
import Model.Produk_Warung;

public class Main_Warung {
 
	ArrayList<Pelanggan_Warung> pw = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Random r = new Random();
    

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
    
    public void lihat_pembeli()
    {
    	int i = 0;
    	
    	load_pembeli();
    	
    	System.out.println("==============");
    	System.out.println("LIST PEMBELI");
    	System.out.println("==============");
    	for (Pelanggan_Warung pw_var : pw) {
    		System.out.println("No. " + (i+1));
			System.out.println("ID Pembeli: " + pw_var.getId_pelanggan());
			System.out.println("Nama pembeli: " + pw_var.getNama_pelanggan());
			System.out.println("");
			i++;
		}
    }
    
    public void load_pembeli()
    {
    	String id_pembeli, nama_pembeli;
    	
    	Connect c = Connect.getConnection();
    	String query = "select * from pelanggan";
    	ResultSet rs = c.executeQuery(query);
    	
    	try {
			while(rs.next())
			{
				id_pembeli = rs.getString("id_pelanggan");
				nama_pembeli = rs.getString("nama_pelanggan");
				
				pw.add(new Pelanggan_Warung(id_pembeli, nama_pembeli));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void loginPembeli()
    {
    	String nama_pembeli;
    	
    	do {
			System.out.print("Masukkan nama: ");
			nama_pembeli = scan.nextLine();
		} while (nama_pembeli.length() <= 0);
    	
    	Connect c = Connect.getConnection();
    	String query = String.format("insert into pelanggan values ('%s', '%s')", generate_pembeli_id(), nama_pembeli);
    	c.executeUpdate(query);
    	
    	System.out.println("\n=============");
    	System.out.println("Data anda:");
    	System.out.println("=============");
    	System.out.println("ID Pembeli: " + generate_pembeli_id());
    	System.out.println("Nama: " + nama_pembeli);
    	
//    	lihat_pembeli();
    	
    }
    
    public String generate_pembeli_id()
    {
    	return "K" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);
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
    
                    loginPembeli();
                    break;
            }
            
            System.out.println();

		} while (input != 3);
        
        scan.close();
    }

    public static void main(String[] args) {
    	
    	// Test komentar buat github
        new Main_Warung();
    }
}
