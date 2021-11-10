package com.tuannv.DAO.Interface;

import com.tuannv.Model.UserModel;

public interface ISignUpDAO {
    boolean signUp(UserModel user);
    boolean checkAccountExist(String userName);
}
