**Step 1:**
localhost:8080/api/createtransaction
method : post
Request Body :
{
	"customerId" : 1,
	"amount" : 120
}
Execute One by one.

{
	"customerId" : 2,
	"amount" : 200
}
Execute One by one.

{
	"customerId" : 3,
	"amount" : 300
}
customerId need take from Customer table. 
Customer table already we have an entry at the time of starting the application.

**Step 2:**
localhost:8080/api/getlastthreemonthspoints
method : get
