package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import model.GuitarSpec; 
import model.Inventory; 
import dbUtil.JDBCsqlite; 

 
 public class InventoryDao { 
 	public InventoryDao(){ 
 		 
	} 
 	 
 	public Inventory getAllGuitars() throws Exception{ 
 		 
 		JDBCsqlite jdbc =  new JDBCsqlite(); 
 		Connection connection = jdbc.connection; 
 		PreparedStatement ps = connection.prepareStatement("select * from Guitar"); 
 		Inventory inventory = new Inventory(); 
 		ResultSet rs = ps.executeQuery(); 
 		 
 		while(rs.next()){			 
 			inventory.addGuitar(rs.getString(1),rs.getDouble(2),rs.getString(4),rs.getInt(8), new GuitarSpec(rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7))); 
 		} 
 		if(rs != null){ 
 			rs.close(); 
 		} 
 		ps.close(); 
 		connection.close(); 
 
 
 		return (Inventory) Inventory.getGuitars(); 
 	} 
 
 
 } 

