import com.google.common.base.Stopwatch;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.concurrent.TimeUnit;


public class Main {
    final static Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BasicConfigurator.configure();

        if (args.length != 3) {
            LOG.info("Invalid number of arguments: Must provide 3 arguments to the program.");
            return;
        }

        String username = args[0];
        String password = args[1];
        String jdbcString = args[2];
        
    
        Class.forName("org.postgresql.Driver");

        System.out.println("\n##### Starting JDBC connection test. Test ID: " + java.util.UUID.randomUUID() + "\n");
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Connection connection = DriverManager.getConnection(jdbcString, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT 1";
            LOG.info("Running Query: " + query);
            ResultSet resultSet = statement.executeQuery(query);

             
            if (resultSet.next()) {
                LOG.info("Database connection successful!!");
                LOG.info("Result of Query: " + resultSet.getString(1) );
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            LOG.info("Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            throw e;
        }
        LOG.info("Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("##### End of test \n\n");



    }



}

