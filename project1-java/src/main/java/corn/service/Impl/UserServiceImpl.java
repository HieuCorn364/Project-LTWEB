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
		UserEntity userEntity = userRepository.getUserByNameAndPassword(userName, passWord);
		return userEntity != null ? true : false;
	}
	@Override
	public boolean checkTrungTenDangNhap(String userName) {
		userRepository.getUserNameToCheck(userName);
		return false;
	}
	@Override
	public void taoTaoKhoanMoi(String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh, String diaChi,
			String dienThoai, String email) {
		UserEntity userEntity = new UserEntity(hoVaTen, tenDangNhap, matKhau, gioiTinh, dienThoai, diaChi, email);
		userRepository.insertUser(userEntity);
	}
	
}
