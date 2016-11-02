package ua.lviv;

import java.sql.*;

public class DB
{
	private String url;
	private String login;
	private String password;
	
	public DB(String url, String login, String password)
	{
		this.url = url;
		this.login = login;
		this.password = password;
	}

	public ResultSet connect(String query)
	{
		try
		(
			Connection con=DriverManager.getConnection(url, login, password);
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
		)
		{
			while (rs.next())
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
			return rs;
		}
		catch (Exception e)
		{
			System.out.println("Error: Can't communicate with DB!");
			System.exit(0);
		}
		return null;
	}
}
