# 카카오 2019 신입공체 1차테스트 후보키 문제

로직

1. Findkey 함수를 통해 primarykey의 후보가 될 수 있는 키들을 구한다.
2. PrimaryKey가 될 수 있는 에트리뷰트들을 제외해서 new_relation 테이블을 만든다.
3. 남은 에트리뷰트들이 조합될 수 있는 집합을 만든다(dfs)
4. new_relation태이블을 가지고 조합될 수 있는 집합들로 후보키들을 선별한다.

