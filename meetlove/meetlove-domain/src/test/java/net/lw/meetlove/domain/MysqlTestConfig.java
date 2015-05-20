package net.lw.meetlove.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource(value="classpath:/net/lw/meetlove/domain/meetlove-mysql.xml")
public class MysqlTestConfig {

}
