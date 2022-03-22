package databases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

	private Properties props = new Properties();
	private HikariConfig config = new HikariConfig(props);
	private HikariDataSource ds;

	private DataSource() {
		//config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		config.setUsername("postgres");
		config.setPassword("wabec");
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/demodb");
		ds = new HikariDataSource(config);

	}

	private static DataSource instance = new DataSource();
	
	public static DataSource getInstance() {
		return instance;
	}
	
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();

	}
	
	
}