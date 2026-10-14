# Healthcare Microservices: Patient, Doctor, API Gateway

Three independent Maven projects for Spring Tool Suite 4.

## Requirements
- JDK 17
- Maven (or STS embedded Maven)
- Internet connection for the first Maven dependency download

## Import into STS 4
1. Extract this ZIP.
2. In STS select File > Import > Maven > Existing Maven Projects.
3. Browse to the extracted `healthcare-microservices` folder.
4. Select the `pom.xml` files for all three projects (or import each project folder separately), then Finish.
5. Wait for Maven dependencies to download.

## Run
Start each main application as Run As > Spring Boot App:
1. patient-service (port 8081)
2. doctor-service (port 8082)
3. healthcare-gateway (port 8080)

## Test through the gateway
- GET http://localhost:8080/patients
- GET http://localhost:8080/patients/1
- GET http://localhost:8080/doctors
- GET http://localhost:8080/doctors/101

Sample data is in memory only. This is a learning demo, not a production healthcare system.
