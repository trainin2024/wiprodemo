# Object : Customer wants to get all orders placed by him 
## Make sure you testdb schema in mysql qoekbench or test your application as per your schema
## Create -Order as  dependent service to be called by customer
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



### c. Test the order -service 
<img width="468" alt="image" src="https://github.com/user-attachments/assets/3ac625f8-9bac-4460-b46d-0ca8a99775ed">

## 4. Run the Customer service http://localhost:9000/customers/myorders/1 
### a. Check the table name in workbench as customer1 as enity class
### b. Insert a record  at least one record
<img width="148" alt="image" src="https://github.com/user-attachments/assets/59179ae4-ed5e-46db-a379-6341f8bcd5bf">

### c. Test the endpoint http://localhost:9000/customers/myorders/1 
<img width="566" alt="image" src="https://github.com/user-attachments/assets/c65c8e46-4a9c-4388-998c-080e746836c8">


s
