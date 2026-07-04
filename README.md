# Tichi Web Application – QA Technical Assignment

## Candidate
**Name:** Subalakshmi Mohanasundaram  
**Role:** QA Intern Technical Assignment  
**Application Under Test:** Tichi Web Application  
**Environment:** Staging  
**Application URL:** https://tichi-app-webapp-stage.web.app/login  

---

## Project Overview

This repository contains my QA technical assignment for the Tichi Web Application. The work covers manual testing, defect reporting, Selenium automation testing, and execution evidence for the Login and Sign Up functionality.

The objective of this assignment was to analyze the application, identify important test scenarios, report defects clearly, and automate selected high-priority login test cases.

---

## Application Modules Covered

- Login
- Email Address Validation
- Password Step
- Sign Up Redirection
- Sign Up Email Prefill and Read-Only Validation
- Forgot Password Flow

---

## Tasks Completed

### Task 1 – Test Case Creation

Created detailed manual test cases for Login, Sign Up, and Forgot Password functionality.

The test cases include:
- Positive test scenarios
- Negative test scenarios
- UI validation
- Functional validation
- Navigation validation
- Regression test coverage

File location: `Task1_Test_Cases`

---

### Task 2 – Defect Reporting

Created defect reports for the following issues:

1. Login page accepts an invalid email format such as `zxy@in`.
2. Login page accepts an invalid special-character email format such as `!#$@in.in`.

Each defect report includes:
- Defect ID
- Summary
- Steps to reproduce
- Expected result
- Actual result
- Severity and priority
- Environment details
- Attachments and screenshots

File location: `Task2_Defect_Reports`

---

### Task 3 – Automation Testing

Automated selected Login page test scenarios using Selenium WebDriver with Java.

Automated scenarios:
1. Verify Email Address field is displayed
2. Verify Continue button is displayed
3. Verify Continue button is enabled and clickable
4. Verify Email Address field is mandatory
5. Verify invalid email without `@` symbol is rejected
6. Verify email with missing domain is rejected
7. Verify email with incomplete domain is rejected
8. Verify registered email opens password step
9. Verify unregistered email redirects to Sign Up page
10. Verify email is prefilled and read-only on Sign Up page

File location: `Task3_Automation_Testing`

---

### Task 4 – Test Execution Evidence

Automation execution evidence is included as screenshots showing the Selenium console output and test results.

File location: `Task4_Test_Execution_Evidence`

---

## Tools and Technologies Used

- Manual Testing
- Selenium WebDriver
- Java 17
- Maven
- Eclipse IDE
- Google Chrome
- Microsoft Excel
- Microsoft Word
- GitHub

---

## Key Learning Outcomes

Through this assignment, I learned how to:

- Analyze functional requirements and application behavior
- Create structured manual test cases
- Differentiate positive, negative, UI, functional, and regression test scenarios
- Identify and document defects with proper severity and priority
- Use Selenium WebDriver with Java for basic UI automation
- Locate web elements using XPath and CSS selectors
- Execute automation scripts and interpret console results
- Organize QA deliverables professionally in a GitHub repository

---

## Conclusion

This assignment gave me practical exposure to the end-to-end QA process, from test case design and defect reporting to automation testing and execution evidence. It also helped me understand how manual testing and automation testing work together to improve software quality.
