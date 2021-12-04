
create database GameOfLife;
use  GameOfLife;

CREATE TABLE Game_State
(G_Name varchar(50), Xcoord int, Ycoord int, Alive BIT, Total_Xcoord int, Total_Ycoord int, primary key(G_Name, Xcoord, Ycoord));

DROP PROCEDURE Save_state

DELIMITER $$
use GameOfLife $$

CREATE PROCEDURE Save_state(IN G_Namein varchar(50), IN Xcoordin int, IN Ycoordin int, IN Alivein bit, In Total_Xcoordin int, In Total_Ycoordin int)
BEGIN
	REPLACE INTO Game_State(G_Name,Xcoord,Ycoord,Alive,Total_Xcoord,Total_Ycoord) VALUES(G_Namein,Xcoordin,Ycoordin,Alivein,Total_Xcoordin,Total_Ycoordin);
END $$

DELIMITER ;


DROP PROCEDURE View_state

DELIMITER $$
use GameOfLife $$

CREATE PROCEDURE View_state()
BEGIN
    
	select Game_State.G_Name
	from Game_State
	group by Game_State.G_Name;
    
END $$
DELIMITER ;


DROP PROCEDURE Load_state

DELIMITER $$
use GameOfLife $$

CREATE PROCEDURE Load_state(IN G_Namein varchar(50))
begin
	IF EXISTS
	(
	select Game_State.Xcoord, Game_State.Ycoord, Game_State.Alive, Game_State.Total_Xcoord,Game_State.Total_Ycoord
	from Game_State
	where Game_State.G_Name = G_Namein 
	)
	
	THEN
		
		select Game_State.Xcoord, Game_State.Ycoord, Game_State.Alive,Game_State.Total_Xcoord, Game_State.Total_Ycoord
		from Game_State
		where Game_State.G_Name = G_Namein;
		
	END IF;
END $$
DELIMITER ;



DROP PROCEDURE Delete_state
DELIMITER $$
use GameOfLife $$

CREATE PROCEDURE Delete_state(IN G_Namein varchar(50))
BEGIN

	IF EXISTS
	(
		select *
		from Game_State
		where Game_State.G_Name = G_Namein 
	)
	THEN

		delete from Game_State where Game_State.G_Name = G_Namein;
	END IF;
END $$
DELIMITER ;

/*-----------------------------------------------------------------
call deleteState ('New');
call viewState;
call loadState('ameer')
*/