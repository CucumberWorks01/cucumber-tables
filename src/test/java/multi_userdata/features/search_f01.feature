# Author: Rajeev Singh
#"""
#sAMPLE EXAMPLE OF SHARE DATA BETWEEN STEPS IN SAME SCENARIO
#"""


Feature: Multiple Tests for single Data Tables tests

  # Scenario: Verify share data in steps
  #   Given on parabank home page
  #   When click on register
  #   Then new user page is open

  
  # Scenario: Verify single data table
      # Given on parabank home page
  #    When click on register
  #    Then new user page is open
  #    When enter data in form feilds as map
  #              |FirstName |LastName |City     |
  #              | Fasana   |darling  | NZ0001  |
  #    And wait for 5s
  #    And refresh browser page
  #    And wait for 5s
     
  
  Scenario: Verify exception when converting single data cell table to list
    #  Given on parabank home page
    #  When click on register
    #  Then new user page is open
     When enter data in form feilds as faker
               |FakerFirstName|FakerLastName|FakerCity|
    #  And wait for 5s
    # And refresh browser page

  Scenario: Verify data table cell as list
    When convert data table to list
            |FakerFirstName|
            |FakerLastName |
            |FakerCity     |

    When convert horizointal single cell data table to list
               |FakerFirstName|FakerLastName|FakerCity|

  @wip
  Scenario: Taking element screenshot
    Given on parabank home page
    When click on register
    And wait for 6s
    When take screenshot of desired element
    And attach screenshot
    





#   When enter data in form feilds as faker # multi_userdata.stepsDef.TableSteps.f2(io.cucumber.datatable.DataTable)      
#     | FakerFirstName | FakerLastName | FakerCity |
#       io.cucumber.datatable.UndefinedDataTableTypeException: Can't convert DataTable to List<java.lang.String>.
# Please review these problems:

#  - There was a table cell transformer for java.lang.String but the table was too wide to use it.
#    Please reduce the table width to use this converter.

#  - There was no table entry or table row transformer registered for java.lang.String.
#    Please consider registering a table entry or row transformer.

# Note: Usually solving one is enough
#         at io.cucumber.datatable.UndefinedDataTableTypeException.listNoConverterDefined(UndefinedDataTableTypeException.java:102)
#         at io.cucumber.datatable.DataTableTypeRegistryTableConverter.toList(DataTableTypeRegistryTableConverter.java:144)
#         at io.cucumber.datatable.DataTable.asList(DataTable.java:199)
#         at io.cucumber.datatable.DataTable.asList(DataTable.java:187)
#         at multi_userdata.stepsDef.TableSteps.f2(TableSteps.java:32)
#         at â?½.enter data in form feilds as faker(file:///E:/VS-Code%20Projects/shareStepData/table-data/src/test/java/multi_userdata/features/search_f01.feature:31)


