package com.fish.fishcenter.networkService;

import android.telecom.Call;


import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("login/{username}/{password}")
    Call login(@Path("username") String username, @Path("password") String password);
}