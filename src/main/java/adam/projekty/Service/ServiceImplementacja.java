package adam.projekty.Service;

import org.springframework.stereotype.Service;

@Service            // Serwis bedzie przeskanowany przez Springa , tak samo jak Component czy Controller , z tym wyjatkiem ze serwis trzyma logike. Prowadzi kalkulacje danych. Controller pobiera raczej operacje wykonane przez logike
public class ServiceImplementacja implements DemoService{
    @Override
    public String getHelloMessage(String uzytkownik) {
        return "Czesc "+uzytkownik;
    }

    @Override
    public String getWelcomeMessage() {
        return "Witaj w tej aplikacji";
    }
}
