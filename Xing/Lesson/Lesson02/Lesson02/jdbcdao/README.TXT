This example demonstrates ORM mapping using JDBC - 

In order to Run this demo, you have to install MySQL Server
- MySQL 8 download link: https://downloads.mysql.com/archives/installer/
- Workbench download link: https://dev.mysql.com/downloads/workbench/

Not able to install MySQL 5.7 - cannot start the server in my Windows.

The data is explicitly mapped from the domain object to SQL...

Vehicle is implemented...

Notice @Autowired -- DataSource ... Environment used for accessing external properties

If you use H2, Use EmbeddedDatabaseBuilder to connect to H2, need to find a way to load vehicle.sql with datasource

