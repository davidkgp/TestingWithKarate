Feature: Testing a REST API with Karate

Scenario: Testing valid GET endpoint
  Given url 'http://localhost:8097/get/student/34'
  When method GET
  Then status 200

Scenario: Testing an invalid GET endpoint - 404
  Given url 'http://localhost:8097/user/wrong'
  When method GET
  Then status 404

Scenario: Testing an valid GET endpoint - with data
  Given url 'http://localhost:8097/get/student/34'
  When method GET
  Then status 200
  And match $ == {"firstName":"Kaushik","lastName":"Bagchi","age":32,"address":{"zipCode":"1123AD","huisnummer":67}}

Scenario: Testing an valid GET endpoint - with data with matchers
  Given url 'http://localhost:8097/get/student/34'
  When method GET
  Then status 200
  And match $ contains {"firstName":"#string","lastName":"Bagchi","age":"#number"}

Scenario: Testing an valid GET endpoint - with data with matchers and regex
  Given url 'http://localhost:8097/get/student/34'
  When method GET
  Then status 200
  And match $ contains {"firstName":"#string","lastName":"#regex ^[A-Z][a-z]*","age":"#number"}