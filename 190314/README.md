# 백준 Q11812

k개의 노드를 가지는 트리 규칙

* 부모노드로 올라갈 때
  * pos-1%k ==0 이거나 pos%k ==0 일 때는 pos/k가 부모노드이고
  * 나머지는 pos/k+1이 부모 노드이다.
* 높이 구할 때
  * 1에서부터 시작하여 k의 제곱근을 계속 곱해 높이를 구함

