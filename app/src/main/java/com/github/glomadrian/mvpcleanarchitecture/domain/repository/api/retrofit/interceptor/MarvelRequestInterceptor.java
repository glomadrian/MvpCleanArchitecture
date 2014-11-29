package com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.retrofit.interceptor;

import android.util.Log;

import com.github.glomadrian.mvpcleanarchitecture.domain.LogUtils;
import com.github.glomadrian.mvpcleanarchitecture.domain.repository.api.ApiUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

import retrofit.RequestInterceptor;

/**
 * Interceptor to add the auth key, and generate the hash for every request
 * The data is exposed in the constructor
 *
 * @author glomadrian
 */
public class MarvelRequestInterceptor implements RequestInterceptor {


    private String publicKey;
    private String privateKey;

    public MarvelRequestInterceptor(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    @Override
    public void intercept(RequestFacade request) {
        String timeStamp = generateTimestamp();
        request.addEncodedQueryParam(ApiUtils.PARAM_TIMESTAMP, timeStamp);
        request.addEncodedQueryParam(ApiUtils.PARAM_KEY, publicKey);
        request.addEncodedQueryParam(ApiUtils.PARAM_HASH, generateMarvelHash(timeStamp, privateKey, publicKey));


    }

    private String generateTimestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return String.valueOf(timestamp.getTime());
    }


    private String generateMarvelHash(String timeStamp, String privateKey, String publicKey) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(timeStamp);
            stringBuilder.append(privateKey);
            stringBuilder.append(publicKey);

            byte[] bytes = stringBuilder.toString().getBytes();

            String md5 = new BigInteger(1, messageDigest.digest(bytes)).toString(16);

            return md5;

        } catch (NoSuchAlgorithmException e) {
            Log.e(LogUtils.generateTag(this), " Hash type not found");
            return "invalid";
        }
    }

}
