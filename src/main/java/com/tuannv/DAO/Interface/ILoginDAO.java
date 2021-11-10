package com.tuannv.DAO.Interface;

import com.tuannv.Model.UserModel;

public interface ILoginDAO {
    UserModel findUser(String userName, String password);
}
