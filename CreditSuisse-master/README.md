## Coding Assignment
# Pre Requisites
In order to run this program you will need to first have Java 1.8 installed on your machine and have previously set up 
gradle so that you can use the gradle command.

You can check for these requirements by using the commands:

gradle -v

java -version


### Run The Program

cd CreditSuisse-master and run the command 
gradle run --args='logfile.txt' which will build and run the program with the log file to be parsed being 
logfile.txt which is a sample file

In order to run with a different logfile you just need to move the log file into the CreditSuisse directory and replace 
**logfile.txt** with the new file name in the aforementioned command or give a relative path to the logfile that you 
would like to be parsed.

Logging output from the program can be found in Logs.txt

# Notes
* `SELECT * FROM Events` statement which reads all table entries and logs the alerts in debug mode. 
Also added  
 `DELETE FROM Events` method to clear the table before closing the connection.

