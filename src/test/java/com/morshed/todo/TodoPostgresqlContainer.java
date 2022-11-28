package com.morshed.todo;

import org.testcontainers.containers.PostgreSQLContainer;

public class TodoPostgresqlContainer extends PostgreSQLContainer<TodoPostgresqlContainer> {
    private static final String IMAGE_VERSION="postgres:9.6.12";
    private static TodoPostgresqlContainer container;
    private static String db_url = "jdbc:tc:postgresql:///todo";
    private static String db_username = "root";
    private static String db_password = "123456";

    private TodoPostgresqlContainer(){
        super(IMAGE_VERSION);
    }

    public static TodoPostgresqlContainer getInstance(){
        if(container == null){
            container = new TodoPostgresqlContainer()
                    .withDatabaseName("todo")
                    .withUsername(db_username)
                    .withPassword(db_password);
        }
        return container;
    }


    @Override
    public void start() {
        super.start();
        var urlStr = container.getJdbcUrl().replace("jdbc","jdbc:tc");
        System.setProperty("DB_URL", urlStr);
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        super.stop();
    }
}
