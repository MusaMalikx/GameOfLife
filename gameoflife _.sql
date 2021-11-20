create table GameRecord(
userId int,
userName varchar(50) Not Null,
x_coord int Not Null, --last position of block in x dimension
y_coord int Not Null, --last position of block in y dimension
primary key (userId)
)
-- procedure to get user data
create procedure  userdata
@getUserId int
as
(
select *
from GameRecord
where GameRecord.userId = @getUserId
)

--procedure to save/insert new data into game DB
create procedure newplayerdata
@userId int, @userName varchar(50), @Xcoord int, @Ycoord int
as
insert into GameRecord values (@userId,@userName,@Xcoord,@Ycoord)

-- procedure to delete a player data from game DB using their id
create procedure deleteplayerrecord
@userId int
as
delete
from GameRecord
where GameRecord.userId = @userId
