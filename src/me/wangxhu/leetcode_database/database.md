# leetcode_database题解

* [595. 大的国家](#595大的国家)
* [183.从不订购的客户](#183从不订购的客户)
* [182.查找重复的电子邮箱](#182查找重复的电子邮箱)
* [197.上升的温度](#197上升的温度)
* [596.超过5名学生的课](#596超过5名学生的课)
* [620.有趣的电影](#620有趣的电影)
* [627.交换工资](#627交换工资)
* [181.超过经理收入的员工](#181超过经理收入的员工)


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

