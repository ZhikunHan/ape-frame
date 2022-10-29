package org.hantiv.redis.exception;

/**
 * @Author Zhikun Han
 * @Date Created in 11:13 2022/10/29
 * @Description:
 */
public class ShareLockException extends RuntimeException{

    public ShareLockException(String message){
        super(message);
    }

}
