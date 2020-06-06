/*====================================================================================================*/
-- author: rveizaga
-- description: Base notations of scripts
-- date: 8/13/2019
-- release: 2.0.5
/*====================================================================================================*/

/*===========*/
-- File name --
/*===========*/
-- The file name must be sequential and have an appropriate title according to its functionality.

/*========*/
-- Header --
/*========*/
-- The header must contain the following information:
-- - author.- The name of developer creating the script.
-- - description.- A little description about the purpose of the script.
-- - date.- The date that was created this file.
-- - release.- The last release version of the project.

/*======*/
-- Body --
/*======*/
-- The body will contain all the operations that is required to update the database.
-- For a summary of the operations you can review: https://dev.mysql.com/doc/refman/5.7/en/sql-syntax.html
-- For sql conventions you can review:  https://www.sqlstyle.guide/

/*=============*/
-- Constraints --
/*=============*/
-- Any created script that is already merged to the official branch, MUST NOT be modified anymore.

/*================*/
-- How to execute --
/*================*/
-- To run the script in a MySQL instance, you need to execute the following command:
-- $ mysql -u USERNAME -pPASSWORD -h HOST -P PORT -D DATABASE_NAME < FILE_NAME.sql
-- For example:
-- $ mysql -u setfusion -psetfusion -h 10.9.1.166 -P 3306 -D explanations_persistence_dhin < 000_template.sql

SELECT DATABASE() as CURRENT_DATABASE;