##---------------------- for user registration----------------------##

API  :  localhost:8888/user/v1/create(post method)

{
	"userId":3,
	"userName":"uttamtiwari",
	"emailId":"uttamtiwari409@gmail.com",
	"mobileNo":8951155889,
	"createdOn":"1586431024324",
	"updatedOn":"1586431024324",
	"userStatus":"ACTIVE"
}

##---------------------- get user based on userId----------------------##

API  : localhost:8888/user/v1/getOneUser/{userId}(get method)

##---------------------- get  all user----------------------##
API  :localhost:8888/user/v1/getAllUser(get method)

##---------------------- delete user based on userId----------------------##
API  :localhost:8888/user/v1/delete/{userId}(get method)

##---------------------- List Of All User Based On Created Date----------------------##
API  :localhost:8888/user/v1/getListUser/{createdDate}(get method)

##---------------------- Updated User Based On userId----------------------##
API  :localhost:8888/user/v1/update/2(put method)

{
	"userId":2,
	"userName":"Ashwin",
	"emailId":"ashwinpandey409@gmail.com",
	"mobileNo":8951155876,
	"createdOn":"1586431024324",
	"updatedOn":"1586431024324"
}

##---------------------- list of User Based On userStatus----------------------##
API  :localhost:8888/user/v1/getUsersByUserStatus/ACTIVE(get method)
