# leetcode_database题解
## 简单

* [595. 大的国家](#595大的国家)
* [183.从不订购的客户](#183从不订购的客户)
* [182.查找重复的电子邮箱](#182查找重复的电子邮箱)
* [197.上升的温度](#197上升的温度)
* [596.超过5名学生的课](#596超过5名学生的课)
* [620.有趣的电影](#620有趣的电影)
* [627.交换工资](#627交换工资)
* [181.超过经理收入的员工](#181超过经理收入的员工)
* [176.第二高的薪水](#176第二高的薪水)

## 中等

* [177.第N高的薪水](#177第N高的薪水)
* [178.分数排名](#178分数排名)
* [184.部门工资最高的员工](#184部门工资最高的员工)
* [180.连续出现的数字](#180连续出现的数字)
* [626.换座位](#626换座位)

## 难

* [185.部门工资前三高的员工](#185部门工资前三高的员工)
* [262.行程和用户](#262行程和用户)
* [601.体育馆的人流量](#601体育馆的人流量)


# 595. 大的国家

https://leetcode-cn.com/problems/big-countries/description/

## 描述
```html
+-----------------+------------+------------+--------------+---------------+
| name            | continent  | area       | population   | gdp           |
+-----------------+------------+------------+--------------+---------------+
| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
| Albania         | Europe     | 28748      | 2831741      | 12960000      |
| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
| Andorra         | Europe     | 468        | 78115        | 3712000       |
| Angola          | Africa     | 1246700    | 20609294     | 100990000     |
+-----------------+------------+------------+--------------+---------------+
```
查找面积超过 3,000,000 或者人口数超过 25,000,000 的国家。

```html
+--------------+-------------+--------------+
| name         | population  | area         |
+--------------+-------------+--------------+
| Afghanistan  | 25500100    | 652230       |
| Algeria      | 37100000    | 2381741      |
+--------------+-------------+--------------+
```

## SQL Schema
```sql
DROP TABLE
IF
    EXISTS World;
CREATE TABLE World ( NAME VARCHAR ( 255 ), continent VARCHAR ( 255 ), area INT, population INT, gdp INT );
INSERT INTO World ( NAME, continent, area, population, gdp )
VALUES
    ( 'Afghanistan', 'Asia', '652230', '25500100', '203430000' ),
    ( 'Albania', 'Europe', '28748', '2831741', '129600000' ),
    ( 'Algeria', 'Africa', '2381741', '37100000', '1886810000' ),
    ( 'Andorra', 'Europe', '468', '78115', '37120000' ),
    ( 'Angola', 'Africa', '1246700', '20609294', '1009900000' );
```
## Solution

```sql
SELECT
    W.name,
    W.population,
    W.area
FROM
    World W
WHERE
    W.area>3000000
    OR W.population>25000000;
```

# 176.第二高的薪水

https://leetcode-cn.com/problems/second-highest-salary/description/

## Solution

此处注意使用LIMIT X,Y 来限制最终返回结果

X:从第几个开始

Y:一共返回几行


为了在没有查找到数据时返回 null，需要在查询结果外面再套一层 SELECT。

```sql
SELECT
    ( SELECT DISTINCT Salary 
    FROM Employee 
    ORDER BY Salary 
    DESC LIMIT 1, 1 ) 
    SecondHighestSalary;
``` 

# 177.第N高的薪水

https://leetcode-cn.com/problems/nth-highest-salary/description/

## Solution
同176

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT

BEGIN

   SET
    N=N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT ( SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N, 1 )
      
  );
END
```

# 178.分数排名

https://leetcode-cn.com/problems/rank-scores/description/

## Solution

使用内联

```sql
SELECT
    S1.score,
    COUNT(DISTINCT S2.score) Rank
FROM
    Scores S1
    INNER JOIN Scores S2
    ON S1.score<=S2.score
GROUP BY
    S1.id
ORDER BY
    S1.SCORE DESC ;
```


# 180.连续出现的数字

https://leetcode-cn.com/problems/consecutive-numbers/description/

## Solution

1341ms

```sql
SELECT
    DISTINCT L1.num ConsecutiveNums
FROM
    Logs L1,
    Logs L2,
    Logs L3
WHERE L1.id = l2.id - 1
    AND L2.id = L3.id - 1
    AND L1.num = L2.num
    AND l2.num = l3.num;
```

1327ms

```sql
SELECT distinct l3.num as ConsecutiveNums 
FROM logs l1

LEFT JOIN logs l2
on l1.id + 1 = l2.id

left join logs l3
on l1.id + 2 = l3.id

WHERE l1.num = l2.num and l2.num = l3.num and l1.num = l3.num
```

691ms

```sql
select
    distinct l1.Num as ConsecutiveNums
from Logs l1, Logs l2, Logs l3
where l1.Id = l2.Id-1 and l2.Id=l3.Id-1
and l1.Num=l2.Num and l2.Num=l3.Num
```

429ms

```sql
select distinct Num as ConsecutiveNums from (
	select Num, @count :=if(@pre = Num, @count + 1, 1) count, @pre := Num
	from Logs, (select @count := 0, @pre := null) init
) t where t.count >= 3 
```

237ms

```sql
SELECT distinct num as ConsecutiveNums FROM(
SELECT id, num, 
@pre := @cur,
@cur := num,
@rep_ct := IF(@pre = @cur, @rep_ct + 1, 1) as rep_ct
FROM `Logs` l, (SELECT @pre := null, @cur := 0, @rep_ct := 1) init
) temp WHERE rep_ct >= 3
```
# 181.超过经理收入的员工

https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/description/

484ms

```sql
SELECT
    E1.NAME AS Employee
FROM
    Employee E1
    INNER JOIN Employee E2
    ON E1.ManagerId = E2.Id
    AND E1.Salary > E2.Salary;
```

# 183.从不订购的客户

https://leetcode-cn.com/problems/customers-who-never-order/description/

##  描述


Curstomers 表：

```html
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

Orders 表：

```html
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

查找没有订单的顾客信息：

```html
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

## SQL Schema

```sql
DROP TABLE
IF
    EXISTS Customers;
CREATE TABLE Customers ( Id INT, NAME VARCHAR ( 255 ) );
DROP TABLE
IF
    EXISTS Orders;
CREATE TABLE Orders ( Id INT, CustomerId INT );
INSERT INTO Customers ( Id, NAME )
VALUES
    ( 1, 'Joe' ),
    ( 2, 'Henry' ),
    ( 3, 'Sam' ),
    ( 4, 'Max' );
INSERT INTO Orders ( Id, CustomerId )
VALUES
    ( 1, 3 ),
    ( 2, 1 );
```

## Solution
```sql
SELECT
    Name AS Customers
FROM
    Customers
WHERE
    Id NOT IN ( SELECT CustomerId FROM Orders );
```

# 182.查找重复的电子邮箱

https://leetcode-cn.com/problems/duplicate-emails/description/

## Solution
按邮件字段进行分组,然后聚合查询邮件的数量大于1的个数,这个和596题有点儿像.
```sql
SELECT 
    Email
FROM
    Person
GROUP BY
   Email
HAVING 
    COUNT(Email)>1;
```


# 184.部门工资最高的员工

https://leetcode-cn.com/problems/department-highest-salary/description/

## Solution

```sql
SELECT 
    D.NAME Department,
    E.NAME Employee,
    E.Salary
FROM
    Employee E,
    Department D,
    (SELECT DepartmentId ,MAX(Salary) Salary FROM Employee GROUP BY DepartmentId ) M
WHERE 
    E.DepartmentId = D.Id
    AND E.DepartmentId = M.DepartmentId 
    AND E.Salary = M.Salary;
```

# 185.部门工资前三高的员工

https://leetcode-cn.com/problems/department-top-three-salaries/description/

## Solution

1452ms

```sql
SELECT D1.Name Department, E1.Name Employee,  E1.Salary
FROM Employee E1, Employee E2, Department D1
WHERE E1.DepartmentID = E2.DepartmentID
AND E2.Salary >= E1.Salary 
AND E1.DepartmentID = D1.ID      
GROUP BY E1.Name
HAVING COUNT(DISTINCT E2.Salary) <= 3
ORDER BY D1.Name, E1.Salary DESC;

```

672ms

```sql
Select 
       dep.Name as Department, emp.Name as Employee, emp.Salary 
from 
     Department dep, 
     Employee emp 
where 
      emp.DepartmentId=dep.Id 
      and 
    (Select count(distinct Salary) From Employee where DepartmentId=dep.Id and Salary>emp.Salary)<3
```

617ms

```sql
select B.Name as Department, A.Name as Employee, A.Salary
from Employee A, Department B
where A.DepartmentId = B.Id 
    and 3>(select count(distinct Salary) from Employee 
                    where DepartmentId=B.Id and Salary>A.Salary)
order by B.Name asc, A.Salary desc
```

# 620.有趣的电影

https://leetcode-cn.com/problems/not-boring-movies/description/

## Solution
本题常规思路,使用ORDER BY 字段 ASC/DESC;进行升许和降序

方法一:229ms
```sql
SELECT 
    id,
    movie,
    description,
    rating
FROM
    cinema
WHERE 
    id % 2 =1
    AND description != 'boring'
ORDER BY
    rating DESC;
```
方法二: 242ms
```sql
SELECT
    *
FROM
    cinema
WHERE
    id % 2 = 1
    AND description != 'boring'
ORDER BY
    rating DESC;
```

# 627.交换工资

https://leetcode-cn.com/problems/swap-salary/description/

## Solution

case when then else end语句

```sql
UPDATE
    salary
SET
    sex =(CASE WHEN sex='m' THEN 'f' ELSE 'm' END);
```

if(expr1,expr2,expr3)语句

expr1:判断条件

ecpr2,3是expr1的自定义条件
```sql
UPDATE
    salary 
SET 
    sex = if(sex = 'm', 'f','m');
```

# 197.上升的温度

https://leetcode-cn.com/problems/rising-temperature/description/

DATEDIFF()函数可以计算两个日期之差
 498ms

```sql
SELECT
    w1.Id 
FROM
    weather w1
INNER JOIN
    weather w2 
ON
    w1.Temperature > w2.Temperature 
    AND DATEDIFF(w1.RecordDate, w2.RecordDate) = 1;
```

# 596.超过5名学生的课

https://leetcode-cn.com/problems/classes-more-than-5-students/description/

## Solution
按照课程分类,然后再判断大于等于5的学生数
```sql
SELECT
    c.class
FROM
    courses c
GROUP BY
    class 
HAVING
    COUNT(DISTINCT student)>=5;
```

模板:
```sql
GROUP BY 字段 HAVING 条件判断;
说明: 
GROUP BY 字段  即按该字段进行分组,将相同的分在一起
HAVING 过滤分组
WHERE 过滤行
DISTINCT  用来过滤掉多余的重复的记录只保留一条,即只返回不重复记录的条数.

```

# 262.行程和用户

https://leetcode-cn.com/problems/trips-and-users/description/

## Solution

302ms

```sql
select request_at as Day, ROUND(sum((case when t.Status !='completed' then 1 else 0 end))/count(*),2) 
    as 'Cancellation Rate'
    from Trips t inner join Users u 
    on u.Users_Id =t.Client_Id 
    and u.banned='no'
    and (request_at between '2013-10-01' and '2013-10-03')
    group by Day;
            
```

211ms

```sql
select t.Request_at Day, round(
    sum(case  when t.Status like "cancelled%" then 1 else 0 end)/(count(1)),2)
 "Cancellation Rate"
from Trips  t
inner join Users u
on u.Users_Id = t.Client_Id  and u.Banned = "No"
where t.Request_at between "2013-10-01" and "2013-10-03" group by t.Request_at
order by to_days(t.Request_at) asc
```

227ms

```sql
select Request_at Day, convert(sum(if(Status<>'completed', 1,0))/count(*),decimal(10,2)) as 'Cancellation Rate'
from Trips
where Client_Id in (select Users_Id from Users where Banned = 'no' and Role = 'client')
and Driver_Id in (select Users_Id from Users where Banned = 'no' and Role = 'driver')
and Request_at >= '2013-10-01'
and Request_at <= '2013-10-03'
group by Request_at
```

359ms

```sql
select Request_at Day, convert(sum(if(Status<>'completed', 1,0))/count(*),decimal(10,2)) as 'Cancellation Rate'
from Trips
where Client_Id in (select Users_Id from Users where Banned = 'no' and Role = 'client')
and Driver_Id in (select Users_Id from Users where Banned = 'no' and Role = 'driver')
and Request_at >= '2013-10-01'
and Request_at <= '2013-10-03'
group by Request_at
```

# 626.换座位

https://leetcode-cn.com/problems/exchange-seats/description/

## Solution

256ms

```sql
SELECT
	(CASE
		WHEN MOD(id,2) != 0 AND counts !=id THEN id+1
		WHEN MOD(id,2) !=0 AND counts =id THEN id
		ELSE id-1
	END) AS id,
	student
FROM
	seat,
	(SELECT COUNT(*) AS counts
	FROM
		seat) AS seat_counts
ORDER BY id ASC;
```
295ms

```sql
select 
case
    when id = (select case when count( * )%2 = 1 then count( * ) 
                else null end from seat)
    then id
    else
        case when id%2 = 0 then (id-1) 
             else (id+1) end 
end as id, student from seat order by id
```
450ms

```sql
SELECT
    s1.id - 1 AS id,
    s1.student
FROM
    seat s1
WHERE
    s1.id MOD 2 = 0 UNION
SELECT
    s2.id + 1 AS id,
    s2.student
FROM
    seat s2
WHERE
    s2.id MOD 2 = 1
    AND s2.id != ( SELECT max( s3.id ) FROM seat s3 ) UNION
SELECT
    s4.id AS id,
    s4.student
FROM
    seat s4
WHERE
    s4.id MOD 2 = 1
    AND s4.id = ( SELECT max( s5.id ) FROM seat s5 )
ORDER BY
    id;

```

# 601.体育馆的人流量

https://leetcode-cn.com/problems/human-traffic-of-stadium/description/

## Solution

 448ms
 
```sql
SELECT DISTINCT s1.*
FROM stadium s1, stadium s2, stadium s3 
WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100  
AND ( (s1.id - s2.id =1 AND s2.id - s3.id =1 )  
OR (s2.id - s1.id = 1 AND s1.id - s3.id =1)
OR (s3.id - s2.id = 1 AND s2.id - s1.id = 1)  )
ORDER BY s1.id;

```
467ms

```sql
select 
    distinct s1.id, s1.date, s1.people
from 
    stadium s1,
    stadium s2,
    stadium s3
where
    s1.people >= 100 
    and s2.people >= 100
    and s3.people >= 100
    and (
        (s1.id = s2.id - 1 and s1.id = s3.id - 2)
        or (s1.id = s2.id + 1 and s1.id = s3.id - 1)
        or (s1.id = s2.id + 2 and s1.id = s3.id + 1)
    )
order by s1.id;

```

