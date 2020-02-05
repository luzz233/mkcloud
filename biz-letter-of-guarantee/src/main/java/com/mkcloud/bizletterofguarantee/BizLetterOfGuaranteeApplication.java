package com.mkcloud.bizletterofguarantee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mkcloud.bizletterofguarantee.mapper")
public class BizLetterOfGuaranteeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizLetterOfGuaranteeApplication.class, args);
    }

}
