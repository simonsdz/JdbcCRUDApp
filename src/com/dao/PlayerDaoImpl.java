package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Player;
import com.util.JdbcUtil;

//actual logic of interacting with database through JDBC
public class PlayerDaoImpl implements IPlayerDao {

	private Connection connection = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;

	// create operation
	@Override
	public Player addPlayer(Player player) {
		try {
			String insertQuery = "insert into india(name, age, team) values(?,?,?)";
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(insertQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, player.getName());
				prepareStatement.setInt(2, player.getAge());
				prepareStatement.setString(3, player.getTeam());

				int rowsAffected = prepareStatement.executeUpdate();
				if (rowsAffected == 1) {
					return player;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// delete operation
	@Override
	public Player deletePlayer(Integer playerID) {
		// TODO Auto-generated method stub
		String deleteQuery = "delete from india where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(deleteQuery);
			}
			if (prepareStatement != null) {
				Player player = new Player();
				prepareStatement.setInt(1, playerID);

				int rowsAffected = prepareStatement.executeUpdate();
				if (rowsAffected == 1) {
					return player;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// update Operation
	@Override
	public Player updatePlayer(Player player) {
		// TODO Auto-generated method stub
		String updateQuery = "update india set name = ?, age = ?, team = ? where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(updateQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, player.getName());
				prepareStatement.setInt(2, player.getAge());
				prepareStatement.setString(3, player.getTeam());
				prepareStatement.setInt(4, player.getId());

				int rowsAffected = prepareStatement.executeUpdate();
				if (rowsAffected == 1) {
					return player;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// read Operation
	@Override
	public Player searchPlayer(Integer playerID) {
		String searchQuery = "select id, name, age, team from india where id = ?";
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(searchQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, playerID);

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				Player player = new Player();
				if (resultSet.next()) {
					player.setId(resultSet.getInt(1));
					player.setName(resultSet.getString(2));
					player.setAge(resultSet.getInt(3));
					player.setTeam(resultSet.getString(4));

					return player;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
