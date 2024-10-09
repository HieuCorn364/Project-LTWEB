package corn.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import corn.config.MySQLConnection;
import corn.entity.UserEntity;
import corn.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository {
	public UserEntity getUserByNameAndPassword(String userName, String passWord) {
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
				return user;
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
		return null;
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

	@Override
	public boolean getUserNameToCheck(String userName) {
		boolean ketQua = false;
		Connection con = MySQLConnection.getConnection();
		try {
			
			String sql = "SELECT * FROM user WHERE username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ketQua = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ketQua;
	}

	@Override
	public void insertUser(UserEntity userEntity) {
		try {
			Connection con = MySQLConnection.getConnection();
			String sql = "INSERT INTO user (username, password, fullname, sex, address, phone, email) "
					+ " VALUES (?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userEntity.getUserName());
			st.setString(2, userEntity.getPassWord());
			st.setString(3, userEntity.getFullName());
			st.setString(4, userEntity.getSex());
			st.setString(5, userEntity.getAddress());
			st.setString(6, userEntity.getPhone());
			st.setString(7, userEntity.getEmail());
			st.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean getEmail(String email) {
		boolean ketQua = false;
		Connection con = MySQLConnection.getConnection();
		try {
			
			String sql = "SELECT * FROM user WHERE email=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ketQua = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ketQua;
	}

	@Override
	public void updatePassWord(String pass, String username) {
		try {
			Connection con = MySQLConnection.getConnection();
			String sql = "UPDATE user SET password = ? WHERE username = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pass);
			st.setString(2, username);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
