package com.app.mapper;

import com.app.pojo.DevUser;

public interface DevMapper {
    DevUser doLogin(String devCode,String devName);
}
