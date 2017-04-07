# mybriefcase

## Database setup
* Install MySql
* Open the mybriefcasedb_mysql.sql or mybriefcasedb_mysql.mwb model.
* Follow [these](https://dev.mysql.com/doc/workbench/en/wb-forward-engineering-live-server.html) instructions to import the database into your local connection:

## Deploy to Apache Tomcat Server
### From Eclipse ide
* Right-click on the mybriefcase project and select 'Run as | Run on server'
* Create a new or use an existing tomcat server.
* Add the myBriefcase project to the server instance.
### From file system
* Drop the .war file into the tomcat webapps folder

Modify the server's context.xml file to include the following line inside the context tag:
```
<Resource name="jdbc/mybriefcase" auth="Container" type="javax.sql.DataSource"
	maxActive="100" maxIdle="30" maxWait="10000"
	username="mybriefcase_user" password="admin" 
	driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mybriefcasedb"/>
```

