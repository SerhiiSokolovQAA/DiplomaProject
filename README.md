# DiplomaWork

#  To run all scenarios from feature file in one thread:

mvn clean test -Dtest=TestRunner "-Dcucumber.filter.tags=Tag from feature file" -Ddataproviderthreadcount=1

#  To run specific scenario from feature file in one thread:

mvn clean test -Dtest=TestRunner "-Dcucumber.filter.tags=Scenario tag" -Ddataproviderthreadcount=1

#  To run all scenarios from feature file in a specific number of threads:

mvn clean test -Dtest=TestRunner "-Dcucumber.filter.tags=Tag from feature file" -Ddataproviderthreadcount=number of threads

#  To run all specific scenarios from feature file in a specific number of threads:

mvn clean test -Dtest=TestRunner "-Dcucumber.filter.tags=Scenario tag #1 or Scenario tag #2" -Ddataproviderthreadcount=1

#    Run allure report:

- allure serve allure-results

