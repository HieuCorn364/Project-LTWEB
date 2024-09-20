package corn.service;

import corn.entity.UserEntity;

public interface IUserService {
	
	public UserEntity findByUserName(String userName);
	public boolean checkLogin(String userName, String passWord);
	public boolean checkTrungTenDangNhap(String userName);
	public void taoTaoKhoanMoi(String tenDangNhap,String matKhau, String hoVaTen,String gioiTinh,String diaChi,String dienThoai,String email);
}
