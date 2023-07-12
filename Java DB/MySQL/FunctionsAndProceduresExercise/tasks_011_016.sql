-- Calculating Interest_011


DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(id int, interest_rate DECIMAL (19, 4))
BEGIN
SELECT a.id as account_id,
ah.first_name,
ah.last_name,
a.balance as current_balance,
ufn_calculate_future_value(a.balance, interest_rate, 5) as balance_in_5_years
from accounts as a
JOIN account_holders as ah on ah.id  = a.account_holder_id
WHERE a.id = id;
END $$

DELIMITER ;


call usp_calculate_future_value_for_account(1, 0.1);


-- Deposit Money_012

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN

IF money_amount > 0
THEN
START TRANSACTION;
UPDATE accounts as a
SET
a.balance = a.balance + money_amount
WHERE a.id = account_id;

IF (SELECT a. balance
FROM accounts as a
WHERE a.id = account_id) < 0
THEN ROLLBACK;
ELSE COMMIT;
END IF;
END IF;
END $$

DELIMITER ;


--CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
--BEGIN
--
--IF money_amount > 0
--THEN UPDATE accounts as a
--SET
--a.balance = a.balance + money_amount
--WHERE a.id = account_id;
--END IF;
--END


-- Withdraw Money_013

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN

IF money_amount > 0
THEN
START TRANSACTION;

UPDATE accounts AS a
SET
    a.balance = a.balance - money_amount
WHERE
    a.id = account_id;

IF(SELECT a.balance from accounts as a
WHERE a.id = account_id) < 0
THEN ROLLBACK;

ELSE COMMIT;

END IF;
END IF;

END $$
DELIMITER ;

call usp_withdraw_money(1, 10);

SELECT
    *
FROM
    accounts
WHERE
    id = 1;


-- Money Transfer_014
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
    BEGIN
    IF amount > 0
    AND from_account_id != to_account_id
    AND (SELECT a.id FROM accounts AS a WHERE a.id = from_account_id) IS NOT NULL
    AND (SELECT a.id FROM accounts AS a WHERE a.id = to_account_id) IS NOT NULL
    AND (SELECT a.balance FROM accounts AS a WHERE a.id = from_account_id) >= amount
    THEN
    START TRANSACTION;
UPDATE accounts AS a
SET
    a.balance = a.balance - amount
WHERE
    a.id = from_account_id;

UPDATE accounts AS a
SET
    a.balance = a.balance + amount
WHERE
    a.id = to_account_id;

    IF(SELECT a.balance FROM accounts AS a
    WHERE a.id = from_account_id) < 0
    THEN ROLLBACK;

    ELSE COMMIT;

		END IF;
    END IF;
    END $$
DELIMITER ;

call usp_transfer_money(1, 2, 10);

SELECT
    *
FROM
    accounts
WHERE
    id IN (1 , 2);


-- Log Accounts Trigger_015

CREATE TABLE logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    old_sum DECIMAL(19 , 4 ),
    new_sum DECIMAL(19 , 4 )
);

DELIMITER $$
CREATE TRIGGER updated_accounts
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
IF old.balance != new.balance THEN
INSERT INTO logs (account_id, old_sum, new_sum)
VALUES(OLD.id, OLD.balance, NEW.balance);
END IF;
END$$
DELIMITER ;


-- Emails Trigger-016

CREATE TABLE notification_emails (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    recipient INT NOT NULL,
    subject VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_create_new_mail
AFTER INSERT ON `logs`
FOR EACH ROW

BEGIN
INSERT INTO notification_emails(recipient, subject, body)
VALUES (
NEW.account_id,
concat('Balance change for account: ', NEW.account_id),
concat('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), 'your balance was changed from ',
ROUND(NEW.old_sum, 2), ' to ', ROUND(NEW.new_sum, 2), '.')
);
END $$
DELIMITER ;
