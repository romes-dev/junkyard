import java.util.ArrayList;
import java.util.List;

// Interface Observer que declara o método update
interface Observer {
    void update(String message);
}

// Classe Subject que mantém a lista de observadores e notifica quando o estado muda
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Adiciona um observador
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove um observador
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Altera o estado e notifica os observadores
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    // Notifica cada observador sobre a mudança
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Implementação concreta do Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a atualização: " + message);
    }
}

// Classe principal para demonstrar o Observer na prática
public class ObserverExample {
    public static void main(String[] args) {
        // Cria o sujeito que será observado
        Subject subject = new Subject();

        // Cria dois observadores
        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        // Registra os observadores no sujeito
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Altera o estado do sujeito, fazendo com que os observadores sejam notificados
        subject.setState("Estado alterado!");
    }
}
