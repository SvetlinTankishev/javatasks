DELIMITER //

CREATE PROCEDURE IncreaseSalariesWithInflation(
    IN inflationRate DECIMAL(5, 2),
    OUT updatedCount INT,
    OUT message TEXT
)
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE employeeId INT;
    DECLARE currentSalary DECIMAL(10, 2);
    
    DECLARE cur CURSOR FOR SELECT id, salary FROM employee;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    SET updatedCount = 0;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO employeeId, currentSalary;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Calculate new salary with inflation
        SET currentSalary = currentSalary * (1 + inflationRate / 100);
        
        -- Update the employee's salary
        UPDATE employee SET salary = currentSalary WHERE id = employeeId;
        SET updatedCount = updatedCount + 1;
    END LOOP;

    CLOSE cur;

    SET message = CONCAT(updatedCount, ' employees have had their salaries updated.');
END //

DELIMITER ;
