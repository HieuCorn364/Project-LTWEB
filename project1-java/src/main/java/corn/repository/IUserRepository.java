package corn.repository;

import java.util.List;

import corn.entity.UserEntity;

public interface IUserRepository {
	public UserEntity findByUserName(String userName);
	public List<UserEntity> getUserByNameAndPassword(String userName, String passWord);
	public boolean getUserNameToCheck(String userName);
	public void insertUser(UserEntity userEntity);
}
