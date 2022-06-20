package Model;

import java.util.*;

public class Penjual_Warung {
	
	ArrayList<Penjual_Warung> penjualList = new ArrayList<>();
    
    private String id_penjual;
    private String username;
    private String password;

	public String getId_penjual() {
		return id_penjual;
	}

	public void setId_penjual(String id_penjual) {
		this.id_penjual = id_penjual;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String generateId() {
		
		String id = "A";
		int min = 0;
		int max = 9;
		
		Random random = new Random();
		
		int num1 = random.nextInt((max - min) + 1) + min;
		int num2 = random.nextInt((max - min) + 1) + min;
		int num3 = random.nextInt((max - min) + 1) + min;
		
		// A098
		id = id + num1 + num2 + num3;
		
		return id;
	}
    
	public void setDataPenjual() {
		
		setId_penjual(generateId());
		setUsername("admin");
		setPassword("admin1234");
		
		penjualList.add(this);
	}
	
	public ArrayList<Penjual_Warung> getDataPenjual() {
		
		return penjualList;
	}
}
