package com.appskimo.app.sample.controller;

import com.appskimo.app.sample.domain.dto.DummyDto;
import com.appskimo.app.sample.domain.dto.Page;
import com.appskimo.app.sample.service.ApiService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dominic.lee on 2017. 11. 23..
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiController {

    private final ApiService apiService;

    @ApiOperation(value = "데이터 조회")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "q[name]", value = "이름", paramType = "query"),
        @ApiImplicitParam(name = "q[phone]", value = "핸드폰", paramType = "query")
    })
    @GetMapping("data")
    public Object data(Page page) {
        return apiService.getDummies(page);
    }

    @ApiOperation(value = "사용자 저장")
    @PostMapping("user")
    public Object user(@RequestBody DummyDto dummyDto) {
        return apiService.save(dummyDto.getInstance());
    }

}
