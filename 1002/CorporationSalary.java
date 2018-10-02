/*
10.2
topcoder .중급-02 .회사 조직과 급여

 */
package questions;

public class CorporationSalary {

    int employeeNum;    //직원의 수를 담는 변수
    String[] relations; //직원의 관계를 담는 변수

    long[] salary;      //각 직원의 급여를 담는 변수
    void setSalary(int w){
        salary = new long[w];
    }


    public long totalSalary(String[] relations){

        long sum = 0;

        setSalary(relations.length);
        this.relations = relations;
        this.employeeNum = relations.length;

        for(int i = 0; i<this.employeeNum;i++){
            if (salary[i] == 0){
                salary[i] = countSalary(i);
            }
        }

        for(int i=0;i<salary.length;i++){
            sum+=salary[i];
            System.out.println(salary[i]);
        }

        return sum;
    }

    public long countSalary(int n){

        /*
        부하직원이 없는 직원의 급여는 1임으로 그냥 1을 리턴해준다.
         */
        if (!relations[n].contains("Y")) {
            salary[n] = 1;
            return 1;
        }

        /*
        만약 salary에 값이 들어가 있다는 것은 이미 급여의 합산이
        완료되었다는 뜻으로 계산 하지 않고 넘어간다.
         */
        for(int i=0;i<this.employeeNum;i++){
            if(relations[n].charAt(i) == 'Y'){
                if(salary[i]>0){
                    salary[n] += salary[i];
                }
                else{
                    salary[n] += countSalary(i);
                }
            }
        }

        return salary[n];
    }


}
