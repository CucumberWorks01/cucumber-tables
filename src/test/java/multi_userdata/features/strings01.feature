
@stringtests
Feature: Tests string related tests in cucumber

Scenario: Test1 case insensitive gherkin
   Given perform get request "http://testurl:3000/topics"
   Given perform GET request "http://testurl:3000/topics"
   Given perform GET REQUEST "http://testurl:3000/topics"

Scenario: Test2 or conditions 
   Given we have to wait for 10 secs
   Given we have to wait for 10 seconds
   When I search for IND in Database
   When I search for USA in Database
   Then Something is not counted
   Then Something is counted
   When bulb has a value true
   When bulb has a value false
   When she sends the correct challenge solution
   When he sends the incorrect challenge solution


Scenario: ExampleTest 3 for json data type doc string
   Given some json data
      """json
         {
           "name":"rajeev singh",
           "skill":"QA-Automation"
         }
      """