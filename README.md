# postgresql-jdbc-tester

A simple Spring Boot command line application to test JDBC connection to Postgresql database.

[![Maven Build Status](https://github.com/aimtiaz11/postgresql-jdbc-tester/actions/workflows/maven.yml/badge.svg)](https://github.com/aimtiaz11/postgresql-jdbc-tester/actions/workflows/maven.yml)


## How to run

Download the JAR from [release](https://github.com/aimtiaz11/postgresql-jdbc-tester/releases/tag/1.0) page or alternatively checkout the code from this repository and run:

```
mvn clean package
```

Execute the JAR file. Example below:

```
java -jar target/postgresql-jdbc-tester-1.0.jar "db_user" "db_pass" "jdbc:postgresql://mydb.postgres.database.azure.com:1234/databaseName"
```

> *Security Tip*: A good practice is to read the JDBC string into a variable using the `read` command in Linux to prevent DB credentials in JDBC string to be logged in bash history.

## How it works

To test the JDBC connection, the app will attempt to connect to Postgresql database and execute a single SQL query: `SELECT 1` and close connection.

## License
(The MIT License)

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

