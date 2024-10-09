package corn.service;

import corn.entity.UserEntity;

public interface IUserService {
	
	UserEntity findByUserName(String userName);
	boolean checkLogin(String userName, String passWord);
	boolean checkTrungTenDangNhap(String userName);
	void taoTaoKhoanMoi(String tenDangNhap,String matKhau, String hoVaTen,String gioiTinh,String diaChi,String dienThoai,String email);
	boolean checkEmail(String email);
	void changePass(String pass, String username);
}
