package corn.repository;

import corn.entity.UserEntity;

public interface IUserRepository {
	UserEntity findByUserName(String userName);
	UserEntity getUserByNameAndPassword(String userName, String passWord);
	boolean getUserNameToCheck(String userName);
	void insertUser(UserEntity userEntity);
	boolean getEmail(String email);
	void updatePassWord(String pass, String username);
}
