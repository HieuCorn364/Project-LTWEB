package corn.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import corn.config.MySQLConnection;
import corn.entity.UserEntity;
import corn.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository {
	public List<UserEntity> getUserByNameAndPassword(String userName, String passWord){
		List<UserEntity> users = new ArrayList<UserEntity>();
		Connection connection = MySQLConnection.getConnection();
		String query = "select * from user u where u.username = ? and u.password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserEntity user = new UserEntity();
				user.setId(resultSet.getLong("id"));
				user.setFullName(resultSet.getString("fullname"));
				user.setUserName(resultSet.getString("username"));
				user.setAge(resultSet.getLong("age"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public UserEntity findByUserName(String userName) {
		String sql = "SELECT * FROM User where username = ?";
		Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			UserEntity user = new UserEntity();
			while (resultSet.next()) {
				user.setId(resultSet.getLong("id"));
				user.setFullName(resultSet.getString("fullname"));
				user.setUserName(resultSet.getString("username"));
				user.setAge(resultSet.getLong("age"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
