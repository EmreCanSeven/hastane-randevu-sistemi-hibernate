package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;

public class DbOperations2 {


	public Connection baglan() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/deneme?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "mysql1071");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public void insertEt(String adi, String soyadi, int salary) {

		Connection con = baglan();

		
		Statement myStat2 = null;

		try {
			myStat2 = (Statement) con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String calistirilacakString = "INSERT into calisanlar.yonetici(  adi, soyadi, salary)  values ( '"+adi+"'," + "'"+soyadi+"'," + salary + ")";
		

		try {
			int myRs2 = myStat2.executeUpdate(calistirilacakString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public void veriTabanindanSil(String adi, String soyadi, int salary) {

		Connection con = baglan();
		
		Statement myStat2 = null;

		try {
			myStat2 = (Statement) con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String silinecekString = "delete from calisanlar.yonetici  where adi='"+adi+"' and soyadi='" + soyadi + "' and  salary=" +salary + "" ;
		

		try {
			int myRs2 = myStat2.executeUpdate(silinecekString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	

}
//	public void insertOrnegi() {
//		insertEt("David", "Copperfield", 3500);
//	}
	
//	public static int topla(int birinciDeger,int ikinciDeger) {
//		
//		int toplam = 0;
//		
//		toplam = birinciDeger + ikinciDeger;
//		
//		return toplam;
//		
//	}
//
//	public static String stringBirlestir(String birinciString,String ikinciString) {
//		
//		String donulenDeger = "";
//		
//		donulenDeger = birinciString + " " + ikinciString;
//		
//		
//		
//		String strIleIntinToplami = donulenDeger + topla(3,5);
//		
//		return strIleIntinToplami;
//	
//	}

//	public String stringKaristir(String birinciStr, String ikinciStr, String ucuncuStr) {

		//3.gelen stringi baþa yaz--
		//3. den sonra ; koy
		//1. ve 2. stringi aralarýna 1 tane boþluk koyup birleþtirip yukardaki 3.stringin sonuna eklesin
		//geriye bu deðeri dönsün
		//örnek cihan,adil,seven --> seven;cihan adil


//		String sonCumle = "";

	//	sonCumle = ucuncuString + ";" + birinciString + " " +ikinciString;

//		String birVeIkininBirlesimi = stringBirlestir(birinciStr, ikinciStr);
//		
//		sonCumle = ucuncuStr + ";" + birVeIkininBirlesimi;
//		
//		return sonCumle;
//	}
//	
//	public static void main(String[] args) {
//
//		DbOperations dbOperations = new DbOperations();
//		
//		String s1 = "emre";
//		String s2 = "cihan";
//		
//		String s3 = "mehmet";
//		String s4 = "kemal";
//		
//
//		String s5 = "ayhan";
//		String s6 = "ýsýk";
//		
////		String deneme = dbOperations.stringBirlestir("emre","cihan");
//		String deneme = dbOperations.stringBirlestir(s1, s2);
//		String deneme2 = dbOperations.stringBirlestir(s3, s4);
//		String deneme3 = dbOperations.stringBirlestir(s5, s6);
//		
//		
//		System.out.println(deneme); //emre cihan
//		System.out.println(deneme2); //mehmet kemal
//		System.out.println(deneme3);
//		
		
//		String s1="emre";
//		String s2="sevennn";
//		
//		String deneme = stringBirlestir(s1, s2);
//		
//		System.out.println(deneme);
		
//		String denemeX = dbOperations.stringKaristir("mehmet","kemal","hasan"); //hasan;mehmet kemal
//		System.out.println(denemeX);



//	}
//
//}
