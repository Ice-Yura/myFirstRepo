package ua.lviv;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Main
{
	private static DB db;
	private static ResultSet rs;
	private static List<User> list;
	
	public static void main(String[] args) throws SQLException, IOException
	{
		db=new DB("jdbc:mysql://localhost:3306/pavlyuk", "root", "123456");
		showAll();
//		showUsers("kyiv");
//		showCitys("vasyl");
//		parseAllUsers();
	}

	public static void parseAllUsers() throws SQLException
	{
		list=new ArrayList<>();
		rs=db.connect("select * from users;");
		while (rs.next())
			list.add(new User(rs.getString("name"),rs.getString("city")));
	}
	
	public static void showAll() throws SQLException
	{
		rs=db.connect("select * from users;");
		System.out.println("Users and City:");
		print();
	}
	
	public static void showUsers(String city) throws SQLException
	{
		rs=db.connect("select * from users where city='"+city+"';");
		System.out.println("Users from "+city+":");
		print();
	}
	
	public static void showCitys(String user) throws SQLException
	{
		rs=db.connect("select * from users where user='"+user+"';");
		System.out.println("Citys with user "+user+":");
		print();
	}
	
	private static void print() throws SQLException
	{
		while (rs.next())
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
	}

	public static List<User> getList()
	{
		return list;
	}
}
