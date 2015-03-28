create database newq
GO
use newq
GO
create table appUser(
	appUserId int identity primary key ,
	name varchar(15),
	pwd varchar(50),
	userImage varchar(200),
	isAvailable bit default(1),
	userRole varchar(5) default ('user')
)
create table appSecurity(
	appSecurityId int identity primary key,
	salt varchar(200),
	sCount int,
	isAvailable bit default(1),
)
create table newQGroup(
	newQGroupId int identity primary key,
	name varchar(50),
	isAvailable bit default(1)
)
create table newQItem(
	newQItemId int identity primary key,
	title nvarchar(50),
	presentImage varchar(200),
	content nvarchar(MAX),
	appUserId int,
	newQGroupId int,
	insertDate datetime,
	tag varchar(255),
	isAvailable bit default(1),
	foreign key (appUserId) references appUser(appUserId),
	foreign key (newQGroupId) references newQGroup(newQGroupId)
)
create table actHistory(
	actHistoryId int identity primary key,
	typeAction varchar(20),
	actionTime datetime,
	actionDescription varchar(255),
	appUserId int,
	foreign key (appUserId) references appUser(appUserId),
)