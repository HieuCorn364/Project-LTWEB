package corn.service.Impl;

import java.util.List;

import corn.entity.UserEntity;
import corn.repository.IUserRepository;
import corn.repository.Impl.UserRepositoryImpl;
import corn.service.IUserService;

public class UserServiceImpl implements IUserService {

	public IUserRepository userRepository = new UserRepositoryImpl(); 
	@Override
	public UserEntity findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	@Override
	public boolean checkLogin(String userName, String passWord) {
		List<UserEntity> list = userRepository.getUserByNameAndPassword(userName, passWord);
		return list.size() > 0 ? true : false;
	}
	
}
