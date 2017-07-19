package anki;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Engine engine= Engine.getInstance();

        boolean end=false;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("\n*/*/*/*/* MENU PRINCIPAL */*/*/*/* \n (1) Pour créer un nouvel utilisateur et jouer \n (2) Charger une ancienne partie \n (3) Quitter");

            switch (scanner.nextInt()){
                case 1 :
                    String tmpPseudo;
                    String tmpPass;
                    System.out.println("*/*/*/*/* CRÉATION UTILISATEUR */*/*/*/*");
                    System.out.print("Pseudo : \t");
                    tmpPseudo = scanner.next();
                    System.out.print("Pass : \t");
                    tmpPass = scanner.next();
                    if(!Engine.mapStudent.containsKey(tmpPseudo)){
                        Engine.mapStudent.put(tmpPseudo, new Student(tmpPseudo, tmpPass,new Date()));
                        Engine.students.write("STUDENTS",Engine.mapStudent.get(tmpPseudo).getPseudo()+ "="+Engine.mapStudent.get(tmpPseudo).getPass()+"="+Engine.mapStudent.get(tmpPseudo).getBeginDateString());
                        engine.play(Engine.mapStudent.get(tmpPseudo));
                    }else {
                        System.out.println("Ce pseudo existe déjà");
                    }

                    break;
                case 2 :
                        System.out.println("*/*/*/*/* PARTIE CHARGÉE */*/*/*/*");
                        System.out.print("Pseudo : \t");
                        tmpPseudo = scanner.next();
                        System.out.print("Pass : \t");
                        tmpPass = scanner.next();

                        if(Engine.mapStudent.containsKey(tmpPseudo) &&
                                tmpPass.equals(Engine.mapStudent.get(tmpPseudo).getPass())
                                )
                        {
                            engine.play(Engine.mapStudent.get(tmpPseudo));
                        }else {
                            System.out.println("\nCe pseudo n'existe pas dans le système\n");
                        }
                    break;
                case 3:
                    end=true;
                    break;
            }
        }while (end!=true);
    }
}
