package pe.edu.cibertec.spring_mvc_jyd.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HikariCpConfig {

    @Value("${DB_SAKILA_URL}")
    private String dbSakilaUrl;
    @Value("${DB_SAKILA_USER}")
    private String dbSakilaUser;
    @Value("${DB_SAKILA_PASSWORD}")
    private String dbSakilaPass;
    @Value("${DB_SAKILA_DRIVER}")
    private String dbSakilaDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        System.out.println("HikariDataSource Configured with URL: " + dbSakilaUrl);

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbSakilaUrl);
        config.setUsername(dbSakilaUser);
        config.setPassword(dbSakilaPass);
        config.setDriverClassName(dbSakilaDriver);

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println(config.getMaximumPoolSize());
        System.out.println("##### HikariCp initialized ######");
        return new HikariDataSource(config);

    }

}
