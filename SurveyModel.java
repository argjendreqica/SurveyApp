import javax.swing.*;

public class SurveyModel {



    public String[] questions(){
        String [] pyetjet = new String[9];
        pyetjet[0] = selectOne("Cilin nga Smartphone-t e preferoni nga aspekti i sigurise? ");
        pyetjet[1] = selectOne( "Cili smartphone ka rezolucionin me te mire te kameres?");
        pyetjet[2] = selectOne( "Cili ka qmime me te arsyeshem?");
        pyetjet[3] = selectOne( "Cili nga te dy perditesohet me shpesh?");
        pyetjet[4] = selectOne( "Cilin nga modelet e keni momentalisht?");
        pyetjet[5] = selectOne( "Cilin e preferoni per nga dizajni?");
        pyetjet[6] = selectOne( "Cili eshte me rezistent ndaj ujit?");
        pyetjet[7] = selectOne( "Cili eshte me funksional?");
        pyetjet[8] = selectOne( "Cilin e preferoni sa i perket performances?");
        return pyetjet;
    }


    public String chectWinner(String rezultatet[]){
        int iphone = 0;
        int samsung = 0;
        int winner = 1;
        for (int i = 0; i < rezultatet.length;i++){
            if(rezultatet[i].equals("Iphone")){
                iphone++;
            }
            else if(rezultatet[i].equals("Samsung")){
                samsung++;

            }
        }
        if(samsung > iphone){
            winner=2;
        }
        String smart_phone ="";
        switch (winner)
        {
            case 1:
                smart_phone = "Iphone";
                break;
            case 2:
                smart_phone = "Samsung";
                break;
            default:
                smart_phone = "Gabim";
                break;
        }

        return smart_phone;
    }
    public double winner_percentage(String[] rezultati){
        double percentage =0;
        int iphone = 0;
        int samsung = 0;
        int winner = 1;
        for (int i = 0; i < rezultati.length;i++){
            if(rezultati[i].equals("Iphone")){
                iphone++;
            }
            else if(rezultati[i].equals("Samsung")){
                samsung++;
            }
        }
        if(samsung > iphone){
            winner=samsung;
        }
        else{winner = iphone;}

        percentage = (100.0/rezultati.length) * winner;
        return percentage;
    }

    private String selectOne(String s)
    {
    	Object[] possibleValues = { "Iphone", "Samsung" };
    	Object selectedValue = JOptionPane.showInputDialog(null,s, "Input",JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
    	return "" + selectedValue;
    }


  
}
