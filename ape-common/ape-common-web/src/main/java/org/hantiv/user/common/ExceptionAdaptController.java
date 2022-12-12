package org.hantiv.demo.common;

import org.hantiv.demo.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Zhikun Han
 * @Date Created in 9:25 2022/8/17
 * @Description:
 */
@RestControllerAdvice
public class ExceptionAdaptController {

    @ExceptionHandler({RuntimeException.class})
    public Result runTimeException(RuntimeException e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }
}
