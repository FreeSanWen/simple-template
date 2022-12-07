package cn.penguin.common.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author wensy
 * @since 2022/12/7 9:35
 */
@Slf4j
@Component
public class StartRunner implements ApplicationRunner {

    @Resource
    private DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.queryForMap("select 1 from dual");
        } catch (DataAccessException e) {
            log.warn("{}初始化数据库连接报错:", e);
        } catch (Exception e) {
            log.warn("{}初始化数据库连接报错:", e);
        }
    }
}
