import java.awt.Color;

import javax.swing.JOptionPane;

public class SurveyController {

	SurveyModel mod = new SurveyModel();

	String[][] vargu;

	public String[][] procedura() {
        JOptionPane.showMessageDialog(null, "Ky pyetesor ka per qellim te percaktoj se cilin nga smartphonet e pelqeni duke \nu bazuar ne disa tipare." +
                " \nJu lutem pergjigjuni me korrektesi ne menyre qe vleresimi te jete sa me i drejt!");

		int users = new Integer(JOptionPane.showInputDialog("Sa persona do t'i qasen pyetesorit? \n (Vemendje! Numri maksimal mund te jete 10 dhe nuk mund t'i " +
                "shikoni rezultatet gjeresa t'i plotesoni te gjithe pyetesoret! )")).intValue();
		if(users > 0 && users <11){
			vargu = new String[users + 1][5];
			vargu[0][0] = "Emri";
			vargu[0][1] = "Mbiemri";
			vargu[0][2] = "Email";
			vargu[0][3] = "Fituesi";
			vargu[0][4] = "Perqindja %";

			String[] rezultatet = new String[9];
			for (int i = 0; i < users; i++) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
						case 0:
							vargu[i + 1][j] = JOptionPane.showInputDialog("Shkruaj emrin e personit " + (i + 1));
							break;
						case 1:
							vargu[i + 1][j] = JOptionPane.showInputDialog("Shkruaj mbiemrin e personit " + (i + 1));
							break;
						case 2:
							vargu[i + 1][j] = JOptionPane.showInputDialog("Shkruaj emailin e personit " + (i + 1));
							break;
						case 3:
							rezultatet = mod.questions();
							vargu[i + 1][j] = mod.chectWinner(rezultatet);
							break;
						case 4:
							String s = "" + mod.winner_percentage(rezultatet);
							vargu[i + 1][j] = s.substring(0, 5) + " %";
							break;
					}
				}
			}
		}
		else if(users > 11){
			JOptionPane.showMessageDialog(null, "Nuk mund te krijosh me shume se 10 persona qe do t'i qasen pyetesorit");
			procedura();
		}
		else if(users < 0 ){
			JOptionPane.showMessageDialog(null, "Gabim! Numer negativ i personave qe do ti qasen pyetesorit!");
			procedura();
		}
		else {
            JOptionPane.showMessageDialog(null, "Gabim! Nuk mund t'i paraqisni 0 shfrytezues");
            procedura();
        }
		return vargu;
	}
	public static void main(String[] args)
	{
		SurveyController obj = new SurveyController();
		
		SurveyView obj1 = new SurveyView(obj.procedura());
		obj1.display();
	}

}
