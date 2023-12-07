## Inapp-Messenger

### Overview
This messaging web application is designed to address the challenge of handling a high volume of customer inquiries for Branch, offering a streamlined approach for a team of agents to respond to incoming messages. (Take away assignment)

### Features
#### Messaging System:

Agents can log in simultaneously and respond to incoming customer messages.
No authentication is required for simplicity.

#### API Endpoint:

Customer messages are sent and received through a dedicated API endpoint.
Simulation can be done via a simple web form or a Postman collection.

#### Database Storage:

Customer service messages provided in a CSV file are stored in a chosen database.
Messages appear on the agents' portal for viewing and responding. Customers can send inquiries simultaneously for the agents to reply.

#### Scalability:

The application is designed to scale as the customer base grows.

#### Hosting:

The application can be hosted on any environment, and instructions for local setup are provided.

#### Setup Instructions
> Prerequisites
- Java Development Kit (JDK) 17+<br>
- Apache Maven installed <br>
- Database of your choice (e.g., MariaDB, PostgreSQL) installed and configured 

>Steps
Clone the Repository:

```
    git clone https://github.com/ElijahWandimi/Inapp-messenger.git
    cd Inapp-messenger
```
Build and Run the Application:

```
    mvn clean install
    java -jar target/branch-messaging-app.jar
```
#### Access the Application:

Open a web browser and go to http://localhost:10290/api/*

>> append *agent* or *customer* depending on the who is accessing the endpoint

API Endpoint:

Use the provided API endpoint for simulating customer messages.

#### Database Setup:

Configure your database details in application.yml.<br>
Run the application to initialize the database.

#### Video Demonstration and Code Walkthrough
<video src='https://github.com/ElijahWandimi/Inapp-messenger/blob/master/inapp_demo.webm' width=180>

Key Aspects Covered:

- Overview of the messaging system architecture.
- Implementation of the API endpoint and message processing.
- Database configuration and integration.

Note:
*The video is kept concise, focusing on crucial aspects and not exceeding 5-6 minutes.*
