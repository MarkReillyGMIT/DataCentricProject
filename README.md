# Data Centric Project

## Introduction
JSF (Jakarta Server Faces) dynamic web application that queries and updates a MySQL database and
a MongoDB database.

## Databases

### Mongo Database
The Mongo Database is called *storeHeadOfficeDB* which consists of a collection called
storeHeadOffice, which initially has 3 documents as follows:

![](ReadmeFiles/Mongo.PNG?raw=true)

<hr/>

### MySQL Database
The MySQL Database is called *shops*, it consists of two tables **Store** and **Product**

![](ReadmeFiles/MysqlStore.PNG?raw=true)

![](ReadmeFiles/MysqlProduct.PNG?raw=true)


## Overview of Application
The application consists of the following pages:

### Main Page
The Main page consists of 3 links:
- One to the Manage Stores page
- One to the Manage Products page
- One to the Manage Head offices page

![](ReadmeFiles/MainPg.PNG?raw=true)

<hr/>

### Manage Stores Page
The Manage Stores page:
- Shows details of all Stores
- Has an Add Store button
- Has Show Products and Delete actions for each Store
- Has a link back to the Home page.

![](ReadmeFiles/ManageStorePg.PNG?raw=true)

<hr/>

### Add Stores Page
The Add Store Page allows the user to enter a Store Name and Founded date.
If an existing Store Name is entered an error should be displayed as shown.

![](ReadmeFiles/AddStorePg.PNG?raw=true)

If Store Name or Founded are not specified appropriate error messages are shown:

![](ReadmeFiles/AddStoreErrorPg.PNG?raw=true)

<hr/>

### Show Products Details Page
When the Show Products action is pressed on the Manage Stores page, the user is
brought to the Store/Product Details page.
This page shows details of all Stores and the Products in those stores as shown.

![](ReadmeFiles/Store&ProductsPg.PNG?raw=true)

If there are no Products in a particular Store, nothing should be show:

![](ReadmeFiles/NoStore&ProductsPg.PNG?raw=true)

<hr/>

### Delete Store
When the Delete action is pressed on the Manage Stores page, if the particular Store
to be deleted has no Products, it is deleted from the database and the user remains on
the Manage Stores page which is updated to show the new list of courses.

If the particular Store to be deleted has Products, an error message is shown and the
Store is not deleted from the database.

![](ReadmeFiles/deletedStoreError.PNG?raw=true)

<hr/>

### Manage Products Page
The Manage Products page:
- Shows details of all Products
- Has a Delete action for each Product
- Has a link back to the Home page.

![](ReadmeFiles/ManageStorePg.PNG?raw=true)

### Delete Product
When the Delete action is pressed on the Manage Products page, the product is
deleted from the database and the user remains on the Manage Products page which is
updated to show the new list of products.

<hr/>

### Manage Head Offices
The Manage Head Offices page:
- Shows the Store ID and Location of the Store’s head office – from the
storeHeadOffice collection in the storeHeadOfficeDB database in MongoDB
- Has an Add Head Office button
- Has a link back to the Home page

![](ReadmeFiles/ManageHeadOffices.PNG?raw=true)








