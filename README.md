## **Customer Account API**
**Postman Link**
https://www.getpostman.com/collections/1d8164010b9435bc67bd

### **Database Schema**
![image of schema](https://github.com/yeboah326/customer_api/blob/main/schema.png?raw=true)
### **Customers**
**Create new customer**
<pre>POST /customers</pre>
Request Body
<pre>
{
    "name":"John Doe",
    "email":"jdow@dowmail.com",
    "phoneNumber":"0123456789",
    "dateOfBirth":"2000-01-01"
}</pre>

**Get all customers**
<pre>GET /customers</pre>

**Get customer by email**
<pre>GET /customers/email/{email}</pre>

**Get customer by phone Number**
<pre>GET /customers/phoneNumber/{phoneNumber}</pre>

**Delete a customer and all linked accounts**
<pre>DELETE /customers/{customerId}</pre>

### **Accounts**
**Create new account**
<pre>POST /accounts/new/{customerId}</pre>
Request Body
<pre>
{
    "openingAmount":100.00
}
</pre>

**Get all accounts**
<pre>GET /accounts</pre>

**Get customer accounts by email**
<pre>GET /customers/{email}/accounts</pre>

**Get customer accounts by phone number**
<pre>GET /customers/{phoneNumber}/accounts</pre>

**Delete account by account number**
<pre>DELETE /accounts/{accountNumber}</pre>
