# Sale Campaign Management System

The Sale Campaign Management System is a Spring Boot application that allows you to manage campaigns and products for a sales platform. It provides RESTful APIs to create, retrieve, and manage campaigns and products.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
    - [Campaigns](#campaigns)
    - [Products](#products)
- [Examples](#examples)
    - [Creating a Campaign](#creating-a-campaign)
    - [Retrieving All Campaigns](#retrieving-all-campaigns)
    - [Retrieving Paginated Products](#retrieving-paginated-products)
- [License](#license)

## Installation
1. Clone the repository:
    ```
    git clone https://github.com/your-username/sale-campaign-management.git
    ```
2. Navigate to the project directory:
    ```
    cd sale-campaign-management
    ```
3. Build and run the Spring Boot application:
    ```
    ./mvnw spring-boot:run
    ```

## Usage
After starting the application, you can access the REST APIs using tools like cURL or Postman.

## API Endpoints

### Campaigns
- POST /campaigns: Create a new campaign.
- GET /campaigns: Retrieve all campaigns.
- GET /campaigns/past: Retrieve past campaigns.
- GET /campaigns/current: Retrieve current campaigns.
- GET /campaigns/upcoming: Retrieve upcoming campaigns.

### Products
- GET /products: Retrieve all products with pagination.

## Examples

### Creating a Campaign
```bash
curl -X POST "http://localhost:8080/campaigns" -H "Content-Type: application/json" -d '{
  "startDate": "2023-08-01",
  "endDate": "2023-08-15",
  "title": "Summer Sale",
  "campaignDiscounts": [
    {
      "productId": "jeiu8f03",
      "discountPercentage": 10
    }
  ]
}'
````
### Retrieving all Campaign
```bash
curl -X GET "http://localhost:8080/campaigns" -H "accept: application/json"
```

### Retrieving Paginated Products
```bash
curl -X GET "http://localhost:8080/products?page=1&pageSize=10" -H "accept: application/json"
```

