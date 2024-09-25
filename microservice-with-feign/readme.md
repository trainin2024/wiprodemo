# Object : Customer wants to get all orders placed by him 
## Make sure you testdb schema in mysql qoekbench or test your application as per your schema
## 1. Download both servics
## 2. Import into workspace
## 3. Run the Order Service - http://localhost:8000/order/1/orders 

### a. Check the table name in workbench as customer_order4 as enity class
### b. insert records : 
    ` SELECT * FROM testdb.customer_order4;
    insert into testdb.customer_order4 values ( 1, 1, 'Mobile');
    insert into testdb.customer_order4 values ( 2, 1, 'TV');
    insert into testdb.customer_order4 values ( 4, 2, 'Microrwave');`

<img width="213" alt="image" src="https://github.com/user-attachments/assets/03046eed-beec-4be3-a87d-eb4ee9dc6eb4">

## 4. Run the Customer service 
### a. Check the table name in workbench as customer1 as enity class
### b. Insert a record  at least 
<img width="90" alt="image" src="https://github.com/user-attachments/assets/7d63b613-58bd-44f4-9225-731592ee73e2">

### c. Test the endpoint http://localhost:9000/customers/myorders/1 
<img width="441" alt="image" src="https://github.com/user-attachments/assets/e9d246af-70b0-4e7d-904b-01f8d5215767">

s
