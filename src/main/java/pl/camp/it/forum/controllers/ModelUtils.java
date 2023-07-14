package pl.camp.it.forum.controllers;

import org.springframework.ui.Model;
import pl.camp.it.forum.session.SessionData;

public class ModelUtils {
    //Utils to klasy pomocnicze
    //nie jest komponentem, bo jest statyczna i w związku z tym nie musimy jej wstrzykiwać
    //poniższa metoda zmienia dane w Modelu, więc nie musi nic zwracać
    //metoda dostaje model i sessiondata i uzupełnia w modelu to co wyciągnie z SD
    public static void addCommonDataToModel(Model model, SessionData sessionData){
        model.addAttribute("logged", sessionData.isLogged());
        model.addAttribute("admin", sessionData.isAdmin());
    }


}
