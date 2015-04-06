create database newq
GO
use newq
GO
create table appUser(
	appUserId int primary key ,
	appName varchar(15),
	appPwd varchar(50),
	userImage varchar(200),
	isAvailable bit default(1),
	userRole varchar(5) default ('user')
)
create table appSecurity(
	appSecurityId int primary key,
	salt varchar(200),
	sCount int,
	isAvailable bit default(1),
)
create table newQGroup(
	newQGroupId int primary key,
	newQGroupName varchar(50),
	isAvailable bit default(1)
)
create table newQItem(
	newQItemId int primary key,
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
	actHistoryId int primary key,
	typeAction varchar(20),
	actionTime datetime,
	actionDescription varchar(255),
	appUserId int,
	foreign key (appUserId) references appUser(appUserId),
)

INSERT INTO appUser values(1,'chinhnk','123','',1,'admin')
INSERT INTO newQGroup values(1,'News',1);
INSERT INTO newQGroup values(2,'Sports',0);
INSERT INTO newQGroup values(3,'Weather',1);

select * from newQItem;