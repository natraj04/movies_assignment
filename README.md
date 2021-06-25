Overview:
  In this project we are using selenide (selenide is a open source test automation tool that is wrapper aroung selenium more details on this can be found in
https://selenide.org/). Along with selenide i have integrated it with testng framework.

The design patteren used is Page Object Model combined with page factory. For reporting i have integrated extent reporter.

Tools/software needed:
- Java 1.7 or above
- maven 3.6 or above for building the prject
- IDE (eclipse/ intelliJ) any java supported IDE
- Web Browsers

How to run a tests?

1. Clone this repo using git bash or git cli
   Command: 
    - open git bash in a new folder
    - git clone https://github.com/natraj04/movies_assignment.git
    - git checkout master -> (this step has to be done since code is present in master branch not in main branch)
2. open the repo in eclipse or InteliiJ or anyother java IDE
3. On the root folder you will see somthing called Suites -> under which you will have full_suite.xml which currently has all 3 testcases
    ![image](https://user-images.githubusercontent.com/49331044/123371555-9e764700-d59f-11eb-89e7-b5575e41ee75.png)
    - With help of xml we have the ability to control few parts of the execution
    - Which browser do you want to test on? chrome/safari/firefox (not you would need to have the browsers installed on to the system, driver is not manditory)
    - Number of threads: this specifies the count of browsers spawned i.e. do you want to run the tests on single thread (sequentual) or multi thread(parellel execution)
    - Reporting: to take screen shot on pass/fail/default this screenshot will be attched with the report based on this configuration attached a sample report zip [surefire-reports.zip](https://github.com/natraj04/movies_assignment/files/6713626/surefire-reports.zip)

We can also execute the tests individually from each testcase via testNg
