package app.service;

import app.repo.CalcRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalcService {


    private final CalcRepo calcRepo;


    public CalcService(CalcRepo calcRepo) {
        this.calcRepo = calcRepo;
    }

    public String calc(String op){
       try {
           final boolean edgeChecker = Character.isDigit(op.charAt(0)) && Character.isDigit(op.charAt(op.length() - 1));
           if ((op.contains("*"))&& edgeChecker){
               final String[] numbers = op.split("\\*", 2);
               return String.valueOf(Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]));
           }else if ((op.contains("+"))&& edgeChecker){
               final String[] numbers = op.split("\\+", 2);
               return String.valueOf(Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]));
           }else if ((op.contains("-"))&& edgeChecker){
               final String[] numbers = op.split("\\-", 2);
               return String.valueOf(Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]));
           }else   if ((op.contains("\\/"))&& edgeChecker){
               final String[] numbers = op.split("\\/", 2);
               if (Double.parseDouble(numbers[2])!=0){
                   return String.valueOf(Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]));
               }
           }
       }catch (Exception ex){

       }
        return "Something wrong";
    }

//    public String calcParan(String op){
//        while (op.contains("(") && op.contains(")")){
//            String paran = calc(op.substring(op.indexOf("("), op.indexOf(")")));
//        }
//    }
}
