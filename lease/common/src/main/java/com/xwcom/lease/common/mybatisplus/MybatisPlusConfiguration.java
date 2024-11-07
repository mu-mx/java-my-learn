package com.xwcom.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @date 2024/11/7
 */
@Configuration
@MapperScan("com.xwcom.lease.web.*.mapper")
public class MybatisPlusConfiguration {

}
