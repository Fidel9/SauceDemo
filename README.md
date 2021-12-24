#CHECKLIST

 loginPagesTest
 input: mvn clean test -DsuiteXmlFile='src/test/resources/regression.xml'
 output: 
 [INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 304.07 s - in TestSuite
 
 [INFO] Results:

 [INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
 
 [INFO] ------------------------------------------------------------------------
 [INFO] BUILD SUCCESS
 [INFO] ------------------------------------------------------------------------
 [INFO] Total time:  05:52 min
 [INFO] Finished at: 2021-12-24T12:01:11+03:00
 [INFO] ------------------------------------------------------------------------


 ProductsCriticalPathTest
 input:  mvn clean test -DsuiteXmlFile='src/test/resources/regression.xml'
 output:
 Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 61.086 s - in TestSuite
 [INFO] Results:

 [INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
 [INFO] ------------------------------------------------------------------------
 [INFO] BUILD SUCCESS
 [INFO] ------------------------------------------------------------------------
 [INFO] Total time:  01:17 min
 [INFO] Finished at: 2021-12-24T12:13:02+03:00


  команда для просмотра доступных
  обновлений библиотек:
  mvn versions:display-dependency-updates
  [INFO] --- versions-maven-plugin:2.8.1:display-dependency-updates (default-cli) @ SauceDemo ---
  [INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central
  [INFO] artifact org.testng:testng: checking for updates from central
  [INFO] artifact io.github.bonigarcia:webdrivermanager: checking for updates from central
  [INFO] No dependencies in Dependencies have newer versions.
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  37.894 s
