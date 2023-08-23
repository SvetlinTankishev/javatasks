select * from employee;

create schema employeesdb;
use employeesdb;
create table employee (
id INT primary key,
first_name varchar(50),
last_name varchar(50),
birth_date varchar(50),
department varchar(50),
salary decimal(10, 2)
);
SELECT DATABASE();
DELIMITER //

CREATE PROCEDURE IncreaseSalariesForDepartment(
    IN departmentName VARCHAR(50),
    IN raiseAmount DECIMAL(10, 2),
    OUT updatedCount INT,
    OUT message TEXT
)
BEGIN
    -- Initialize output parameters
    SET updatedCount = 0;
    SET message = '';

    -- Validate departmentName parameter
    SET @validationsPassed := TRUE;
    
    IF departmentName IS NULL OR departmentName = '' THEN
        SET message = 'Invalid department name';
        SET @validationsPassed := FALSE;
    END IF;

    -- Validate raiseAmount parameter
    IF raiseAmount <= 0 THEN
        SET message = 'Invalid raise amount';
        SET @validationsPassed := FALSE;
    END IF;

    -- If validations passed, update salaries
    IF @validationsPassed THEN
        -- Update salaries
        UPDATE employee
        SET salary = salary + raiseAmount
        WHERE department = departmentName;

        -- Get the number of updated rows
        SELECT ROW_COUNT() INTO updatedCount;

        -- Set output message
        SET message = CONCAT('Salaries updated for ', updatedCount, ' employees in department ', departmentName);
    END IF;
END //

DELIMITER ;