package com.snk.web.controller.api;

import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 人脸接口
 * 
 * @author snk
 */
@Api("人脸接口")
@RestController
@RequestMapping("/api/face")
public class FaceController extends BaseController
{

    private static final Logger log = LoggerFactory.getLogger(FaceController.class);

    @PostMapping()
    public AjaxResult heart(HttpServletRequest request, HttpServletResponse response)
    {
        log.info("心跳.....................");
        return AjaxResult.success();
    }

}
