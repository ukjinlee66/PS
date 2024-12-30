-- DEVELOPERS 테이블에서 Front End 스킬을 가진 개발자의 정보를 조회하려 합니다. 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.
-- 결과는 ID를 기준으로 오름차순 정렬해 주세요.


SELECT distinct D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
INNER JOIN SKILLCODES S ON D.SKILL_CODE & S.CODE = S.CODE
WHERE S.CATEGORY = 'Front End'
ORDER BY D.ID




-- 110010000(400) = 100000000(256), 10000000(126), 10000(16)